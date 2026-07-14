# DOCUMENTO 00 - INTRODUÇÃO E VISÃO DO PRODUTO
**Projeto:** Sistema de Gestão de Territórios e Publicações (GTP)  
**Versão:** 1.0.0  
**Status:** Em Elaboração  
**Data:** Julho/2026  
**Autor:** Fabio André Zatta  

---

## Controle de Versões
| Versão | Data | Autor | Descrição |
| :--- | :--- | :--- | :--- |
| **1.0.0** | Jul/2026 | Fabio | Criação inicial do documento técnico. |

---

## 1. Introdução

### 1.1 Apresentação
O **Sistema de Gestão de Territórios e Publicações (GTP)** é uma plataforma web moderna projetada para auxiliar congregações na administração otimizada de territórios, fluxo de publicações, usuários e processos organizacionais locais. 
O sistema substitui com segurança os controles manuais descentralizados (como planilhas isoladas ou cadernos físicos), unificando os dados em um ecossistema seguro e auditável baseado em navegadores web corporativos e dispositivos móveis.

### 1.2 Propósito do Documento
Servir como guia oficial de arquitetura, escopo e requisitos, alinhando as expectativas entre desenvolvedores, arquitetos, analistas e administradores do ecossistema.

### 1.3 Público-Alvo do Documento
* Patrocinadores do Projeto
* Administradores e Líderes de Equipe
* Engenheiros e Arquitetos de Software (Java/React)
* Profissionais de QA / Testadores

---

## 2. Objetivos do Projeto

### 2.1 Objetivo Geral
Desenvolver uma plataforma web corporativa multi-tenant para gestão unificada de territórios e publicações, assegurando alta rastreabilidade histórica e estrito isolamento lógico de dados entre diferentes congregações.

### 2.2 Objetivos Específicos
* **Isolamento de Dados:** Arquitetura Multi-tenant (Shared Database / Shared Schema).
* **Gestão Territorial:** Controle de saídas, devoluções e pendências.
* **Logística de Publicações:** Controle fino de estoques, pedidos normais e campanhas mundiais.
* **Segurança e Conformidade:** Logs completos de auditoria imutáveis e aderência à LGPD.

---

## 3. Contexto do Problema e Justificativa

### 3.1 Situação Atual e Desafios
* **Alta Volatilidade de Dados:** Informações dispersas em planilhas locais ou anotações físicas expostas a perdas.
* **Falta de Rastreabilidade:** Impossibilidade de mapear com exatidão históricos passados de saídas de materiais ou territórios.
* **Gargalos Operacionais:** Dependência operacional crônica de indivíduos específicos para geração manual de relatórios básicos.

### 3.2 Benefícios com a Plataforma GTP
A virada para o digital utilizando **Java 21** e **React 19** trará redução de retrabalho, segurança contra vazamentos de dados de acordo com a LGPD e agilidade operacional imediata.

## 4. Justificativa
A necessidade de um sistema centralizado surge da crescente demanda por organização, rastreabilidade e confiabilidade dos registros administrativos. A adoção de uma plataforma web robusta permitirá uma redução drástica de erros operacionais, melhoria na segurança e conformidade da informação, além de escalabilidade técnica para futuras necessidades.

---

## 5. Visão e Características do Produto

### 5.1 Definição Arquitetural
Plataforma Cloud Multi-Tenant nativa. Cada organização possui sua identificação lógica exclusiva (`congregacao_id`), impedindo vazamento ou intersecção de dados.

### 5.2 Perfis de Acesso Definidos (RBAC)
1. **Administrador Geral:** Visão global do ecossistema e provisionamento de tenants.
2. **Administrador da Congregação:** Gestão de usuários internos locais e configurações da unidade.
3. **Superintendente de Serviço:** Monitoramento de indicadores analíticos de atividade.
4. **Servo de Território:** Operador dedicado ao fluxo logístico de cartões e mapas.
5. **Servo de Publicações:** Operador do almoxarifado, entradas/saídas e pedidos.
6. **Publicador:** Usuário final com perfil de consulta e requisições próprias.

---
## 6. Público-Alvo (Perfis de Acesso)
* **Administrador Geral:** Responsável pelo gerenciamento global do sistema, criação de instâncias de congregações e auditoria geral.
* **Administrador da Congregação:** Gerencia usuários e configurações estritamente locais do seu ambiente.
* **Superintendente de Serviço:** Supervisiona a operação, analisa relatórios gerenciais e monitora indicadores de progresso.
* **Servo de Território:** Gerencia o cadastro, a disponibilização, saídas e devoluções das áreas de cobertura.
* **Servo de Publicações:** Controla os fluxos de estoque, as entregas de pedidos e as campanhas em andamento.
* **Publicador:** Usuário final que realiza consultas rápidas de seu histórico e faz solicitações de materiais.

---

## 7. Benefícios Esperados
**Operacionais:** Redução extrema do trabalho manual e acesso instantâneo aos dados logísticos.
**Gerenciais:** Visão analítica por meio de dashboards consolidados e relatórios precisos.
**Técnicos:** Arquitetura de software de fácil manutenção, segura contra invasões e altamente escalável.

---
## 8. Escopo do Produto
### 8.1 Objetivo do Escopo
O escopo inicial define todas as bases funcionais essenciais do GTP para sua versão 1.0.0. Ele foca em
entregar o isolamento lógico essencial e as operações críticas de territórios e publicações com alto nível de
usabilidade.

