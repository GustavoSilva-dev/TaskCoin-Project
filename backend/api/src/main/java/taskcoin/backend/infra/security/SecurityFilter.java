package taskcoin.backend.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import taskcoin.backend.repositorios.FilhosRepository;
import taskcoin.backend.repositorios.ResponsaveisRepository;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private FilhosRepository filhosRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);

            var responsavel = responsaveisRepository.findByEmail(subject);
            if (responsavel != null ) {
                var authentication = new UsernamePasswordAuthenticationToken(responsavel, null, responsavel.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            var filho = filhosRepository.findByEmail(subject);
            if(filho != null){
                var authentication = new UsernamePasswordAuthenticationToken(filho, null, filho.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    public String recuperarToken(HttpServletRequest request){
        var authenticationHeader = request.getHeader("Authorization");
        if(authenticationHeader != null){
            return authenticationHeader.replace("Bearer ", "");
        }

        return null;
    }
}
