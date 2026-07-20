# Sprint 01 — Fundação do Projeto

## Informações da Sprint

**Projeto:** Gestor de Territórios e Publicações (GTP)

**Objetivo:**  
Criar a fundação técnica do projeto, estabelecendo a arquitetura inicial, organização dos códigos, configurações de ambiente e estrutura necessária para evolução do sistema.

**Status:** Planejada

---

# Objetivo Principal

Preparar o ambiente completo de desenvolvimento do GTP, garantindo uma base organizada, escalável e seguindo boas práticas de arquitetura de software.

---

# Escopo da Sprint

## Backend

### Configuração Inicial

Implementar:

- Projeto Spring Boot 3.
- Java 21 LTS.
- Maven.
- Configuração de Profiles.
- Configuração inicial de banco de dados.
- Configuração de variáveis de ambiente.

Tecnologias:

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- PostgreSQL
- Flyway
- Lombok
- MapStruct

---

# Arquitetura Backend

Criar estrutura baseada em módulos e responsabilidades.

Estrutura inicial:

br.com.gtp
├── auth
│
├── congregation
│
├── people
│
├── territories
│
├── publications
│
├── orders
│
├── notifications
│
├── reports
│
├── settings
│
├── audit
│
└── shared

---

# Camadas Internas

Cada módulo seguirá:

module
├── application
│
├── domain
│
├── infrastructure
│
└── interfaces

----

# Responsabilidades:

## Domain

- Entidades.
- Regras de negócio.
- Serviços de domínio.

## Application

- Casos de uso.
- Orquestração da aplicação.

## Infrastructure

- Banco de dados.
- Integrações.
- Implementações técnicas.

## Interfaces

- Controllers.
- DTOs.
- Entrada e saída da API.

---

# Frontend

Criar estrutura inicial React.

Tecnologias:

- React
- Vite
- React Router
- Axios
- CSS Modules

Estrutura:

src
├── components
│
├── pages
│
├── routes
│
├── services
│
├── contexts
│
├── hooks
│
├── utils
│
└── assets

---

# Funcionalidades

Implementar:

- Layout principal.
- Rotas básicas.
- Página inicial.
- Estrutura de componentes.
- Comunicação inicial com API.

---

# Banco de Dados

Preparar:

- Configuração PostgreSQL.
- Migrações Flyway.
- Estrutura inicial.

Exemplo:

db
├── V1__initial_schema.sql

---

# Documentação

Criar:

- README.
- Arquitetura Backend.
- Arquitetura Frontend.
- Guia de desenvolvimento.

---

# Testes

Configurar:

- JUnit 5.
- Mockito.
- Estrutura de testes.

---

# Critérios de Aceitação

✔ Backend inicia corretamente.

✔ Frontend executa sem erros.

✔ Estrutura arquitetural criada.

✔ Banco configurado.

✔ Projeto versionado no GitHub.

---

# Resultado Esperado

Ao final da Sprint 01 o GTP possuirá uma base profissional preparada para implementação das funcionalidades de negócio.
