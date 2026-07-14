


Sistema de Gestão de Territórios e Publicações (GTP)

Documento 13 – Estratégia de Testes

________________________________________
Projeto: Sistema de Gestão de Territórios e Publicações (GTP)  
Versão: 1.0.0  
Status: Em Elaboração  
Data: Julho/2026  
Autor: Fabio André Zatta  
________________________________________





1 – Introdução
1.1 Objetivo
Este documento estabelece a estratégia oficial de testes do Gestor de Territórios e Publicações (GTP), definindo os princípios, processos, ferramentas e critérios utilizados para garantir a qualidade do software durante todo o seu ciclo de vida.
A estratégia de testes tem como finalidade assegurar que o sistema atenda aos requisitos funcionais e não funcionais especificados, preservando a confiabilidade, segurança, desempenho e manutenibilidade da aplicação.
Os testes serão tratados como parte integrante do processo de desenvolvimento, sendo executados continuamente desde a implementação das funcionalidades até a implantação em produção.
Os principais objetivos desta estratégia são:
•	garantir a correta implementação das regras de negócio;
•	detectar defeitos precocemente;
•	reduzir riscos de regressão;
•	assegurar a estabilidade das integrações entre os módulos;
•	validar a conformidade da API REST;
•	verificar a experiência do usuário no frontend;
•	validar requisitos de segurança, desempenho e disponibilidade;
•	fornecer indicadores objetivos de qualidade por meio de métricas e cobertura de testes;
•	apoiar a integração contínua (CI) e a entrega contínua (CD).

1.2 Escopo
Esta estratégia abrange todas as camadas do sistema GTP, contemplando tanto os componentes desenvolvidos internamente quanto as integrações utilizadas pela aplicação.
Estão incluídos no escopo:
Backend
•	Casos de Uso (Use Cases);
•	Serviços de Domínio;
•	Camada de Aplicação;
•	Controladores REST;
•	Spring Security;
•	Spring Data JPA;
•	Repositórios;
•	Entidades JPA/Hibernate;
•	DTOs;
•	Mapeamentos MapStruct;
•	Validações;
•	Integrações externas;
•	Migrações Flyway.
Frontend
•	Componentes React;
•	Hooks personalizados;
•	Context API;
•	Rotas protegidas;
•	Formulários;
•	Serviços HTTP;
•	Gerenciamento de estado;
•	Dashboards;
•	Componentes reutilizáveis;
•	Responsividade;
•	Acessibilidade.
Banco de Dados
•	Migrações Flyway;
•	Integridade referencial;
•	Consultas;
•	Índices;
•	Views;
•	Funções;
•	Procedures;
•	Triggers.
Infraestrutura
•	Docker;
•	Docker Compose;
•	PostgreSQL;
•	Pipeline CI/CD;
•	Configuração de ambientes;
•	Monitoramento.
Também fazem parte do escopo:
•	testes unitários;
•	testes de integração;
•	testes funcionais;
•	testes da API REST;
•	testes End-to-End (E2E);
•	testes de regressão;
•	testes de segurança;
•	testes de desempenho;
•	testes de carga.

1.3 Público-Alvo
Este documento destina-se aos profissionais envolvidos no desenvolvimento, manutenção e evolução do GTP.
Inclui:
•	Desenvolvedores Backend;
•	Desenvolvedores Frontend;
•	Arquitetos de Software;
•	Engenheiros de Qualidade (QA);
•	DevOps;
•	Administradores de Banco de Dados;
•	Gestores Técnicos;
•	Colaboradores responsáveis por futuras manutenções do sistema.
O documento também poderá servir como referência para auditorias técnicas e revisões arquiteturais.

1.4 Documentos Relacionados
Esta estratégia de testes complementa os demais documentos arquiteturais do projeto.
Documento	Relação
Documento 01 – Visão Geral do Sistema	Define os objetivos e o contexto do GTP.
Documento 02 – Requisitos Funcionais	Fornece os requisitos que deverão ser validados pelos testes.
Documento 03 – Regras de Negócio	Define as regras que deverão possuir cobertura de testes.
Documento 04 – Casos de Uso	Base para testes funcionais e de integração.
Documento 05 – Arquitetura Geral	Define a estrutura arquitetural utilizada pela estratégia de testes.
Documento 06 – Arquitetura Backend	Especifica os componentes testados no backend.
Documento 07 – Arquitetura Frontend	Define os componentes e fluxos testados na interface.
Documento 08 – Segurança	Orienta os testes de autenticação, autorização e segurança.
Documento 09 – Docker	Fornece o ambiente de execução dos testes.
Documento 10 – API REST	Define os contratos que serão validados.
Documento 11 – DER	Define a estrutura dos dados utilizada nos testes.
Documento 12 – Banco de Dados PostgreSQL	Define a camada de persistência validada pelos testes.

1.5 Tecnologias Utilizadas
A estratégia de testes do GTP utilizará ferramentas consolidadas no ecossistema Java e React, priorizando automação, confiabilidade e integração com o processo de desenvolvimento.
Backend
Tecnologia	Finalidade
JUnit 5	Testes unitários e de integração.
Mockito	Simulação de dependências (mocking).
AssertJ	Escrita de asserções mais legíveis.
Spring Boot Test	Testes integrados da aplicação.
Testcontainers	Execução de testes com PostgreSQL real em contêineres.
Flyway	Preparação e versionamento do banco durante os testes.

Frontend
Tecnologia	Finalidade
Vitest	Execução de testes unitários.
React Testing Library	Testes de componentes React com foco no comportamento do usuário.
Playwright	Testes End-to-End (E2E).
MSW (Mock Service Worker)	Simulação de respostas da API em testes de interface, quando necessário.

Qualidade
Tecnologia	Finalidade
JaCoCo	Medição da cobertura de código do backend.
SonarQube	Análise estática, métricas de qualidade e identificação de vulnerabilidades.
GitHub Actions	Execução automatizada da pipeline de testes e integração contínua.

1.6 Princípios da Estratégia de Testes
A estratégia de testes do GTP será guiada pelos seguintes princípios:
•	Qualidade desde o início (Shift Left): os testes serão planejados e implementados desde as primeiras etapas do desenvolvimento.
•	Automação prioritária: sempre que possível, os testes serão automatizados para garantir repetibilidade e rapidez nas validações.
•	Cobertura orientada ao risco: funcionalidades críticas terão maior nível de cobertura.
•	Independência dos testes: cada teste deverá ser executável de forma isolada, sem depender de outros testes.
•	Reprodutibilidade: os resultados deverão ser consistentes em diferentes ambientes.
•	Rastreabilidade: cada requisito e regra de negócio deverá possuir testes correspondentes.
•	Integração contínua: a execução dos testes fará parte obrigatória do pipeline de CI/CD.


1.7 Organização da Estratégia
A estratégia de testes está organizada em camadas complementares:
                		 Estratégia de Testes
                         │
     ┌───────────────────┼───────────────────┐
     │                   │                   │
 Testes Unitários   Testes Integração   Testes API
     │                   │                   │
     └───────────────┬───┴───────────────────┘
                     │
             Testes Frontend
                     │
                     ▼
             Testes End-to-End
                     │
                     ▼
      Segurança • Desempenho • Regressão
                     │
                     ▼
             Pipeline CI/CD
Essa abordagem segue o princípio da Pirâmide de Testes, priorizando testes rápidos e automatizados nas camadas inferiores e reservando os testes mais complexos para validação dos fluxos críticos da aplicação.

1.8 Conclusão do Capítulo
Este capítulo apresentou os objetivos, o escopo, o público-alvo, os documentos relacionados, as tecnologias e os princípios que orientam a estratégia de testes do GTP. Ao estabelecer uma visão estruturada e integrada da qualidade, cria-se uma base sólida para garantir que todas as funcionalidades do sistema sejam desenvolvidas, verificadas e evoluídas de forma confiável.
A adoção de uma estratégia abrangente, combinando testes unitários, de integração, de API, de frontend, End-to-End, desempenho e segurança, contribuirá para reduzir defeitos, aumentar a estabilidade da aplicação e apoiar a evolução contínua do projeto.



2 – Arquitetura Geral da Estratégia de Testes
2.1 Objetivo
Este capítulo apresenta a arquitetura da estratégia de testes adotada pelo Gestor de Territórios e Publicações (GTP), definindo como as diferentes camadas de validação trabalham de forma integrada para assegurar a qualidade da aplicação.
A estratégia foi concebida para acompanhar todo o ciclo de vida do software, desde a implementação das funcionalidades até sua disponibilização em produção, promovendo uma cultura de qualidade contínua.
Os principais objetivos são:
•	garantir a confiabilidade da aplicação;
•	detectar defeitos nas fases iniciais do desenvolvimento;
•	reduzir regressões entre versões;
•	validar requisitos funcionais e não funcionais;
•	automatizar o processo de verificação;
•	integrar os testes ao pipeline de CI/CD.

2.2 Princípios Arquiteturais
A arquitetura de testes do GTP segue os mesmos princípios definidos para a arquitetura do sistema.
São eles:
•	Qualidade incorporada ao desenvolvimento (Quality by Design);
•	Automação como padrão;
•	Testabilidade;
•	Baixo acoplamento entre testes;
•	Reprodutibilidade dos ambientes;
•	Cobertura orientada ao risco;
•	Rastreabilidade entre requisitos, código e testes;
•	Integração contínua.
Esses princípios garantem que a estratégia de testes acompanhe a evolução da aplicação sem comprometer sua manutenibilidade.

2.3 Arquitetura Geral da Estratégia de Testes
A validação do sistema será organizada em múltiplas camadas complementares.
                          			 Usuário
                             │
                             ▼
                  Testes End-to-End (Playwright)
                             │
                             ▼
                 Testes da Interface (React)
                             │
                             ▼
                Testes da API REST (MockMvc)
                             │
                             ▼
            Testes de Integração (Spring Boot)
                             │
                             ▼
              Testes Unitários (JUnit + Mockito)
                             │
                             ▼
                      Código da Aplicação
Cada camada possui objetivos específicos e complementares, permitindo detectar defeitos o mais cedo possível.









2.4 Pirâmide de Testes
O GTP adotará a Pirâmide de Testes, priorizando testes rápidos, automatizados e de fácil manutenção.
                    		  ┌────────────────────┐
                 │   Testes E2E       │
                 │   (Playwright)     │
                 └────────────────────┘
                           ▲
                 ┌────────────────────┐
                 │ Testes da API      │
                 │ MockMvc            │
                 └────────────────────┘
                           ▲
              ┌──────────────────────────┐
              │ Testes de Integração     │
              │ Spring Boot +            │
              │ Testcontainers           │
              └──────────────────────────┘
                           ▲
            ┌────────────────────────────────┐
            │ Testes Unitários               │
            │ JUnit • Mockito • AssertJ      │
            └────────────────────────────────┘
Distribuição esperada
Camada	Percentual aproximado
Testes Unitários	65%
Testes de Integração	20%
Testes da API	10%
Testes End-to-End	5%
Essa distribuição favorece rapidez na execução dos testes e facilidade de manutenção.




2.5 Fluxo da Qualidade
A estratégia de testes será integrada ao fluxo de desenvolvimento.

  Requisito
      │
      ▼
Caso de Uso
      │
      ▼
Implementação
      │
      ▼
Teste Unitário
      │
      ▼
Teste de Integração
      │
      ▼
Teste da API
      │
      ▼
Teste Frontend
      │
      ▼
Teste E2E
      │
      ▼
