# Guia de Contribuição

Obrigado pelo seu interesse em contribuir com o **Gestor de Territórios e Publicações (GTP)**.

Este documento descreve as diretrizes para colaboração no projeto, visando manter a qualidade do código, da documentação e da arquitetura.

---

# Código de Conduta

Todos os colaboradores devem manter um ambiente respeitoso, colaborativo e profissional.

Espera-se que todos:

* sejam respeitosos com outros colaboradores;
* mantenham discussões técnicas objetivas;
* utilizem linguagem apropriada;
* aceitem críticas construtivas;
* priorizem a qualidade do projeto.

Comportamentos ofensivos, discriminatórios ou inadequados não serão tolerados.

---

# Como Contribuir

Você pode contribuir de diversas formas:

* correção de bugs;
* desenvolvimento de novas funcionalidades;
* melhoria da documentação;
* criação de testes automatizados;
* otimização de desempenho;
* revisão de código;
* melhorias de segurança.

Antes de iniciar qualquer contribuição, verifique se já existe uma Issue relacionada ao assunto.

---

# Fluxo de Desenvolvimento

O projeto utiliza Git e GitHub como sistema de controle de versão.

Fluxo recomendado:

1. Faça um **Fork** do repositório (caso não tenha acesso direto).
2. Crie uma branch para sua alteração.
3. Desenvolva a funcionalidade.
4. Execute os testes.
5. Atualize a documentação, quando necessário.
6. Envie um Pull Request.

---

# Convenção de Branches

Utilize os seguintes padrões:

```text
feature/nome-da-funcionalidade

bugfix/nome-do-bug

hotfix/nome-da-correcao

release/v1.0.0
```

Exemplos:

```text
feature/autenticacao-jwt

feature/publicadores

feature/dashboard

bugfix/login

hotfix/security
```

---

# Padrão de Commits

Utilize mensagens claras e objetivas.

Formato recomendado:

```text
tipo: descrição
```

Exemplos:

```text
feat: adiciona cadastro de usuários

fix: corrige autenticação JWT

docs: atualiza documentação

refactor: reorganiza camada de serviços

test: adiciona testes de autenticação

style: padroniza formatação do código

chore: atualiza dependências
```

Tipos aceitos:

* feat
* fix
* docs
* refactor
* test
* style
* chore
* build
* ci
* perf

---

# Padrões de Código

## Backend

* Java 21
* Spring Boot 3
* Clean Architecture
* SOLID
* DTOs para comunicação externa
* Validação com Jakarta Validation
* Documentação com OpenAPI/Swagger

---

## Frontend

* React
* Componentes reutilizáveis
* Hooks
* React Router
* Axios
* Organização por funcionalidades (feature-based)

---

## Banco de Dados

* PostgreSQL
* Versionamento com Flyway
* Não alterar migrations já executadas
* Novas alterações devem ser feitas por meio de novas migrations

---

# Testes

Antes de enviar um Pull Request:

* execute os testes automatizados;
* verifique se não existem erros de compilação;
* valide a funcionalidade implementada;
* confirme que nenhuma funcionalidade existente foi afetada.

Sempre que possível, novas funcionalidades devem incluir testes automatizados.

---

# Documentação

Toda alteração relevante deve refletir na documentação do projeto.

Atualize, quando necessário:

* README.md
* CHANGELOG.md
* documentação em `docs/`
* diagramas
* especificações da API

---

# Pull Requests

Ao abrir um Pull Request:

* descreva claramente a alteração realizada;
* informe a Issue relacionada (quando existir);
* explique o motivo da mudança;
* informe possíveis impactos.

O Pull Request poderá passar por revisão antes da aprovação.

---

# Reportando Bugs

Ao abrir uma Issue de bug, informe:

* descrição do problema;
* passos para reproduzir;
* comportamento esperado;
* comportamento observado;
* ambiente utilizado (Sistema Operacional, navegador, versão do Java, etc.);
* logs ou capturas de tela, quando aplicável.

---

# Solicitação de Funcionalidades

Para sugerir uma nova funcionalidade:

* descreva o problema que deseja resolver;
* explique a solução proposta;
* informe possíveis benefícios;
* indique impactos na arquitetura, quando houver.

---

# Licença

Ao contribuir com este projeto, você concorda que sua contribuição será distribuída sob a mesma licença do projeto (MIT).

---

# Agradecimentos

Agradecemos a todos que colaboram com o desenvolvimento do **Gestor de Territórios e Publicações (GTP)**.

Toda contribuição, independentemente do tamanho, ajuda a tornar o projeto mais robusto, seguro e útil para a comunidade.
