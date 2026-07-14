
 
 
 
Sistema de Gestão de Territórios e Publicações (GTP)  


Documento 03 – Regra de Negocio 


  
  
  
  
Projeto: Sistema de Gestão de Territórios e Publicações (GTP)   Versão: 1.0.0    
Status: Em Elaboração    
Data: Julho/2026    
Autor: Fabio André Zatta    
 
 
 
 
 


 
 


 
 
1	– Introdução
1.1 Objetivo
Este documento estabelece as Regras de Negócio do Gestor de Territórios e Publicações (GTP).
As regras definem as restrições, validações, políticas operacionais e comportamentos obrigatórios que devem ser observados por todos os módulos do sistema, garantindo consistência, segurança, rastreabilidade e aderência aos processos das congregações.
As Regras de Negócio complementam os Requisitos Funcionais definidos no Documento 02, especificando como o sistema deve agir em cada situação.

1.2 Escopo
Este documento aplica-se a todos os módulos do GTP, incluindo:
•	Administração
•	Congregações
•	Pessoas
•	Usuários
•	Territórios
•	Publicações
•	Pedidos
•	Campanhas
•	Dashboard
•	Relatórios
•	Auditoria
•	Configurações
•	Notificações
Todas as regras descritas são de cumprimento obrigatório pelo sistema.

1.3 Estrutura das Regras
Cada regra seguirá um padrão para facilitar rastreabilidade e implementação.
Identificação
Exemplo:
RN-001
Onde:
•	RN = Regra de Negócio
•	001 = Número sequencial

Estrutura da Regra
Cada regra conterá:
•	Identificador
•	Nome
•	Objetivo
•	Descrição
•	Módulos afetados
•	Perfis envolvidos
•	Condições
•	Exceções
•	Eventos gerados
•	Requisitos Funcionais relacionados

Exemplo
RN-001 – Isolamento entre Congregações
Objetivo
Garantir que uma congregação não tenha acesso aos dados de outra.
Descrição
Toda consulta, alteração, exclusão lógica e operação deverá considerar obrigatoriamente a Congregação ativa do usuário autenticado.
Módulos
•	Todos
Perfis
•	Todos
Exceção
O Desenvolvedor Geral poderá acessar todas as congregações para fins de administração e manutenção.
Relacionamento
•	RF-136

1.4 Classificação das Regras
As regras serão classificadas em categorias para facilitar a manutenção.
Prefixo	Categoria
RN-ADM	Administração
RN-USR	Usuários
RN-CONG	Congregações
RN-TERR	Territórios
RN-PUB	Publicações
RN-PED	Pedidos
RN-CAMP	Campanhas
RN-AUD	Auditoria
RN-SEC	Segurança
RN-CFG	Configurações
RN-NOT	Notificações
RN-GER	Regras Gerais
Essa classificação facilitará a localização das regras e sua implementação por módulos.

2 – Regras Gerais do Sistema
RN-GER-001 – Isolamento entre Congregações
Objetivo
Garantir a separação lógica dos dados entre as congregações cadastradas no sistema.
Descrição
Cada registro deverá estar vinculado a uma única congregação.
Usuários somente poderão visualizar e manipular informações pertencentes à congregação à qual estão vinculados.
Exceção
O Desenvolvedor Geral possui acesso global.
Módulos
Todos.
RF Relacionado
RF-136.

RN-GER-002 – Exclusão Lógica
Nenhuma entidade principal será removida fisicamente do banco de dados.
Ao solicitar uma exclusão, o sistema deverá alterar seu status para Arquivado, Inativo ou Cancelado, conforme o contexto.
Os registros permanecerão disponíveis para auditoria e histórico.

RN-GER-003 – Auditoria Obrigatória
Toda operação de inclusão, alteração, cancelamento, arquivamento ou mudança de status deverá gerar um registro de auditoria contendo:
•	Usuário responsável.
•	Data e hora.
•	Operação realizada.
•	Entidade afetada.
•	Valores alterados (quando aplicável).
•	Endereço IP.
•	Identificação do dispositivo ou navegador (quando disponível).

RN-GER-004 – Linha do Tempo (Timeline)
Toda entidade principal deverá manter uma linha do tempo com os eventos relevantes ocorridos durante seu ciclo de vida.
A Timeline nunca poderá ser alterada manualmente.

RN-GER-005 – Histórico de Negócio
Toda mudança significativa deverá ser registrada como histórico de negócio.
O histórico deverá ser permanente e imutável.

RN-GER-006 – Integridade Referencial
O sistema não permitirá a criação de registros órfãos.
Exemplos:
•	Pedido sem solicitante.
•	Território sem congregação.
•	Publicação sem categoria.
•	Usuário sem perfil.
•	Campanha sem responsável.

RN-GER-007 – Datas e Horários
Todas as operações deverão registrar data e hora utilizando um padrão único definido para o sistema.
Os horários apresentados na interface deverão respeitar a configuração regional do ambiente.


RN-GER-008 – Identificadores Únicos
Cada entidade principal deverá possuir um identificador interno único, imutável e independente de nomes ou códigos exibidos ao usuário.

RN-GER-009 – Versionamento
Sempre que uma entidade suportar versionamento, apenas uma versão poderá estar ativa simultaneamente.
As versões anteriores permanecerão disponíveis para consulta histórica.

RN-GER-010 – Eventos de Domínio
Toda operação relevante deverá publicar um evento de domínio correspondente, permitindo integração entre módulos sem acoplamento direto.
Exemplos:
•	TerritorioRetirado
•	PedidoCriado
•	PedidoEntregue
•	EstoqueAtualizado
•	CampanhaEncerrada

Resumo do Capítulo
Código	Regra
RN-GER-001	Isolamento entre Congregações
RN-GER-002	Exclusão Lógica
RN-GER-003	Auditoria Obrigatória
RN-GER-004	Linha do Tempo
RN-GER-005	Histórico de Negócio
RN-GER-006	Integridade Referencial
RN-GER-007	Datas e Horários
RN-GER-008	Identificadores Únicos
RN-GER-009	Versionamento
RN-GER-010	Eventos de Domínio

3 – Congregações
3.1 Objetivo
Este capítulo estabelece as regras relacionadas ao cadastro, administração, funcionamento e isolamento das Congregações dentro do GTP.
A Congregação representa a unidade organizacional básica do sistema.
Todos os recursos operacionais pertencem obrigatoriamente a uma Congregação.
________________________________________
3.2 Conceito
A Congregação representa uma comunidade das Testemunhas de Jeová responsável pela administração de:
•	Territórios
•	Publicadores
•	Publicações
•	Pedidos
•	Campanhas
•	Configurações
•	Usuários
Todas as operações realizadas no sistema estarão vinculadas exatamente a uma Congregação.


RN-CONG-001 — Congregação Obrigatória
•	Descrição
Nenhum recurso operacional poderá existir sem estar associado a uma Congregação.
Aplica-se a
•	Usuários
•	Pessoas
•	Territórios
•	Publicações
•	Pedidos
•	Campanhas
•	Estoque
•	Configurações
Não permitido
Pedido
    ↓
Sem Congregação

RN-CONG-002 — Isolamento de Dados
Uma Congregação jamais poderá visualizar informações pertencentes a outra Congregação.
Essa regra deverá ser aplicada em:
•	consultas;
•	relatórios;
•	dashboards;
•	APIs;
•	exportações;
•	notificações.
Exceção
Desenvolvedor Geral.
•	
RN-CONG-003 — Administração Independente
Cada Congregação possuirá autonomia administrativa sobre seus próprios dados.
Ela poderá administrar:
•	Usuários;
•	Territórios;
•	Publicações;
•	Pedidos;
•	Campanhas;
•	Configurações.
Sem interferir em outra Congregação.

RN-CONG-004 — Configurações Próprias
Cada Congregação poderá possuir configurações específicas.
Exemplos:
•	Tipos de Território;
•	Categorias de Publicações;
•	Tipos de Pedido;
•	Prioridades;
•	Mensagens;
•	Motivos de Cancelamento.
Essas configurações não serão compartilhadas automaticamente entre Congregações.

RN-CONG-005 — Exclusão
Uma Congregação nunca poderá ser removida fisicamente.
Situações possíveis:
•	Ativa
•	Inativa
•	Arquivada
Todo histórico permanecerá preservado.

RN-CONG-006 — Código da Congregação
Cada Congregação possuirá um identificador interno único.
Esse identificador será imutável.
Mesmo que o nome seja alterado.

RN-CONG-007 — Alteração de Nome
O nome da Congregação poderá ser alterado.
Entretanto:
•	deverá ser registrado em auditoria;
•	deverá ser registrado na Timeline;
•	o histórico deverá permanecer íntegro.

RN-CONG-008 — Responsável Administrativo
Cada Congregação deverá possuir um Administrador Geral ativo.
Caso esse usuário seja desativado:
•	outro Administrador deverá ser definido antes da conclusão da operação.
Nunca poderá existir Congregação sem responsável administrativo.

RN-CONG-009 — Configuração Inicial
Ao criar uma Congregação, o sistema deverá criar automaticamente:
•	parâmetros padrão;
•	perfis padrão;
•	categorias iniciais;
•	permissões básicas;
•	configurações iniciais.
RN-CONG-010 — Auditoria
Toda alteração na Congregação deverá registrar:
•	usuário;
•	data;
•	hora;
•	operação;
•	dados alterados.

RN-CONG-011 — Timeline
Toda Congregação possuirá uma Timeline contendo:
•	criação;
•	alterações;
•	mudança de responsável;
•	ativação;
•	inativação;
•	arquivamento.

RN-CONG-012 — Eventos
As operações deverão publicar eventos.
Exemplos:
CongregacaoCriada
CongregacaoAtualizada
CongregacaoArquivada
CongregacaoReativada