Pipeline CI/CD
      │
      ▼
   Deploy
Cada funcionalidade deverá percorrer todas essas etapas antes de ser considerada pronta para produção.

2.6 Estratégia por Camada da Aplicação
Camada de Domínio
Serão testados:
•	entidades;
•	objetos de valor;
•	regras de negócio;
•	validações;
•	cálculos;
•	comportamentos do domínio.
Objetivo:
Garantir que as regras de negócio sejam executadas corretamente, independentemente das demais camadas.

Camada de Aplicação
Serão testados:
•	casos de uso;
•	serviços;
•	orquestração das operações;
•	validações de entrada;
•	exceções.
Objetivo:
Verificar a implementação correta dos fluxos de negócio.

Camada de Persistência
Serão testados:
•	repositórios;
•	consultas;
•	relacionamentos;
•	migrações Flyway;
•	integridade dos dados;
•	transações.

Objetivo:
Assegurar que a persistência funcione corretamente com um banco PostgreSQL real.

Camada de API
Serão testados:
•	endpoints;
•	autenticação;
•	autorização;
•	serialização;
•	validação dos DTOs;
•	códigos HTTP;
•	tratamento de erros.
Objetivo:
Garantir que a API REST respeite os contratos definidos no Documento 10.

Frontend
Serão testados:
•	componentes React;
•	formulários;
•	Context API;
•	Hooks;
•	navegação;
•	responsividade;
•	estados da interface.
Objetivo:
Garantir a experiência do usuário e o correto funcionamento da interface.

2.7 Critérios de Aceitação
Uma funcionalidade somente será considerada concluída quando atender aos seguintes critérios:
•	implementação concluída;
•	testes unitários aprovados;
•	testes de integração aprovados;
•	testes da API aprovados;
•	testes do frontend aprovados;
•	testes End-to-End aprovados (quando aplicável);
•	cobertura mínima atingida;
•	análise do SonarQube sem bloqueios;
•	documentação atualizada.
Esses critérios reduzem o risco de regressões e mantêm um padrão uniforme de qualidade.
2.8 Integração com CI/CD
Todos os testes serão executados automaticamente na pipeline de integração contínua.
Fluxo previsto:
Commit
   │
   ▼
GitHub
   │
   ▼
GitHub Actions
   │
   ├── Build
   ├── Testes Unitários
   ├── Testes Integração
   ├── Testes API
   ├── Testes Frontend
   ├── SonarQube
   ├── Cobertura
   └── Deploy
A publicação de novas versões dependerá da aprovação de todas as etapas obrigatórias.

2.9 Ambientes de Testes
Serão utilizados ambientes específicos para cada fase do processo.
Ambiente	Finalidade
Local	Desenvolvimento diário.
Testes Automatizados	Execução pela pipeline CI/CD.
Homologação	Validação integrada e testes de aceitação.
Produção	Ambiente oficial do sistema.
Cada ambiente possuirá configurações independentes e banco de dados próprio.

2.10 Rastreabilidade
Todos os testes deverão possuir rastreabilidade com os artefatos do projeto.
Fluxo de rastreabilidade:
  Requisito
      │
      ▼
Regra de Negócio
      │
      ▼
 Caso de Uso
      │
      ▼
  Endpoint
      │
      ▼
   Classe
      │
      ▼
    Teste
Essa estratégia facilita auditorias, manutenção e identificação de impactos durante a evolução do sistema.
2.11 Papéis e Responsabilidades
A qualidade do software será responsabilidade compartilhada por toda a equipe.
Papel	Responsabilidades
Desenvolvedor Backend	Implementar e manter testes unitários, de integração e de API.
Desenvolvedor Frontend	Implementar testes de componentes, hooks e interface.
QA	Planejar, executar e acompanhar testes funcionais e E2E.
DevOps	Integrar os testes à pipeline CI/CD e monitorar sua execução.
Arquiteto de Software	Definir padrões, revisar a estratégia e acompanhar métricas de qualidade.

2.12 Ferramentas da Estratégia
Backend
•	JUnit 5;
•	Mockito;
•	AssertJ;
•	Spring Boot Test;
•	Testcontainers;
•	Flyway.
Frontend
•	Vitest;
•	React Testing Library;
•	Playwright;
•	MSW.

Qualidade
•	JaCoCo;
•	SonarQube;
•	GitHub Actions.
Essas ferramentas foram selecionadas por sua ampla adoção na comunidade Java e React e pela integração com a arquitetura definida para o GTP.

2.13 Métricas de Qualidade
Os seguintes indicadores serão monitorados:
Indicador	Meta
Cobertura geral	≥ 85%
Domínio	≥ 95%
Casos de Uso	≥ 90%
Serviços	≥ 90%
Frontend	≥ 80%
Vulnerabilidades críticas	0
Bugs críticos em produção	0
Build quebrado	0
Essas métricas servirão como referência para acompanhar a evolução da qualidade do projeto.

2.14 Relação com os Demais Documentos
Documento	Relação
Documento 06 – Arquitetura Backend	Define as camadas e componentes testados no backend.
Documento 07 – Arquitetura Frontend	Especifica os elementos da interface cobertos pelos testes.
Documento 08 – Segurança	Orienta os testes de autenticação, autorização e proteção da aplicação.
Documento 09 – Docker	Fornece os ambientes isolados para execução dos testes.
Documento 10 – API REST	Define os contratos validados pelos testes da API.
Documento 11 – DER	Serve de base para os testes de persistência e integridade dos dados.
Documento 12 – Banco de Dados PostgreSQL	Define o ambiente de persistência utilizado nos testes de integração.

2.15 Conclusão do Capítulo
A arquitetura geral da estratégia de testes do GTP estabelece uma abordagem em camadas, combinando testes unitários, de integração, de API, de frontend e End-to-End para garantir a qualidade da aplicação de forma contínua. A adoção da Pirâmide de Testes, aliada à automação, à integração com CI/CD e à rastreabilidade entre requisitos e testes, permite detectar defeitos precocemente, reduzir regressões e aumentar a confiabilidade do sistema.
Essa estratégia está alinhada com a arquitetura do GTP e fornece uma base sólida para o desenvolvimento incremental e sustentável da plataforma.

3 – Testes Unitários
3.1 Objetivo
Os testes unitários constituem a primeira camada da estratégia de qualidade do Gestor de Territórios e Publicações (GTP). Seu propósito é validar o comportamento de unidades isoladas de código, garantindo que regras de negócio, cálculos, validações e fluxos internos funcionem corretamente sem depender de componentes externos.
Os testes unitários deverão ser:
•	rápidos;
•	determinísticos;
•	independentes;
•	automatizados;
•	fáceis de manter.
A execução frequente desses testes permitirá identificar defeitos ainda durante o desenvolvimento, reduzindo significativamente o custo de correções em etapas posteriores.

3.2 Objetivos Específicos
A estratégia de testes unitários busca:
•	validar regras de negócio;
•	verificar cálculos e validações;
•	testar comportamentos esperados e exceções;
•	garantir a estabilidade da camada de domínio;
•	apoiar refatorações com segurança;
•	reduzir regressões;
•	aumentar a confiabilidade do código.

3.3 Escopo
Serão contemplados pelos testes unitários:
Camada de Domínio
•	Entidades
•	Objetos de Valor (Value Objects)
•	Enums
•	Regras de negócio
•	Validações
•	Métodos utilitários

Camada de Aplicação
•	Casos de Uso (Use Cases)
•	Serviços de Aplicação
•	Serviços de Domínio
•	Validadores
•	Conversores
•	Estratégias

Componentes Auxiliares
•	DTOs com lógica
•	Builders
•	Utilitários
•	Helpers
•	Mapeadores (quando houver lógica personalizada)

Não fazem parte do escopo dos testes unitários:
•	Banco de dados;
•	Spring Context;
•	HTTP;
•	PostgreSQL;
•	Docker;
•	API REST;
•	Frontend.
Esses componentes serão validados nas camadas de integração e testes funcionais.



3.4 Arquitetura dos Testes Unitários
Cada unidade será testada de forma isolada.
Classe
   │
Dependências Mockadas
   │
JUnit 5
   │
Mockito
   │
AssertJ
   │
Resultado Esperado
Todas as dependências externas deverão ser simuladas (mockadas) utilizando Mockito.

3.5 Organização dos Testes
A estrutura de diretórios seguirá a organização da aplicação.
src
 ├── main
 │
 └── test
      └── java
           └── br.com.gtp
                ├── domain
                ├── application
                ├── infrastructure
                ├── security
                ├── util
                └── controller
A estrutura dos testes deverá refletir a estrutura do código-fonte para facilitar localização e manutenção.

3.6 Ferramentas Utilizadas
JUnit 5
Framework principal para execução dos testes.
Responsável por:
•	organização dos testes;
•	execução;
•	ciclo de vida;
•	parametrização;
•	agrupamento.

Mockito
Utilizado para:
•	criação de mocks;
•	simulação de dependências;
•	verificação de chamadas;
•	isolamento das unidades testadas.

AssertJ
Utilizado para tornar as asserções mais legíveis.
Exemplo de benefícios:
•	leitura fluida;
•	mensagens claras;
•	maior expressividade.

3.7 Estrutura dos Testes
Cada teste deverá seguir o padrão AAA (Arrange, Act, Assert).
Arrange
Preparação do cenário.
•	criação dos objetos;
•	configuração dos mocks;
•	definição dos dados.

Act
Execução da operação.
Normalmente:
•	chamada do método;
•	execução do caso de uso.

Assert
Verificação dos resultados.
Serão validados:
•	valores retornados;
•	estados;
•	exceções;
•	chamadas aos mocks.

3.8 Convenções de Nomenclatura
Os nomes dos métodos de teste deverão descrever claramente o comportamento esperado.
Formato recomendado:
deve<Comportamento>Quando<Condição>()
Exemplos:
deveCadastrarPublicadorQuandoDadosValidos()
deveLancarExcecaoQuandoEmailDuplicado()
deveAtualizarTerritorioQuandoAdministrador()
deveNegarLoginQuandoSenhaInvalida()
Essa convenção facilita a leitura e a identificação de falhas.

3.9 Testes das Entidades
As entidades deverão possuir testes para:
•	criação;
•	atualização;
•	estados válidos;
•	estados inválidos;
•	validações;
•	igualdade;
•	regras internas.
Exemplo:
Publicador
Testes previstos:
•	criação válida;
•	telefone obrigatório;
•	e-mail válido;
•	alteração de endereço;
•	mudança de situação.

3.10 Testes dos Casos de Uso
Os casos de uso representam a principal camada de regras de negócio.
Cada caso de uso deverá possuir testes contemplando:
•	fluxo principal;
•	fluxos alternativos;
•	exceções;
•	regras de autorização;
•	validações.

Exemplo:
Cadastrar Publicador
Cenários:
•	cadastro realizado;
•	nome obrigatório;
•	e-mail duplicado;
•	congregação inexistente;
•	usuário sem permissão.

3.11 Testes dos Serviços
Serviços deverão validar:
•	processamento;
•	integração entre componentes;
•	regras auxiliares;
•	tratamento de erros.
Dependências serão simuladas por mocks.

3.12 Testes dos Repositórios
Os repositórios não serão testados unitariamente.
A validação será realizada nos testes de integração utilizando:
•	Spring Boot Test;
•	Testcontainers;
•	PostgreSQL.
Isso evita testes artificiais de consultas SQL.

