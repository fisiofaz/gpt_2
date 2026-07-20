# Sprint 02

**Versão:** 0.2.0

**Período:** Julho/2026

**Status:** ✅ Concluída

---

# Objetivo

Implementar a infraestrutura compartilhada do sistema (Shared) e desenvolver o primeiro módulo funcional do GTP, estabelecendo o padrão arquitetural que será utilizado em todos os demais módulos.

---

# Backlog da Sprint

| Status | Item |
|---------|------|
| ✅ | Criar módulo Shared |
| ✅ | Criar módulo Congregation |
| ✅ | Implementar CRUD de Congregações |
| ✅ | Criar DTOs |
| ✅ | Implementar MapStruct |
| ✅ | Criar Services |
| ✅ | Criar Controllers |
| ✅ | Criar Repositories |
| ✅ | Configurar OpenAPI (Swagger) |
| ✅ | Implementar tratamento global de exceções |
| ✅ | Configurar validações |
| ✅ | Criar migrations Flyway |
| ✅ | Testar API via Postman |

---

# Funcionalidades Implementadas

## Shared

Foi criada toda a infraestrutura compartilhada do projeto, utilizada por todos os módulos.

### Componentes

- BaseEntity
- Auditoria
- Exceptions
- GlobalExceptionHandler
- ApiResponse
- ApiError
- Enums compartilhados
- Configurações comuns

---

## Módulo Congregation

Primeiro módulo funcional do sistema.

### Implementado

- Entidade Congregation
- Repository
- Service
- Controller
- DTOs
- Mapper (MapStruct)
- Use Cases
- Validações
- CRUD completo

---

## Banco de Dados

### Flyway

Implementadas as migrations do módulo Congregation.

Exemplo:

- V1__Initial.sql
- V2__Create_Congregation.sql

---

## API REST

Implementados os endpoints REST.

### Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | /api/v1/congregations | Listar |
| GET | /api/v1/congregations/{id} | Buscar |
| POST | /api/v1/congregations | Criar |
| PUT | /api/v1/congregations/{id} | Atualizar |
| DELETE | /api/v1/congregations/{id} | Excluir |

---

## Documentação

Implementação da documentação automática utilizando:

- OpenAPI
- Swagger UI

---

## Tratamento de Exceções

Implementado tratamento global utilizando:

- ResourceNotFoundException
- BusinessException
- GlobalExceptionHandler

Padronização das respostas de erro da API.

---

## Validações

Implementadas validações utilizando Jakarta Validation.

Exemplos:

- @NotBlank
- @NotNull
- @Email
- @Size

---

# Estrutura Criada

```text
backend/

shared/
├── config/
├── exception/
├── response/
├── enums/
└── entity/

congregation/
├── application/
│   ├── dto/
│   ├── mapper/
│   ├── service/
│   └── usecase/
│
├── domain/
│   ├── entity/
│   └── repository/
│
└── interfaces/
    └── controller/
```

---

# Testes Realizados

| Teste | Resultado |
|--------|-----------|
| Criar Congregação | ✅ |
| Buscar Congregação | ✅ |
| Atualizar Congregação | ✅ |
| Excluir Congregação | ✅ |
| Validação de Campos | ✅ |
| Tratamento de Exceções | ✅ |
| Testes via Postman | ✅ |

---

# Problemas Encontrados

| Problema | Solução |
|----------|---------|
| Ajustes no MapStruct | Configuração do componentModel="spring" |
| Ajustes nas migrations | Revisão das versões Flyway |
| Padronização das respostas | Criação do ApiResponse e ApiError |

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- PostgreSQL 17
- Flyway
- MapStruct
- Lombok
- Jakarta Validation
- OpenAPI / Swagger
- Maven
- Postman

---

# Commits

Principais commits da Sprint 2:

- feat(shared): criar infraestrutura compartilhada
- feat(congregation): implementar módulo Congregation
- feat(api): adicionar documentação OpenAPI
- refactor(shared): padronizar tratamento de exceções

---

# Pull Request

**Branch**

```
feature/backend-base
```

**Status**

✅ Merge realizado com sucesso.

---

# Resultado da Sprint

A Sprint 2 consolidou a arquitetura base do GTP, estabelecendo os padrões de desenvolvimento que serão reutilizados em todos os módulos futuros. Foi implementada a infraestrutura compartilhada do sistema e entregue o primeiro módulo funcional (Congregation), incluindo CRUD completo, documentação da API, tratamento global de exceções e testes de integração via Postman.

---

# Próxima Sprint

## Objetivos

- Implementar o módulo Users
- Spring Security
- JWT
- Login
- Controle de autenticação
- Controle de autorização

---

# Observações

A infraestrutura criada nesta Sprint passou a servir como base para todos os módulos do sistema, garantindo padronização, reutilização de código e escalabilidade para a evolução do GTP.