RN-CONG-013 — Limites Operacionais
Cada Congregação poderá definir parâmetros como:
•	prazo máximo de empréstimo de um território;
•	quantidade máxima de territórios por publicador;
•	estoque mínimo por publicação;
•	prazo de retirada de pedidos;
•	quantidade máxima de pedidos simultâneos.
Esses limites serão utilizados pelas regras de negócio dos demais módulos.

RN-CONG-014 — Personalização Visual
Cada Congregação poderá personalizar elementos visuais do sistema, sem alterar sua identidade funcional.
Exemplos:
•	logotipo;
•	imagem de capa;
•	cores institucionais (dentro de um conjunto permitido);
•	mensagens de boas-vindas.
Essa personalização será restrita ao ambiente da própria Congregação.

RN-CONG-015 — Configuração de Calendário
Cada Congregação poderá cadastrar períodos relevantes para suas atividades, como:
•	campanhas locais;
•	eventos internos;
•	datas de inventário;
•	períodos de manutenção dos territórios.
Essas informações poderão ser utilizadas pelos módulos de Campanhas, Pedidos e Dashboard.



3.3 Resumo do Capítulo
Código	Regra
RN-CONG-001	Congregação Obrigatória
RN-CONG-002	Isolamento de Dados
RN-CONG-003	Administração Independente
RN-CONG-004	Configurações Próprias
RN-CONG-005	Exclusão Lógica
RN-CONG-006	Identificador Imutável
RN-CONG-007	Alteração de Nome
RN-CONG-008	Administrador Obrigatório
RN-CONG-009	Configuração Inicial
RN-CONG-010	Auditoria
RN-CONG-011	Timeline
RN-CONG-012	Eventos de Domínio
RN-CONG-013	Limites Operacionais
RN-CONG-014	Personalização Visual
RN-CONG-015	Configuração de Calendário

4 – Pessoas
4.1 Objetivo
Este capítulo estabelece as regras relacionadas ao cadastro, identificação, manutenção e ciclo de vida das pessoas cadastradas no GTP.
Toda pessoa representa um indivíduo pertencente a uma Congregação, podendo ou não possuir acesso ao sistema.



4.2 Conceito
Pessoa é uma entidade do domínio.
Usuário é uma credencial de acesso.
Portanto:
Pessoa
↓
Pode possuir
↓
Usuário
Nem toda Pessoa será um Usuário.
Mas todo Usuário obrigatoriamente estará vinculado a uma Pessoa.

RN-PES-001 — Pessoa Obrigatória
Nenhum Usuário poderá existir sem uma Pessoa vinculada.
Não permitido
Usuário
↓
Sem Pessoa

RN-PES-002 — Congregação Obrigatória
Toda Pessoa deverá pertencer exatamente a uma Congregação.
Não será permitido cadastrar pessoas sem Congregação.

RN-PES-003 — Cadastro Único
Dentro de uma Congregação não poderá existir duplicidade de cadastro da mesma pessoa.
O sistema deverá validar informações suficientes para evitar cadastros duplicados.
Exemplos:
•	nome completo;
•	data de nascimento;
•	telefone (quando informado);
•	e-mail (quando informado).
Quando houver suspeita de duplicidade, o sistema deverá alertar o administrador antes da confirmação do cadastro.

RN-PES-004 — Situação da Pessoa
Toda Pessoa possuirá uma situação cadastral.
Estados possíveis:
Situação	Descrição
Ativa	Participa normalmente das atividades
Inativa	Cadastro preservado, sem atuação
Arquivada	Registro mantido apenas para histórico
Nenhum registro será excluído fisicamente.

RN-PES-005 — Histórico
Todas as alterações cadastrais deverão ser registradas.
Exemplos:
•	alteração de nome;
•	mudança de telefone;
•	alteração de endereço;
•	atualização de e-mail.
O histórico permanecerá disponível para consulta administrativa.

RN-PES-006 — Designações
Uma Pessoa poderá exercer uma ou mais designações dentro da Congregação.
Exemplos:
•	Publicador
•	Servo de Territórios
•	Servo de Publicações
•	Superintendente de Serviço
•	Administrador Geral
Cada designação terá período de vigência.
O sistema manterá o histórico completo dessas designações.

RN-PES-007 — Período de Vigência
Toda designação deverá possuir:
•	data de início;
•	data de término (opcional);
•	motivo do encerramento (quando aplicável).
Isso permitirá responder perguntas como:
•	Quem era o Servo de Territórios em janeiro de 2025?
•	Quando determinado publicador assumiu uma responsabilidade?

RN-PES-008 — Alteração de Designação
Ao alterar uma designação:
•	a alteração será registrada na Timeline;
•	a auditoria será atualizada;
•	o histórico permanecerá preservado.
Nenhuma designação anterior será apagada.

RN-PES-009 — Pessoa sem Usuário
Uma Pessoa poderá existir sem possuir credenciais de acesso.
Exemplos:
•	publicadores que não utilizam o sistema;
•	registros históricos;
•	pessoas aguardando ativação.

RN-PES-010 — Desativação
Ao desativar uma Pessoa:
•	novas retiradas de territórios serão bloqueadas;
•	novos pedidos de publicações não poderão ser criados;
•	permissões de acesso serão revogadas (caso exista um Usuário associado).
Os registros históricos permanecerão disponíveis.

RN-PES-011 — Reativação
Uma Pessoa poderá ser reativada.
Ao reativar:
•	as permissões serão recalculadas;
•	as designações vigentes serão verificadas;
•	a Timeline registrará o evento.

RN-PES-012 — Contatos
Uma Pessoa poderá possuir múltiplos meios de contato.
Exemplos:
•	telefone residencial;
•	telefone celular;
•	e-mail principal;
•	e-mail alternativo.
Um contato poderá ser definido como principal.



RN-PES-013 — Endereços
Uma Pessoa poderá possuir um ou mais endereços cadastrados.
Será possível indicar:
•	endereço principal;
•	endereço para correspondência.
O histórico de alterações de endereço será preservado.

RN-PES-014 — Privacidade de Dados
Os dados pessoais deverão ser acessíveis apenas por usuários autorizados.
Cada perfil visualizará somente as informações necessárias para suas funções.
Informações sensíveis deverão ser protegidas conforme as configurações de segurança do sistema.

RN-PES-015 — Timeline
Cada Pessoa possuirá uma linha do tempo contendo:
•	cadastro;
•	alterações;
•	mudança de designações;
•	criação ou remoção de usuário;
•	ativação;
•	inativação.

RN-PES-016 — Eventos de Domínio
As operações relacionadas às Pessoas deverão publicar eventos, como:
PessoaCadastrada
PessoaAtualizada
PessoaAtivada
PessoaInativada
DesignacaoAlterada

4.3 Resumo do Capítulo
Código	Regra
RN-PES-001	Pessoa obrigatória para Usuário
RN-PES-002	Congregação obrigatória
RN-PES-003	Cadastro único
RN-PES-004	Situação cadastral
RN-PES-005	Histórico
RN-PES-006	Designações
RN-PES-007	Vigência das designações
RN-PES-008	Alteração de designações
RN-PES-009	Pessoa sem usuário
RN-PES-010	Desativação
RN-PES-011	Reativação
RN-PES-012	Contatos
RN-PES-013	Endereços
RN-PES-014	Privacidade de dados
RN-PES-015	Timeline
RN-PES-016	Eventos de domínio



5 – Usuários, Autenticação e Controle de Acesso
5.1 Objetivo
Este capítulo estabelece as regras relacionadas ao acesso ao sistema, autenticação, autorização e gerenciamento de usuários.
Enquanto o capítulo anterior trata da Pessoa, este capítulo define como essa Pessoa acessa o GTP.
5.2 Conceitos
Pessoa
Representa o indivíduo.
Usuário
Representa a conta de acesso.
Designação
Representa a responsabilidade dentro da Congregação.
Permissão
Representa aquilo que o usuário pode fazer.







Exemplo
Fabio André Zatta
        │
        ▼
      Pessoa
        │
        ▼
	   Usuário

login

senha

       2FA
        │
        ▼
  Designação

Servo de Territórios
        │
        ▼
Permissões

Cadastrar Território

Editar Território

Retirar

Receber
Observe que a mesma pessoa poderá assumir novas designações ao longo do tempo, sem perder seu histórico.

RN-USR-001 — Pessoa Obrigatória
Todo Usuário deverá estar vinculado a exatamente uma Pessoa ativa.
Não será permitido criar usuários órfãos.

RN-USR-002 — Login Único
Cada login deverá ser único em todo o sistema.
Não será permitido reutilizar um login existente, mesmo que o usuário esteja inativo.

RN-USR-003 — E-mail Único
Quando utilizado como login, o e-mail deverá ser único.

RN-USR-004 — Situação do Usuário
Todo Usuário possuirá uma situação.
Estados:
•	Ativo
•	Bloqueado
•	Suspenso
•	Inativo

RN-USR-005 — Senhas
As senhas nunca serão armazenadas em texto puro.
Deverão ser armazenadas utilizando algoritmo seguro de hash.

RN-USR-006 — Política de Senhas
A senha deverá obedecer à política configurada pela administração, incluindo comprimento mínimo e critérios de complexidade quando habilitados.
O sistema permitirá ajustar essa política por configuração.

RN-USR-007 — Alteração de Senha
Toda alteração deverá:
•	invalidar sessões ativas (quando configurado);
•	registrar auditoria;
•	registrar Timeline.

RN-USR-008 — Recuperação de Senha
O processo deverá utilizar token temporário.
O token:
•	possuirá validade;
•	será de uso único;
•	será invalidado após utilização.

