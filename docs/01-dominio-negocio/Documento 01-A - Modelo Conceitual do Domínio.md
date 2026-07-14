# Documento 01-A - Modelo Conceitual do Domínio
**Projeto:** Gestor de Territórios e Publicações (GTP)  
**Versão:** 1.1.0  
**Status:** Em Elaboração  
**Autor:** Fabio André Zatta  

---

## 1. O Conceito de Recurso Congregacional

Um **Recurso Congregacional** é uma abstração pura de domínio utilizada para unificar conceitualmente qualquer bem, material ou ativo cuja administração seja de responsabilidade da congregação. Esta abstração define uma interface comportamental e lógica comum para elementos que possuem ciclo de vida, controle de disponibilidade, responsáveis e histórico de movimentações.

> ⚠️ **Nota de Arquitetura:** Este conceito não representa uma tabela direta no banco de dados, mas sim um modelo polimórfico conceitual que garante a extensibilidade do sistema.

### 1.1 Divisão de Recursos (Versão 1.0)
```
Recurso Congregacional
│
├── Território (Ativo Geográfico)
└── Publicação (Ativo de Almoxarifado / Literatura)
```
No futuro, essa mesma abstração permitirá acoplar novos recursos, como equipamentos de som, projetores, salas e veículos sem impactar a arquitetura core do ecossistema.

### 1.2 Matriz de Alinhamento de Características
| Característica | Território | Publicação |
| :--- | :---: | :---: |
| Pertence a uma Congregação | ✅ | ✅ |
| Possui Identificação Única | ✅ | ✅ |
| Possui Estado de Disponibilidade | ✅ | ✅ |
| Possui Estado de Indisponibilidade | ✅ | ✅ |
| Possui Responsável (Custódia Temporária) | ✅ | ✅ |
| Gera Histórico de Movimentações | ✅ | ✅ |
| Dispara Logs de Auditoria | ✅ | ✅ |
| Possui Situação/Status Controlado | ✅ | ✅ |

---

## 2. Nova Organização do Domínio (Bounded Contexts)

Com a introdução dessa camada conceitual, o ecossistema GTP subdivide-se em Contextos Delimitados transparentes:

```
Gestor de Territórios e Publicações (GTP)
│
├── Congregação (Tenant Root)
│
├── Pessoas
│      ├── Usuário
│      ├── Designação
│      ├── Função
│      └── Permissões
│
├── Recursos Congregacionais
│      ├── Territórios
│      └── Publicações
│
├── Pedidos
├── Campanhas
├── Configurações
└── Auditoria
```

---

## 3. Reflexos Arquiteturais (Estrutura de Pastas)

### 3.1 Backend Java (Spring Boot)
Adota-se a estratégia de **Package-by-Feature** para garantir alta coesão e isolamento de escopo:
```
br.com.gtp
│
├── administracao
├── congregacao
├── pessoas
├── territorios
├── publicacoes
├── pedidos
├── campanhas
├── auditoria
├── configuracoes
└── shared
```

### 3.2 Frontend React
No ecossistema cliente, o desenvolvimento orienta-se em diretórios desacoplados dentro da pasta `features`:
```
src/
├── features/
│   ├── administracao/
│   ├── congregacoes/
│   ├── pessoas/
│   ├── territorios/
│   ├── publicacoes/
│   ├── pedidos/
│   ├── campanhas/
│   ├── auditoria/
│   └── configuracoes/
├── shared/
├── layouts/
└── core/
```

---

## 4. Agregado Raiz (Aggregate Root)

### 4.1 Definição
No padrão DDD (Domain-Driven Design), a **Congregação** assume o papel de **Aggregate Root** (Agregado Raiz). Nenhuma entidade operacional ou cadastral possui autonomia de existência fora do escopo de um Tenant (Congregação) ativo e validado.

```
                           Congregação (Aggregate Root)
                                │
        ┌───────────────────────┼────────────────────────┐
        ▼                       ▼                        ▼
     Pessoas              Recursos                 Administração
    (Usuários)         (Territórios)              (Configurações)
        │                 (Estoque)                      │
        └───────────────────────┬────────────────────────┘
                                ▼
                            Auditoria
```

### 4.2 Invariantes de Domínio (Regras Corporativas Absolutas)
* **INV-001:** Toda Pessoa pertence a exatamente uma Congregação.
* **INV-002:** Todo Usuário pertence a exatamente uma Pessoa física cadastrada.
* **INV-003:** Todo Território pertence a exatamente uma Congregação.
* **INV-004:** Toda Publicação pertence a exatamente uma Congregação.
* **INV-005:** Todo Pedido pertence a exatamente uma Congregação.
* **INV-006 (Imutabilidade Transversal):** Nenhuma entidade operacional pode mudar de Congregação após ser criada. Caso mude de localidade, o registro original sofre encerramento lógico e cria-se um novo no destino.
* **INV-007:** Toda operação mutável crucial deve gerar e persistir de forma síncrona um registro de Auditoria.
* **INV-008:** Todas as queries de busca do banco de dados devem injetar implicitamente o identificador da congregação autenticada.
* **INV-009:** Um Território possui um histórico de N versões, mas sempre existirá exatamente uma única versão ativa (vigente) por vez.

