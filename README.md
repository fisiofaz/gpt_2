# Gestor de Territórios e Publicações (GTP)

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-blue)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![React](https://img.shields.io/badge/React-19-61DAFB)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED)

---

# Sobre o Projeto

O **Gestor de Territórios e Publicações (GTP)** é uma plataforma web desenvolvida para modernizar e centralizar o gerenciamento de territórios, publicações, usuários e processos administrativos utilizados pelas congregações.

O sistema foi projetado com foco em:

- Segurança
- Escalabilidade
- Manutenibilidade
- Arquitetura Limpa
- Boas práticas de Engenharia de Software
- Experiência do usuário

---

# Objetivos

- Centralizar o gerenciamento dos territórios.
- Controlar empréstimos e devoluções de publicações.
- Gerenciar usuários, perfis e permissões.
- Disponibilizar dashboards e indicadores.
- Automatizar processos administrativos.
- Garantir rastreabilidade e auditoria.
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

- PostgreSQL 17
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

```text
gtp/

├── backend/
├── frontend/
├── database/
├── docs/
├── docker/
├── api/
├── diagrams/
├── assets/
├── CHANGELOG.md
├── ROADMAP.md
└── README.md
```

---

# Documentação

Toda a documentação técnica encontra-se na pasta **docs/**.

## Documentos disponíveis

- Introdução
- Requisitos
- Casos de Uso
- Regras de Negócio
- Arquitetura
- Backend
- Frontend
- APIs REST
- Banco de Dados
- Segurança
- Testes
- Deploy
- Diagramas
- Sprints

---

# Funcionalidades

## Implementadas

- Autenticação JWT
- Spring Security
- Controle de Usuários
- Controle de Congregações
- CRUD REST
- Flyway
- MapStruct
- Tratamento Global de Exceções
- Cadastro de publicadores
- Atualização de publicadores
- Exclusão de publicadores
- Busca por ID
- Listagem
- Paginação
- Filtros
- Validações de negócio
- Integração com Congregation
- Segurança JWT

## Em desenvolvimento

- Territórios
- Publicações
- Empréstimos
- Dashboard
- Relatórios
- Auditoria
- Notificações
- Configurações

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

🚧 Em desenvolvimento

## Progresso

| Sprint | Status |
|---------|--------|
| Sprint 1 | ✅ Concluída |
| Sprint 2 | ✅ Concluída |
| Sprint 3 | ✅ Concluída |
| Sprint 4 | ⏳ Em planejamento |

---

# Evolução do Projeto

O histórico completo de evolução está documentado em:

- `CHANGELOG.md`
- `ROADMAP.md`
- `docs/sprints/`

---

# Contribuição

Contribuições são bem-vindas.

Leia o arquivo **CONTRIBUTING.md** antes de enviar Pull Requests.

---

# Licença

Este projeto está licenciado sob a Licença **MIT**.

Consulte o arquivo **LICENSE** para mais informações.

---

# Autor

**Fabio André Zatta**

Projeto desenvolvido como iniciativa de estudo, portfólio e contribuição tecnológica voltada ao gerenciamento de territórios e publicações.