RN-USR-009 — Tentativas de Login
Após um número configurável de tentativas inválidas, o usuário será temporariamente bloqueado.
O administrador poderá desbloquear a conta antes do término desse período.

RN-USR-010 — Sessões
Cada autenticação criará uma sessão.
A sessão registrará:
•	data;
•	hora;
•	endereço IP;
•	dispositivo (quando disponível);
•	navegador (quando disponível).

RN-USR-011 — Sessões Simultâneas
O sistema permitirá configurar o número máximo de sessões simultâneas por usuário.
Essa configuração poderá ser definida globalmente ou por congregação.

RN-USR-012 — Encerramento de Sessão
O usuário poderá:
•	encerrar a sessão atual;
•	encerrar todas as demais sessões ativas.

RN-USR-013 — Permissões
Nenhuma operação será executada sem validação prévia das permissões do usuário.
A validação ocorrerá no backend.

RN-USR-014 — Herança de Permissões
As permissões poderão ser concedidas por:
•	perfil;
•	designação;
•	atribuição direta.
Quando houver conflito, prevalecerá a política definida pelo Administrador Geral.

RN-USR-015 — Autenticação Multifator (2FA)
O sistema será preparado para suportar autenticação em dois fatores.
Na primeira versão, o recurso poderá permanecer desabilitado por padrão.

RN-USR-016 — Auditoria de Acesso
Toda autenticação registrará:
•	sucesso ou falha;
•	data e hora;
•	endereço IP;
•	navegador;
•	dispositivo (quando disponível).


RN-USR-017 — Desativação Automática
Caso a Pessoa vinculada seja desativada:
•	o Usuário será automaticamente impedido de acessar o sistema;
•	as sessões existentes poderão ser encerradas automaticamente.

RN-USR-018 — Alteração de Designação
Ao alterar a designação de uma Pessoa, as permissões do Usuário deverão ser recalculadas imediatamente.

RN-USR-019 — Exclusão
Usuários nunca serão excluídos fisicamente.
Estados possíveis:
•	Ativo
•	Inativo
•	Arquivado
RN-USR-020 — Timeline
Toda conta de usuário possuirá uma Timeline contendo:
•	criação;
•	primeiro acesso;
•	alterações de senha;
•	bloqueios;
•	desbloqueios;
•	alterações de permissões;
•	alterações de designação;
•	encerramento de sessões.



RN-USR-021 — Eventos de Domínio
As operações relacionadas aos Usuários publicarão eventos, como:
UsuarioCriado

UsuarioAtualizado

UsuarioBloqueado

UsuarioDesbloqueado

SenhaAlterada

LoginRealizado

LogoutRealizado

PermissaoAlterada

RN-USR-022 — Política de Menor Privilégio
Todo usuário receberá apenas as permissões estritamente necessárias para executar suas responsabilidades.
Permissões adicionais deverão ser concedidas explicitamente e registradas em auditoria.

RN-USR-023 — Acesso Emergencial
O sistema poderá permitir um modo de acesso emergencial para manutenção, restrito ao Desenvolvedor Geral.
Todo acesso desse tipo deverá:
•	ser justificado;
•	ser registrado em auditoria;
•	gerar alerta ao Administrador Geral da congregação afetada.

5.3 Resumo do Capítulo
Código	Regra
RN-USR-001	Pessoa obrigatória
RN-USR-002	Login único
RN-USR-003	E-mail único
RN-USR-004	Situação do usuário
RN-USR-005	Hash de senhas
RN-USR-006	Política de senhas
RN-USR-007	Alteração de senha
RN-USR-008	Recuperação de senha
RN-USR-009	Tentativas de login
RN-USR-010	Sessões
RN-USR-011	Sessões simultâneas
RN-USR-012	Encerramento de sessão
RN-USR-013	Validação de permissões
RN-USR-014	Herança de permissões
RN-USR-015	Preparação para 2FA
RN-USR-016	Auditoria de acesso
RN-USR-017	Desativação automática
RN-USR-018	Recalcular permissões
RN-USR-019	Exclusão lógica
RN-USR-020	Timeline
RN-USR-021	Eventos de domínio
RN-USR-022	Menor privilégio
RN-USR-023	Acesso emergencial
6 – Territórios
6.1 Objetivo
Este capítulo estabelece as regras de negócio para criação, manutenção, distribuição, retirada, devolução e acompanhamento dos territórios pertencentes às Congregações.
Um território representa uma área geográfica designada à Congregação para a pregação das boas novas e deve ser administrado de forma organizada, segura e rastreável.

6.2 Conceitos
Cada território deverá possuir:
•	identificação única;
•	congregação proprietária;
•	tipo de território;
•	situação atual;
•	histórico de movimentações;
•	mapa ou descrição da área (quando disponível);
•	data de criação;
•	responsável pelo cadastro.

RN-TERR-001 — Vínculo Obrigatório
Todo território deverá pertencer a exatamente uma Congregação.
Não será permitido compartilhar um mesmo território entre congregações.

RN-TERR-002 — Código Único
Cada território possuirá um código único dentro da Congregação.
O código poderá seguir um padrão configurável (ex.: T-001, U-015, R-020).
Uma vez criado, o código não poderá ser reutilizado para outro território.

RN-TERR-003 — Situação do Território
Todo território deverá possuir uma situação.
Estados permitidos:
•	Disponível
•	Reservado
•	Retirado
•	Em Revisão
•	Arquivado
As transições deverão respeitar o fluxo definido pelo sistema.


RN-TERR-004 — Retirada
Somente usuários autorizados poderão registrar a retirada de um território.
A retirada deverá informar:
•	publicador responsável;
•	data e hora;
•	responsável pela entrega;
•	previsão de devolução (quando configurada).

RN-TERR-005 — Um Território, Uma Retirada Ativa
Um território não poderá estar retirado por mais de um publicador ao mesmo tempo.
Antes de registrar uma nova retirada, o sistema deverá verificar se existe movimentação ativa.

RN-TERR-006 — Limite de Territórios
Cada Congregação poderá configurar a quantidade máxima de territórios ativos por publicador.
Ao atingir esse limite, novas retiradas serão bloqueadas até que haja devolução ou autorização excepcional.

RN-TERR-007 — Devolução
A devolução encerrará a movimentação ativa do território.
O sistema registrará:
•	data e hora;
•	usuário responsável pelo recebimento;
•	observações;
•	situação do território após a devolução.


RN-TERR-008 — Devolução em Atraso
Caso a Congregação defina um prazo máximo de permanência com o território, o sistema deverá identificar automaticamente devoluções em atraso.
Esses casos deverão gerar alerta para o Servo de Territórios e para o Superintendente de Serviço.

RN-TERR-009 — Histórico Permanente
Todas as retiradas e devoluções permanecerão registradas.
O histórico nunca poderá ser alterado ou excluído.

RN-TERR-010 — Reserva (Opcional)
A Congregação poderá habilitar a funcionalidade de reserva de territórios.
Uma reserva:
•	terá prazo de validade;
•	poderá ser cancelada;
•	impedirá outra retirada durante sua vigência.

RN-TERR-011 — Reatribuição
Um território retirado poderá ser reatribuído apenas por usuários autorizados.
A reatribuição deverá encerrar a movimentação anterior e iniciar uma nova, preservando o histórico.

RN-TERR-012 — Manutenção
Territórios poderão ser colocados em "Em Revisão" para atualização de mapas, descrição ou limites.
Enquanto estiverem nessa situação, não poderão ser retirados.
RN-TERR-013 — Arquivamento
Territórios que deixarem de existir ou forem substituídos poderão ser arquivados.
O arquivamento:
•	não apagará o histórico;
•	impedirá novas retiradas;
•	manterá o território disponível para consultas históricas.

RN-TERR-014 — Atualização de Informações
Qualquer alteração em dados do território (nome, descrição, mapa, limites, tipo) deverá gerar:
•	registro de auditoria;
•	evento de domínio;
•	atualização da Timeline.

RN-TERR-015 — Eventos de Domínio
As operações relacionadas aos territórios publicarão eventos, como:
TerritorioCriado
TerritorioAtualizado
TerritorioReservado
TerritorioRetirado
TerritorioDevolvido
TerritorioReatribuido
TerritorioArquivado



RN-TERR-016 — Indicadores
Toda movimentação deverá atualizar automaticamente os indicadores utilizados pelo Dashboard, incluindo:
•	quantidade de territórios disponíveis;
•	quantidade de territórios retirados;
•	tempo médio de utilização;
•	devoluções em atraso.

RN-TERR-017 — Integridade Geográfica
Cada território deverá possuir uma identificação geográfica consistente.
No futuro, essa informação poderá ser integrada a mapas digitais, permitindo visualizar limites e localização sem alterar as regras de negócio.

RN-TERR-018 — Bloqueio por Situação do Publicador
Não será permitida a retirada de territórios por pessoas:
•	inativas;
•	arquivadas;
•	sem a designação necessária (caso configurado pela Congregação).

6.3 Resumo do Capítulo
Código	Regra
RN-TERR-001	Vínculo obrigatório
RN-TERR-002	Código único
RN-TERR-003	Situação do território
RN-TERR-004	Retirada
RN-TERR-005	Uma retirada ativa
RN-TERR-006	Limite por publicador
RN-TERR-007	Devolução
RN-TERR-008	Devolução em atraso
RN-TERR-009	Histórico permanente
RN-TERR-010	Reserva
RN-TERR-011	Reatribuição
RN-TERR-012	Manutenção
RN-TERR-013	Arquivamento
RN-TERR-014	Atualização de informações
RN-TERR-015	Eventos de domínio
RN-TERR-016	Indicadores
RN-TERR-017	Integridade geográfica
RN-TERR-018	Bloqueio por situação do publicador
	