3.13 Testes dos Controllers
Os controllers também não serão testados unitariamente.
Sua validação ocorrerá por meio de:
•	MockMvc;
•	Spring Boot Test.
O objetivo é testar o comportamento HTTP real.

3.14 Testes de Exceções
Todas as exceções relevantes deverão possuir testes específicos.
Exemplos:
•	recurso não encontrado;
•	acesso negado;
•	validação;
•	conflito de dados;
•	operação inválida.
Cada exceção deverá verificar:
•	tipo;
•	mensagem;
•	comportamento esperado.

3.15 Testes Parametrizados
Sempre que houver múltiplos cenários semelhantes, deverão ser utilizados testes parametrizados do JUnit 5.
Exemplos:
•	CPF;
•	telefone;
•	e-mail;
•	datas;
•	formatos.
Essa abordagem reduz duplicação de código e amplia a cobertura.
3.16 Cobertura Esperada
Metas mínimas:
Camada	Cobertura
Domínio	≥ 95%
Casos de Uso	≥ 90%
Serviços	≥ 90%
Utilitários	≥ 95%
Cobertura Geral dos Testes Unitários	≥ 90%
A cobertura será monitorada automaticamente pelo JaCoCo e integrada ao SonarQube.

3.17 Boas Práticas
Os testes unitários deverão seguir as seguintes recomendações:
•	testar apenas uma responsabilidade por teste;
•	manter testes independentes;
•	evitar dependência entre testes;
•	utilizar dados simples e representativos;
•	não acessar banco de dados;
•	não acessar arquivos externos;
•	utilizar mocks apenas para dependências externas;
•	evitar lógica complexa nos próprios testes;
•	manter os testes tão legíveis quanto o código de produção.

3.18 Antipadrões
Devem ser evitados:
•	testes frágeis (fragile tests);
•	duplicação excessiva;
•	uso indiscriminado de mocks;
•	dependência da ordem de execução;
•	esperas artificiais (Thread.sleep);
•	testes excessivamente longos;
•	múltiplas verificações sem relação no mesmo método.
Esses antipadrões dificultam a manutenção e reduzem a confiabilidade da suíte de testes.

3.19 Integração com CI/CD
Os testes unitários serão executados automaticamente:
•	em cada commit;
•	em cada Pull Request;
•	antes do merge para a branch principal;
•	antes de qualquer implantação.
A falha em qualquer teste impedirá a continuidade da pipeline.

3.20 Relação com os Demais Documentos
Documento	Relação
Documento 03 – Regras de Negócio	Define as regras que deverão ser cobertas pelos testes unitários.
Documento 04 – Casos de Uso	Fornece os fluxos de negócio validados nesta camada.
Documento 06 – Arquitetura Backend	Define as classes, serviços e componentes testados.
Documento 08 – Segurança	Estabelece as regras de autenticação e autorização verificadas pelos testes.
Documento 10 – API REST	Complementa os testes unitários com validações dos contratos HTTP.

3.21 Conclusão do Capítulo
Os testes unitários representam a base da estratégia de qualidade do GTP, permitindo validar de forma rápida e isolada as regras de negócio e os componentes internos da aplicação. Ao priorizar testes independentes, legíveis e automatizados, o projeto reduz o risco de regressões e cria uma base sólida para refatorações e evolução contínua.
A combinação de JUnit 5, Mockito, AssertJ, JaCoCo e SonarQube proporciona um ambiente robusto para desenvolvimento orientado à qualidade, garantindo que cada nova funcionalidade seja acompanhada de uma suíte de testes correspondente.

4 – Testes de Integração
4.1 Objetivo
Os testes de integração têm como objetivo validar o funcionamento conjunto dos componentes do Gestor de Territórios e Publicações (GTP), assegurando que as diferentes camadas da aplicação interajam corretamente em um ambiente o mais próximo possível da produção.
Enquanto os testes unitários verificam componentes isolados, os testes de integração confirmam que a comunicação entre serviços, repositórios, banco de dados, segurança e infraestrutura ocorre de forma consistente.
Os principais objetivos são:
•	validar a integração entre as camadas da aplicação;
•	garantir o correto funcionamento da persistência de dados;
•	verificar a execução das migrações Flyway;
•	assegurar a integridade das transações;
•	detectar problemas de configuração do ambiente;
•	validar consultas ao PostgreSQL;
•	confirmar o comportamento esperado da aplicação em cenários reais.

4.2 Escopo
Os testes de integração abrangerão os seguintes componentes:
Camada de Persistência
•	Repositórios Spring Data JPA;
•	Consultas personalizadas;
•	Entidades JPA;
•	Relacionamentos;
•	Transações;
•	Índices e restrições.
Banco de Dados
•	PostgreSQL;
•	Flyway;
•	Integridade referencial;
•	Constraints;
•	Views;
•	Funções auxiliares.
Camada de Aplicação
•	Serviços;
•	Casos de Uso;
•	Componentes de infraestrutura;
•	Conversores;
•	Validadores.
Segurança
•	Spring Security;
•	JWT;
•	Controle de acesso;
•	Perfis de usuários.

4.3 Arquitetura dos Testes de Integração
A arquitetura dos testes será baseada em componentes reais, reduzindo o uso de mocks.
  JUnit 5
     │
Spring Boot Test
     │
Testcontainers
     │
PostgreSQL
     │
  Flyway
     │
Spring Data JPA
     │
  Serviços
     │
Resultado Validado
Essa abordagem aumenta a confiabilidade dos testes e aproxima o ambiente de teste das condições de produção.

4.4 Spring Boot Test
O framework Spring Boot Test será utilizado para carregar o contexto da aplicação durante os testes.
Principais responsabilidades:
•	inicializar o contexto Spring;
•	injetar dependências reais;
•	configurar perfis de teste;
•	disponibilizar os componentes da aplicação.
Essa abordagem permite validar a integração entre os diferentes módulos sem a necessidade de inicializar toda a infraestrutura de produção.
4.5 Testcontainers
O GTP utilizará o Testcontainers para executar um banco PostgreSQL real durante os testes de integração.
Benefícios
•	ambiente isolado;
•	banco descartável;
•	repetibilidade;
•	independência da máquina do desenvolvedor;
•	compatibilidade com CI/CD.
Fluxo simplificado:
Teste
   │
   ▼
Testcontainers
   │
   ▼
Container PostgreSQL
   │
   ▼
Flyway
   │
   ▼
Banco Pronto
   │
   ▼
Execução dos Testes
Essa estratégia elimina diferenças entre ambientes e reduz falhas relacionadas à configuração local.

4.6 Integração com Flyway
Antes da execução dos testes, o Flyway aplicará automaticamente todas as migrações do banco de dados.
Fluxo:
1.	criação do contêiner PostgreSQL;
2.	aplicação das migrações Flyway;
3.	inicialização do contexto Spring;
4.	execução dos testes;
5.	descarte do ambiente.
Essa integração garante que todos os testes utilizem a estrutura oficial do banco de dados.

4.7 Testes dos Repositórios
Os repositórios deverão ser testados utilizando o banco PostgreSQL real.
Serão validados:
•	inserção;
•	atualização;
•	exclusão;
•	consultas por identificador;
•	consultas paginadas;
•	filtros;
•	ordenação;
•	consultas personalizadas;
•	relacionamentos.
Exemplo de cenários:
•	localizar publicador por e-mail;
•	listar territórios ativos;
•	consultar designações por período;
•	recuperar publicações pendentes.

4.8 Testes de Persistência
Os testes de persistência verificarão:
•	mapeamentos JPA;
•	chaves primárias;
•	chaves estrangeiras;
•	restrições de unicidade;
•	integridade referencial;
•	cascatas;
•	carregamento (lazy e eager);
•	versionamento otimista (optimistic locking), quando utilizado.
Esses testes asseguram que o modelo implementado corresponda ao DER definido no Documento 11.

4.9 Testes de Transações
As transações deverão ser validadas para garantir a consistência dos dados.
Cenários previstos:
•	confirmação (commit) em operações bem-sucedidas;
•	reversão (rollback) em caso de erro;
•	comportamento em exceções;
•	integridade após falhas.
Esses testes são essenciais para operações que envolvem múltiplas entidades.

4.10 Testes das Migrações
Cada nova migração Flyway deverá ser validada.
Aspectos verificados:
•	criação correta das tabelas;
•	inclusão de colunas;
•	criação de índices;
•	restrições;
•	dados iniciais;
•	compatibilidade com versões anteriores.
As migrações deverão ser executadas integralmente em um banco vazio antes de qualquer implantação.

4.11 Testes de Segurança Integrada
A integração entre Spring Security e o restante da aplicação deverá ser validada.
Serão testados:
•	autenticação;
•	autorização;
•	perfis de acesso;
•	filtros de segurança;
•	acesso negado;
•	recursos protegidos.
Exemplos:
•	usuário autenticado acessando recurso permitido;
•	usuário sem permissão recebendo resposta HTTP 403;
•	requisição sem token recebendo HTTP 401.

4.12 Dados de Teste
Os testes utilizarão dados controlados.
Boas práticas:
•	criar apenas os dados necessários;
•	evitar dependência entre cenários;
•	limpar o ambiente após a execução, quando necessário;
•	utilizar builders e factories para facilitar a criação de objetos.
Sempre que possível, cada teste deverá preparar seu próprio conjunto de dados.


4.13 Ambiente de Testes
O ambiente de integração será composto pelos seguintes elementos:
Componente	Tecnologia
Aplicação	Spring Boot
Banco de Dados	PostgreSQL
Contêiner	Testcontainers
Migrações	Flyway
Framework de Testes	JUnit 5
Build	Maven
Essa configuração garante consistência entre os ambientes local, CI/CD e homologação.

4.14 Integração com CI/CD
Os testes de integração serão executados automaticamente:
•	em Pull Requests;
•	antes do merge na branch principal;
•	antes da geração de artefatos de implantação;
•	durante a validação de versões.
A falha em qualquer teste impedirá a continuidade da pipeline.

4.15 Métricas
Serão monitorados os seguintes indicadores:
Indicador	Meta
Sucesso dos testes de integração	100%
Tempo médio de execução	Inferior a 10 minutos por pipeline*
Falhas por configuração	0
Falhas por migração	0
Cobertura dos repositórios	100% dos métodos críticos
* O tempo poderá variar conforme a infraestrutura utilizada pela equipe de CI/CD.

4.16 Boas Práticas
Durante a implementação dos testes de integração deverão ser observadas as seguintes recomendações:
•	utilizar banco PostgreSQL real por meio do Testcontainers;
•	evitar mocks desnecessários;
•	executar as migrações Flyway antes dos testes;
•	manter os testes independentes;
•	validar fluxos completos;
•	utilizar transações sempre que apropriado;
•	manter os testes determinísticos e reprodutíveis.

4.17 Antipadrões
Devem ser evitados:
•	compartilhamento de dados entre testes;
•	dependência da ordem de execução;
•	uso de banco local compartilhado;
•	manipulação manual do esquema durante os testes;
•	criação de cenários excessivamente complexos;
•	dependência de serviços externos sem necessidade.
Esses antipadrões reduzem a confiabilidade e dificultam a manutenção da suíte de testes.
4.18 Relação com os Demais Documentos
Documento	Relação
Documento 06 – Arquitetura Backend	Define os componentes integrados nesta camada de testes.
Documento 08 – Segurança	Estabelece as regras de autenticação e autorização verificadas nos testes.
Documento 09 – Docker	Fornece a base para a infraestrutura utilizada pelo Testcontainers.
Documento 10 – API REST	Complementa os testes de integração com a validação dos contratos HTTP.
Documento 11 – DER	Define o modelo de dados utilizado nos testes de persistência.
Documento 12 – Banco de Dados PostgreSQL	Especifica a estrutura física validada durante a execução das migrações e consultas.

