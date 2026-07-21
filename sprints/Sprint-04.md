# Sprint 04 — Módulo Publishers

**Projeto:** Gestor de Territórios e Publicações (GTP)  
**Versão:** 0.4.0  
**Status:** ✅ Concluída  
**Período:** Julho/2026

---

# Objetivo

Implementar o módulo **Publishers**, responsável pelo gerenciamento completo dos publicadores da congregação.

Este módulo servirá como base para os módulos de **Territórios**, **Publicações**, **Designações**, **Relatórios** e demais funcionalidades do sistema.

A implementação reutiliza toda a infraestrutura construída nas Sprints anteriores:

- Arquitetura em Camadas
- Clean Architecture
- Spring Boot
- Spring Security
- JWT
- DTOs
- MapStruct
- Use Cases
- Services
- Controllers
- PostgreSQL
- Flyway
- Tratamento Global de Exceções

---

# Objetivos da Sprint

- Implementar CRUD completo de Publicadores
- Criar entidade Publisher
- Criar API REST
- Integrar com Congregation
- Aplicar regras de negócio
- Proteger endpoints com JWT
- Validar autenticação
- Preparar módulo para integração futura com Territórios e Publicações

---

# Estrutura Implementada

```
publishers
├── application
│   ├── dto
│   │   ├── request
│   │   └── response
│   ├── mapper
│   ├── service
│   └── usecase
│
├── domain
│   ├── entity
│   └── repository
│
└── interfaces
    └── controller
```

---

# Funcionalidades Implementadas

## Domínio

- Entidade Publisher
- PublisherRepository
- Relacionamento com Congregation
- Enums de domínio

---

## DTOs

### Requests

- CreatePublisherRequest
- UpdatePublisherRequest

### Response

- PublisherResponse

---

## Mapper

Implementado utilizando **MapStruct**.

Responsável por:

- DTO → Entity
- Entity → DTO
- Atualização parcial da entidade

---

# Casos de Uso

Implementados:

- ✅ CreatePublisherUseCase
- ✅ UpdatePublisherUseCase
- ✅ DeletePublisherUseCase
- ✅ FindPublisherByIdUseCase
- ✅ ListPublishersUseCase

Todos seguindo o padrão adotado no projeto.

---

# Service

Implementado como camada de orquestração entre Controller e Use Cases.

Responsabilidades:

- Delegar chamadas
- Manter baixo acoplamento
- Facilitar testes

---

# Controller

Endpoints implementados:

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | /api/v1/publishers | Criar publicador |
| GET | /api/v1/publishers | Listar publicadores |
| GET | /api/v1/publishers/{id} | Buscar por ID |
| PUT | /api/v1/publishers/{id} | Atualizar |
| DELETE | /api/v1/publishers/{id} | Excluir |

---

# Banco de Dados

Criada Migration:

```
V4__Create_Publishers.sql
```

Tabela:

```
publishers
```

Relacionamentos:

- Publisher → Congregation

Foram definidos:

- Primary Key UUID
- Foreign Key
- Índices
- Constraints

---

# API REST

CRUD completo implementado.

### Cadastro

- POST

### Listagem

- GET

### Busca por ID

- GET

### Atualização

- PUT

### Exclusão

- DELETE

---

# Regras de Negócio

Implementadas:

## Cadastro

- Validar congregação existente
- Validar e-mail duplicado
- Validar campos obrigatórios
- Definir status inicial como ACTIVE

---

## Atualização

- Validar existência
- Validar congregação
- Validar duplicidade de e-mail desconsiderando o próprio registro

---

## Exclusão

Preparada estrutura para impedir exclusão quando houver vínculos futuros com:

- Territórios
- Publicações
- Designações

---

# Segurança

Implementado:

- JWT Authentication
- JwtAuthenticationFilter
- UserDetails
- UserDetailsService
- PasswordEncoder (BCrypt)
- AuthenticationProvider
- SecurityFilterChain
- Proteção dos endpoints
- Autenticação Stateless

Preparado para implementação futura de RBAC.

---

# Testes

Realizados utilizando Postman.

Casos testados:

- Cadastro
- Atualização
- Busca por ID
- Listagem
- Exclusão
- Validações
- JWT
- Autenticação

Todos os testes executados com sucesso.

---

# Arquitetura Utilizada

```
Controller
      │
      ▼
Service
      │
      ▼
Use Cases
      │
      ▼
Repository
      │
      ▼
PostgreSQL
```

---

# Tecnologias

- Java 21
- Spring Boot 3
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- PostgreSQL
- Flyway
- MapStruct
- Lombok
- Jakarta Validation
- Maven

---

# Resultado da Sprint

Implementado com sucesso o módulo completo de gerenciamento de Publicadores.

O sistema agora possui:

- CRUD completo
- Segurança JWT
- Integração com Congregações
- Regras de negócio
- API REST
- Banco de Dados
- Estrutura preparada para expansão

---

# Próxima Sprint

## Sprint 05 — Módulo Territories

Objetivos:

- Implementar entidade Territory
- Cadastro de territórios
- Reserva
- Devolução
- Histórico
- Situação do território
- Integração com Publisher
- Integração com Congregation
- API REST
- Regras de negócio
- Segurança
- Testes
- Documentação

---

# Checklist da Sprint

| Item | Status |
|------|--------|
| Estrutura do módulo | ✅ |
| Domínio | ✅ |
| DTOs | ✅ |
| Mapper | ✅ |
| Use Cases | ✅ |
| Service | ✅ |
| Controller | ✅ |
| Banco de Dados | ✅ |
| API REST | ✅ |
| Regras de Negócio | ✅ |
| Segurança | ✅ |
| Testes | ✅ |
| Documentação | ✅ |

---

# Conclusão

A Sprint 04 consolida a arquitetura do GTP e estabelece um padrão reutilizável para os próximos módulos do sistema.

Com a infraestrutura implementada, os módulos de Territórios, Publicações e Designações poderão reutilizar praticamente toda a arquitetura construída até esta etapa, acelerando o desenvolvimento das próximas sprints e mantendo a padronização do projeto.