7 – Publicações
7.1 Objetivo
Este capítulo define as regras para gerenciamento das publicações distribuídas pela Congregação, abrangendo cadastro, estoque, movimentações, pedidos e distribuição.
O objetivo é garantir controle preciso dos materiais, evitando perdas, divergências de estoque e entregas incorretas.

7.2 Conceitos
Cada publicação deverá possuir:
•	código interno;
•	sigla oficial;
•	nome;
•	categoria;
•	situação;
•	controle de estoque;
•	histórico de movimentações.
As publicações serão utilizadas em:
•	Pedidos Individuais;
•	Pedidos Normais;
•	Pedidos de Campanha.
RN-PUB-001 — Cadastro Obrigatório
Nenhuma movimentação poderá ocorrer para uma publicação não cadastrada.

RN-PUB-002 — Sigla Única
Cada publicação deverá possuir uma sigla única dentro da Congregação.
Exemplos:
•	T-33
•	LM
•	CVM
•	EBM
A sigla não poderá ser reutilizada para outra publicação ativa.

RN-PUB-003 — Categoria Obrigatória
Toda publicação deverá pertencer a uma categoria previamente cadastrada.
Exemplos:
•	Livros
•	Revistas
•	Brochuras
•	Tratados
•	Formulários
•	Outros materiais
As categorias serão parametrizáveis por Congregação.

RN-PUB-004 — Situação da Publicação
Estados possíveis:
•	Ativa
•	Inativa
•	Arquivada
Publicações arquivadas não poderão receber novas movimentações.

RN-PUB-005 — Controle de Estoque
Quando uma publicação possuir controle de estoque habilitado, toda entrada ou saída deverá atualizar automaticamente a quantidade disponível.
Não será permitido alterar o saldo diretamente, exceto por meio de ajuste autorizado.

RN-PUB-006 — Estoque Negativo
O sistema não permitirá estoque negativo.
Qualquer movimentação que resulte em saldo inferior a zero será bloqueada.

RN-PUB-007 — Estoque Mínimo
Cada publicação poderá possuir um estoque mínimo configurado.
Quando o saldo atingir ou ficar abaixo desse limite:
•	será gerado um alerta;
•	o Dashboard será atualizado;
•	uma notificação poderá ser enviada ao Servo de Publicações.

RN-PUB-008 — Movimentações de Estoque
Toda movimentação deverá informar:
•	tipo (entrada, saída, ajuste, devolução);
•	quantidade;
•	responsável;
•	data e hora;
•	motivo (quando aplicável).

RN-PUB-009 — Ajuste de Estoque
Ajustes somente poderão ser realizados por usuários autorizados.
Todo ajuste deverá possuir justificativa obrigatória e registro em auditoria.

RN-PUB-010 — Inventário
A Congregação poderá realizar inventários periódicos.
Ao finalizar um inventário:
•	diferenças deverão ser registradas;
•	ajustes poderão ser gerados;
•	o histórico será preservado.

RN-PUB-011 — Pedido Individual
Pedidos Individuais serão destinados ao uso pessoal do publicador.
Fluxo permitido:
Pendente
      ↓
Separado
      ↓
Pronto para Retirada
      ↓
Retirado
      ↓
Concluído
Caso necessário, o pedido poderá ser cancelado antes da retirada.

RN-PUB-012 — Pedido Normal
Pedidos Normais representam materiais recebidos regularmente da organização para abastecimento da Congregação.
Esses pedidos atualizarão automaticamente o estoque após o recebimento.

RN-PUB-013 — Pedido de Campanha
Pedidos de Campanha deverão possuir:
•	campanha vinculada;
•	data de início;
•	data de término;
•	lista de publicações;
•	quantidades previstas.
Após o encerramento da campanha, o sistema deverá manter o histórico completo.

RN-PUB-014 — Entrega
A entrega de publicações somente poderá ocorrer para o destinatário correto ou para pessoa autorizada conforme regras definidas pela Congregação.
Toda entrega registrará:
•	responsável pela entrega;
•	data e hora;
•	itens entregues;
•	quantidades.

RN-PUB-015 — Devolução
Caso haja devolução de publicações ao estoque:
•	o saldo será atualizado;
•	a movimentação será registrada;
•	o motivo da devolução será informado.

RN-PUB-016 — Histórico Permanente
Nenhuma movimentação de estoque será excluída.
Todo histórico permanecerá disponível para auditoria e relatórios.

RN-PUB-017 — Eventos de Domínio
As operações relacionadas às publicações publicarão eventos, como:
PublicacaoCriada
EstoqueAtualizado
EstoqueCritico
PedidoIndividualCriado
PedidoNormalRecebido
PedidoCampanhaCriado
PublicacaoEntregue

RN-PUB-018 — Indicadores
Toda movimentação atualizará automaticamente os indicadores utilizados pelo Dashboard e pelos relatórios, incluindo:
•	saldo em estoque;
•	consumo por período;
•	itens mais distribuídos;
•	itens com estoque crítico;
•	previsão de reposição.

7.3 Resumo do Capítulo
Código	Regra
RN-PUB-001	Cadastro obrigatório
RN-PUB-002	Sigla única
RN-PUB-003	Categoria obrigatória
RN-PUB-004	Situação da publicação
RN-PUB-005	Controle de estoque
RN-PUB-006	Estoque negativo
RN-PUB-007	Estoque mínimo
RN-PUB-008	Movimentações
RN-PUB-009	Ajuste de estoque
RN-PUB-010	Inventário
RN-PUB-011	Pedido Individual
RN-PUB-012	Pedido Normal
RN-PUB-013	Pedido de Campanha
RN-PUB-014	Entrega
RN-PUB-015	Devolução
RN-PUB-016	Histórico permanente
RN-PUB-017	Eventos de domínio
RN-PUB-018	Indicadores
8 – Pedidos
8.1 Objetivo
Este capítulo define as regras para criação, processamento, atendimento, retirada, entrega, cancelamento e encerramento dos pedidos de publicações.
Os pedidos representam solicitações realizadas pelos publicadores ou pela Congregação e deverão seguir fluxos padronizados, garantindo rastreabilidade e controle.

8.2 Conceitos
Todo pedido deverá possuir:
•	número único;
•	congregação;
•	solicitante;
•	tipo;
•	status;
•	itens;
•	datas;
•	responsável pelo atendimento;
•	histórico.
8.3 Tipos de Pedido
O GTP suportará três tipos principais de pedidos:
1.	Pedido Individual
o	Realizado por um publicador para uso pessoal.
2.	Pedido Normal
o	Utilizado para registrar materiais recebidos regularmente pela congregação.
3.	Pedido de Campanha
o	Relacionado a uma campanha específica, com período definido.
Cada tipo seguirá regras específicas, mas compartilhará o mesmo ciclo básico de gestão.

RN-PED-001 — Identificação Única
Todo pedido deverá possuir um número único dentro da Congregação.
Esse número será gerado automaticamente pelo sistema e não poderá ser alterado.

RN-PED-002 — Solicitante Obrigatório
Todo pedido deverá possuir um solicitante válido.
O solicitante deverá ser uma Pessoa ativa vinculada à Congregação.

RN-PED-003 — Tipo Obrigatório
Nenhum pedido poderá ser criado sem a definição do tipo:
•	Individual;
•	Normal;
•	Campanha.

RN-PED-004 — Itens Obrigatórios
Todo pedido deverá conter pelo menos um item.
Cada item deverá informar:
•	publicação;
•	quantidade solicitada.

RN-PED-005 — Disponibilidade de Estoque
Antes da separação ou entrega, o sistema deverá verificar a disponibilidade em estoque.
Caso não exista quantidade suficiente, o pedido permanecerá pendente ou parcialmente atendido, conforme configuração da Congregação.

RN-PED-006 — Status do Pedido
Os status permitidos serão:
•	Pendente;
•	Em Separação;
•	Pronto para Retirada;
•	Retirado;
•	Concluído;
•	Cancelado.
As transições deverão respeitar o fluxo estabelecido pelo sistema.

RN-PED-007 — Alteração de Status
Toda alteração de status deverá:
•	registrar data e hora;
•	registrar usuário responsável;
•	atualizar a Timeline;
•	gerar evento de domínio.

RN-PED-008 — Cancelamento
Pedidos somente poderão ser cancelados antes da conclusão.
O cancelamento deverá registrar:
•	motivo;
•	usuário responsável;
•	data e hora.
Se houver itens separados, o estoque deverá ser regularizado automaticamente.

RN-PED-009 — Retirada
A retirada somente poderá ocorrer para:
•	o solicitante;
•	pessoa autorizada pela Congregação.
A retirada deverá registrar:
•	responsável pela entrega;
•	data e hora;
•	confirmação da entrega.

RN-PED-010 — Atendimento Parcial
Quando configurado, o sistema poderá permitir atendimento parcial.
Os itens não atendidos permanecerão pendentes até nova disponibilidade de estoque ou cancelamento.

RN-PED-011 — Histórico Permanente
Nenhum pedido será excluído fisicamente.
Todos os eventos relacionados ao pedido permanecerão registrados.

RN-PED-012 — Auditoria
Toda operação deverá registrar:
•	criação;
•	alteração;
•	cancelamento;
•	separação;
•	retirada;
•	conclusão.

RN-PED-013 — Eventos de Domínio
As operações relacionadas aos pedidos publicarão eventos, como:
PedidoCriado
PedidoAtualizado
PedidoSeparado
PedidoProntoParaRetirada
PedidoRetirado
PedidoConcluido
PedidoCancelado

RN-PED-014 — Notificações
O sistema poderá gerar notificações automáticas para eventos como:
•	pedido criado;
•	pedido pronto para retirada;
•	pedido cancelado;
•	pedido concluído.