### 8.2 Escopo Funcional (Versão 1.0.0)

* **Segurança:** Autenticação via JSON Web Tokens (**JWT**) com expiração segura; senhas criptografadas via **BCrypt**.
* **Dashboard:** Painéis customizados contendo indicadores de pendências e estatísticas rápidas conforme o perfil.
* **Gestão de Congregações & Usuários:** Operações de CRUD completas, bloqueio/desbloqueio e delegação de papéis dinâmicos.
* **Módulo de Territórios:** CRUD completo, filtros refinados por bairro/região, fluxo automatizado de retirada/devolução e alertas de atraso.
* **Módulo de Publicações:** Catálogo geral indexado por siglas, movimentações internas de ajuste de estoque, fluxo de pedidos individuais e saídas de campanhas sazonais.
* **Auditoria Governamental:** Registro detalhado contendo: `usuário`, `data/hora`, `operação`, `estado anterior`, `estado novo` e `IP de origem`.

---

## 9. Fora de Escopo (Futuro)
* Aplicativo nativo mobile (Android/iOS).
* Integração direta com ferramentas governamentais externas.
* Disparos automatizados automáticos de mensageria via WhatsApp corporativo.

---

## 10. Visão Geral dos Módulos

Login ➔ Dashboard ➔ [Congregações / Usuários] ➔ Territórios ➔ Publicações ➔ Relatórios ➔ Auditoria ➔ Configurações

## 11. Arquitetura e Engenharia de Tecnologia

```
┌────────────────────────────────────────────────────────┐
│               Camada de Apresentação (React 19)        │
└───────────────────────────┬────────────────────────────┘
                            │ REST API (JSON + JWT)
┌───────────────────────────▼────────────────────────────┐
│               Camada de Negócio (Spring Boot 3)        │
└───────────────────────────┬────────────────────────────┘
                            │ Spring Data JPA / Hibernate
┌───────────────────────────▼────────────────────────────┐
│               Banco de Dados (PostgreSQL)              │
└────────────────────────────────────────────────────────┘
```
**Organização dos Módulos Técnicos**
**Backend (DDD Leve):** Separado estritamente por domínios: auth, usuario, congregacao, territorio,
publicacao, pedido, auditoria e shared.
**Frontend (Feature-Based):** Estrutura organizada por módulos visuais funcionais correspondentes dentro da
pasta features/ para maximizar a manutenibilidade.

---

## 12 Matriz de Tecnologias (Tech Stack)
* **Frontend:** React 19, Vite, Tailwind CSS 4, React Router, Axios, Zustand, TanStack Query, Zod.
* **Backend:** Java 21, Spring Boot 3, Spring Security, Spring Data JPA, Hibernate, Maven.
* **Infraestrutura:** PostgreSQL, Docker, Docker Compose, Nginx (Proxy Reverso).

---

## 13. Infraestrutura

[Internet: HTTPS 443] ➔ [Proxy Reverso: Nginx] ➔ [Frontend / Backend] ➔ [PostgreSQL] ➔ [Volumes Locais]

A persistência utilizará volumes Docker permanentes externos, isolando o estado dos dados do ciclo de vida operacional das imagens dos containers.

---

## 14. Segurança e LGPD
O sistema adota criptografia irreversível **BCrypt** para armazenamento seguro de senhas, além de aplicar de
maneira transversal os princípios da **LGPD (Lei Geral de Proteção de Dados)**, garantindo que nenhum
dado cadastral sensível seja exposto sem a devida finalidade do negócio.

---

## 15. Princípios de Engenharia Aplicados
* **SOLID** & **Clean Code**
* **DDD Leve** (Design Orientado a Domínios) para os pacotes (`auth`, `usuario`, `territorio`, `publicacao`, etc.)
* **DRY** (Don't Repeat Yourself) & **KISS** (Keep It Simple, Stupid)

---

## 16. Roadmap Estratégico de Evolução
* **V1.0.0 (Atual):** Core business completo (Territórios, Estoque, Auditoria e Multi-tenant básico).
* **V1.1.0:** Geração avançada de relatórios exportáveis e dashboards dinâmicos interativos.
* **V2.0.0:** Aplicativo mobile híbrido focado em mobilidade offline e notificações automáticas.
* **V3.0.0:** IA preditiva aplicada à sugestão logística inteligente de cobertura territorial.

---

## 17. Glossário Técnico
| Termo | Definição |
| :--- | :--- |
| **Multi-tenant** | Modelo onde uma única instância atende múltiplos clientes de forma isolada. |
| **RBAC** | Role-Based Access Control (Controle de acesso lógico baseado no papel do usuário). |
| **JWT** | JSON Web Token (Padrão de mercado para tráfego seguro de credenciais via API). |
| **Auditoria** | Trilhas de logs imutáveis guardadas para fins de conformidade e segurança. |

---

## 18. Referências Técnicas
* Documentações Oficiais: React, Spring Framework, PostgreSQL, Docker.
* Normas de Segurança: OWASP Top 10 Security Risks.
* Padrões de Comunicação: RFC 7519 — JSON Web Token specifications.

---

## 9. Considerações Finais
O ecossistema **GTP** materializa as melhores práticas de desenvolvimento corporativo em Java e React, mitigando os riscos operacionais do papel ou de planilhas locais frágeis e garantindo uma fundação arquitetural escalável pelos próximos anos.
