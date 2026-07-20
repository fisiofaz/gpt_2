# Sprint 03 — Congregação e Publicadores

## Informações da Sprint

**Projeto:** Gestor de Territórios e Publicações (GTP)

**Objetivo:**  
Criar os primeiros módulos funcionais do sistema: Congregação e Cadastro de Publicadores.

**Status:** Planejada

---

# Objetivo Principal

Implementar o núcleo inicial do gerenciamento organizacional do GTP.

---

# Escopo da Sprint

# Módulo Congregação

## Funcionalidades

Criar:

- Cadastro.
- Consulta.
- Atualização.
- Exclusão.
- Pesquisa.

---

# Entidade Congregation

Campos:
- id
- nome
- cidade
- estado
- endereco
- responsavel
- status
- createdAt
- updatedAt

---

# API

Endpoints:
- GET /api/v1/congregations
- POST /api/v1/congregations
- PUT /api/v1/congregations/{id}
- DELETE /api/v1/congregations/{id}

---

# Módulo Publicadores

## Funcionalidades

Implementar:

- Cadastro de publicadores.
- Listagem.
- Busca.
- Atualização.
- Controle de status.

---

# Entidade Person

Campos:
- id
- nome
- telefone
- email
- dataNascimento
- dataBatismo
- status
- congregationId

---

# API

Endpoints:
- GET /api/v1/people
- POST /api/v1/people
- PUT /api/v1/people/{id}
- DELETE /api/v1/people/{id}
  
---

# Frontend

Criar páginas:

pages
├── Congregacoes
└── Publicadores

---

# Componentes

Criar:

- DataTable.
- Formulários.
- Modal confirmação.
- Busca.

---

# Banco de Dados

Criar migrations:

db
├── V1__initial_schema.sql
├── V2__create_congregations.sql
├── V3__create_people.sql

---

# Regras de Negócio

Implementar:

- Publicador deve pertencer a uma congregação.
- Cadastro deve possuir validações.
- Registros inativos não devem ser removidos fisicamente.

---

# Testes

Implementar:

- Testes CRUD.
- Testes de validação.
- Testes de regras de negócio.

---

# Critérios de Aceitação

✔ Congregações cadastradas.

✔ Publicadores cadastrados.

✔ CRUD completo.

✔ Integração frontend/backend.

✔ Dados persistidos.

---

# Resultado Esperado

Ao final da Sprint 03 o GTP terá seus primeiros módulos operacionais funcionando e preparados para receber os módulos de territórios e publicações.