RN-PED-015 — Indicadores
Toda movimentação de pedidos deverá atualizar automaticamente os indicadores do Dashboard e dos relatórios.
Exemplos:
•	pedidos pendentes;
•	pedidos concluídos;
•	tempo médio de atendimento;
•	quantidade de pedidos por tipo.

RN-PED-016 — Prazo para Retirada
A Congregação poderá configurar um prazo máximo para retirada de pedidos prontos.
Pedidos não retirados dentro do prazo poderão:
•	gerar lembretes ao solicitante;
•	gerar alertas ao Servo de Publicações;
•	ser cancelados automaticamente, conforme configuração da Congregação.

RN-PED-017 — Conferência da Entrega
Antes da conclusão da retirada, o responsável deverá confirmar que os itens entregues correspondem ao pedido.
Caso haja divergência, o sistema deverá permitir registrar ocorrências e impedir a conclusão até que a situação seja resolvida.

RN-PED-018 — Reabertura de Pedido
Pedidos concluídos não poderão ser reabertos.
Pedidos cancelados somente poderão ser reativados por usuários autorizados e enquanto não houver impacto irreversível no estoque.
Toda reabertura deverá ser registrada em auditoria.
8.4 Resumo do Capítulo
Código	Regra
RN-PED-001	Identificação única
RN-PED-002	Solicitante obrigatório
RN-PED-003	Tipo obrigatório
RN-PED-004	Itens obrigatórios
RN-PED-005	Disponibilidade de estoque
RN-PED-006	Status do pedido
RN-PED-007	Alteração de status
RN-PED-008	Cancelamento
RN-PED-009	Retirada
RN-PED-010	Atendimento parcial
RN-PED-011	Histórico permanente
RN-PED-012	Auditoria
RN-PED-013	Eventos de domínio
RN-PED-014	Notificações
RN-PED-015	Indicadores
RN-PED-016	Prazo para retirada
RN-PED-017	Conferência da entrega
RN-PED-018	Reabertura de pedido
9 – Campanhas
9.1 Objetivo
Este capítulo estabelece as regras para criação, execução, acompanhamento e encerramento das campanhas de distribuição de publicações.
Uma campanha representa uma ação organizada da Congregação para distribuição de determinados materiais durante um período específico.

9.2 Conceitos
Cada campanha deverá possuir:
•	identificação única;
•	congregação;
•	nome;
•	descrição (opcional);
•	período de vigência;
•	status;
•	publicações vinculadas;
•	responsáveis;
•	histórico.
RN-CAMP-001 — Identificação Única
Toda campanha deverá possuir um identificador único dentro da Congregação.
Esse identificador será gerado automaticamente e não poderá ser alterado.

RN-CAMP-002 — Período Obrigatório
Toda campanha deverá informar:
•	data de início;
•	data de término.
A data de término não poderá ser anterior à data de início.

RN-CAMP-003 — Publicações Vinculadas
Uma campanha deverá possuir pelo menos uma publicação vinculada.
Não será permitido iniciar uma campanha sem materiais definidos.

RN-CAMP-004 — Status da Campanha
Os status permitidos serão:
•	Planejada;
•	Ativa;
•	Suspensa;
•	Encerrada;
•	Cancelada.
As transições deverão seguir o fluxo definido pelo sistema.

RN-CAMP-005 — Início da Campanha
Somente campanhas em estado Planejada poderão ser iniciadas.
Ao iniciar:
•	registrar data e hora;
•	registrar usuário responsável;
•	atualizar indicadores;
•	publicar evento de domínio.

RN-CAMP-006 — Suspensão
Uma campanha poderá ser suspensa temporariamente.
Durante a suspensão:
•	novos pedidos vinculados poderão ser bloqueados, conforme configuração da Congregação;
•	o histórico permanecerá preservado.

RN-CAMP-007 — Encerramento
Ao encerrar uma campanha:
•	não serão permitidos novos pedidos vinculados;
•	indicadores serão consolidados;
•	relatório final poderá ser emitido.

RN-CAMP-008 — Cancelamento
Campanhas poderão ser canceladas antes do encerramento.
O cancelamento deverá registrar:
•	motivo;
•	responsável;
•	data e hora.

RN-CAMP-009 — Participantes
A campanha poderá possuir participantes registrados.
Cada participação poderá informar:
•	pessoa;
•	função na campanha;
•	período de participação.

RN-CAMP-010 — Indicadores
Toda campanha deverá manter indicadores atualizados, como:
•	quantidade de pedidos;
•	publicações distribuídas;
•	participantes;
•	período de execução.

RN-CAMP-011 — Histórico Permanente
Todas as alterações relacionadas à campanha permanecerão registradas.
Nenhuma campanha será excluída fisicamente.

RN-CAMP-012 — Auditoria
Toda operação deverá registrar:
•	criação;
•	alteração;
•	início;
•	suspensão;
•	encerramento;
•	cancelamento.

RN-CAMP-013 — Eventos de Domínio
As operações relacionadas às campanhas publicarão eventos, como:

CampanhaCriada

CampanhaAtualizada

CampanhaIniciada

CampanhaSuspensa

CampanhaEncerrada

CampanhaCancelada

RN-CAMP-014 — Notificações
O sistema poderá gerar notificações automáticas para:
•	início de campanha;
•	suspensão;
•	encerramento;
•	prazo de encerramento próximo;
•	publicação de resultados.

RN-CAMP-015 — Relatório Final
Ao término da campanha, o sistema poderá gerar um relatório consolidado contendo:
•	período;
•	publicações distribuídas;
•	quantidade de pedidos;
•	participantes;
•	indicadores de desempenho;
•	observações registradas.
Esse relatório ficará disponível para consulta futura.

RN-CAMP-016 — Sobreposição de Campanhas
A Congregação poderá possuir várias campanhas simultâneas, desde que utilizem objetivos distintos ou sejam explicitamente permitidas.
Caso haja conflito de recursos ou materiais, o sistema deverá alertar o Administrador Geral antes da ativação.

RN-CAMP-017 — Metas da Campanha
Opcionalmente, a Congregação poderá definir metas para cada campanha, como:
•	quantidade de publicações a distribuir;
•	quantidade de pedidos esperados;
•	participação estimada de publicadores.
O progresso será acompanhado automaticamente durante a campanha.

RN-CAMP-018 — Avaliação Pós-Campanha
Após o encerramento, será possível registrar uma avaliação contendo:
•	pontos positivos;
•	dificuldades encontradas;
•	sugestões para campanhas futuras.
Essas informações ficarão disponíveis para consulta histórica e planejamento de novas campanhas.

9.3 Resumo do Capítulo
Código	Regra
RN-CAMP-001	Identificação única
RN-CAMP-002	Período obrigatório
RN-CAMP-003	Publicações vinculadas
RN-CAMP-004	Status da campanha
RN-CAMP-005	Início da campanha
RN-CAMP-006	Suspensão
RN-CAMP-007	Encerramento
RN-CAMP-008	Cancelamento
RN-CAMP-009	Participantes
RN-CAMP-010	Indicadores
RN-CAMP-011	Histórico permanente
RN-CAMP-012	Auditoria
RN-CAMP-013	Eventos de domínio
RN-CAMP-014	Notificações
RN-CAMP-015	Relatório final
RN-CAMP-016	Sobreposição de campanhas
RN-CAMP-017	Metas
RN-CAMP-018	Avaliação pós-campanha

10 – Auditoria e Histórico
10.1 Objetivo
Este capítulo estabelece as regras para registro, consulta e preservação da auditoria e do histórico de negócio do GTP.
Todo evento relevante deverá ser registrado de forma rastreável, preservando a integridade das informações e permitindo consultas futuras.

10.2 Conceitos
No GTP teremos dois conceitos distintos:
Auditoria
Registra quem realizou uma operação.
Exemplos:
•	criação;
•	alteração;
•	exclusão lógica;
•	login;
•	logout;
•	mudança de permissões.

Histórico de Negócio
Registra a evolução natural da entidade.
Exemplos:
•	território retirado;
•	território devolvido;
•	pedido concluído;
•	campanha encerrada;
•	estoque ajustado.
Exemplo
Usuário altera um Pedido
↓
Auditoria

• usuário
• data
• IP
• operação
↓
Histórico

• status alterado
• de Pendente
• para Pronto para Retirada
São informações complementares, mas independentes.

RN-AUD-001 — Auditoria Obrigatória
Toda operação crítica deverá gerar um registro de auditoria.
Incluem-se:
•	criação;
•	alteração;
•	exclusão lógica;
•	autenticação;
•	alteração de permissões;
•	alterações de configurações;
•	movimentações de estoque;
•	retiradas e devoluções de territórios.

RN-AUD-002 — Informações Mínimas
Cada registro deverá conter, no mínimo:
•	usuário;
•	pessoa vinculada;
•	congregação;
•	data;
•	hora;
•	endereço IP;
•	navegador (quando disponível);
•	dispositivo (quando disponível);
•	operação realizada;
•	entidade afetada.

RN-AUD-003 — Valores Alterados
Sempre que possível, o sistema deverá registrar:
•	valor anterior;
•	valor novo;
•	campo alterado.
Isso permitirá reconstruir o histórico de alterações.

RN-AUD-004 — Imutabilidade
Registros de auditoria não poderão ser alterados ou excluídos por usuários do sistema.
Qualquer mecanismo de manutenção deverá ser restrito ao Desenvolvedor Geral e ocorrer apenas em situações excepcionais, mantendo rastreabilidade.

RN-AUD-005 — Histórico Permanente
O histórico de negócio será permanente.
Nenhum evento histórico será removido.

RN-AUD-006 — Timeline
Todas as entidades principais possuirão uma Timeline.
Entidades contempladas:
•	Congregações;
•	Pessoas;
•	Usuários;
•	Territórios;
•	Publicações;
•	Pedidos;
•	Campanhas.

