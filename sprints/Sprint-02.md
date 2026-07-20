# Sprint 02 — Autenticação e Gestão de Usuários

## Informações da Sprint

**Projeto:** Gestor de Territórios e Publicações (GTP)

**Objetivo:**  
Implementar autenticação, autorização e gerenciamento de usuários utilizando segurança baseada em JWT.

**Status:** Planejada

---

# Objetivo Principal

Criar o módulo de segurança do sistema permitindo controle de acesso através de usuários, perfis e permissões.

---

# Escopo da Sprint

# Backend

## Módulo Auth

Criar:
- Login.
- Logout.
- Geração de token JWT.
- Validação de token.
- Controle de sessão.

---

# Entidades

## User

Campos:
- id
- nome
- email
- senha
- ativo
- createdAt
- updatedAt

## Role

Campos:
- id
- nome
- descricao

## Permission

Campos:
- id
- nome
- descricao

---

# Segurança

Implementar:

- Spring Security.
- JWT Authentication Filter.
- Password Encoder.
- Controle de permissões.

---

# Endpoints

## Autenticação

- POST /api/v1/auth/login
- POST /api/v1/auth/logout
- POST /api/v1/auth/refresh

---

## Usuários

- GET /api/v1/users
- POST /api/v1/users
- PUT /api/v1/users/{id}
- DELETE /api/v1/users/{id}

---

# Frontend

Criar:

## Página Login

Funcionalidades:

- Email.
- Senha.
- Validação.
- Mensagens de erro.

---

# Controle de Rotas

Implementar:

- AuthContext.
- PrivateRoute.
- Persistência do usuário.
- Controle por perfil.

Estrutura:
- contexts
- AuthContext.jsx
- routes
- PrivateRoute.jsx

---

# Perfis Iniciais

Criar:
- ADMIN
- ANCIÃO
- PUBLICADOR
- VISUALIZADOR

---

# Testes

Implementar:

- Testes de autenticação.
- Testes de autorização.
- Testes de usuários.

---

# Critérios de Aceitação

✔ Usuário consegue realizar login.

✔ Token JWT funcionando.

✔ Rotas protegidas.

✔ Perfis aplicados corretamente.

✔ Usuários gerenciáveis.

---

# Resultado Esperado

Ao final da Sprint 02 o GTP terá controle seguro de acesso e base para expansão dos módulos.