---

## 5. Eventos de Domínio (Domain Events)

Os **Eventos de Domínio** materializam fatos de negócios imutáveis ocorridos no passado, promovendo o desacoplamento completo entre módulos. 

### 5.1 Fluxo de Comunicação Desacoplada
```
[Ator/Usuário] -> [Serviço de Domínio] -> [Persistência Relacional] -> [Disparo de Evento]
                                                                             │
                                                     ┌───────────────────────┴───────────────────────┐
                                                     ▼                       ▼                       ▼
                                                (Auditoria)             (Dashboards)           (Notificações)
```

### 5.2 Mapeamento de Eventos por Contexto

* **Módulo Administração:** `PessoaCadastrada`, `UsuarioCriado`, `DesignacaoAtribuida`, `PermissaoAlterada`.
* **Módulo Territórios:** `TerritorioDisponibilizado`, `TerritorioRetirado`, `TerritorioDevolvido`, `TerritorioAtualizado`, `TerritorioRedesenhado`, `NovaVersaoTerritorioPublicada`.
* **Módulo Publicações:** `PublicacaoCadastrada`, `EstoqueAtualizado`, `PedidoCriado`, `PedidoRecebido`, `PedidoRetirado`, `PedidoCancelado`.
* **Módulo Campanhas:** `CampanhaCriada`, `CampanhaIniciada`, `CampanhaFinalizada`.
* **Eventos Transversais:** `LoginRealizado`, `LogoutRealizado`, `SenhaAlterada`, `AuditoriaRegistrada`.

---

## 6. Novo Conceito: Cadastros Parametrizáveis

A Congregação poderá definir e personalizar diversos cadastros de apoio, respeitando suas necessidades operacionais.

```
Congregação
│
├── Configurações
│
├── Cadastros Parametrizáveis
│   ├── Tipos de Território
│   ├── Categorias de Publicações
│   ├── Idiomas
│   ├── Tipos de Pedido
│   ├── Motivos de Arquivamento
│   ├── Motivos de Cancelamento
│   ├── Tipos de Movimentação
│   ├── Tipos de Campanha
│   └── Outros parâmetros
│
└── Recursos Congregacionais
```

---

## 7. Capítulo 8 – Versionamento dos Recursos Congregacionais

### 7.1 Objetivo
Os Recursos Congregacionais poderão sofrer alterações durante sua vida útil. Essas alterações não deverão eliminar informações históricas. Para preservar a rastreabilidade, o GTP adotará um mecanismo de versionamento, permitindo manter todas as versões de um recurso. Na versão inicial do sistema, este mecanismo será aplicado aos Territórios, podendo ser estendido futuramente para outros recursos.

### 7.2 Conceito
Existem duas informações diferentes:

1. **O Território:** Representa o cadastro permanente. Exemplo: *Território Nº 25* (Ele continuará existindo por muitos anos).
2. **A Versão do Território:** Representa como esse território estava em determinado momento.

* **Exemplo de Evolução:**
  * **Versão 1:** Mapa A, 50 Quadras, Ano 2024.
  * **Versão 2:** Mapa Novo, 62 Quadras, Ano 2026.

Observe que o território continua sendo o mesmo; o que mudou foi apenas sua configuração estrutural ou geográfica.

### 7.3 Modelo Conceitual
```
Congregação
      │
      ▼
Território
      │
      ├──────────────┐
      ▼              ▼
   Versão 1       Versão 2
      │              │
      ▼              ▼
    Mapa A         Mapa B
```

### 7.4 O que poderá mudar entre versões
Uma nova versão poderá alterar:
* Mapa, imagem ou arquivo PDF;
* Limites geográficos e descrição;
* Quantidade estimada de residências, apartamentos e empresas;
* Observações gerais.

Essas alterações criam um novo registro de versão e nunca modificam as versões anteriores.

### 7.5 O que nunca muda
O cadastro principal permanece estritamente constante e imutável:
* Identificador único ($ID$);
* Vínculo com a Congregação ($Tenant$);
* Número do território;
* Data de criação original.

### 7.6 Benefícios
Essa arquitetura permite responder perguntas complexas de auditoria e histórico de negócio como:
* *Como era o Território 18 em 2025?*
* *Quantas vezes o Território 07 foi redesenhado?*
* *Qual mapa estava vigente em março de 2026?*

### 7.7 Regra Geral
Sempre existirá apenas **uma versão ativa** (vigente). As demais permanecerão salvas apenas como histórico imutável.

---

## 8. Conclusão
Ao definir a **Congregação** como Aggregate Root, estruturar a comunicação inter-módulos orientada a **Eventos de Domínio** e consolidar o **Versionamento de Recursos**, a aplicação garante o isolamento indispensável para cenários Multi-tenant, assegurando manutenibilidade, rastreabilidade e extensibilidade para o crescimento planejado da aplicação GTP.