4.19 Conclusão do Capítulo
Os testes de integração desempenham um papel essencial na garantia da qualidade do GTP ao validar a interação entre os diversos componentes da aplicação em um ambiente próximo ao de produção. A utilização de Spring Boot Test, Testcontainers, PostgreSQL e Flyway proporciona um ambiente confiável, reproduzível e alinhado às práticas modernas de desenvolvimento.
Ao integrar esses testes à pipeline de CI/CD, o projeto reduz significativamente o risco de falhas decorrentes de configurações incorretas, incompatibilidades entre camadas ou problemas de persistência, fortalecendo a estabilidade da plataforma.

5 – Testes da API REST
5.1 Objetivo
Os testes da API REST têm como objetivo validar que todos os endpoints do Gestor de Territórios e Publicações (GTP) atendam aos contratos definidos no Documento 10 – API REST, garantindo comportamento consistente, seguro e previsível para consumidores da API.
Esta camada de testes verifica a comunicação HTTP entre clientes e servidor, assegurando que as requisições sejam processadas corretamente, que as respostas estejam no formato esperado e que os mecanismos de autenticação, autorização e tratamento de erros funcionem adequadamente.
Os principais objetivos são:
•	validar todos os endpoints REST;
•	garantir conformidade com a especificação OpenAPI;
•	verificar autenticação e autorização;
•	validar regras de entrada e saída de dados;
•	testar códigos de resposta HTTP;
•	assegurar compatibilidade entre versões da API;
•	detectar regressões antes da publicação de novas versões.

5.2 Escopo
Os testes desta camada contemplam:
Endpoints
•	GET
•	POST
•	PUT
•	PATCH
•	DELETE
Recursos
•	Autenticação
•	Usuários
•	Congregações
•	Publicadores
•	Territórios
•	Designações
•	Publicações
•	Estudos Bíblicos
•	Notificações
•	Configurações
•	Relatórios
Aspectos Técnicos
•	Headers HTTP
•	Query Parameters
•	Path Variables
•	Request Body
•	Response Body
•	Paginação
•	Ordenação
•	Filtros
•	Upload e Download de arquivos (quando implementados)












5.3 Arquitetura dos Testes
Os testes utilizarão componentes reais da aplicação, simulando apenas a camada HTTP quando apropriado.
Cliente HTTP
      │
      ▼
MockMvc / Spring Boot Test
      │
      ▼
Controller REST
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
PostgreSQL (Testcontainers)
Essa abordagem permite validar o comportamento da API sem necessidade de iniciar um servidor externo.

5.4 Ferramentas Utilizadas
Ferramenta	Finalidade
Spring Boot Test	Inicialização do contexto da aplicação.
MockMvc	Execução de requisições HTTP simuladas.
JUnit 5	Framework de testes.
AssertJ	Asserções.
Jackson	Serialização e desserialização JSON.
Testcontainers	Banco PostgreSQL real durante os testes.
Flyway	Preparação automática do banco de testes.


5.5 Testes dos Métodos HTTP
Cada endpoint deverá possuir cenários cobrindo os principais métodos HTTP.
GET
Validar:
•	busca por identificador;
•	listagem;
•	paginação;
•	filtros;
•	ordenação;
•	ausência de registros.

POST
Validar:
•	criação com sucesso;
•	dados inválidos;
•	campos obrigatórios;
•	conflitos;
•	duplicidade.

PUT
Validar:
•	atualização completa;
•	recurso inexistente;
•	validações;
•	controle de concorrência, quando aplicável.


PATCH
Validar:
•	atualização parcial;
•	alteração de estado;
•	campos específicos.

DELETE
Validar:
•	remoção bem-sucedida;
•	recurso inexistente;
•	restrições de integridade;
•	exclusão lógica (soft delete), quando utilizada.

5.6 Validação dos DTOs
Os objetos de transferência de dados (DTOs) deverão ser testados quanto às validações declaradas.
Exemplos:
•	campos obrigatórios;
•	tamanho mínimo e máximo;
•	formatos válidos;
•	e-mail;
•	telefone;
•	datas;
•	valores numéricos.
Cada regra deverá gerar respostas padronizadas em caso de erro.


5.7 Autenticação
Os testes deverão validar o fluxo completo de autenticação.
Cenários previstos:
•	login com credenciais válidas;
•	login com senha incorreta;
•	usuário inexistente;
•	usuário bloqueado (caso implementado);
•	token JWT válido;
•	token expirado;
•	token inválido;
•	ausência de token.

5.8 Autorização
Os testes verificarão o controle de acesso baseado em perfis (roles).
Exemplos:
Perfil	Cenário
Administrador	Acesso permitido aos recursos administrativos.
Publicador	Acesso apenas aos recursos autorizados.
Usuário sem permissão	Resposta HTTP 403 (Forbidden).
Usuário não autenticado	Resposta HTTP 401 (Unauthorized).

5.9 Validação das Respostas
Cada endpoint deverá validar:
•	código HTTP;
•	estrutura JSON;
•	tipos dos campos;
•	valores retornados;
•	mensagens;
•	metadados de paginação;
•	links HATEOAS (caso adotados futuramente).
Exemplo de resposta esperada:
{
  "id": 15,
  "nome": "João Silva",
  "email": "joao@email.com",
  "situacao": "ATIVO"
}

5.10 Tratamento de Erros
Todos os erros deverão seguir o padrão definido no Documento 10.
Exemplos:
Situação	HTTP
Recurso não encontrado	404
Dados inválidos	400
Não autenticado	401
Sem permissão	403
Conflito	409
Erro interno	500
Além do código HTTP, será validado o conteúdo da resposta de erro, incluindo identificador da ocorrência, mensagem e detalhes quando apropriado.



5.11 Paginação, Ordenação e Filtros
Os testes deverão validar:
•	paginação;
•	ordenação crescente;
•	ordenação decrescente;
•	múltiplos critérios de ordenação;
•	filtros combinados;
•	pesquisa textual;
•	resultados vazios.
Também serão verificados os metadados retornados, como número da página, tamanho, total de elementos e total de páginas.

5.12 Contratos da API
A API deverá permanecer compatível com a especificação OpenAPI.
Serão verificados:
•	endpoints existentes;
•	parâmetros;
•	tipos de dados;
•	respostas documentadas;
•	códigos HTTP previstos;
•	exemplos de requisição e resposta.
Mudanças incompatíveis deverão ser evitadas ou introduzidas por meio de uma nova versão da API.

5.13 Testes de Versionamento
Quando houver múltiplas versões da API, serão validados:
•	coexistência entre versões;
•	compatibilidade retroativa;
•	depreciação controlada;
•	funcionamento dos clientes existentes.
Isso reduz impactos sobre aplicações consumidoras durante a evolução do sistema.

5.14 Integração com Segurança
Os testes da API serão integrados ao Spring Security.
Serão verificados:
•	filtros JWT;
•	autenticação;
•	autorização;
•	expiração de tokens;
•	renovação de tokens (quando implementada);
•	acesso a recursos protegidos.

5.15 Automação
Todos os testes da API serão executados automaticamente:
•	durante o desenvolvimento;
•	em Pull Requests;
•	na pipeline CI/CD;
•	antes do deploy.
A aprovação dos testes será requisito obrigatório para publicação de novas versões.





5.16 Métricas
Serão acompanhados os seguintes indicadores:
Indicador	Meta
Endpoints testados	100%
Recursos críticos cobertos	100%
Testes aprovados	100%
Falhas críticas	0
Cobertura da camada de API	≥ 90%

5.17 Boas Práticas
Durante a implementação dos testes da API deverão ser observadas as seguintes recomendações:
•	validar sempre o código HTTP e o corpo da resposta;
•	testar cenários positivos e negativos;
•	manter independência entre os testes;
•	utilizar dados de teste controlados;
•	evitar dependência da ordem de execução;
•	automatizar a preparação do ambiente com Flyway e Testcontainers;
•	manter os testes sincronizados com a documentação OpenAPI.

5.18 Antipadrões
Devem ser evitados:
•	testes dependentes entre si;
•	validação apenas do código HTTP, sem verificar o conteúdo da resposta;
•	uso de dados compartilhados entre cenários;
•	repetição excessiva de código;
•	alteração manual do banco de testes durante a execução;
•	ausência de testes para cenários de erro.

5.19 Relação com os Demais Documentos
Documento	Relação
Documento 06 – Arquitetura Backend	Define os controladores, serviços e repositórios exercitados pelos testes da API.
Documento 08 – Segurança	Estabelece os mecanismos de autenticação e autorização validados nesta camada.
Documento 09 – Docker	Disponibiliza a infraestrutura utilizada durante os testes automatizados.
Documento 10 – API REST	Define os contratos, endpoints e padrões que devem ser respeitados.
Documento 11 – DER	Fornece o modelo de dados utilizado nas operações persistentes.
Documento 12 – Banco de Dados PostgreSQL	Especifica a estrutura física validada durante os testes de persistência da API.

5.20 Conclusão do Capítulo
Os testes da API REST garantem que a principal interface de comunicação do GTP permaneça consistente, segura e aderente aos contratos definidos para integração entre frontend e backend. Ao validar endpoints, autenticação, autorização, regras de negócio, formatos de dados e tratamento de erros, essa camada reduz significativamente o risco de incompatibilidades e regressões.
Combinados aos testes unitários e de integração, os testes da API constituem um dos pilares da estratégia de qualidade do projeto, assegurando que novas funcionalidades possam ser incorporadas sem comprometer a estabilidade da plataforma.



6 – Testes do Frontend
6.1 Objetivo
Os testes do frontend têm como objetivo garantir que a interface do Gestor de Territórios e Publicações (GTP) ofereça uma experiência consistente, acessível, responsiva e confiável aos usuários.
Esta camada da estratégia de testes valida o comportamento da aplicação React sob a perspectiva do usuário, assegurando que componentes, páginas, formulários, navegação e fluxos de interação funcionem corretamente em diferentes cenários.
Os testes do frontend complementam os testes unitários, de integração e da API REST, formando uma estratégia de qualidade abrangente para toda a aplicação.
Os principais objetivos são:
•	validar o comportamento dos componentes React;
•	verificar a renderização correta da interface;
•	garantir o funcionamento da navegação;
•	testar formulários e validações;
•	assegurar o correto gerenciamento de estado;
•	validar a comunicação com a API;
•	verificar requisitos de acessibilidade;
•	reduzir regressões na interface.

6.2 Escopo
Os testes do frontend abrangerão todos os módulos da aplicação.
Componentes
•	Botões;
•	Campos de entrada;
•	Tabelas;
•	Cards;
•	Modais;
•	Menus;
•	Barra lateral;
•	Cabeçalho;
•	Componentes reutilizáveis.

Páginas
•	Login;
•	Dashboard;
•	Usuários;
•	Congregações;
•	Publicadores;
•	Territórios;
•	Designações;
•	Publicações;
•	Estudos Bíblicos;
•	Relatórios;
•	Configurações.

Funcionalidades
•	Navegação;
•	Autenticação;
•	Controle de permissões;
•	Filtros;
•	Pesquisa;
•	Paginação;
•	Upload de arquivos (quando implementado);
•	Exportação de dados (quando implementada).

6.3 Arquitetura dos Testes
Os testes serão organizados de forma semelhante à estrutura da aplicação.
Componente React
        │
     Vitest
        │