RN-AUD-007 — Consulta
Usuários visualizarão apenas auditorias compatíveis com suas permissões.
O Desenvolvedor Geral poderá consultar registros globais.
O Administrador Geral visualizará apenas registros da sua Congregação.

RN-AUD-008 — Pesquisa
A auditoria permitirá filtros por:
•	período;
•	usuário;
•	módulo;
•	operação;
•	entidade;
•	tipo de evento.

RN-AUD-009 — Exportação
Os registros poderão ser exportados para:
•	PDF;
•	Excel;
•	CSV.
A exportação obedecerá às permissões do usuário.


RN-AUD-010 — Eventos de Domínio
Toda auditoria relevante poderá originar eventos para:
•	notificações;
•	monitoramento;
•	indicadores.
Exemplos:
AuditoriaRegistrada

LoginRealizado

PermissaoAlterada

ConfiguracaoAtualizada

RN-AUD-011 — Retenção de Dados
Os registros de auditoria deverão ser mantidos pelo período definido na política do sistema ou da Congregação, respeitando a preservação do histórico necessário para consultas e conformidade.

RN-AUD-012 — Registro de Falhas
Tentativas de operações não autorizadas também deverão ser registradas.
Exemplos:
•	tentativa de acesso sem permissão;
•	tentativa de alterar dados de outra Congregação;
•	tentativa de excluir registros protegidos.

RN-AUD-013 — Assinatura de Eventos
Cada evento de auditoria deverá possuir um identificador único e referências à entidade e à operação correspondente, garantindo rastreabilidade entre auditoria, histórico e eventos de domínio.
RN-AUD-014 — Correlação de Eventos
Operações compostas (como retirada de território ou conclusão de pedido) poderão gerar múltiplos registros de auditoria, vinculados por um identificador de correlação para facilitar investigações e análises.

RN-AUD-015 — Alertas de Auditoria
O sistema poderá emitir alertas para eventos considerados críticos, como:
•	múltiplas tentativas de login inválidas;
•	alterações repetidas de permissões;
•	grande volume de ajustes de estoque em curto período;
•	acessos administrativos fora do horário habitual (quando essa política estiver habilitada).

10.4 Resumo do Capítulo
Código	Regra
RN-AUD-001	Auditoria obrigatória
RN-AUD-002	Informações mínimas
RN-AUD-003	Valores alterados
RN-AUD-004	Imutabilidade
RN-AUD-005	Histórico permanente
RN-AUD-006	Timeline
RN-AUD-007	Consulta
RN-AUD-008	Pesquisa
RN-AUD-009	Exportação
RN-AUD-010	Eventos de domínio
RN-AUD-011	Retenção de dados
RN-AUD-012	Registro de falhas
RN-AUD-013	Assinatura de eventos
RN-AUD-014	Correlação de eventos
RN-AUD-015	Alertas de auditoria




11 – Notificações e Comunicação
11.1 Objetivo
Este capítulo estabelece as regras para geração, envio, gerenciamento e acompanhamento das notificações do GTP.
As notificações têm como objetivo informar os usuários sobre eventos relevantes, apoiar a execução das atividades e reduzir esquecimentos ou atrasos.

11.2 Conceitos
Uma notificação poderá ser originada por:
•	eventos automáticos do sistema;
•	ações realizadas por usuários;
•	tarefas agendadas;
•	lembretes;
•	alertas administrativos.
Cada notificação possuirá um ciclo de vida próprio.

11.3 Ciclo de Vida
   Gerada
      ↓
   Enviada
      ↓
   Recebida
      ↓
     Lida
      ↓
  Arquivada



Caso necessário:
   Gerada
      ↓
  Cancelada

RN-NOT-001 — Geração Automática
O sistema deverá gerar notificações automaticamente sempre que ocorrerem eventos previamente configurados.
Exemplos:
•	pedido criado;
•	pedido pronto para retirada;
•	campanha iniciada;
•	campanha encerrada;
•	território devolvido;
•	estoque crítico;
•	alteração de permissões.

RN-NOT-002 — Destinatários
Toda notificação deverá possuir um ou mais destinatários.
Os destinatários poderão ser definidos por:
•	usuário específico;
•	designação;
•	perfil;
•	congregação;
•	grupo de usuários.

RN-NOT-003 — Tipos
O sistema deverá suportar diferentes tipos de notificação.
Exemplos:
•	Informação;
•	Aviso;
•	Alerta;
•	Urgente.
Cada tipo poderá possuir prioridade distinta.

RN-NOT-004 — Prioridade
Cada notificação deverá possuir um nível de prioridade.
Exemplos:
•	Baixa;
•	Normal;
•	Alta;
•	Crítica.
Notificações críticas poderão exigir confirmação de leitura.

RN-NOT-005 — Canais
O sistema deverá permitir diferentes canais de comunicação.
Na primeira versão:
•	notificações internas.
Arquitetura preparada para futuras integrações:
•	e-mail;
•	WhatsApp (quando autorizado);
•	push notification;
•	SMS (opcional).

RN-NOT-006 — Confirmação de Leitura
Quando configurado, o destinatário deverá confirmar a leitura da notificação.
A confirmação registrará:
•	usuário;
•	data;
•	hora.

RN-NOT-007 — Histórico
Todas as notificações permanecerão registradas.
Mesmo após leitura ou arquivamento.

RN-NOT-008 — Preferências
Cada usuário poderá configurar preferências de recebimento.
Exemplos:
•	receber notificações de campanhas;
•	receber alertas de estoque;
•	receber avisos administrativos;
•	receber lembretes de pedidos.
Respeitando sempre as permissões definidas pela Congregação.

RN-NOT-009 — Lembretes Automáticos
O sistema poderá gerar lembretes automáticos para:
•	pedidos prontos para retirada;
•	territórios próximos do prazo de devolução;
•	campanhas prestes a encerrar;
•	inventários agendados;
•	estoque abaixo do mínimo.

RN-NOT-010 — Expiração
Algumas notificações poderão possuir data de expiração.
Após esse período:
•	permanecerão no histórico;
•	deixarão de aparecer como pendentes.
RN-NOT-011 — Eventos de Domínio
Toda geração de notificação deverá publicar eventos.
Exemplos:
NotificacaoGerada
NotificacaoEnviada
NotificacaoLida
NotificacaoArquivada

RN-NOT-012 — Auditoria
Toda operação relevante deverá ser registrada.
Incluindo:
•	criação;
•	envio;
•	leitura;
•	arquivamento;
•	cancelamento.

RN-NOT-013 — Agrupamento
O sistema poderá agrupar notificações semelhantes para evitar excesso de mensagens.
Exemplo:
Em vez de enviar dez alertas de estoque baixo, poderá enviar uma única notificação consolidada.

RN-NOT-014 — Dashboard
As notificações deverão alimentar o Dashboard do usuário.
Indicadores:
•	notificações pendentes;
•	críticas;
•	não lidas;
•	vencidas.
RN-NOT-015 — Comunicação entre Usuários
O GTP permitirá o envio de comunicados internos entre usuários autorizados.
Esses comunicados:
•	não substituirão as notificações automáticas;
•	poderão possuir anexos (em versões futuras);
•	permanecerão registrados no histórico.

RN-NOT-016 — Notificações por Papel
O sistema enviará automaticamente notificações conforme a responsabilidade do usuário.
Exemplos:
•	Servo de Territórios: devoluções em atraso, novos territórios cadastrados, solicitações de reatribuição.
•	Servo de Publicações: pedidos pendentes, estoque crítico, inventários programados.
•	Superintendente de Serviço: indicadores gerais, campanhas, alertas administrativos.
•	Administrador Geral: alterações de configuração, gestão de usuários e eventos críticos.
•	Desenvolvedor Geral: falhas sistêmicas, integrações e eventos técnicos.

RN-NOT-017 — Reenvio
Quando permitido, notificações não lidas poderão ser reenviadas automaticamente após um período configurável.
O reenvio deverá ser limitado para evitar mensagens repetitivas.

11.4 Resumo do Capítulo
Código	Regra
RN-NOT-001	Geração automática
RN-NOT-002	Destinatários
RN-NOT-003	Tipos
RN-NOT-004	Prioridade
RN-NOT-005	Canais
RN-NOT-006	Confirmação de leitura
RN-NOT-007	Histórico
RN-NOT-008	Preferências
RN-NOT-009	Lembretes automáticos
RN-NOT-010	Expiração
RN-NOT-011	Eventos de domínio
RN-NOT-012	Auditoria
RN-NOT-013	Agrupamento
RN-NOT-014	Dashboard
RN-NOT-015	Comunicação entre usuários
RN-NOT-016	Notificações por papel
RN-NOT-017	Reenvio

12 – Configurações e Parametrizações
12.1 Objetivo
Este capítulo estabelece as regras para gerenciamento das configurações e parametrizações do GTP.
As parametrizações permitem adaptar o comportamento do sistema sem necessidade de alterações no código-fonte.
Todas as configurações deverão ser versionadas, auditadas e respeitar o isolamento entre Congregações.

12.2 Conceitos
O GTP possuirá três níveis de configuração:

Desenvolvedor Geral
        │
        ▼
Configurações Globais
        │
        ▼
Administrador Geral
        │
        ▼
Configurações da Congregação
        │
        ▼
Usuário
        │
        ▼
Preferências Individuais
Essa hierarquia garante flexibilidade sem comprometer a governança do sistema.

RN-CON-001 — Configurações Globais
As configurações globais serão administradas exclusivamente pelo Desenvolvedor Geral.
Exemplos:
•	política padrão de senhas;
•	idiomas disponíveis;
•	parâmetros de segurança;
•	funcionalidades experimentais;
•	integrações externas.

