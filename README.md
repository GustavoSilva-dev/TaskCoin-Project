# 🪙 TaskCoin - Plataforma de Gamificação de Tarefas Familiares

<p align="center">
  <img src="./footages/taskcoinIcon-removebg.png" style="filter:drop-shadow(0 0 100px white);" alt="TaskCoin Banner" width="200px">
</p>

<p align="center">
  <strong>Incentivando a disciplina, as virtudes e a organização aos seus filhos.</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB" alt="React">
  <img src="https://img.shields.io/badge/Vite-B73BFE?style=for-the-badge&logo=vite&logoColor=FFD62E" alt="Vite">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Spring_Boot-F2F4F8?style=for-the-badge&logo=spring-boot&logoColor=6DB33F" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white" alt="Supabase">
</p>

---

## 📌 Sobre o Projeto

O **TaskCoin** é uma plataforma Full-Stack desenvolvida como um aplicativo híbrido (PWA) focado na educação familiar e no desenvolvimento comportamental infantil. Através do conceito de **gamificação**, pais conseguem cadastrar rotinas, metas e tarefas diárias para seus filhos. 

Ao cumprir os deveres, os filhos acumulam moedas virtuais (*TaskCoins*) que podem ser trocadas por conquistas e recompensas reais combinadas dentro do ecossistema da família. Mais do que um simples gerenciador de tarefas, a plataforma atua como uma ferramenta de fortalecimento de laços, autonomia e consistência de hábitos saudáveis.

---

## 📸 Demonstração Visual

Abaixo estão algumas das principais telas do ecossistema, em sua versão mobile:

| 📱 Visão do Filho (PWA Mobile) | 💻 Painel dos Pais (Gestão) |
| :---: | :---: |
<img src="./footages/1000150655.gif" width="300px" alt="Visão do Filho"><br>_Visualização de tarefas, nível, ofensiva e carteira de moedas_ | <img src="./footages/1000150657.gif" width="300px" alt="Painel dos Pais"><br>_Visualização de filhos, tarefas ativas e cadastro de tarefas_ |

---

## 🏗️ Estrutura do Repositório

O repositório está organizado em um formato unificado contendo de maneira isolada o ecossistema de cliente e servidor:

```bash
TaskCoin-Project/
├── backend/       # API REST desenvolvida em Java e Spring Boot (Maven)
├── footages/      # GIFs representativos do sistema, pasta dedicada ao README.md
└── frontend/      # Aplicação Single Page Application (SPA) com React e Vite
```

## 🛠️ Tecnologias Utilizadas
### Front-end
<ul>
<li>React.js (com JavaScript/JSX)</li>
<li>Vite</li>
<li>CSS3</li>
<li>PWA - Progressive Web App (Instalável diretamente no smartphone)</li>
</ul>

### Back-end
<ul>
<li>Java 17 / Spring Boot</li>
<li>Spring Data</li>
<li>Maven</li>
<li>PostgreSQL / Supabase (Banco de Dados Relacional)</li>
</ul>

## 🚀 Como Executar o Projeto Localmente
### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina: <br/>
Node.js (versão 18 ou superior) <br/>
JDK 17 (Configurado nas variáveis de ambiente) <br/>
Seu banco de dados relacional ativo. <br/>

### 1. Configurando o Back-end
Navegue até a pasta do servidor:

```bash
cd backend/api
```
Certifique-se de configurar as credenciais do seu banco de dados no arquivo <strong>src/main/resources/application.properties</strong>.


Execute o servidor utilizando o wrapper do Maven:
### No Windows
```bash
mvnw.cmd spring-boot:run
``` 

### No Linux/Mac
```bash
./mvnw spring-boot:run
```

O servidor back-end iniciará por padrão na porta 8080.

### 2. Configurando o Front-end
Abra uma nova aba no seu terminal e navegue até a pasta da interface:
```Bash
cd frontend
```

Instale as dependências do projeto:
```Bash
npm install
``` 

Inicie o servidor de desenvolvimento do Vite:
```Bash
npm run dev
```

O terminal informará um endereço local (geralmente **http://localhost:5173**). Abra o link no seu navegador para testar a aplicação!

## ✒️ Autores
<center>Gustavo Silva - Desenvolvedor Full-Stack: <strong>GustavoSilva-dev</strong></center> <br/>
<center>Jefferson - Desenvolvedor Front-End: <strong>Marcosszxleonardo</strong></center> <br/>
<center>Marcos Leonardo - Desenvolvedor Front-End: <strong>Jefferson19620</strong></center>