React Testing Library
        │
MSW (quando necessário)
        │
Simulação do Usuário
        │
Validação do Comportamento

Essa arquitetura privilegia testes baseados no comportamento observado pelo usuário, evitando dependência de detalhes internos de implementação.

6.4 Ferramentas Utilizadas
Ferramenta	Finalidade
Vitest	Execução dos testes unitários do frontend.
React Testing Library	Testes de componentes focados no comportamento do usuário.
MSW (Mock Service Worker)	Simulação de respostas da API quando necessário.
Playwright	Testes End-to-End da aplicação.
Vite	Ambiente de execução dos testes.





6.5 Organização dos Testes
A estrutura dos testes deverá acompanhar a organização dos componentes da aplicação.
src
│
├── components
│     ├── Button
│     │      ├── Button.jsx
│     │      └── Button.test.jsx
│     │
│     ├── Modal
│     ├── Table
│     └── Sidebar
│
├── pages
│     ├── Dashboard
│     ├── Login
│     ├── Publicadores
│     └── Territorios
│
├── hooks
├── contexts
├── services
└── tests
Essa organização facilita a localização e manutenção dos testes.

6.6 Testes de Componentes
Cada componente deverá possuir testes que validem:
•	renderização;
•	propriedades (props);
•	eventos;
•	estados;
•	acessibilidade;
•	comportamento esperado.
Exemplo:
Botão
Cenários:
•	renderização correta;
•	clique;
•	estado desabilitado;
•	indicador de carregamento;
•	acessibilidade por teclado.

6.7 Testes de Hooks
Os hooks personalizados deverão ser testados isoladamente.
Serão validados:
•	estados internos;
•	atualização de dados;
•	efeitos colaterais;
•	tratamento de erros;
•	chamadas à API;
•	limpeza de recursos.
Exemplos:
•	useAuth
•	usePagination
•	useApi
•	usePermissions

6.8 Testes da Context API
Os contextos da aplicação deverão possuir testes específicos.
Exemplos:
•	AuthContext;
•	ThemeContext (caso implementado);
•	NotificationContext;
•	ConfigContext.
Serão verificados:
•	estado inicial;
•	atualização do estado;
•	compartilhamento entre componentes;
•	persistência quando aplicável.

6.9 Testes de Rotas
A navegação da aplicação deverá ser validada.
Serão testados:
•	rotas públicas;
•	rotas protegidas;
•	redirecionamentos;
•	páginas inexistentes (404);
•	permissões por perfil;
•	navegação após login e logout.
Esses testes garantirão o correto funcionamento do React Router.

6.10 Testes de Formulários
Todos os formulários deverão possuir testes para:
•	preenchimento dos campos;
•	validações;
•	envio correto;
•	mensagens de erro;
•	limpeza dos campos;
•	estados de carregamento;
•	prevenção de múltiplos envios.
Exemplos:
Cadastro de Publicador
Validações:
•	nome obrigatório;
•	e-mail válido;
•	telefone;
•	congregação obrigatória;
•	mensagem de sucesso.

6.11 Testes de Comunicação com a API
A comunicação entre frontend e backend será validada utilizando o MSW (Mock Service Worker) sempre que o objetivo for isolar a interface da disponibilidade da API.
Serão testados:
•	carregamento de dados;
•	estados de carregamento (loading);
•	tratamento de erros;
•	mensagens de sucesso;
•	respostas vazias;
•	falhas de autenticação;
•	indisponibilidade do serviço.
Quando o objetivo for validar a integração completa entre frontend e backend, os testes deverão utilizar a API real em um ambiente de integração.

6.12 Testes de Acessibilidade
A interface deverá atender às boas práticas de acessibilidade.
Serão verificados:
•	navegação por teclado;
•	foco dos componentes;
•	textos alternativos;
•	contraste adequado;
•	uso correto de elementos semânticos;
•	associação entre rótulos (labels) e campos de formulário;
•	mensagens compreensíveis para tecnologias assistivas.
Sempre que possível, serão incorporadas ferramentas automatizadas de verificação de acessibilidade ao processo de testes.

6.13 Testes de Responsividade
A interface deverá ser validada nos principais pontos de quebra definidos para o projeto.
Larguras mínimas previstas:
Dispositivo	Resolução
Smartphone pequeno	320 px
Smartphone padrão	375 px
Smartphone grande	425 px
Tablet	768 px
Notebook	1366 px
Desktop	1920 px
Além da adaptação visual, serão verificados o funcionamento dos componentes e a usabilidade em cada resolução.

6.14 Testes de Estados da Interface
Cada componente deverá ser testado em diferentes estados.
Exemplos:
•	carregando;
•	vazio;
•	sucesso;
•	erro;
•	desabilitado;
•	sem permissão;
•	dados incompletos.
Esses cenários garantem que a interface permaneça consistente em diferentes condições de uso.

6.15 Boas Práticas
Durante a implementação dos testes do frontend deverão ser observadas as seguintes recomendações:
•	testar o comportamento observado pelo usuário, e não detalhes internos de implementação;
•	utilizar consultas da React Testing Library baseadas em papéis (roles), rótulos e textos visíveis;
•	evitar dependência de seletores frágeis;
•	manter os testes independentes;
•	utilizar dados de teste simples e representativos;
•	reutilizar funções auxiliares para reduzir duplicação;
•	manter componentes desacoplados para facilitar os testes.

6.16 Antipadrões
Devem ser evitados:
•	testes dependentes da estrutura interna do componente;
•	excesso de snapshots sem validação de comportamento;
•	dependência da ordem de execução dos testes;
•	duplicação excessiva de cenários;
•	uso desnecessário de temporizações artificiais;
•	manipulação direta do estado interno dos componentes.
Esses antipadrões tornam os testes frágeis e dificultam sua manutenção.

6.17 Integração com CI/CD
Os testes do frontend serão executados automaticamente:
•	a cada commit;
•	em todas as Pull Requests;
•	antes do merge para a branch principal;
•	antes da publicação de novas versões.
Falhas nessa etapa impedirão a continuidade da pipeline de integração contínua.

6.18 Métricas
Serão monitorados os seguintes indicadores:
Indicador	Meta
Cobertura dos componentes	≥ 80%
Cobertura dos hooks	≥ 90%
Cobertura dos contextos	≥ 90%
Testes aprovados	100%
Componentes críticos cobertos	100%
Falhas críticas de interface	0
As métricas serão acompanhadas periodicamente para orientar melhorias contínuas na qualidade da interface.


6.19 Relação com os Demais Documentos
Documento	Relação
Documento 07 – Arquitetura Frontend	Define a organização dos componentes, páginas e serviços testados neste capítulo.
Documento 08 – Segurança	Fornece as regras de autenticação e autorização validadas na interface.
Documento 10 – API REST	Define os contratos consumidos pelos serviços HTTP do frontend.
Documento 13 – Estratégia de Testes	Complementa os testes unitários, de integração e da API com a validação da camada de apresentação.

6.20 Conclusão do Capítulo
Os testes do frontend garantem que a interface do GTP permaneça consistente, acessível e alinhada às expectativas dos usuários. Ao validar componentes, páginas, navegação, formulários e comunicação com a API sob a perspectiva do comportamento do usuário, essa camada reduz regressões e aumenta a confiabilidade da aplicação.
A utilização do Vitest, da React Testing Library, do MSW e do Playwright estabelece uma estratégia moderna e robusta de validação da interface, integrada às demais camadas de testes e ao pipeline de integração contínua.

7 – Testes End-to-End (E2E)
7.1 Objetivo
Os testes End-to-End (E2E) representam a camada mais alta da estratégia de testes do Gestor de Territórios e Publicações (GTP). Seu objetivo é validar o funcionamento completo da aplicação sob a perspectiva do usuário final, verificando a interação entre frontend, backend, banco de dados e infraestrutura.
Enquanto os testes unitários, de integração e da API avaliam componentes específicos, os testes E2E garantem que os fluxos completos de negócio funcionem corretamente em um ambiente próximo ao de produção.
Os principais objetivos são:
•	validar jornadas completas dos usuários;
•	verificar a integração entre todas as camadas do sistema;
•	detectar regressões em funcionalidades críticas;
•	garantir que os requisitos funcionais sejam atendidos;
•	aumentar a confiança antes da implantação em produção.

7.2 Escopo
Os testes E2E abrangerão os principais fluxos operacionais do GTP.
Fluxos de Autenticação
•	Login;
•	Logout;
•	Renovação de sessão (quando implementada);
•	Recuperação de acesso (quando implementada).
Gestão de Usuários
•	Cadastro;
•	Alteração;
•	Exclusão;
•	Controle de permissões.
Congregações
•	Cadastro;
•	Alteração;
•	Consulta;
•	Exclusão.
Publicadores
•	Cadastro;
•	Atualização;
•	Pesquisa;
•	Mudança de situação;
•	Exclusão lógica.
Territórios
•	Cadastro;
•	Designação;
•	Devolução;
•	Histórico.
Publicações
•	Cadastro;
•	Consulta;
•	Atualização;
•	Controle de estoque.
Estudos Bíblicos
•	Cadastro;
•	Atualização;
•	Acompanhamento;
•	Encerramento.
Relatórios
•	Geração;
•	Filtros;
•	Exportação (quando implementada).






7.3 Arquitetura dos Testes E2E
Os testes E2E utilizarão a aplicação completa em execução.
Playwright
      │
      ▼
Frontend React
      │
HTTPS
      │
      ▼
API REST Spring Boot
      │
Spring Security
      │
Spring Data JPA
      │
PostgreSQL
Essa arquitetura reproduz o ambiente real de utilização da aplicação.

7.4 Ferramentas Utilizadas
Ferramenta	Finalidade
Playwright	Automação dos testes E2E.
JUnit 5 (quando aplicável)	Organização de cenários complementares.
GitHub Actions	Execução automatizada na pipeline.
Docker Compose	Preparação do ambiente de testes.
PostgreSQL	Persistência dos dados.
O Playwright foi escolhido por oferecer suporte moderno a múltiplos navegadores, excelente desempenho e integração com pipelines de CI/CD.

7.5 Estratégia dos Testes
Cada cenário deverá reproduzir o comportamento esperado de um usuário.

Fluxo básico:
Usuário
    │
Login
    │
Navegação
    │
Operação
    │
Persistência
    │
Validação
    │
Logout
Cada teste deverá ser independente e iniciar em um estado conhecido do sistema.

7.6 Cenários Críticos
Os fluxos considerados críticos deverão possuir cobertura obrigatória.
Autenticação
•	login válido;
•	login inválido;
•	logout;
•	acesso sem autenticação;
•	sessão expirada.

Gestão de Usuários
•	cadastrar usuário;
•	editar usuário;
•	alterar perfil;
•	bloquear usuário (quando implementado);
•	remover usuário.

Gestão de Publicadores
•	cadastrar publicador;
•	editar cadastro;
•	consultar;
•	pesquisar;
•	alterar situação;
•	excluir logicamente.

Gestão de Territórios
•	cadastrar território;
•	editar território;
•	designar território;
•	devolver território;
•	consultar histórico.

Gestão de Publicações
•	cadastrar publicação;
•	atualizar estoque;
•	consultar catálogo.

Relatórios
•	gerar relatório;
•	aplicar filtros;
•	exportar dados.



