# DOCUMENTO 01 - DOMÍNIO DO NEGÓCIO
**Projeto:** Sistema de Gestão de Territórios e Publicações (GTP)  
**Versão:** 1.0.0  
**Status:** Em Elaboração  
**Data:** Julho/2026  
**Autor:** Fabio André Zatta  

---

## Controle de Versões
| Versão | Data | Autor | Descrição |
| :--- | :--- | :--- | :--- |
| **1.0.0** | Julho/2026 | Fabio André Zatta | Criação do Documento de Domínio do Negócio. |

---

## 1. Introdução
O **Sistema de Gestão de Territórios e Publicações (GTP)** foi concebido para apoiar a administração das atividades realizadas pelas congregações, permitindo controlar territórios, publicações, usuários e processos administrativos.

Este documento descreve o funcionamento do negócio independentemente da tecnologia utilizada. Seu objetivo é representar fielmente a realidade operacional das congregações, servindo como referência para todas as etapas de análise, modelagem, desenvolvimento e manutenção do sistema.

## 2. Objetivo
* Definir o domínio do negócio de forma clara e agnóstica à tecnologia.
* Identificar as entidades principais e agregados de domínio.
* Estabelecer os relacionamentos lógicos entre as entidades.
* Mapear e documentar a estrutura organizacional corporativa e papéis operacionais.
* Registrar regras do negócio transversais (como isolamento multi-tenant).

---

## 3. Conceitos Fundamentais do Negócio

### 3.1 O que é uma Congregação?
Uma congregação representa uma comunidade local responsável por organizar e administrar suas atividades em uma determinada região geográfica. No sistema, cada congregação constitui uma unidade administrativa independente (**Tenant**), possuindo seus próprios usuários, territórios, publicações, pedidos e configurações.

* **Isolamento de Dados (Multi-tenancy):** Uma congregação nunca poderá acessar informações pertencentes a outra congregação. Essa regra é absoluta e protegida em nível arquitetural de banco de dados (Shared Database / Shared Schema).

### 3.2 Usuários e Acessos
Todo usuário do sistema pertence obrigatoriamente a uma única congregação. Os usuários representam os atores físicos que interagem com o software para movimentar a logística de estoques de publicações ou gerenciar a posse temporária de mapas de territórios.

```
Congregação
   │
   ├───► Usuários
   ├───► Territórios
   ├───► Publicações
   ├───► Pedidos
   └───► Configurações
```

---

## 4. Estrutura Organizacional (Perfis e Papéis)

O sistema utiliza o modelo de Controle de Acesso Baseado em Funções (**RBAC**). Os perfis definidos mapeiam responsabilidades do mundo real:

1. **Desenvolvedor Geral:** Perfil puramente técnico. Atua na infraestrutura de servidores, banco de dados e manutenção de código, sem alçada operacional no negócio.
2. **Administrador Geral:** Responsável pela gestão macro da plataforma. Provisiona novas congregações no banco de dados e gerencia métricas globais e auditoria do ecossistema.
3. **Administrador da Congregação:** Gestor local da instância. Possui poder para gerenciar o cadastro de usuários locais e ajustar parametrizações operacionais da sua unidade.
4. **Superintendente de Serviço:** Gestor operacional e analítico. Acompanha dashboards estatísticos de cobertura de territórios e tendências logísticas de pedidos.
5. **Servo de Território:** Operador logístico de mapas geográficos. Responsável por cadastrar cartões territoriais, gerenciar saídas de campo, devoluções e pendências por atraso.
6. **Servo de Publicações:** Gestor logístico do estoque de literaturas. Controla inventários, remessas periódicas de materiais, campanhas e separação/entrega de pedidos.
7. **Publicador:** Usuário final básico. Realiza solicitações de materiais, reservas e consultas do seu histórico operacional.

---

## 5. Entidades e Dicionário de Atributos do Domínio

### 5.1 Visão Geral do Modelo de Domínio
```
Congregação
│
├── Usuários (Perfis & Permissões)
├── Territórios (Movimentações / Status)
├── Publicações (Categorias / Estoque / Movimentações de Almoxarifado)
├── Pedidos (Item do Pedido / Tipo)
├── Campanhas Sazonais
└── Auditoria Transversal
```

### 5.2 Estrutura Detalhada dos Atributos

#### 5.2.1 Congregação
* `id`: Identificador único primário.
* `nome`: Nome fantasia oficial da congregação.
* `numero`: Código identificador organizacional opcional.
* `endereco`, `bairro`, `cidade`, `estado`, `pais`: Informações geográficas de localização física da sede.
* `ativa`: Flag booleano para controle lógico de bloqueio/ativação da instância do Tenant.

#### 5.2.2 Usuário
* `id`: Chave primária.
* `nome`: Nome civil completo do usuário.
* `email`: Endereço eletrônico corporativo (utilizado como credencial/login).
* `senha`: Criptografia irreversível segura baseada em **BCrypt**.
* `ativo`: Status booleano para gerenciamento de bloqueios administrativos.
* `ultimoAcesso`: Histórico de data/hora do último login.

#### 5.2.3 Território
* `id`, `numero`: Chaves de identificação e código visível do mapa de território.
* `descricao`, `bairro`: Delimitação textual das ruas cobertas pelo perímetro.
* `status`: Enumerador de estado (`Disponível`, `Retirado`, `Em revisão`, `Inativo`).

#### 5.2.4 Movimentação de Território
* `id`: Identificador da movimentação.
* `dataRetirada`: Data de início do trabalho de pregação no território.
* `dataPrevista`: Data limite sugerida para devolução do cartão de mapa.
* `dataDevolucao`: Data de encerramento e devolução efetiva do mapa ao acervo local.

#### 5.2.5 Publicação & Estoque
* **Publicação:** Catálogo mestre indexado por nome, sigla e categoria (Bíblias, Livros, Revistas, Brochuras, Folhetos, Tratados, Convites).
* **Estoque:** Consolidação física de quantidades (`quantidadeAtual`, `quantidadeMínima`).
* **Movimentação de Estoque:** Tabela imutável de logs transacionais (`Entrada`, `Saída`, `Ajuste`, `Entrega`, `Cancelamento`), atuando como livro-razão de controle.

#### 5.2.6 Pedidos & Itens
* **Pedido:** Requisição agrupada classificada por tipo (`Individual`, `Normal`, `Campanha`) e controlada pelos estados de ciclo de vida (`Pendente`, `Recebido`, `Retirado`, `Cancelado`).
* **Item do Pedido:** Entidade de amarração N:M contendo a referência da publicação específica e a quantidade requisitada.

#### 5.2.7 Auditoria Sistêmica
Entidade transversal que atua salvando logs indestrutíveis para governança e segurança: `usuário`, `data/hora`, `tipo de operação`, `entidade modificada`, `payload anterior`, `payload novo` e `endereço IP` do dispositivo cliente.

---

## 6. Considerações Finais
Este modelo conceitual agnóstico unifica a linguagem onipresente do negócio da plataforma **GTP**, estruturando as regras fundamentais que guiarão as próximas etapas de engenharia de software e mapeamento objeto-relacional (ORM) no ecossistema Spring Boot / PostgreSQL.
