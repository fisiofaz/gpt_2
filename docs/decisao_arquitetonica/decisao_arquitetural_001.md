# Decisão Arquitetural nº 001: Linha do Tempo (Timeline) para Entidades Importantes

## 1. Contexto e Motivação
No ecossistema GTP, o rastreamento de mudanças tradicionalmente focado apenas em logs de auditoria técnica (quem alterou, o que alterou e quando) não é suficiente para expressar o fluxo de valor e a evolução do negócio. 

Para preencher essa lacuna, esta decisão estabelece que **toda entidade importante do GTP possuirá sua própria Linha do Tempo (Timeline)**. Isso garante que cada entidade central mantenha um histórico rico, contextualizado e focado nas regras de negócio, facilitando o entendimento da jornada do dado tanto para usuários operacionais quanto para fins de suporte e inteligência de processos.

## 2. Diferença entre Auditoria e Timeline de Negócio
* **Auditoria Técnica:** Focada em infraestrutura e segurança (ex: `UPDATE tabela SET status = 'A' WHERE id = 1`).
* **Timeline de Negócio:** Focada na jornada do usuário e nos marcos do processo (ex: `Pedido separado para envio por João`).

---

## 3. Exemplos Práticos de Aplicação

### 3.1 Entidade: Território
A evolução de um território envolve atualizações cartográficas, posse física ou lógica e versionamento.

* **05/01/2026** – Território criado
* **12/01/2026** – Mapa atualizado
* **18/01/2026** – Retirado por João
* **22/01/2026** – Devolvido
* **10/02/2026** – Nova versão criada

### 3.2 Entidade: Pedido
O ciclo de vida de um pedido reflete diretamente a eficiência logística e o atendimento à demanda.

* **02/03/2026** – Pedido criado
* **05/03/2026** – Material recebido
* **06/03/2026** – Pedido separado
* **08/03/2026** – Pedido entregue
* **08/03/2026** – Pedido concluído

### 3.3 Entidade: Publicação
O fluxo de publicação compreende desde a entrada operacional até o encerramento do seu ciclo de utilidade.

* **Março/2026** – Cadastro realizado
* **Março/2026** – Entrada de lote
* **Março/2026** – Ajuste de estoque
* **Março/2026** – Entrega efetuada
* **Março/2026** – Arquivamento concluído

---

## 4. Diretrizes de Implementação
1. **Imutabilidade:** Os eventos registrados na Timeline nunca devem ser alterados ou excluídos.
2. **Linguagem Ubíqua:** Os termos utilizados nos eventos devem refletir rigorosamente o vocabulário de negócio (Domain-Driven Design).
3. **Desempenho:** O armazenamento da linha do tempo deve ser otimizado para leituras rápidas, preferencialmente utilizando padrões de Append-Only ou Event Sourcing onde aplicável.
