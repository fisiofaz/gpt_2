# Sprint 03

**Versão:** 0.3.0

**Período:** Julho/2026

**Status:** ✅ Concluída

---

# Objetivo

Implementar o módulo **Users**, responsável pelo gerenciamento de usuários e autenticação da aplicação, utilizando Spring Security e JWT, estabelecendo a base de segurança para todos os módulos futuros do GTP.

---

# Backlog da Sprint

| Status | Item |
|---------|------|
| ✅ | Estrutura do módulo Users |
| ✅ | Enums |
| ✅ | Entidade User |
| ✅ | UserRepository |
| ✅ | DTOs |
| ✅ | UserMapper |
| ✅ | Use Cases |
| ✅ | Service |
| ✅ | Controller |
| ✅ | Migration Flyway |
| ✅ | Spring Security |
| ✅ | JWT |
| ✅ | AuthenticationService |
| ✅ | Login |
| ✅ | Testes Postman |

---

# Funcionalidades Implementadas

## Módulo Users

Implementado o módulo completo de gerenciamento de usuários.

### Componentes

- User
- UserRepository
- DTOs Request/Response
- UserMapper (MapStruct)
- Use Cases
- UserService
- UserController

---

## Banco de Dados

### Flyway

Criada a migration:

```
V3__Create_User.sql
```

### Estrutura

Tabela:

```
users
```

Campos principais:

- id
- first_name
- last_name
- email
- password
- phone
- role
- status
- last_login
- created_at
- updated_at
- created_by
- updated_by

---

## Spring Security

Implementada toda a infraestrutura de autenticação.

### Componentes

- PasswordConfig
- BCryptPasswordEncoder
- UserDetailsImpl
- UserDetailsServiceImpl
- AuthenticationProvider
- SecurityConfig

### Funcionalidades

- Autenticação Stateless
- Criptografia de senha (BCrypt)
- Controle de rotas protegidas
- Liberação de endpoints públicos
- Integração com UserDetailsService

---

## JWT

Implementada autenticação baseada em JSON Web Token.

### Componentes

- JwtService
- JwtAuthenticationFilter

### Funcionalidades

- Geração de Token
- Validação do Token
- Extração do usuário autenticado
- Autenticação automática via filtro

---

## AuthenticationService

Implementado serviço responsável pela autenticação.

### Fluxo

1. Receber LoginRequest
2. Validar usuário
3. Validar senha
4. Gerar JWT
5. Retornar LoginResponse

---

## Login

Endpoint implementado:

```
POST /api/v1/auth/login
```

Retorno:

```json
{
  "token": "jwt...",
  "type": "Bearer"
}
```

---

# API REST

## Usuários

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | /api/v1/users | Criar usuário |

---

## Autenticação

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | /api/v1/auth/login | Login |

---

# Estrutura Criada

```text
users/

application/
├── dto/
│   ├── request/
│   └── response/
├── mapper/
├── service/
└── usecase/

domain/
├── entity/
└── repository/

interfaces/
└── controller/

shared/

security/
├── config/
├── jwt/
├── userdetails/
└── authentication/
```

---

# Testes Realizados

## Cadastro

| Teste | Resultado |
|--------|-----------|
| Criar usuário | ✅ |
| Usuário duplicado | ✅ |
| Senha criptografada | ✅ |

---

## Login

| Teste | Resultado |
|--------|-----------|
| Login válido | ✅ |
| Senha incorreta | ✅ |
| E-mail inexistente | ✅ |

---

## Segurança

| Teste | Resultado |
|--------|-----------|
| Endpoint protegido | ✅ |
| Token válido | ✅ |
| Token inválido | ✅ |
| Acesso sem token | ✅ |

---

# Problemas Encontrados

| Problema | Solução |
|----------|---------|
| Configuração do JWT | Adequação à versão 0.12.6 do JJWT |
| Bean do UserDetailsService | Ajuste da configuração do AuthenticationProvider |
| Migrations Flyway | Correção da estrutura da tabela users |
| Password não criptografada | Inclusão do BCryptPasswordEncoder |
| Ajustes de autenticação | Configuração correta do SecurityFilterChain |

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL 17
- Flyway
- JWT (jjwt 0.12.6)
- MapStruct
- Lombok
- Jakarta Validation
- Maven
- Postman

---

# Commits

Principais commits da Sprint 3:

- feat(users): criar módulo Users
- feat(auth): implementar autenticação JWT
- feat(security): configurar Spring Security
- feat(login): criar endpoint de login
- refactor(jwt): ajustar geração e validação de tokens
- test(postman): validar autenticação e endpoints protegidos

---

# Pull Request

**Branch**

```
feature/users-authentication
```

**Status**

✅ Merge realizado com sucesso.

---

# Resultado da Sprint

A Sprint 3 entregou a infraestrutura completa de autenticação e autorização do GTP. Foi implementado o módulo Users, integração com Spring Security, autenticação Stateless utilizando JWT, criptografia de senhas com BCrypt e proteção dos endpoints da API. Todos os cenários principais foram validados por meio de testes no Postman, consolidando uma base segura e reutilizável para a evolução dos próximos módulos.

---

# Próxima Sprint

## Objetivos

- Implementar o módulo Publicadores
- CRUD completo
- Relacionamento com Congregações
- Regras de negócio
- Novos endpoints REST
- Testes e documentação

---

# Observações

A infraestrutura de autenticação desenvolvida nesta Sprint será reutilizada por todos os módulos do sistema, garantindo padronização, segurança e escalabilidade para as próximas fases do projeto.