7.7 Validação da Interface
Durante a execução dos testes serão verificados:
•	carregamento das páginas;
•	elementos visíveis;
•	mensagens de sucesso;
•	mensagens de erro;
•	indicadores de carregamento;
•	navegação;
•	menus;
•	componentes dinâmicos.
A validação será baseada no comportamento percebido pelo usuário.

7.8 Validação da Persistência
Após cada operação relevante, os testes deverão confirmar que os dados foram persistidos corretamente.
Exemplos:
•	cadastro disponível em consultas;
•	atualização refletida nas listagens;
•	exclusão lógica respeitada;
•	alterações mantidas após novo acesso.

7.9 Testes de Segurança
Os testes E2E também validarão aspectos relacionados à segurança.
Serão verificados:
•	autenticação;
•	autorização;
•	rotas protegidas;
•	expiração de sessão;
•	acesso por diferentes perfis;
•	proteção contra acesso indevido.

7.10 Dados de Teste
Cada cenário utilizará dados controlados.
Boas práticas:
•	dados independentes;
•	criação automática do ambiente;
•	limpeza após execução, quando necessário;
•	reutilização de fixtures.
Sempre que possível, os testes deverão ser executados sem depender de dados previamente existentes.

7.11 Navegadores Suportados
Os testes serão executados nos principais navegadores suportados pelo Playwright.
Navegador	Situação
Chromium	Obrigatório
Firefox	Obrigatório
WebKit	Obrigatório
Essa estratégia amplia a confiabilidade da interface em diferentes ambientes.

7.12 Responsividade
Os testes validarão a interface em diferentes resoluções.
Dispositivo	Resolução
Smartphone	375 px
Tablet	768 px
Notebook	1366 px
Desktop	1920 px
Serão verificadas:
•	navegação;
•	menus;
•	tabelas;
•	formulários;
•	componentes responsivos.

7.13 Execução Automatizada
Os testes E2E serão executados:
•	antes de cada release;
•	em homologação;
•	durante a pipeline de CI/CD;
•	sob demanda para validação de regressões.
Em execuções locais, será possível rodar apenas cenários específicos para acelerar o ciclo de desenvolvimento.

7.14 Estratégia de Regressão
Os testes E2E formarão a principal suíte de regressão funcional.
Sempre que uma nova funcionalidade for implementada:
•	novos cenários deverão ser adicionados;
•	cenários antigos continuarão sendo executados;
•	regressões impedirão novas implantações.
Essa estratégia garante estabilidade ao longo da evolução do sistema.

7.15 Métricas
Serão acompanhados os seguintes indicadores:
Indicador	Meta
Fluxos críticos cobertos	100%
Cenários E2E aprovados	100%
Falhas críticas	0
Tempo médio de execução da suíte	Até 20 minutos*
Regressões em produção	0
* O tempo poderá variar conforme a infraestrutura da pipeline e a quantidade de cenários automatizados.

7.16 Boas Práticas
Durante a implementação dos testes End-to-End deverão ser observadas as seguintes recomendações:
•	automatizar apenas fluxos críticos;
•	manter cenários independentes;
•	evitar dependência entre testes;
•	utilizar identificadores estáveis (data-testid) apenas quando necessário, priorizando seletores acessíveis;
•	validar o comportamento do usuário;
•	minimizar o uso de esperas fixas (hard waits), preferindo esperas explícitas do Playwright;
•	reutilizar funções auxiliares para reduzir duplicação;
•	manter os cenários simples e objetivos.


7.17 Antipadrões
Devem ser evitados:
•	testes excessivamente longos;
•	múltiplos fluxos distintos em um único cenário;
•	dependência da ordem de execução;
•	compartilhamento de dados entre testes;
•	validações superficiais;
•	excesso de esperas artificiais;
•	automação de funcionalidades pouco relevantes.
Esses antipadrões tornam a suíte lenta, instável e difícil de manter.

7.18 Integração com CI/CD
A suíte E2E será integrada ao pipeline de entrega contínua.
Fluxo previsto:
Commit
   │
Build
   │
Testes Unitários
   │
Testes Integração
   │
Testes API
   │
Testes Frontend
   │
Testes E2E
   │
Deploy

Caso qualquer cenário falhe, a implantação será interrompida até a correção do problema.


7.19 Relação com os Demais Documentos
Documento	Relação
Documento 06 – Arquitetura Backend	Fornece os serviços utilizados durante os fluxos completos.
Documento 07 – Arquitetura Frontend	Define a interface validada pelos testes E2E.
Documento 08 – Segurança	Estabelece os mecanismos de autenticação e autorização exercitados.
Documento 09 – Docker	Disponibiliza o ambiente utilizado para execução automatizada.
Documento 10 – API REST	Define os contratos consumidos durante a execução dos fluxos.
Documento 11 – DER	Estrutura os dados persistidos durante os cenários.
Documento 12 – Banco de Dados PostgreSQL	Define o banco utilizado nos testes completos.

7.20 Conclusão do Capítulo
Os testes End-to-End representam a validação mais próxima da experiência real dos usuários do GTP. Ao exercitar a aplicação de ponta a ponta, desde a interface React até a persistência no PostgreSQL, esses testes garantem que todas as camadas trabalhem de forma integrada e consistente.
Embora sejam mais lentos que os testes unitários e de integração, sua execução automatizada sobre os principais fluxos de negócio reduz significativamente o risco de regressões e aumenta a confiança nas novas versões do sistema.
Integrados à pipeline de CI/CD, os testes E2E tornam-se um importante mecanismo de proteção da qualidade antes da disponibilização de qualquer atualização.



8 – Testes Não Funcionais
8.1 Objetivo
Os testes não funcionais têm como objetivo verificar se o Gestor de Territórios e Publicações (GTP) atende aos requisitos de qualidade que vão além das funcionalidades do sistema.
Enquanto os testes funcionais respondem à pergunta "o sistema faz o que deveria fazer?", os testes não funcionais respondem questões como:
•	O sistema é rápido?
•	O sistema suporta múltiplos usuários?
•	O sistema é seguro?
•	O sistema é estável?
•	O sistema é acessível?
•	O sistema continua funcionando sob alta carga?
Esses testes são fundamentais para garantir que o GTP possa ser utilizado de forma confiável em ambientes de produção.

8.2 Escopo
A estratégia de testes não funcionais abrangerá os seguintes aspectos:
•	desempenho;
•	carga;
•	estresse;
•	escalabilidade;
•	disponibilidade;
•	segurança;
•	acessibilidade;
•	usabilidade;
•	compatibilidade;
•	confiabilidade;
•	recuperação após falhas;
•	observabilidade.

8.3 Arquitetura dos Testes Não Funcionais
Os testes serão executados em um ambiente semelhante ao de produção.
Usuários Simulados
        │
        ▼
Ferramenta de Testes
        │
        ▼
 Frontend React
        │
        ▼
    API REST
        │
        ▼
   Spring Boot
        │
        ▼
   PostgreSQL
        │
        ▼
  Monitoramento
Durante os testes serão coletadas métricas da aplicação, do banco de dados e da infraestrutura.

8.4 Testes de Desempenho
Os testes de desempenho têm como objetivo avaliar o tempo de resposta da aplicação em condições normais de utilização.
Serão monitorados:
•	tempo médio de resposta;
•	tempo máximo;
•	utilização de CPU;
•	consumo de memória;
•	utilização do banco de dados;
•	número de conexões simultâneas;
•	latência das consultas.
Metas iniciais
Indicador	Meta
Tempo médio das APIs	≤ 500 ms
Tempo máximo das APIs críticas	≤ 2 s
Tempo de carregamento das páginas principais	≤ 3 s
Login	≤ 2 s
Dashboard	≤ 3 s
Essas metas poderão ser revisadas conforme a evolução do projeto e a infraestrutura disponível.

8.5 Testes de Carga
Os testes de carga verificarão o comportamento do sistema sob o volume esperado de utilização.
Serão simulados:
•	múltiplos usuários autenticados;
•	consultas simultâneas;
•	cadastros concorrentes;
•	geração simultânea de relatórios;
•	operações administrativas.
Objetivos:
•	identificar gargalos;
•	validar estabilidade;
•	medir consumo de recursos.

8.6 Testes de Estresse
Os testes de estresse avaliarão o comportamento da aplicação além da carga prevista.
Serão observados:
•	degradação gradual do desempenho;
•	recuperação após sobrecarga;
•	tratamento de erros;
•	estabilidade do banco de dados;
•	recuperação dos serviços.
A aplicação deverá falhar de forma controlada, preservando a integridade dos dados.

8.7 Testes de Escalabilidade
Esses testes verificarão a capacidade do sistema de crescer conforme o aumento da demanda.
Serão avaliados cenários como:
•	aumento de usuários;
•	crescimento do banco de dados;
•	aumento de requisições simultâneas;
•	expansão horizontal da aplicação;
•	múltiplas instâncias do backend.
Os resultados orientarão futuras decisões de arquitetura e infraestrutura.

8.8 Testes de Segurança
Os testes de segurança complementam o Documento 08 – Segurança e têm como objetivo validar a eficácia dos mecanismos de proteção implementados.
Serão realizados testes para verificar:

Autenticação
•	credenciais inválidas;
•	expiração de sessão;
•	invalidação de tokens;
•	renovação de sessão (quando implementada).
Autorização
•	acesso por perfil;
•	recursos protegidos;
•	tentativas de acesso indevido.
Validação de Entrada
•	SQL Injection;
•	Cross-Site Scripting (XSS);
•	Cross-Site Request Forgery (CSRF), quando aplicável;
•	manipulação de parâmetros;
•	validação de arquivos enviados.
Configuração
•	cabeçalhos HTTP de segurança;
•	HTTPS;
•	CORS;
•	proteção contra divulgação de informações sensíveis.

8.9 Testes de Usabilidade
Os testes de usabilidade verificarão se a interface é intuitiva e eficiente.
Serão observados:
•	facilidade de navegação;
•	clareza das informações;
•	consistência visual;
•	tempo para execução das tarefas;
•	feedback ao usuário;
•	mensagens de erro compreensíveis.
Sempre que possível, esses testes poderão ser complementados por avaliações com usuários representativos.

8.10 Testes de Acessibilidade
A aplicação deverá atender às boas práticas de acessibilidade.
Serão verificados:
•	navegação por teclado;
•	contraste entre texto e fundo;
•	estrutura semântica do HTML;
•	textos alternativos para imagens;
•	identificação correta de campos de formulário;
•	foco visível;
•	compatibilidade com leitores de tela.
O objetivo é promover uma experiência inclusiva para diferentes perfis de usuários.

8.11 Testes de Compatibilidade
Serão avaliados diferentes navegadores e dispositivos.
Navegadores
•	Google Chrome;
•	Microsoft Edge;
•	Mozilla Firefox;
•	Safari.
Sistemas Operacionais
•	Windows;
•	Linux;
•	macOS.
Dispositivos
•	Desktop;
•	Notebook;
•	Tablet;
•	Smartphone.
Esses testes visam assegurar comportamento consistente entre plataformas suportadas.

8.12 Testes de Disponibilidade e Recuperação
Serão avaliados cenários relacionados à continuidade do serviço.
Exemplos:
•	indisponibilidade temporária do banco de dados;
•	reinício da aplicação;
•	perda temporária de conectividade;
•	falha de serviços externos integrados.
Objetivos:
•	verificar recuperação automática quando aplicável;
•	garantir integridade dos dados;
•	minimizar impacto aos usuários.