RN-CON-002 — Configurações da Congregação
Cada Congregação poderá definir suas próprias configurações operacionais.
Exemplos:
•	quantidade máxima de territórios por publicador;
•	prazo para devolução de territórios;
•	prazo para retirada de pedidos;
•	controle de reservas;
•	atendimento parcial de pedidos.
Essas configurações afetarão apenas a Congregação correspondente.

RN-CON-003 — Preferências do Usuário
Cada usuário poderá configurar preferências pessoais, como:
•	tema claro ou escuro;
•	idioma (quando disponível);
•	quantidade de registros por página;
•	preferências de notificações;
•	dashboard inicial.
Essas preferências não alterarão as regras de negócio do sistema.

RN-CON-004 — Versionamento
Toda alteração em configurações deverá gerar uma nova versão lógica.
O sistema registrará:
•	configuração anterior;
•	configuração atual;
•	responsável;
•	data e hora.

RN-CON-005 — Auditoria
Todas as alterações em configurações deverão ser registradas na auditoria.

RN-CON-006 — Histórico
Nenhuma configuração será removida definitivamente.
O histórico completo deverá permanecer disponível para consulta.
RN-CON-007 — Restauração
O Administrador Geral poderá restaurar uma configuração anterior da sua Congregação.
A restauração também será registrada em auditoria.

RN-CON-008 — Validação
Antes de salvar uma configuração, o sistema deverá validar:
•	consistência dos valores;
•	dependências entre parâmetros;
•	conflitos com regras globais.
Configurações inválidas não poderão ser aplicadas.

RN-CON-009 — Configurações Sensíveis
Parâmetros relacionados à segurança ou integridade dos dados somente poderão ser alterados por usuários autorizados.
Exemplos:
•	autenticação multifator (2FA);
•	políticas de senha;
•	retenção de auditoria;
•	integrações críticas.

RN-CON-010 — Valores Padrão
Ao criar uma nova Congregação, o sistema deverá aplicar automaticamente um conjunto de configurações padrão.
Essas configurações poderão ser personalizadas posteriormente.

RN-CON-011 — Eventos de Domínio
Toda alteração relevante em configurações deverá publicar eventos, como:

ConfiguracaoCriada
ConfiguracaoAtualizada
ConfiguracaoRestaurada
ConfiguracaoRemovida

RN-CON-012 — Parametrização de Territórios
A Congregação poderá parametrizar regras relacionadas aos territórios, incluindo:
•	quantidade máxima por publicador;
•	prazo padrão de devolução;
•	uso de reservas;
•	obrigatoriedade de justificativa em reatribuições;
•	bloqueio automático por atraso.

RN-CON-013 — Parametrização de Publicações
A Congregação poderá definir parâmetros como:
•	estoque mínimo padrão;
•	categorias disponíveis;
•	siglas permitidas;
•	necessidade de aprovação para ajustes de estoque;
•	inventários programados.

RN-CON-014 — Parametrização de Pedidos
Será possível configurar:
•	tipos de pedidos habilitados;
•	atendimento parcial;
•	prazo para retirada;
•	cancelamento automático por inatividade;
•	confirmação obrigatória de entrega.


RN-CON-015 — Parametrização de Notificações
Cada Congregação poderá configurar:
•	eventos que geram notificações;
•	prioridades padrão;
•	lembretes automáticos;
•	confirmação obrigatória de leitura;
•	prazo para expiração.

RN-CON-016 — Parametrização de Campanhas
A Congregação poderá definir:
•	modelos de campanhas;
•	metas padrão;
•	notificações automáticas;
•	participantes obrigatórios;
•	relatórios gerados ao encerramento.

RN-CON-017 — Parametrização de Relatórios
Será possível configurar:
•	logotipo da Congregação;
•	cabeçalho e rodapé;
•	formato padrão (PDF ou Excel);
•	indicadores exibidos;
•	periodicidade de relatórios automáticos.

RN-CON-018 — Importação e Exportação de Configurações
O Desenvolvedor Geral poderá exportar e importar conjuntos de configurações para facilitar implantação e manutenção.
As configurações importadas deverão passar por validação antes da aplicação.

12.3 Resumo do Capítulo
Código	Regra
RN-CON-001	Configurações globais
RN-CON-002	Configurações da Congregação
RN-CON-003	Preferências do usuário
RN-CON-004	Versionamento
RN-CON-005	Auditoria
RN-CON-006	Histórico
RN-CON-007	Restauração
RN-CON-008	Validação
RN-CON-009	Configurações sensíveis
RN-CON-010	Valores padrão
RN-CON-011	Eventos de domínio
RN-CON-012	Parametrização de territórios
RN-CON-013	Parametrização de publicações
RN-CON-014	Parametrização de pedidos
RN-CON-015	Parametrização de notificações
RN-CON-016	Parametrização de campanhas
RN-CON-017	Parametrização de relatórios
RN-CON-018	Importação e exportação

13 – Relatórios e Indicadores
13.1 Objetivo
Este capítulo estabelece as regras para geração de relatórios, indicadores (KPIs), dashboards e estatísticas do GTP.
As informações apresentadas deverão refletir os dados operacionais do sistema em tempo real ou conforme a periodicidade configurada.
13.2 Conceitos
O GTP possuirá três níveis de visualização:
Indicadores Operacionais
        │
        ▼
Dashboards
        │
        ▼
Relatórios Gerenciais
Todos os dados apresentados deverão respeitar as permissões do usuário e o isolamento entre Congregações.

RN-REL-001 — Atualização dos Indicadores
Os indicadores deverão ser atualizados automaticamente sempre que ocorrer uma operação que altere os dados do sistema.
Exemplos:
•	retirada de território;
•	devolução de território;
•	criação de pedido;
•	entrega de publicações;
•	ajuste de estoque;
•	encerramento de campanha.

RN-REL-002 — Isolamento de Dados
Os relatórios deverão exibir apenas informações da Congregação do usuário autenticado.
Exceção:
•	Desenvolvedor Geral (visão global);
•	Administrador Geral, quando autorizado a visualizar indicadores consolidados de múltiplas congregações (caso essa funcionalidade seja implementada futuramente).

RN-REL-003 — Dashboard Personalizado
Cada perfil poderá visualizar um dashboard específico.
Desenvolvedor Geral
•	saúde do sistema;
•	integrações;
•	erros;
•	uso do sistema.
Administrador Geral
•	indicadores gerais;
•	usuários;
•	territórios;
•	pedidos;
•	campanhas;
•	estoque.
Superintendente de Serviço
•	territórios;
•	campanhas;
•	produtividade;
•	atrasos.
Servo de Territórios
•	territórios disponíveis;
•	retirados;
•	devoluções previstas;
•	devoluções em atraso.
Servo de Publicações
•	estoque;
•	pedidos;
•	inventários;
•	campanhas.
Publicador
•	pedidos;
•	territórios retirados;
•	histórico pessoal;
•	notificações.

RN-REL-004 — Indicadores de Territórios
O sistema deverá disponibilizar indicadores como:
•	total de territórios;
•	disponíveis;
•	retirados;
•	em revisão;
•	arquivados;
•	devoluções em atraso;
•	tempo médio de utilização.

RN-REL-005 — Indicadores de Publicações
O sistema deverá apresentar:
•	estoque atual;
•	estoque mínimo;
•	itens críticos;
•	itens mais distribuídos;
•	consumo por período;
•	ajustes realizados.

RN-REL-006 — Indicadores de Pedidos
O sistema deverá calcular:
•	pedidos pendentes;
•	em separação;
•	prontos para retirada;
•	retirados;
•	concluídos;
•	cancelados;
•	tempo médio de atendimento;
•	percentual de atendimento parcial.

RN-REL-007 — Indicadores de Campanhas
Para cada campanha deverão ser apresentados:
•	período;
•	participantes;
•	pedidos relacionados;
•	publicações distribuídas;
•	metas definidas;
•	percentual de conclusão.

RN-REL-008 — Indicadores de Usuários
O sistema poderá apresentar:
•	usuários ativos;
•	usuários inativos;
•	últimos acessos;
•	tentativas de login;
•	sessões ativas;
•	distribuição por designação.

RN-REL-009 — Indicadores de Auditoria
O Dashboard Administrativo poderá apresentar:
•	operações realizadas;
•	alterações de permissões;
•	acessos administrativos;
•	tentativas de acesso negadas;
•	eventos críticos.

RN-REL-010 — Exportação
Todos os relatórios poderão ser exportados conforme as permissões do usuário.
Formatos suportados:
•	PDF;
•	Excel;
•	CSV.

RN-REL-011 — Agendamento
O sistema permitirá agendar relatórios automáticos.
Exemplos:
•	semanal;
•	mensal;
•	trimestral;
•	anual.
Os relatórios poderão ser disponibilizados para download ou enviados por canais configurados futuramente.

RN-REL-012 — Filtros
Todos os relatórios deverão permitir filtros compatíveis com o módulo.
Exemplos:
•	período;
•	congregação;
•	campanha;
•	usuário;
•	território;
•	publicação;
•	status.

RN-REL-013 — Eventos de Domínio
A geração de relatórios relevantes poderá publicar eventos, como:
RelatorioGerado
IndicadorAtualizado
DashboardAtualizado
ExportacaoRealizada

RN-REL-014 — Histórico
Os relatórios gerados automaticamente poderão ser armazenados para consulta posterior, conforme política definida pela Congregação.

RN-REL-015 — Indicadores Comparativos
O sistema poderá apresentar comparações entre períodos.
Exemplos:
•	mês atual × mês anterior;
•	ano atual × ano anterior;
•	campanhas equivalentes.

