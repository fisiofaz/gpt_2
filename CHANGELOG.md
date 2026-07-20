# Changelog

Todas as alterações relevantes deste projeto serão documentadas neste arquivo.

O formato deste documento é baseado em Keep a Changelog e o projeto segue Semantic Versioning (SemVer).

---

## [Unreleased]

### Added

- Estrutura inicial da documentação.
- Organização das Sprints.
- Melhorias contínuas em andamento.

---

# [0.3.0] - 2026-07-20

## Added

### Sprint 3 — Módulo Users

#### Backend

- Estrutura completa do módulo Users.
- Entidade User.
- UserRepository.
- DTOs.
- UserMapper (MapStruct).
- Use Cases.
- Service.
- Controller.
- Migration Flyway V3.

#### Segurança

- Spring Security.
- BCrypt Password Encoder.
- UserDetails.
- UserDetailsService.
- AuthenticationProvider.
- SecurityConfig.

#### JWT

- JwtService.
- JwtAuthenticationFilter.
- AuthenticationService.
- Endpoint de Login.

#### Testes

- Cadastro de usuário.
- Login.
- Endpoint protegido.
- Token inválido.
- Acesso sem token.
- Senha incorreta.
- E-mail inexistente.
- Usuário duplicado.

---

# [0.2.0] - 2026-07-15

## Added

### Sprint 2

- Infraestrutura Shared.
- Tratamento global de exceções.
- MapStruct.
- Módulo Congregation.
- CRUD completo.
- Flyway.
- Swagger/OpenAPI.
- Testes via Postman.

---

# [0.1.0] - 2026-07-13

## Added

### Sprint 1

- Estrutura inicial do projeto.
- Spring Boot.
- PostgreSQL.
- Flyway.
- Arquitetura em camadas.
- Organização dos módulos.
- Documentação inicial.

---

## Versionamento

| Tipo | Exemplo | Significado |
|------|----------|-------------|
| MAJOR | 2.0.0 | Mudanças incompatíveis |
| MINOR | 1.3.0 | Novas funcionalidades |
| PATCH | 1.3.2 | Correções |
