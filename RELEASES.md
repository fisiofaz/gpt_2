# Releases

Este documento apresenta um resumo das versões publicadas do **Gestor de Territórios e Publicações (GTP)**.

Para o histórico completo de alterações consulte:

- CHANGELOG.md

---

# Roadmap de Releases

| Versão | Status |
|---------|---------|
| 0.1.0 | ✅ Publicada |
| 0.2.0 | ✅ Publicada |
| 0.3.0 | ✅ Publicada |
| 0.4.0 | 🚧 Em desenvolvimento |
| 0.5.0 | Planejada |
| 0.6.0 | Planejada |
| 0.7.0 | Planejada |
| 0.8.0 | Planejada |
| 0.9.0 | Planejada |
| 1.0.0 | Planejada |

---

# Release 0.1.0

**Data**

Julho/2026

## Objetivo

Estruturação inicial do projeto.

### Entregas

- Estrutura do repositório
- README
- Licença MIT
- Organização das pastas
- Planejamento inicial
- Arquitetura base

---

# Release 0.2.0

**Data**

Julho/2026

## Objetivo

Construção da infraestrutura do backend.

### Entregas

- Spring Boot
- PostgreSQL
- Flyway
- Shared
- Exception Handler
- OpenAPI
- Congregation Module
- CRUD Congregações
- MapStruct
- Testes Postman

---

# Release 0.3.0

**Data**

Julho/2026

## Objetivo

Implementação completa da autenticação.

### Entregas

### Users

- CRUD de Usuários
- DTOs
- Mapper
- Repository
- Use Cases
- Service
- Controller

### Segurança

- Spring Security
- BCrypt
- UserDetails
- AuthenticationProvider
- SecurityConfig

### JWT

- JwtService
- JwtAuthenticationFilter
- AuthenticationService
- Login

### Banco

- Migration V3

### Testes

- Cadastro
- Login
- Token
- Endpoints protegidos
- Usuário duplicado
- Senha criptografada

---

# Próxima Release

## 0.4.0

Prevê a implementação de:

- Publicadores
- CRUD completo
- Regras de negócio
- Relacionamentos
- APIs
- Testes

---

# Histórico

| Release | Situação |
|----------|----------|
| 0.1.0 | Estrutura inicial |
| 0.2.0 | Backend base |
| 0.3.0 | Segurança e autenticação |
| 0.4.0 | Publicadores |
| 0.5.0 | Territórios |
| 0.6.0 | Publicações |
| 0.7.0 | Dashboard |
| 0.8.0 | Relatórios |
| 0.9.0 | Auditoria |
| 1.0.0 | Primeira versão oficial |

---

# Estratégia de Versionamento

O projeto segue o padrão **Semantic Versioning (SemVer)**.

```
MAJOR.MINOR.PATCH
```

Exemplos:

```
0.3.0
```

Nova funcionalidade.

```
0.3.1
```

Correção de bugs.

```
0.4.0
```

Novo módulo.

```
1.0.0
```

Primeira versão estável.

---

# Próximas Grandes Entregas

- Gestão de Publicadores
- Gestão de Territórios
- Gestão de Publicações
- Dashboard
- Relatórios
- Auditoria
- Aplicativo Mobile
- PWA
- Inteligência Artificial
- Deploy em Produção