RN-REL-016 — Metas e Desempenho
Quando existirem metas configuradas, o sistema deverá apresentar:
•	percentual atingido;
•	tendência de conclusão;
•	desvios relevantes;
•	alertas de risco.


RN-REL-017 — Consistência dos Dados
Os indicadores deverão ser gerados a partir dos dados oficiais do sistema.
Não será permitido editar manualmente indicadores ou estatísticas.

RN-REL-018 — Atualização Incremental
Sempre que possível, o sistema deverá atualizar apenas os indicadores afetados por uma operação, reduzindo processamento e melhorando o desempenho.

RN-REL-019 — Dashboard em Tempo Real
Os dashboards deverão ser atualizados automaticamente quando ocorrerem eventos relevantes.
Na implementação técnica, isso poderá ser realizado utilizando WebSocket ou Server-Sent Events (SSE), conforme a arquitetura adotada.

RN-REL-020 — KPIs Estratégicos
O GTP deverá disponibilizar indicadores estratégicos para acompanhamento da operação da Congregação.
Exemplos:
•	percentual de territórios disponíveis;
•	tempo médio de permanência dos territórios;
•	índice de devoluções em atraso;
•	taxa de atendimento de pedidos;
•	índice de disponibilidade de estoque;
•	campanhas concluídas dentro do prazo.
Esses KPIs servirão como base para os painéis gerenciais e para futuras análises históricas.

13.3 Resumo do Capítulo
Código	Regra
RN-REL-001	Atualização dos indicadores
RN-REL-002	Isolamento de dados
RN-REL-003	Dashboard personalizado
RN-REL-004	Indicadores de territórios
RN-REL-005	Indicadores de publicações
RN-REL-006	Indicadores de pedidos
RN-REL-007	Indicadores de campanhas
RN-REL-008	Indicadores de usuários
RN-REL-009	Indicadores de auditoria
RN-REL-010	Exportação
RN-REL-011	Agendamento
RN-REL-012	Filtros
RN-REL-013	Eventos de domínio
RN-REL-014	Histórico
RN-REL-015	Indicadores comparativos
RN-REL-016	Metas e desempenho
RN-REL-017	Consistência dos dados
RN-REL-018	Atualização incremental
RN-REL-019	Dashboard em tempo real
RN-REL-020	KPIs estratégicos

14 – Integrações, Segurança Avançada e Regras Transversais
14.1 Objetivo
Este capítulo estabelece as regras transversais do GTP, aplicáveis a todos os módulos do sistema.
Inclui diretrizes para segurança, integrações, desempenho, disponibilidade, interoperabilidade e governança dos dados.
________________________________________
14.2 Conceitos
As regras deste capítulo complementam os capítulos anteriores e deverão ser observadas durante toda a implementação do sistema.
Elas possuem caráter obrigatório e não poderão ser ignoradas por nenhum módulo.

RN-TRANS-001 — Multi-Tenant Obrigatório
O GTP será um sistema multi-tenant.
Toda informação deverá pertencer obrigatoriamente a uma Congregação.
Nenhuma operação poderá acessar dados de outra Congregação sem autorização explícita.

RN-TRANS-002 — Isolamento de Dados
Todo acesso aos dados deverá aplicar automaticamente filtros de Congregação.
Essa validação ocorrerá no backend e não dependerá do frontend.

RN-TRANS-003 — API Segura
Todas as APIs deverão exigir autenticação e autorização antes de executar qualquer operação protegida.

RN-TRANS-004 — Comunicação Segura
Toda comunicação entre cliente e servidor deverá utilizar HTTPS em ambientes de homologação e produção.

RN-TRANS-005 — Proteção de Dados
Informações sensíveis deverão ser protegidas conforme boas práticas de segurança.
Exemplos:
•	senhas criptografadas por hash seguro;
•	tokens protegidos;
•	dados pessoais tratados conforme a legislação aplicável.
RN-TRANS-006 — Controle de Sessão
Toda sessão deverá possuir:
•	tempo máximo de inatividade;
•	expiração configurável;
•	encerramento seguro.

RN-TRANS-007 — Logs Técnicos
O sistema deverá registrar logs técnicos para:
•	erros;
•	exceções;
•	falhas de integração;
•	operações críticas.
Esses logs serão distintos da auditoria funcional.

RN-TRANS-008 — Integrações Futuras
A arquitetura deverá permitir integração com serviços externos.
Exemplos:
•	envio de e-mails;
•	WhatsApp Business (quando autorizado);
•	serviços de mapas;
•	autenticação externa;
•	armazenamento em nuvem.

RN-TRANS-009 — Versionamento de API
As APIs deverão possuir versionamento.
Exemplo:
/api/v1
/api/v2
Isso permitirá evolução sem quebra de compatibilidade.
RN-TRANS-010 — Padronização das Respostas
Todas as APIs deverão retornar respostas padronizadas contendo:
•	sucesso ou erro;
•	mensagem;
•	dados;
•	data e hora;
•	identificador da requisição.

RN-TRANS-011 — Tratamento de Erros
Os erros deverão ser tratados de forma padronizada.
O sistema nunca deverá expor detalhes internos da implementação ao usuário final.

RN-TRANS-012 — Disponibilidade
O sistema deverá ser projetado para alta disponibilidade.
Falhas em um módulo não deverão comprometer o funcionamento dos demais.

RN-TRANS-013 — Escalabilidade
A arquitetura deverá permitir crescimento horizontal e vertical, suportando aumento de usuários, congregações e volume de dados sem necessidade de reestruturação do domínio.

RN-TRANS-014 — Backup e Recuperação
O banco de dados deverá possuir mecanismos de backup e recuperação.
Os procedimentos deverão ser documentados e testados periodicamente.

RN-TRANS-015 — Integridade Referencial
Todas as relações entre entidades deverão garantir integridade referencial.
Não serão permitidos registros órfãos.

RN-TRANS-016 — Desempenho
Consultas frequentes deverão utilizar estratégias de otimização, como:
•	paginação;
•	índices;
•	cache;
•	consultas especializadas.

RN-TRANS-017 — Internacionalização
A arquitetura deverá permitir suporte futuro a múltiplos idiomas e formatos de data, hora e moeda.

RN-TRANS-018 — Acessibilidade
As interfaces deverão seguir boas práticas de acessibilidade.
Exemplos:
•	navegação por teclado;
•	contraste adequado;
•	suporte a leitores de tela;
•	componentes acessíveis.

RN-TRANS-019 — Compatibilidade
O sistema deverá ser compatível com os principais navegadores modernos e dispositivos móveis.

RN-TRANS-020 — Observabilidade
O sistema deverá disponibilizar informações para monitoramento operacional, incluindo:
•	métricas de desempenho;
•	uso de recursos;
•	disponibilidade;
•	eventos críticos.
RN-TRANS-021 — Configuração por Ambiente
O sistema deverá suportar ambientes distintos:
•	Desenvolvimento;
•	Testes;
•	Homologação;
•	Produção.
Cada ambiente possuirá configurações independentes.

RN-TRANS-022 — Infraestrutura com Docker
Todos os componentes principais do GTP deverão ser executáveis por meio de containers Docker.
A infraestrutura inicial deverá contemplar:
•	Backend (Spring Boot);
•	Frontend (React);
•	PostgreSQL;
•	PgAdmin;
•	Redis (cache e sessões, quando adotado);
•	Nginx (proxy reverso, em produção).
A orquestração será realizada inicialmente com Docker Compose, mantendo a arquitetura preparada para futura adoção de Kubernetes.

RN-TRANS-023 — Segurança Baseada em Papéis e Permissões
A autorização deverá combinar:
•	Designações (função da pessoa na Congregação);
•	Perfis de acesso;
•	Permissões granulares por ação.
Nenhuma autorização será baseada apenas na interface do usuário.
Toda validação ocorrerá obrigatoriamente no backend.


RN-TRANS-024 — Documentação da API
Toda API REST deverá ser documentada automaticamente utilizando OpenAPI/Swagger.
A documentação deverá conter:
•	endpoints;
•	parâmetros;
•	exemplos de requisição;
•	exemplos de resposta;
•	códigos de erro;
•	requisitos de autenticação.

RN-TRANS-025 — Governança e Evolução
Toda alteração que impacte regras de negócio deverá manter rastreabilidade com:
•	Documento 02 – Requisitos Funcionais;
•	Documento 03 – Regras de Negócio;
•	Documento 04 – Casos de Uso;
•	Modelo de Dados;
•	Código-fonte.
Nenhuma mudança deverá ser implementada sem atualização da documentação correspondente.

14.3 Resumo do Capítulo
Código	Regra
RN-TRANS-001	Multi-tenant obrigatório
RN-TRANS-002	Isolamento de dados
RN-TRANS-003	API segura
RN-TRANS-004	Comunicação segura
RN-TRANS-005	Proteção de dados
RN-TRANS-006	Controle de sessão
RN-TRANS-007	Logs técnicos
RN-TRANS-008	Integrações futuras
RN-TRANS-009	Versionamento de API
RN-TRANS-010	Padronização das respostas
RN-TRANS-011	Tratamento de erros
RN-TRANS-012	Disponibilidade
RN-TRANS-013	Escalabilidade
RN-TRANS-014	Backup e recuperação
RN-TRANS-015	Integridade referencial
RN-TRANS-016	Desempenho
RN-TRANS-017	Internacionalização
RN-TRANS-018	Acessibilidade
RN-TRANS-019	Compatibilidade
RN-TRANS-020	Observabilidade
RN-TRANS-021	Configuração por ambiente
RN-TRANS-022	Infraestrutura com Docker
RN-TRANS-023	Segurança baseada em papéis e permissões
RN-TRANS-024	Documentação da API
RN-TRANS-025	Governança e evolução