8.13 Observabilidade
Durante os testes serão monitoradas métricas relevantes da aplicação.
Indicadores:
•	utilização de CPU;
•	memória;
•	conexões;
•	consultas lentas;
•	tempo de resposta;
•	erros HTTP;
•	exceções;
•	uso de disco.
Essas informações apoiarão a identificação de gargalos e oportunidades de otimização.

8.14 Ferramentas Utilizadas
Ferramenta	Finalidade
Playwright	Testes E2E e medições básicas de experiência do usuário.
OWASP ZAP	Análise automatizada de vulnerabilidades em aplicações web.
Lighthouse	Avaliação de desempenho, acessibilidade e boas práticas do frontend.
Grafana	Visualização de métricas e monitoramento.
Prometheus	Coleta de métricas da aplicação.
Docker	Ambiente controlado para execução dos testes.
Para testes de carga, poderá ser adotada uma ferramenta como k6 ou Apache JMeter, conforme a infraestrutura e as necessidades do projeto.

8.15 Critérios de Aceitação
O sistema será considerado aprovado quando:
•	cumprir as metas de desempenho estabelecidas;
•	não apresentar vulnerabilidades críticas identificadas nas ferramentas de segurança utilizadas;
•	manter estabilidade durante os testes de carga definidos;
•	atender aos requisitos mínimos de acessibilidade;
•	funcionar corretamente nos navegadores oficialmente suportados;
•	manter disponibilidade e consistência dos dados durante cenários de falha previstos.

8.16 Boas Práticas
Durante a execução dos testes não funcionais deverão ser observadas as seguintes recomendações:
•	utilizar ambientes semelhantes ao de produção;
•	executar testes com volumes de dados representativos;
•	registrar todas as métricas coletadas;
•	documentar gargalos identificados;
•	repetir os testes após otimizações relevantes;
•	integrar os resultados ao processo de melhoria contínua.

8.17 Antipadrões
Devem ser evitados:
•	executar testes de desempenho em ambientes instáveis;
•	comparar resultados obtidos em infraestruturas muito diferentes sem contextualização;
•	ignorar métricas de banco de dados;
•	realizar apenas um ciclo de testes;
•	desconsiderar a experiência do usuário durante avaliações de desempenho.
Esses fatores podem levar a interpretações incorretas e decisões técnicas inadequadas.

8.18 Integração com CI/CD
Nem todos os testes não funcionais serão executados em cada commit.

A estratégia será:
Tipo de Teste	Frequência
Segurança automatizada	Pull Requests e antes das releases
Lighthouse	Pull Requests e antes das releases
Desempenho básico	Releases
Carga	Sob demanda e antes de versões importantes
Estresse	Sob demanda
Compatibilidade	Releases e homologação
Essa abordagem equilibra qualidade e tempo de execução da pipeline.

8.19 Relação com os Demais Documentos
Documento	Relação
Documento 07 – Arquitetura Frontend	Define os componentes e páginas avaliados quanto a desempenho, acessibilidade e usabilidade.
Documento 08 – Segurança	Estabelece os requisitos de segurança validados por esta estratégia.
Documento 09 – Docker	Fornece a infraestrutura para execução controlada dos testes.
Documento 10 – API REST	Define os serviços submetidos aos testes de desempenho e segurança.
Documento 12 – Banco de Dados PostgreSQL	Fornece a camada de persistência monitorada durante os testes de carga e estresse.

8.20 Conclusão do Capítulo
Os testes não funcionais complementam a validação funcional do GTP ao avaliar aspectos essenciais como desempenho, segurança, acessibilidade, compatibilidade, disponibilidade e observabilidade. Essa abordagem garante que a aplicação não apenas execute corretamente suas funcionalidades, mas também ofereça uma experiência confiável e adequada aos usuários em diferentes cenários de utilização.
A combinação de ferramentas de monitoramento, análise de segurança, testes de desempenho e validações de acessibilidade permitirá identificar oportunidades de melhoria de forma contínua, contribuindo para a evolução sustentável da plataforma.

9 – Cobertura, Qualidade e Métricas
9.1 Objetivo
Este capítulo estabelece a estratégia de medição da qualidade do código-fonte do Gestor de Territórios e Publicações (GTP) por meio de indicadores objetivos, métricas de desenvolvimento e ferramentas de análise estática.
O propósito é acompanhar continuamente a evolução da qualidade da aplicação, identificar oportunidades de melhoria e impedir que alterações reduzam a confiabilidade do sistema.
Os principais objetivos são:
•	medir a cobertura de testes;
•	avaliar a qualidade do código;
•	monitorar a complexidade das implementações;
•	detectar duplicação de código;
•	identificar vulnerabilidades de segurança;
•	acompanhar a evolução técnica do projeto;
•	estabelecer critérios objetivos para aprovação de novas versões.

9.2 Estratégia de Qualidade
A qualidade será acompanhada continuamente durante todo o ciclo de desenvolvimento.
A estratégia será baseada em cinco pilares:
•	cobertura de testes;
•	análise estática do código;
•	qualidade arquitetural;
•	segurança;
•	monitoramento contínuo.
Esses pilares permitirão identificar problemas antes que sejam incorporados à base principal do projeto.

9.3 Cobertura de Código
A cobertura de código mede o percentual de instruções executadas durante os testes automatizados.
Serão monitoradas diferentes dimensões da cobertura:
•	linhas executadas;
•	métodos executados;
•	classes exercitadas;
•	ramos condicionais (branches);
•	complexidade ciclomática coberta.
A cobertura, por si só, não garante qualidade, mas serve como um importante indicador de confiança da suíte de testes.

9.4 Metas de Cobertura
O GTP adotará metas mínimas de cobertura para cada camada da aplicação.
Camada	Cobertura Mínima
Domínio	95%
Casos de Uso	90%
Serviços	90%
Utilitários	95%
Controllers	80%
Componentes React	80%
Hooks	90%
Context API	90%
Cobertura Geral	85%
Essas metas poderão ser revisadas conforme a evolução do projeto, sempre buscando equilíbrio entre qualidade e produtividade.

9.5 Ferramentas de Análise
JaCoCo
Será utilizado para medir a cobertura dos testes do backend.
Principais indicadores:
•	cobertura de linhas;
•	cobertura de métodos;
•	cobertura de classes;
•	cobertura de ramos (branches).
Os relatórios serão gerados automaticamente durante a pipeline de integração contínua.

SonarQube
Será utilizado para análise estática da qualidade do código.
Serão monitorados:
•	bugs;
•	vulnerabilidades;
•	code smells;
•	duplicação de código;
•	complexidade;
•	cobertura de testes;
•	débito técnico (technical debt).
O SonarQube será integrado ao pipeline de CI/CD para fornecer feedback contínuo à equipe.

9.6 Quality Gates
Nenhuma alteração poderá ser integrada à branch principal caso os critérios mínimos de qualidade não sejam atendidos.
Os Quality Gates definidos para o GTP são:
Critério	Meta
Cobertura geral	≥ 85%
Bugs críticos	0
Vulnerabilidades críticas	0
Vulnerabilidades altas	0
Duplicação de código	≤ 3%
Code Smells críticos	0
Build	Aprovado
Testes automatizados	100% aprovados
Esses critérios serão avaliados automaticamente durante a pipeline.

9.7 Métricas de Código
Serão acompanhados indicadores relacionados à estrutura do código.
Complexidade Ciclomática
Objetivo:
•	identificar métodos excessivamente complexos;
•	incentivar funções menores e mais coesas.


Meta:
Indicador	Valor
Complexidade por método	≤ 10
Complexidade por classe	Conforme análise arquitetural, priorizando classes coesas e responsabilidades bem definidas.

Duplicação
Será monitorado o percentual de código duplicado.
Meta:
Indicador	Valor
Código duplicado	≤ 3%
A redução de duplicação favorece manutenção e evolução do sistema.

Débito Técnico
O SonarQube fornecerá estimativas do esforço necessário para corrigir problemas identificados.
A equipe deverá acompanhar continuamente esse indicador e priorizar correções conforme o impacto no projeto.

9.8 Métricas de Testes
Além da cobertura, serão monitorados:
•	número total de testes;
•	tempo médio de execução;
•	percentual de aprovação;
•	testes ignorados (skipped);
•	testes falhos;
•	estabilidade da suíte.
Essas informações auxiliarão na identificação de problemas de confiabilidade dos testes.

9.9 Métricas de Segurança
Serão acompanhados indicadores relacionados à segurança da aplicação.
Exemplos:
•	vulnerabilidades críticas;
•	vulnerabilidades altas;
•	dependências desatualizadas;
•	bibliotecas vulneráveis;
•	exposição de segredos;
•	configurações inseguras.
Sempre que possível, ferramentas automatizadas serão utilizadas para apoiar essa análise.

9.10 Métricas de Frontend
A qualidade do frontend será monitorada por indicadores específicos.
Serão avaliados:
•	cobertura dos componentes;
•	cobertura dos hooks;
•	cobertura dos contextos;
•	desempenho;
•	acessibilidade;
•	tamanho dos pacotes gerados (bundle size);
•	uso de dependências.
Essas métricas contribuirão para manter uma interface eficiente e de fácil manutenção.

9.11 Métricas de Backend
Os seguintes indicadores serão acompanhados:
•	cobertura de testes;
•	complexidade;
•	tempo médio das APIs;
•	consumo de memória;
•	uso de CPU;
•	consultas lentas;
•	tempo médio de resposta;
•	falhas em transações.
Essas métricas permitirão identificar gargalos e orientar otimizações.

9.12 Indicadores da Pipeline
Durante cada execução da pipeline serão coletadas informações como:
•	tempo total do build;
•	tempo de execução dos testes;
•	falhas por etapa;
•	cobertura obtida;
•	qualidade aprovada;
•	artefatos gerados.
Esses dados apoiarão a melhoria contínua do processo de desenvolvimento.

9.13 Dashboards de Qualidade
As métricas serão consolidadas em painéis que permitam acompanhar a evolução do projeto.
Os dashboards poderão apresentar:
•	cobertura de testes;
•	evolução da qualidade;
•	vulnerabilidades;
•	duplicação de código;
•	tempo de build;
•	estabilidade da pipeline;
•	evolução do débito técnico.
Esses painéis servirão como apoio à tomada de decisão da equipe.

9.14 Critérios de Aprovação
Uma nova versão somente poderá ser considerada apta para implantação quando atender aos seguintes requisitos:
•	todos os testes aprovados;
•	cobertura mínima alcançada;
•	Quality Gates aprovados;
•	ausência de vulnerabilidades críticas;
•	build concluído com sucesso;
•	documentação atualizada.
Esse processo reduz o risco de publicação de versões instáveis.

9.15 Boas Práticas
Para manter a qualidade do projeto, deverão ser observadas as seguintes recomendações:
•	acompanhar continuamente as métricas;
•	corrigir problemas antes do merge;
•	evitar redução da cobertura de testes;
•	revisar código por meio de Pull Requests;
•	manter dependências atualizadas;
•	monitorar tendências ao longo do tempo;
•	tratar alertas críticos com prioridade.

9.16 Antipadrões
Devem ser evitados:
•	perseguir cobertura elevada sem validar cenários relevantes;
•	ignorar alertas do SonarQube;
•	acumular débito técnico sem planejamento de correção;
•	desabilitar testes para obter aprovação na pipeline;
•	aceitar duplicação excessiva de código;
•	utilizar métricas isoladas como único critério de qualidade.
Esses comportamentos comprometem a efetividade da estratégia de qualidade.

9.17 Integração com CI/CD
As métricas serão coletadas automaticamente durante a execução da pipeline.
Fluxo simplificado:
Commit
   │
   ▼
