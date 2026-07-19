# Gestor de Territórios e Publicações (GTP)

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-blue)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![React](https://img.shields.io/badge/React-19-61DAFB)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED)

---

## Sobre o Projeto

O **Gestor de Territórios e Publicações (GTP)** é uma plataforma web desenvolvida para modernizar e centralizar o gerenciamento de territórios, publicações, usuários e processos administrativos utilizados pelas congregações.

O sistema foi projetado com foco em **segurança**, **escalabilidade**, **manutenibilidade** e **experiência do usuário**, utilizando tecnologias modernas e boas práticas de Engenharia de Software.

---

## Objetivos

- Centralizar o gerenciamento dos territórios.
- Controlar empréstimos e devoluções de publicações.
- Gerenciar usuários, perfis e permissões.
- Disponibilizar dashboards e indicadores.
- Automatizar processos administrativos.
- Garantir rastreabilidade e auditoria das operações.
- Oferecer uma arquitetura preparada para crescimento.

---

# Arquitetura

```
Frontend (React)

        │

 REST API (HTTPS)

        │

Backend (Spring Boot)

        │

 PostgreSQL
```

---

# Tecnologias

## Frontend

- React
- React Router
- Axios
- Vite
- Material UI

## Backend

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Spring Validation
- JWT
- Lombok
- MapStruct

## Banco de Dados

- PostgreSQL
- Flyway

## Infraestrutura

- Docker
- Docker Compose
- Nginx

## Testes

- JUnit 5
- Mockito
- Testcontainers

---

# Estrutura do Projeto

```
gtp/

├── backend/
├── frontend/
├── database/
│   ├── migrations/
│   ├── scripts/
│   └── modelagem/
├── docs/
├── diagrams/
├── docker/
├── api/
└── assets/
```

---

# Documentação

A documentação completa encontra-se na pasta **docs/**.

Ela contempla:

- Introdução
- Requisitos
- Regras de Negócio
- Casos de Uso
- Modelo de Dados
- Arquitetura
- Backend
- Frontend
- APIs
- Banco de Dados
- Segurança
- Testes
- Deploy
- Manuais
- Roadmap

---

# Principais Funcionalidades

- Autenticação JWT
- Controle de usuários
- Perfis e permissões
- Congregações
- Territórios
- Publicadores
- Publicações
- Empréstimos
- Dashboard
- Relatórios
- Auditoria
- Logs
- Configurações
- Notificações

---

# Roadmap

## Versão 1.0

- Estrutura do projeto
- Autenticação
- Usuários
- Perfis
- Congregações
- Territórios
- Publicações

## Versão 1.1

- Dashboard
- Relatórios
- Auditoria
- Notificações

## Versão 2.0

- Aplicativo Mobile
- Progressive Web App (PWA)
- Integrações
- Inteligência Artificial
- Analytics Avançado

---

# Como executar

## Backend

```bash
cd backend
./mvnw spring-boot:run
```

## Frontend

```bash
cd frontend
npm install
npm run dev
```

---

# Status do Projeto

🚧 Em desenvolvimento.

## Progresso

### Sprint 1
- Estrutura inicial do projeto
- Configuração Spring Boot
- PostgreSQL
- Flyway
- Arquitetura em camadas

### Sprint 2
- Infraestrutura Shared
- Módulo Congregation
- CRUD completo
- Flyway
- OpenAPI
- Tratamento global de exceções
- MapStruct
- Testes realizados via Postman

---

# Contribuição

Contribuições são bem-vindas.

Leia o arquivo **CONTRIBUTING.md** antes de enviar Pull Requests.

---

# Licença

Este projeto está licenciado sob a **Licença MIT**.

Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

# Autor

**Fabio André Zatta**

Projeto desenvolvido como iniciativa de estudo, portfólio e contribuição tecnológica voltada ao gerenciamento de territórios e publicações.

---

## Histórico

Consulte o arquivo **CHANGELOG.md** para acompanhar todas as versões do projeto.