Build
   │
   ▼
Testes Automatizados
   │
   ▼
JaCoCo
   │
   ▼
SonarQube
   │
   ▼
Quality Gate
   │
   ▼
Deploy
Caso algum critério obrigatório não seja atendido, a pipeline será interrompida até que as pendências sejam resolvidas.

9.18 Relação com os Demais Documentos
Documento	Relação
Documento 06 – Arquitetura Backend	Define os componentes avaliados pelas métricas de backend.
Documento 07 – Arquitetura Frontend	Define os componentes e páginas monitorados pelas métricas do frontend.
Documento 08 – Segurança	Estabelece os requisitos de segurança acompanhados pelas métricas.
Documento 09 – Docker	Fornece a infraestrutura para execução das ferramentas de análise na pipeline.
Documento 10 – API REST	Define os serviços monitorados quanto à cobertura e desempenho.
Documento 13 – Estratégia de Testes	Consolida todas as métricas produzidas pelas diferentes camadas de testes.

9.19 Indicadores Consolidados
Ao longo do desenvolvimento do GTP, os seguintes indicadores serão considerados estratégicos:
Indicador	Meta
Cobertura Geral	≥ 85%
Cobertura do Domínio	≥ 95%
Cobertura dos Casos de Uso	≥ 90%
Cobertura do Frontend	≥ 80%
Bugs Críticos	0
Vulnerabilidades Críticas	0
Duplicação de Código	≤ 3%
Quality Gate	100% aprovado
Testes Automatizados	100% aprovados
Débito Técnico	Em redução contínua
Esses indicadores servirão como referência para acompanhar a maturidade técnica do projeto e orientar decisões de manutenção e evolução.

9.20 Conclusão do Capítulo
A definição de métricas objetivas de cobertura, qualidade e segurança permite que o GTP evolua de forma controlada, com critérios claros para aprovação de alterações e monitoramento contínuo da saúde do código. A integração de ferramentas como JaCoCo e SonarQube ao processo de CI/CD fornece visibilidade constante sobre a qualidade da aplicação e incentiva uma cultura de melhoria contínua.
Mais do que medir resultados, essas métricas orientam decisões técnicas, reduzem o risco de regressões e contribuem para a construção de uma plataforma robusta, sustentável e preparada para evoluções futuras.

10 – Automação, CI/CD e Conclusão
10.1 Objetivo
Este capítulo consolida a estratégia de automação dos testes do Gestor de Territórios e Publicações (GTP), descrevendo como a execução contínua dos testes será integrada ao processo de desenvolvimento, integração contínua (Continuous Integration – CI) e entrega contínua (Continuous Delivery – CD).
O objetivo é garantir que toda alteração realizada no projeto seja validada automaticamente, reduzindo a possibilidade de regressões e assegurando que apenas versões estáveis e compatíveis sejam disponibilizadas para homologação e produção.


10.2 Estratégia de Automação
Toda a estratégia de testes do GTP será automatizada sempre que tecnicamente viável.
A automação abrangerá:
•	testes unitários;
•	testes de integração;
•	testes da API REST;
•	testes do frontend;
•	testes End-to-End (E2E);
•	testes de segurança automatizados;
•	análise estática de código;
•	verificação de cobertura;
•	validação de qualidade.
Essa abordagem reduz atividades manuais repetitivas, acelera o ciclo de desenvolvimento e aumenta a confiabilidade das entregas.

10.3 Arquitetura da Pipeline
A pipeline de integração contínua será composta por etapas sequenciais de validação.














Desenvolvedor
      │
      ▼
   Commit
      │
      ▼
    Push
      │
      ▼
   GitHub
      │
      ▼
GitHub Actions
      │
      ▼
    Build
      │
      ▼
Testes Unitários
      │
      ▼
Testes de Integração
      │
      ▼
Testes da API
      │
      ▼
Testes Frontend
      │
      ▼
Testes End-to-End
      │
      ▼
Análise SonarQube
      │
      ▼
Quality Gate
      │
      ▼
Docker Build
      │
      ▼
Deploy Homologação
      │
      ▼
Deploy Produção
Cada etapa dependerá da aprovação da etapa anterior, garantindo que falhas sejam identificadas o mais cedo possível.
10.4 Fluxo de Integração Contínua (CI)
A integração contínua será acionada automaticamente a cada:
•	commit enviado ao repositório remoto;
•	Pull Request;
•	merge para a branch principal;
•	criação de uma nova versão (tag);
•	execução manual, quando necessário.
Durante esse processo serão executadas as verificações de qualidade e a suíte de testes correspondente ao contexto da alteração.

10.5 Fluxo de Entrega Contínua (CD)
Após a aprovação das etapas de integração contínua, a entrega contínua seguirá um fluxo controlado.
Etapas previstas:
1.	geração dos artefatos;
2.	criação da imagem Docker;
3.	publicação em registro de contêineres;
4.	implantação em ambiente de homologação;
5.	execução de validações pós-implantação;
6.	aprovação para produção;
7.	implantação em produção.
Sempre que possível, a promoção entre ambientes será automatizada, preservando mecanismos de aprovação quando necessários.

10.6 Ambientes
A estratégia de implantação utilizará ambientes distintos.
Ambiente	Finalidade
Desenvolvimento	Implementação e testes locais.
Integração	Execução da pipeline de CI.
Homologação	Validação funcional antes da produção.
Produção	Utilização pelos usuários finais.
Cada ambiente possuirá configurações próprias, mantendo consistência na arquitetura e isolamento entre fases do ciclo de vida.

10.7 Execução Automatizada dos Testes
A automação seguirá uma abordagem em camadas.
Tipo de Teste	Momento de Execução
Unitários	A cada commit e Pull Request.
Integração	Pull Requests e merges.
API REST	Pull Requests e merges.
Frontend	Pull Requests e merges.
End-to-End	Antes de releases e em homologação.
Não Funcionais	Sob demanda e antes de versões relevantes.
Segurança Automatizada	Pull Requests e releases.
Essa estratégia equilibra rapidez na pipeline com profundidade na validação.

10.8 Governança da Qualidade
A governança da qualidade será baseada em critérios objetivos.
Nenhuma versão poderá avançar para produção caso:
•	existam falhas críticas;
•	os testes obrigatórios não tenham sido aprovados;
•	o Quality Gate esteja reprovado;
•	sejam identificadas vulnerabilidades críticas;
•	a cobertura mínima definida não seja alcançada.
Esses critérios serão aplicados de forma automatizada durante a pipeline.

10.9 Gestão de Regressões
Toda nova funcionalidade deverá ser acompanhada da atualização da suíte de testes correspondente.
A estratégia prevê:
•	inclusão de novos cenários automatizados;
•	manutenção dos testes existentes;
•	execução periódica da suíte completa;
•	revisão dos testes obsoletos.
Esse processo reduz a probabilidade de regressões funcionais e técnicas.

10.10 Monitoramento da Pipeline
Serão monitorados indicadores relacionados ao processo de integração e entrega contínuas.
Principais métricas:
•	tempo médio de execução;
•	taxa de sucesso dos builds;
•	taxa de falhas;
•	frequência de implantações;
•	tempo médio de recuperação após falhas (MTTR);
•	tempo médio entre falhas (MTBF);
•	estabilidade da pipeline.
Esses indicadores apoiarão a melhoria contínua do processo de desenvolvimento.


10.11 Gestão de Evidências
A execução dos testes gerará evidências que poderão ser utilizadas para auditoria e rastreabilidade.
Exemplos:
•	relatórios do JaCoCo;
•	relatórios do SonarQube;
•	resultados do Playwright;
•	relatórios de cobertura;
•	logs da pipeline;
•	artefatos gerados durante o build.
Essas evidências facilitarão análises posteriores e apoiarão processos de homologação.

10.12 Evolução da Estratégia de Testes
A estratégia de testes deverá evoluir continuamente conforme o crescimento do projeto.
As principais diretrizes incluem:
•	ampliar a cobertura de testes;
•	incorporar novas ferramentas quando agregarem valor;
•	revisar metas de qualidade periodicamente;
•	adaptar a suíte às mudanças arquiteturais;
•	automatizar novos cenários críticos.
Essa evolução deverá ocorrer de forma planejada, preservando a estabilidade do processo.

10.13 Boas Práticas
Durante a manutenção da estratégia de testes deverão ser observadas as seguintes recomendações:
•	automatizar testes sempre que possível;
•	executar os testes frequentemente;
•	manter a suíte rápida e confiável;
•	revisar periodicamente os cenários automatizados;
•	tratar falhas de testes com prioridade;
•	manter os ambientes de teste consistentes com a arquitetura definida;
•	documentar alterações relevantes na estratégia.

10.14 Antipadrões
Devem ser evitados:
•	ignorar falhas recorrentes na pipeline;
•	desabilitar testes para acelerar entregas;
•	acumular testes obsoletos;
•	executar apenas testes manuais;
•	publicar versões sem validação automatizada;
•	manter cenários instáveis sem investigação.
Esses antipadrões comprometem a confiabilidade do processo de entrega e aumentam o risco de falhas em produção.

10.15 Relação com os Demais Documentos
Documento	Relação
Documento 06 – Arquitetura Backend	Define os componentes do backend validados pela pipeline.
Documento 07 – Arquitetura Frontend	Define a interface submetida aos testes automatizados.
Documento 08 – Segurança	Estabelece os requisitos de segurança verificados continuamente.
Documento 09 – Docker	Fornece a infraestrutura utilizada para build e execução dos ambientes.
Documento 10 – API REST	Define os contratos validados durante os testes automatizados.
Documento 11 – DER	Estrutura os dados utilizados nos testes de persistência.
Documento 12 – Banco de Dados PostgreSQL	Especifica o banco utilizado durante a execução da suíte de testes.

10.16 Conclusão Geral do Documento
A Estratégia de Testes do Gestor de Territórios e Publicações (GTP) estabelece uma abordagem abrangente para assegurar a qualidade da aplicação em todas as suas camadas. A combinação de testes unitários, de integração, da API REST, do frontend, End-to-End e não funcionais, associada à análise contínua de qualidade e à automação por meio de pipelines de CI/CD, proporciona um processo robusto de validação.
A utilização de ferramentas como JUnit 5, Mockito, Testcontainers, Vitest, React Testing Library, Playwright, JaCoCo e SonarQube permite identificar defeitos precocemente, reduzir regressões e manter elevados padrões de qualidade ao longo da evolução do sistema.
Essa estratégia está alinhada às práticas modernas de desenvolvimento de software, favorecendo entregas frequentes, seguras e sustentáveis.

10.17 Benefícios Esperados
A adoção desta estratégia proporcionará:
•	maior confiabilidade da aplicação;
•	redução de regressões;
•	melhoria contínua da qualidade do código;
•	maior segurança nas implantações;
•	aumento da produtividade da equipe;
•	diminuição do tempo de correção de defeitos;
•	maior previsibilidade das entregas;
•	facilidade de manutenção e evolução do sistema.

 Considerações Finais
A qualidade do GTP não será resultado apenas da execução de testes, mas de uma cultura contínua de desenvolvimento baseada em automação, revisão de código, monitoramento e melhoria permanente.
A estratégia descrita neste documento deverá ser revisada periodicamente para acompanhar a evolução tecnológica do projeto, novas necessidades de negócio e mudanças na arquitetura da solução. Com isso, o GTP permanecerá preparado para crescer de forma sustentável, preservando sua confiabilidade, segurança e facilidade de manutenção.

