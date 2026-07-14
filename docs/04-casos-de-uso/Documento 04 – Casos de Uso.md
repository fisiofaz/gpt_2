
  
  
  
Sistema de Gestão de Territórios e Publicações (GTP)   
 
 
Documento 04 – Casos de Uso
 
 
   
   
   
 
Projeto: Sistema de Gestão de Territórios e Publicações (GTP)   Versão: 1.0.0     
Status: Em Elaboração     Data: Julho/2026     
Autor: Fabio André Zatta     
 
 
  
  
  
  
 
 
  
  
 
 1 – Introdução 
1.1 Objetivo 
O Documento 04 descreve detalhadamente como cada ator interage com o Gestor de Territórios e Publicações (GTP) para atingir seus objetivos.
Enquanto:
•	o Documento 02 define o que o sistema deve fazer;
•	o Documento 03 define quais regras devem ser respeitadas;
o Documento 04 descreve como cada funcionalidade acontece, apresentando os fluxos de interação entre os usuários e o sistema.
Este documento servirá como referência para:
•	desenvolvimento do backend em Java/Spring Boot;
•	desenvolvimento do frontend em React;
•	testes funcionais e de integração;
•	elaboração de casos de teste;
•	treinamento dos usuários.

1.2 Escopo
Este documento cobre todos os módulos do GTP, incluindo:
•	Autenticação;
•	Congregações;
•	Pessoas;
•	Usuários;
•	Administração;
•	Territórios;
•	Publicações;
•	Pedidos;
•	Campanhas;
•	Auditoria;
•	Notificações;
•	Relatórios;
•	Configurações.

1.3 Estrutura de um Caso de Uso
Todos os casos de uso seguirão um padrão único para facilitar leitura e implementação.
Cada caso conterá:
•	Código;
•	Nome;
•	Objetivo;
•	Atores;
•	Pré-condições;
•	Gatilho;
•	Fluxo Principal;
•	Fluxos Alternativos;
•	Fluxos de Exceção;
•	Pós-condições;
•	Regras de Negócio relacionadas;
•	Requisitos Funcionais relacionados;
•	Permissões necessárias.

2 – Atores do Sistema
Antes de descrever os casos de uso, definimos os atores que interagem com o GTP.
Ator 1 – Desenvolvedor Geral
É o responsável técnico pelo sistema.
Possui acesso global a todas as Congregações e funcionalidades técnicas.
Principais responsabilidades:
•	administrar a plataforma;
•	gerenciar versões;
•	configurar parâmetros globais;
•	acompanhar auditorias técnicas;
•	gerenciar integrações;
•	monitorar a infraestrutura.

Ator 2 – Administrador Geral
Representa o Superintendente de Serviço da Congregação.
É responsável pela administração funcional da sua Congregação.
Pode:
•	administrar usuários;
•	configurar parâmetros locais;
•	acompanhar relatórios;
•	supervisionar Servos de Territórios e Publicações;
•	gerenciar campanhas.
Não possui acesso às informações de outras Congregações.

Ator 3 – Servo de Territórios
Responsável pela administração dos territórios.
Pode:
•	cadastrar territórios;
•	alterar informações;
•	disponibilizar territórios;
•	registrar retiradas;
•	registrar devoluções;
•	arquivar territórios;
•	consultar histórico.

Ator 4 – Servo de Publicações
Responsável pela gestão das publicações.
Pode:
•	cadastrar publicações;
•	controlar estoque;
•	registrar entradas e saídas;
•	atender pedidos;
•	organizar campanhas de distribuição;
•	realizar inventários.

Ator 5 – Publicador
Usuário final da Congregação.
Pode:
•	consultar territórios disponíveis;
•	solicitar retirada de territórios;
•	devolver territórios;
•	solicitar publicações;
•	acompanhar pedidos;
•	consultar seu histórico.

Ator 6 – Sistema GTP
Além dos usuários humanos, o próprio sistema executará ações automáticas.
Exemplos:
•	envio de notificações;
•	atualização de dashboards;
•	cálculo de indicadores;
•	geração de auditoria;
•	atualização de estoque;
•	encerramento automático de campanhas (quando configurado).

2.1 Matriz de Responsabilidades
Funcionalidade	Desenvolvedor	Administrador	Servo de Territórios	Servo de Publicações	Publicador	Sistema
Configurações Globais	✔					
Configurações da Congregação		✔				
Cadastro de Usuários	✔	✔				
Cadastro de Pessoas		✔				
Gestão de Territórios		✔	✔			
Gestão de Publicações		✔		✔		
Pedidos de Publicações				✔	✔	
Retirada de Territórios			✔		✔	
Relatórios	✔	✔	✔	✔	Consulta própria	
Auditoria	✔	✔ (da Congregação)	Consulta limitada	Consulta limitada		✔
Notificações	Configura	Configura	Recebe	Recebe	Recebe	Gera

3 – Autenticação

UC-001 – Autenticar Usuário
Objetivo
Permitir que um usuário autenticado acesse o GTP utilizando suas credenciais.

Atores
•	Desenvolvedor Geral
•	Administrador Geral
•	Servo de Territórios
•	Servo de Publicações
•	Publicador

Pré-condições
•	O usuário deve estar cadastrado.
•	A conta deve estar ativa.
•	A Congregação deve estar ativa.
•	O usuário deve possuir permissão de acesso.

Gatilho
O usuário informa suas credenciais na tela de login.

Fluxo Principal
1.	O usuário acessa a tela de login.
2.	Informa e-mail ou nome de usuário.
3.	Informa senha.
4.	Clica em Entrar.
5.	O sistema valida as credenciais.
6.	O sistema identifica a Congregação do usuário.
7.	O sistema carrega perfis e permissões.
8.	O sistema registra a autenticação na auditoria.
9.	O sistema gera os tokens de autenticação.
10.	O sistema redireciona o usuário para o Dashboard correspondente ao seu perfil.

Fluxos Alternativos
FA-001
Usuário já autenticado.
O sistema redireciona diretamente para o Dashboard.

FA-002
Existe mais de um perfil associado ao usuário.
O sistema solicita a seleção do perfil antes de concluir o acesso.

Fluxos de Exceção
FE-001
Usuário inexistente.
O sistema informa que as credenciais são inválidas.

FE-002
Senha incorreta.
O sistema informa que as credenciais são inválidas.

FE-003
Conta bloqueada.
O sistema informa que o acesso está temporariamente bloqueado.

FE-004
Congregação inativa.
O sistema impede o acesso.

FE-005
Usuário inativo.
O sistema impede o acesso.

Pós-condições
•	Sessão iniciada.
•	Auditoria registrada.
•	Tokens emitidos.
•	Dashboard carregado.

Requisitos Relacionados
RF-AUT-001
RF-AUT-002
RF-AUT-003
________________________________________
Regras Relacionadas
RN-USU
RN-AUD
RN-TRANS

UC-002 – Encerrar Sessão
Objetivo
Permitir que o usuário finalize sua sessão com segurança.

Atores
Todos os usuários autenticados.

Fluxo Principal
1.	O usuário seleciona Sair.
2.	O sistema invalida os tokens.
3.	O sistema registra o logout.
4.	O sistema encerra a sessão.
5.	O sistema retorna à tela de login.

Pós-condições
•	Sessão encerrada.
•	Tokens inválidos.
•	Auditoria registrada.

Regras Relacionadas
RN-TRANS-006
RN-AUD-001
RN-AUD-010


UC-003 – Recuperar Senha
Objetivo
Permitir que um usuário redefina sua senha quando esquecer suas credenciais.

Atores
Todos os usuários.

Fluxo Principal
1.	O usuário seleciona Esqueci minha senha.
2.	Informa seu e-mail.
3.	O sistema valida o cadastro.
4.	O sistema gera um token temporário.
5.	O sistema envia instruções para redefinição.
6.	O usuário cria uma nova senha.
7.	O sistema valida a política de senhas.
8.	O sistema atualiza a senha.
9.	O sistema registra a auditoria.

Fluxos de Exceção
•	e-mail inexistente;
•	token expirado;
•	token inválido;
•	senha fora da política.

Pós-condições
Nova senha cadastrada.

UC-004 – Alterar Senha
Objetivo
Permitir que um usuário autenticado altere sua senha.

Fluxo Principal
1.	Acessar Perfil.
2.	Selecionar Alterar Senha.
3.	Informar senha atual.
4.	Informar nova senha.
5.	Confirmar nova senha.
6.	Sistema valida.
7.	Sistema grava.
8.	Sistema registra auditoria.
9.	Sistema confirma operação.

UC-005 – Atualizar Perfil
Objetivo
Permitir que o usuário altere informações permitidas do seu perfil.

Dados editáveis
•	telefone;
•	e-mail (quando permitido);
•	foto;
•	idioma;
•	preferências;
•	notificações.

Fluxo Principal
1.	Abrir Perfil.
2.	Alterar informações.
3.	Salvar.
4.	Sistema valida.
5.	Sistema registra auditoria.
6.	Sistema atualiza os dados.

UC-006 – Selecionar Congregação
Observação: este caso de uso só se aplica caso um mesmo usuário esteja vinculado a mais de uma Congregação. Se decidirmos que cada usuário pertence exclusivamente a uma Congregação, este caso poderá ser removido.
Objetivo
Permitir a seleção da Congregação antes do carregamento do ambiente de trabalho.

Fluxo Principal
1.	Login realizado.
2.	O sistema identifica múltiplas Congregações vinculadas.
3.	Exibe a lista.
4.	O usuário seleciona uma Congregação.
5.	O sistema carrega permissões e configurações específicas.
6.	O Dashboard é exibido.

UC-007 – Renovar Sessão (Refresh Token)
Objetivo
Manter a sessão ativa sem exigir novo login.

Fluxo Principal
1.	O token de acesso expira.
2.	O frontend solicita renovação.
3.	O backend valida o Refresh Token.
4.	Um novo Access Token é emitido.
5.	A sessão continua ativa.

UC-008 – Bloquear Usuário por Tentativas de Login
Objetivo
Proteger o sistema contra tentativas repetidas de acesso indevido.

Fluxo Principal
1.	O usuário informa credenciais inválidas.
2.	O sistema incrementa o contador de falhas.
3.	Ao atingir o limite configurado, a conta é bloqueada temporariamente.
4.	O evento é registrado na auditoria.
5.	O Administrador Geral poderá visualizar o bloqueio.

3.1 Resumo do Capítulo
Código	Caso de Uso
UC-001	Autenticar Usuário
UC-002	Encerrar Sessão
UC-003	Recuperar Senha
UC-004	Alterar Senha
UC-005	Atualizar Perfil
UC-006	Selecionar Congregação (opcional)
UC-007	Renovar Sessão
UC-008	Bloquear Usuário por Tentativas de Login

4 – Congregações
4.1 Introdução
O módulo Congregações é o núcleo do modelo multi-tenant do GTP.
Toda informação do sistema pertence obrigatoriamente a uma Congregação.
Ela representa uma comunidade organizada das Testemunhas de Jeová responsável pela administração dos seus:
•	publicadores;
•	territórios;
•	publicações;
•	campanhas;
•	pedidos;
•	usuários;
•	configurações.
Cada Congregação possui autonomia administrativa, respeitando as regras globais definidas pelo Desenvolvedor Geral.

UC-009 – Cadastrar Congregação
Objetivo
Permitir ao Desenvolvedor Geral cadastrar uma nova Congregação no sistema.

Atores
•	Desenvolvedor Geral

Pré-condições
•	O usuário deve estar autenticado.
•	O usuário deve possuir perfil de Desenvolvedor Geral.

Gatilho
Selecionar Nova Congregação.

Fluxo Principal
1.	O Desenvolvedor acessa o módulo Congregações.
2.	Seleciona Cadastrar Congregação.
3.	Informa os dados obrigatórios:
o	Nome da Congregação;
o	Código identificador;
o	Cidade;
o	Estado;
o	País;
o	Idioma padrão;
o	Fuso horário;
o	Situação inicial.
4.	O sistema valida os dados.
5.	O sistema verifica se o código é único.
6.	O sistema cria a Congregação.
7.	O sistema aplica as configurações padrão.
8.	O sistema registra a auditoria.
9.	O sistema confirma o cadastro.

Fluxos Alternativos
FA-001
Código já existente.
O sistema solicita um novo código.

Fluxos de Exceção
FE-001
Campos obrigatórios não informados.

FE-002
Nome duplicado (quando configurado para impedir duplicidade).

Pós-condições
•	Congregação cadastrada.
•	Configurações iniciais aplicadas.
•	Auditoria registrada.

Regras Relacionadas
RN-CONG-001
RN-CON-010
RN-AUD-001

UC-010 – Consultar Congregação
Objetivo
Permitir consultar os dados cadastrais de uma Congregação.

Atores
•	Desenvolvedor Geral
•	Administrador Geral (somente da própria Congregação)

Fluxo Principal
1.	Acessar Congregações.
2.	Informar filtros.
3.	Sistema realiza a pesquisa.
4.	Exibe os resultados.
5.	Usuário seleciona uma Congregação.
6.	Sistema apresenta os detalhes.

Filtros
•	Nome;
•	Código;
•	Cidade;
•	Estado;
•	Situação.

UC-011 – Alterar Dados da Congregação
Objetivo
Permitir atualizar informações da Congregação.

Atores
•	Desenvolvedor Geral
•	Administrador Geral (somente dados permitidos)

Fluxo Principal
1.	Abrir Congregação.
2.	Editar informações.
3.	Salvar.
4.	Sistema valida.
5.	Sistema registra auditoria.
6.	Sistema confirma atualização.

Dados editáveis pelo Administrador Geral
•	telefone;
•	endereço;
•	e-mail;
•	horários;
•	logotipo;
•	informações públicas.

Dados exclusivos do Desenvolvedor Geral
•	código;
•	status global;
•	configurações estruturais;
•	licenciamento (se aplicável no futuro).

UC-012 – Ativar Congregação
Objetivo
Permitir reativar uma Congregação previamente desativada.

Fluxo Principal
1.	Localizar Congregação.
2.	Selecionar Ativar.
3.	Confirmar operação.
4.	Sistema atualiza o status.
5.	Sistema registra auditoria.
6.	Sistema libera o acesso aos usuários.

UC-013 – Desativar Congregação
Objetivo
Permitir suspender temporariamente uma Congregação.

Fluxo Principal
1.	Localizar Congregação.
2.	Selecionar Desativar.
3.	Informar motivo.
4.	Confirmar.
5.	Sistema registra auditoria.
6.	Sistema bloqueia novos acessos.

Observação
Os dados não serão excluídos. A Congregação permanecerá cadastrada para fins históricos.

UC-014 – Configurar Congregação
Objetivo
Permitir personalizar os parâmetros operacionais da Congregação.

Atores
•	Administrador Geral

Fluxo Principal
1.	Acessar Configurações.
2.	Alterar parâmetros.
3.	Salvar.
4.	Sistema valida.
5.	Sistema registra auditoria.
6.	Sistema aplica as novas configurações.

Exemplos de Configurações
•	prazo de devolução dos territórios;
•	estoque mínimo;
•	confirmação obrigatória de entrega;
•	notificações automáticas;
•	atendimento parcial;
•	inventários.

UC-015 – Consultar Estatísticas da Congregação
Objetivo
Apresentar indicadores consolidados da Congregação.
________________________________________
Informações
•	quantidade de publicadores;
•	usuários ativos;
•	territórios;
•	campanhas;
•	pedidos;
•	estoque;
•	publicações;
•	notificações;
•	auditorias.

UC-016 – Exportar Dados da Congregação
Objetivo
Permitir exportar informações administrativas.

Formatos
•	PDF;
•	Excel;
•	CSV.

Permissões
Desenvolvedor Geral.
Administrador Geral (somente informações da própria Congregação).

UC-017 – Visualizar Histórico da Congregação
Objetivo
Permitir consultar todas as alterações relevantes ocorridas na Congregação.

Eventos Exibidos
•	alterações cadastrais;
•	mudanças de configuração;
•	ativações;
•	desativações;
•	administradores alterados;
•	auditorias.



UC-018 – Transferir Administração da Congregação
Objetivo
Permitir alterar o Administrador Geral responsável pela Congregação.

Atores
•	Desenvolvedor Geral

Fluxo Principal
1.	Selecionar Congregação.
2.	Escolher novo Administrador Geral.
3.	Confirmar transferência.
4.	Sistema valida o usuário.
5.	Atualiza as permissões.
6.	Registra auditoria.
7.	Notifica os envolvidos.

4.2 Resumo do Capítulo
Código	Caso de Uso
UC-009	Cadastrar Congregação
UC-010	Consultar Congregação
UC-011	Alterar Dados da Congregação
UC-012	Ativar Congregação
UC-013	Desativar Congregação
UC-014	Configurar Congregação
UC-015	Consultar Estatísticas da Congregação
UC-016	Exportar Dados da Congregação
UC-017	Visualizar Histórico da Congregação
UC-018	Transferir Administração da Congregação

5 – Pessoas
5.1 Introdução
O módulo Pessoas é responsável pelo gerenciamento dos membros da Congregação que participam das atividades relacionadas aos territórios e às publicações.
Cada pessoa pertence obrigatoriamente a uma única Congregação e pode exercer uma ou mais designações (conforme as regras definidas pelo Administrador Geral).
O cadastro de uma pessoa não cria automaticamente um usuário do sistema.

UC-019 – Cadastrar Pessoa
Objetivo
Permitir o cadastro de uma nova pessoa na Congregação.

Atores
•	Administrador Geral

Pré-condições
•	Usuário autenticado.
•	Permissão para gerenciar pessoas.
•	Congregação ativa.

Gatilho
Selecionar Nova Pessoa.

Fluxo Principal
1.	O Administrador acessa o módulo Pessoas.
2.	Seleciona Cadastrar Pessoa.
3.	Informa os dados obrigatórios:
o	Nome completo;
o	Sexo;
o	Data de nascimento;
o	Telefone;
o	Endereço;
o	Data de batismo (quando aplicável);
o	Situação;
o	Observações.
4.	O sistema valida os dados.
5.	Verifica duplicidades.
6.	Cria o cadastro.
7.	Registra auditoria.
8.	Exibe confirmação.

Fluxos Alternativos
FA-001
Pessoa já cadastrada.
O sistema informa possível duplicidade e permite consultar o cadastro existente.

Fluxos de Exceção
•	Campos obrigatórios não preenchidos.
•	Dados inválidos.

Pós-condições
Pessoa cadastrada com sucesso.

Regras Relacionadas
RN-PES-001
RN-PES-004
RN-AUD-001

UC-020 – Consultar Pessoa
Objetivo
Permitir consultar o cadastro de pessoas da Congregação.

Atores
•	Administrador Geral
•	Servo de Territórios (consulta)
•	Servo de Publicações (consulta)

Filtros
•	Nome;
•	Situação;
•	Designação;
•	Telefone;
•	Data de cadastro.

Resultado
O sistema apresenta uma lista paginada com os registros encontrados.


UC-021 – Atualizar Cadastro da Pessoa
Objetivo
Permitir a alteração das informações cadastrais.

Fluxo Principal
1.	Localizar pessoa.
2.	Abrir cadastro.
3.	Alterar informações permitidas.
4.	Salvar.
5.	Sistema valida.
6.	Registra auditoria.
7.	Atualiza os dados.

UC-022 – Alterar Situação da Pessoa
Objetivo
Alterar a situação cadastral de uma pessoa.

Situações possíveis
•	Ativa;
•	Inativa;
•	Transferida;
•	Falecida.

Regras
•	O histórico deve ser preservado.
•	Não é permitida a exclusão física do cadastro.

UC-023 – Registrar Designações
Objetivo
Associar designações a uma pessoa.

Exemplos
•	Publicador;
•	Servo de Territórios;
•	Servo de Publicações;
•	Superintendente de Serviço;
•	Administrador Geral.

Fluxo Principal
1.	Abrir cadastro.
2.	Selecionar Designações.
3.	Adicionar ou remover designações permitidas.
4.	Confirmar.
5.	Sistema registra auditoria.

UC-024 – Consultar Histórico da Pessoa
Objetivo
Permitir visualizar o histórico completo da pessoa.

Informações apresentadas
•	alterações cadastrais;
•	designações;
•	territórios retirados;
•	territórios devolvidos;
•	pedidos realizados;
•	pedidos entregues;
•	campanhas;
•	notificações;
•	auditoria.

UC-025 – Pesquisar Pessoas
Objetivo
Realizar pesquisas rápidas.

Critérios
•	Nome;
•	Parte do nome;
•	Telefone;
•	Designação;
•	Situação.

Resultado
Lista dinâmica com paginação e ordenação.

UC-026 – Exportar Cadastro de Pessoas
Objetivo
Permitir exportar informações cadastrais.

Formatos
•	PDF;
•	Excel;
•	CSV.

Permissões
Administrador Geral.

UC-027 – Importar Pessoas
Objetivo
Permitir importar registros em lote.

Formatos aceitos
•	CSV;
•	Excel.

Fluxo Principal
1.	Selecionar arquivo.
2.	Sistema valida o formato.
3.	Exibe pré-visualização.
4.	Usuário confirma.
5.	Sistema importa os registros.
6.	Gera relatório da importação.
7.	Registra auditoria.

UC-028 – Visualizar Painel da Pessoa
Objetivo
Apresentar uma visão consolidada da participação da pessoa na Congregação.

Informações
•	Dados pessoais;
•	Designações atuais;
•	Quantidade de territórios retirados;
•	Quantidade de territórios devolvidos;
•	Pedidos realizados;
•	Pedidos concluídos;
•	Participação em campanhas;
•	Último acesso (quando possuir usuário);
•	Notificações pendentes.

5.2 Resumo do Capítulo
Código	Caso de Uso
UC-019	Cadastrar Pessoa
UC-020	Consultar Pessoa
UC-021	Atualizar Cadastro da Pessoa
UC-022	Alterar Situação da Pessoa
UC-023	Registrar Designações
UC-024	Consultar Histórico da Pessoa
UC-025	Pesquisar Pessoas
UC-026	Exportar Cadastro de Pessoas
UC-027	Importar Pessoas
UC-028	Visualizar Painel da Pessoa

6 – Usuários
6.1 Introdução
O módulo Usuários é responsável pela administração das contas de acesso ao GTP.
Enquanto o módulo Pessoas representa os membros da Congregação, o módulo Usuários representa as credenciais de acesso ao sistema.
Uma pessoa pode existir sem possuir usuário.
Todo usuário obrigatoriamente está vinculado a:
•	uma Pessoa;
•	uma Congregação;
•	um Perfil de Acesso.
O sistema deverá impedir a existência de usuários sem vínculo com uma Pessoa.

UC-029 – Criar Usuário
Objetivo
Permitir ao Administrador Geral criar uma conta de acesso para uma Pessoa cadastrada.

Atores
•	Administrador Geral

Pré-condições
•	Usuário autenticado.
•	Permissão para gerenciar usuários.
•	Pessoa cadastrada.
•	Pessoa ativa.
•	Pessoa ainda sem conta de acesso.

Gatilho
Selecionar Novo Usuário.


Fluxo Principal
1.	Acessar o módulo Usuários.
2.	Selecionar Criar Usuário.
3.	Pesquisar a Pessoa.
4.	Selecionar a Pessoa.
5.	Definir:
o	login;
o	e-mail;
o	perfil de acesso;
o	situação inicial.
6.	O sistema gera uma senha temporária.
7.	O sistema cria a conta.
8.	Registra auditoria.
9.	Exibe confirmação.

Fluxos Alternativos
Pessoa já possui usuário.
O sistema impede novo cadastro.

Pós-condições
Usuário criado.
Senha temporária disponível.

Regras Relacionadas
RN-USU-001
RN-USU-003
RN-AUD-001

UC-030 – Consultar Usuários
Objetivo
Permitir localizar usuários cadastrados.

Filtros
•	Nome;
•	Login;
•	Perfil;
•	Situação;
•	Último acesso.

Resultado
Lista paginada.

UC-031 – Alterar Perfil de Acesso
Objetivo
Modificar o perfil de acesso de um usuário.

Fluxo Principal
1.	Localizar usuário.
2.	Abrir cadastro.
3.	Alterar perfil.
4.	Confirmar.
5.	Sistema valida.
6.	Atualiza permissões.
7.	Registra auditoria.

Observação
A alteração não modifica a designação da pessoa na Congregação, apenas suas permissões no sistema.

UC-032 – Ativar Usuário
Objetivo
Permitir reativar uma conta.

Fluxo
1.	Localizar usuário.
2.	Selecionar Ativar.
3.	Confirmar.
4.	Sistema altera situação.
5.	Auditoria registrada.

UC-033 – Desativar Usuário
Objetivo
Suspender uma conta.

Regras
•	O histórico permanece.
•	Nenhuma informação será excluída.
•	O usuário perde imediatamente o acesso ao sistema.

UC-034 – Redefinir Senha
Objetivo
Permitir ao Administrador redefinir a senha de um usuário.

Fluxo
1.	Selecionar usuário.
2.	Escolher Redefinir Senha.
3.	Confirmar.
4.	Sistema gera senha temporária.
5.	Sistema registra auditoria.
6.	Usuário deverá alterar a senha no próximo acesso.

UC-035 – Bloquear Usuário
Objetivo
Bloquear manualmente uma conta.

Motivos
•	afastamento;
•	investigação;
•	segurança;
•	solicitação administrativa.

UC-036 – Desbloquear Usuário
Objetivo
Restabelecer o acesso de um usuário bloqueado.

Fluxo Principal
1.	Localizar usuário.
2.	Selecionar Desbloquear.
3.	Confirmar.
4.	Sistema libera acesso.
5.	Auditoria registrada.

UC-037 – Consultar Histórico do Usuário
Objetivo
Apresentar o histórico completo da conta.

Informações
•	logins;
•	logouts;
•	bloqueios;
•	redefinições de senha;
•	alterações de perfil;
•	alterações cadastrais;
•	auditorias.

UC-038 – Gerenciar Permissões Especiais
Objetivo
Conceder permissões adicionais ao perfil padrão.

Exemplos
•	exportar relatórios;
•	alterar configurações;
•	visualizar auditoria;
•	realizar inventário;
•	cancelar pedidos;
•	aprovar campanhas.
Observação
Permissões especiais nunca poderão ultrapassar os limites definidos pelo perfil do usuário e deverão ser auditadas.

UC-039 – Revogar Permissões Especiais
Objetivo
Remover permissões adicionais concedidas anteriormente.

Fluxo Principal
1.	Selecionar usuário.
2.	Abrir permissões.
3.	Remover permissões.
4.	Confirmar.
5.	Sistema registra auditoria.

UC-040 – Consultar Sessões Ativas
Objetivo
Permitir ao Administrador visualizar as sessões ativas dos usuários da Congregação.

Informações
•	usuário;
•	dispositivo;
•	navegador;
•	endereço IP (quando disponível);
•	data e hora do login;
•	última atividade.

UC-041 – Encerrar Sessão de Usuário
Objetivo
Permitir que o Administrador encerre remotamente a sessão de um usuário.

Fluxo Principal
1.	Selecionar sessão.
2.	Confirmar encerramento.
3.	Sistema invalida os tokens.
4.	Usuário é desconectado.
5.	Auditoria registrada.

UC-042 – Gerenciar Perfis de Acesso
Objetivo
Permitir ao Desenvolvedor Geral definir e evoluir os perfis de acesso do sistema.

Perfis padrão do GTP
•	Desenvolvedor Geral;
•	Administrador Geral;
•	Servo de Territórios;
•	Servo de Publicações;
•	Publicador.

Funcionalidades
•	criar perfil;
•	editar perfil;
•	ativar/desativar perfil;
•	associar permissões;
•	consultar utilização.

6.2 Resumo do Capítulo
Código	Caso de Uso
UC-029	Criar Usuário
UC-030	Consultar Usuários
UC-031	Alterar Perfil de Acesso
UC-032	Ativar Usuário
UC-033	Desativar Usuário
UC-034	Redefinir Senha
UC-035	Bloquear Usuário
UC-036	Desbloquear Usuário
UC-037	Consultar Histórico do Usuário
UC-038	Gerenciar Permissões Especiais
UC-039	Revogar Permissões Especiais
UC-040	Consultar Sessões Ativas
UC-041	Encerrar Sessão de Usuário
UC-042	Gerenciar Perfis de Acesso

7 – Territórios
7.1 Introdução
O módulo Territórios é responsável pelo gerenciamento completo dos territórios pertencentes à Congregação.
Um território representa uma área geográfica destinada ao trabalho de pregação das boas novas.
Cada território pertence exclusivamente a uma Congregação e somente poderá ser retirado por publicadores autorizados.
O sistema deverá manter todo o histórico de movimentações do território desde sua criação até seu arquivamento.

7.2 Ciclo de Vida do Território
          Cadastro
              │
              ▼
        Disponível
              │
              ▼
          Reservado
              │
              ▼
         Em Utilização
              │
              ▼
          Devolvido
              │
              ▼
      Em Conferência
              │
              ▼
 Disponível novamente

Observação: Incluímos o status Reservado porque ele poderá ser útil caso a Congregação permita solicitações de território que ainda dependam da confirmação do Servo de Territórios.

UC-043 – Cadastrar Território
Objetivo
Permitir o cadastro de um novo território pertencente à Congregação.

Atores
•	Servo de Territórios
•	Administrador Geral

Pré-condições
•	Usuário autenticado.
•	Permissão para gerenciar territórios.
•	Congregação ativa.

Fluxo Principal
1.	Acessar o módulo Territórios.
2.	Selecionar Novo Território.
3.	Informar:
o	Código do território;
o	Nome;
o	Descrição;
o	Bairro;
o	Cidade;
o	Limites geográficos;
o	Observações.
4.	Informar se o território é:
o	Urbano;
o	Rural;
o	Comercial;
o	Misto.
5.	Salvar.
6.	O sistema valida as informações.
7.	Cria o território.
8.	Registra auditoria.

UC-044 – Consultar Territórios
Objetivo
Consultar os territórios da Congregação.

Filtros
•	Código;
•	Nome;
•	Bairro;
•	Tipo;
•	Situação;
•	Publicador atual;
•	Disponibilidade.

Resultado
Mapa ou lista paginada.

UC-045 – Atualizar Território
Objetivo
Alterar informações cadastrais do território.

Informações editáveis
•	Nome;
•	Descrição;
•	Observações;
•	Limites;
•	Tipo.

UC-046 – Disponibilizar Território
Objetivo
Colocar um território disponível para retirada.

Fluxo
1.	Selecionar território.
2.	Escolher Disponibilizar.
3.	Sistema altera o status.
4.	Atualiza dashboard.
5.	Registra auditoria.

UC-047 – Reservar Território
Objetivo
Reservar um território para um publicador antes da retirada efetiva.

Fluxo Principal
1.	Publicador solicita reserva.
2.	Servo de Territórios analisa.
3.	Aprova ou rejeita.
4.	Sistema atualiza status.

UC-048 – Retirar Território
Objetivo
Registrar oficialmente a retirada do território.

Fluxo Principal
1.	Publicador solicita retirada.
2.	Servo de Territórios confirma.
3.	Sistema valida:
o	permissões;
o	situação do território;
o	limite de territórios por publicador;
o	pendências existentes.
4.	Sistema registra:
o	data;
o	responsável;
o	previsão de devolução.
5.	Status alterado para Em Utilização.
6.	Auditoria registrada.
7.	Notificação enviada.

Fluxos de Exceção
•	Território indisponível.
•	Publicador bloqueado.
•	Limite de territórios excedido.
•	Pendências de devolução.

UC-049 – Devolver Território
Objetivo
Registrar a devolução de um território.

Fluxo Principal
1.	Publicador devolve território.
2.	Servo de Territórios recebe.
3.	Sistema registra:
o	data;
o	observações;
o	condição do território.
4.	Status passa para Em Conferência.
5.	Auditoria registrada.

UC-050 – Conferir Território
Objetivo
Verificar se o território pode voltar ao status de disponível.

Fluxo Principal
1.	Servo de Territórios analisa o território devolvido.
2.	Verifica informações e eventuais pendências.
3.	Aprova a conferência.
4.	Sistema altera o status para Disponível.

UC-051 – Recolher Território
Objetivo
Permitir que o Servo de Territórios recolha um território antes do prazo previsto, quando necessário.

Exemplos
•	Publicador impossibilitado de continuar.
•	Necessidade administrativa.
•	Erro na retirada.
•	Solicitação do Superintendente de Serviço.

UC-052 – Arquivar Território
Objetivo
Arquivar um território que deixou de ser utilizado.

Regras
•	O histórico permanece.
•	Nenhum dado é excluído.
•	O território não poderá ser retirado enquanto estiver arquivado.

UC-053 – Reativar Território
Objetivo
Reativar um território arquivado.

UC-054 – Consultar Histórico do Território
Objetivo
Visualizar toda a vida útil do território.

Informações
•	Cadastro;
•	Alterações;
•	Retiradas;
•	Devoluções;
•	Reservas;
•	Conferências;
•	Arquivamentos;
•	Auditorias.

UC-055 – Pesquisar Territórios
Objetivo
Pesquisar rapidamente qualquer território da Congregação.

Critérios
•	Código;
•	Bairro;
•	Nome;
•	Situação;
•	Publicador.

UC-056 – Imprimir Cartão do Território
Objetivo
Gerar uma versão impressa ou em PDF do território para utilização durante a pregação.

Conteúdo
•	Código;
•	Nome;
•	Mapa (quando disponível);
•	Limites;
•	Observações;
•	Data de emissão.

UC-057 – Visualizar Território no Mapa
Objetivo
Apresentar o território em um mapa interativo.

Funcionalidades
•	Zoom;
•	Camadas;
•	Limites;
•	Coordenadas;
•	Impressão.
Observação: A integração com serviços de mapas será definida na fase de arquitetura. Podemos avaliar alternativas como OpenStreetMap (gratuito) ou Google Maps, considerando custos, licenciamento e recursos necessários.

UC-058 – Exportar Territórios
Objetivo
Exportar informações dos territórios.

Formatos
•	PDF;
•	Excel;
•	CSV.

UC-059 – Dashboard de Territórios
Objetivo
Apresentar indicadores em tempo real.

Indicadores
•	Territórios disponíveis;
•	Em utilização;
•	Reservados;
•	Em conferência;
•	Arquivados;
•	Devoluções em atraso;
•	Tempo médio de utilização.

7.3 Resumo do Capítulo
Código	Caso de Uso
UC-043	Cadastrar Território
UC-044	Consultar Territórios
UC-045	Atualizar Território
UC-046	Disponibilizar Território
UC-047	Reservar Território
UC-048	Retirar Território
UC-049	Devolver Território
UC-050	Conferir Território
UC-051	Recolher Território
UC-052	Arquivar Território
UC-053	Reativar Território
UC-054	Consultar Histórico do Território
UC-055	Pesquisar Territórios
UC-056	Imprimir Cartão do Território
UC-057	Visualizar Território no Mapa
UC-058	Exportar Territórios
UC-059	Dashboard de Territórios

8 – Publicações
8.1 Introdução
O módulo Publicações é responsável pelo gerenciamento do estoque de publicações da Congregação, incluindo o cadastro de materiais, movimentações, inventários e atendimento dos pedidos.
Todas as movimentações deverão ser registradas para garantir rastreabilidade e controle do estoque.
O módulo é administrado principalmente pelo Servo de Publicações, sob supervisão do Administrador Geral.

8.2 Ciclo de Vida de uma Publicação
Cadastro
    │
    ▼
Disponível em Estoque
    │
    ▼
Reservada para Pedido
    │
    ▼
Entregue
    │
    ▼
Baixa no Estoque

UC-060 – Cadastrar Publicação
Objetivo
Permitir o cadastro de uma nova publicação no catálogo da Congregação.
Atores
•	Servo de Publicações
•	Administrador Geral
Fluxo Principal
1.	Acessar o módulo Publicações.
2.	Selecionar Nova Publicação.
3.	Informar:
o	Código;
o	Sigla;
o	Nome;
o	Categoria;
o	Idioma;
o	Unidade de medida;
o	Controla estoque (Sim/Não).
4.	Salvar.
5.	O sistema valida os dados.
6.	Registra auditoria.

UC-061 – Atualizar Cadastro de Publicação
Objetivo
Alterar dados cadastrais de uma publicação.

UC-062 – Consultar Publicações
Objetivo
Pesquisar publicações cadastradas.
Filtros
•	Código;
•	Sigla;
•	Nome;
•	Categoria;
•	Idioma;
•	Situação.
UC-063 – Registrar Entrada de Estoque
Objetivo
Registrar a entrada de publicações no estoque da Congregação.
Origens possíveis
•	Pedido Normal (Betel);
•	Transferência autorizada;
•	Ajuste de inventário.
Fluxo Principal
1.	Informar a origem.
2.	Selecionar a publicação.
3.	Informar a quantidade.
4.	Confirmar.
5.	Sistema atualiza o estoque.
6.	Sistema registra a movimentação.
7.	Auditoria registrada.

UC-064 – Registrar Saída de Estoque
Objetivo
Registrar a entrega de publicações.
Destinos possíveis
•	Pedido Individual;
•	Pedido de Campanha;
•	Ajuste de estoque;
•	Baixa administrativa.



UC-065 – Consultar Estoque
Objetivo
Visualizar o estoque atual.
Informações exibidas
•	Quantidade disponível;
•	Quantidade reservada;
•	Estoque mínimo;
•	Última movimentação;
•	Localização (quando aplicável).

UC-066 – Ajustar Estoque
Objetivo
Realizar ajustes manuais de estoque.
Motivos
•	Divergência;
•	Inventário;
•	Perda;
•	Danificação;
•	Correção administrativa.
Regra
Todo ajuste deverá informar obrigatoriamente um motivo e ficará registrado na auditoria.

UC-067 – Realizar Inventário
Objetivo
Conferir fisicamente o estoque da Congregação.
Fluxo Principal
1.	Iniciar inventário.
2.	Sistema gera lista de conferência.
3.	Informar quantidades encontradas.
4.	Sistema identifica divergências.
5.	Confirmar ajustes.
6.	Registrar auditoria.

UC-068 – Consultar Movimentações de Estoque
Objetivo
Visualizar todas as entradas e saídas.
Filtros
•	Publicação;
•	Tipo de movimentação;
•	Período;
•	Responsável;
•	Origem.

UC-069 – Arquivar Publicação
Objetivo
Retirar uma publicação de circulação.
Regra
A publicação permanece no histórico e não poderá ser utilizada em novos pedidos.

UC-070 – Reativar Publicação
Objetivo
Permitir que uma publicação arquivada volte a ser utilizada.
UC-071 – Consultar Histórico da Publicação
Objetivo
Visualizar toda a movimentação da publicação.
Informações
•	Entradas;
•	Saídas;
•	Inventários;
•	Ajustes;
•	Pedidos relacionados;
•	Auditorias.

UC-072 – Definir Estoque Mínimo
Objetivo
Configurar a quantidade mínima desejada para uma publicação.
Resultado
Quando o estoque atingir esse limite, o sistema poderá gerar alertas para reposição.

UC-073 – Consultar Publicações com Estoque Baixo
Objetivo
Listar automaticamente os itens abaixo do estoque mínimo.

UC-074 – Exportar Relatório de Estoque
Objetivo
Gerar relatórios do estoque.
Formatos
•	PDF;
•	Excel;
•	CSV.

UC-075 – Dashboard de Publicações
Objetivo
Apresentar indicadores do módulo.
Indicadores
•	Total de itens cadastrados;
•	Estoque disponível;
•	Estoque reservado;
•	Publicações mais distribuídas;
•	Itens abaixo do estoque mínimo;
•	Entradas do mês;
•	Saídas do mês;
•	Ajustes realizados.

UC-076 – Consultar Catálogo de Publicações
Objetivo
Permitir que os publicadores consultem o catálogo de publicações disponíveis para solicitação.
Informações exibidas
•	Nome;
•	Sigla;
•	Categoria;
•	Disponibilidade;
•	Observações (quando houver).
Observação: No Documento 01 definimos que posteriormente construiremos uma tabela completa de categorias, tipos e siglas das publicações. Este caso de uso utilizará esse catálogo quando ele estiver definido.

8.3 Resumo do Capítulo
Código	Caso de Uso
UC-060	Cadastrar Publicação
UC-061	Atualizar Cadastro
UC-062	Consultar Publicações
UC-063	Registrar Entrada de Estoque
UC-064	Registrar Saída de Estoque
UC-065	Consultar Estoque
UC-066	Ajustar Estoque
UC-067	Realizar Inventário
UC-068	Consultar Movimentações
UC-069	Arquivar Publicação
UC-070	Reativar Publicação
UC-071	Consultar Histórico
UC-072	Definir Estoque Mínimo
UC-073	Consultar Estoque Baixo
UC-074	Exportar Relatório de Estoque
UC-075	Dashboard de Publicações
UC-076	Consultar Catálogo de Publicações



9 – Pedidos de Publicações
9.1 Introdução
O módulo Pedidos gerencia todo o ciclo de solicitação, aprovação (quando necessária), separação, entrega e conclusão dos pedidos de publicações.
Cada pedido será composto por:
•	Cabeçalho;
•	Itens;
•	Histórico;
•	Movimentações;
•	Auditoria.
Todo pedido pertence a uma Congregação.

9.2 Ciclo de Vida do Pedido
Criado
   │
   ▼
Pendente
   │
   ▼
Em Separação
   │
   ▼
Pronto para Entrega
   │
   ▼
Entregue
   │
   ▼
Concluído
Outros estados possíveis:
•	Cancelado;
•	Parcialmente Entregue;
•	Rejeitado (quando aplicável).
UC-077 – Criar Pedido Individual
Objetivo
Permitir que um Publicador solicite publicações para uso pessoal.
Atores
•	Publicador
Pré-condições
•	Usuário autenticado.
•	Pessoa ativa.
•	Catálogo disponível.
Fluxo Principal
1.	Acessar o módulo Pedidos.
2.	Selecionar Novo Pedido Individual.
3.	Escolher as publicações.
4.	Informar as quantidades desejadas.
5.	Confirmar o pedido.
6.	O sistema valida a disponibilidade.
7.	O sistema registra o pedido com status Pendente.
8.	O Servo de Publicações é notificado.

UC-078 – Criar Pedido de Campanha
Objetivo
Permitir a solicitação de publicações para uma campanha previamente cadastrada.
Fluxo Principal
1.	Selecionar a campanha.
2.	Escolher os materiais disponíveis.
3.	Informar quantidades.
4.	Confirmar.
5.	Sistema vincula o pedido à campanha.

UC-079 – Criar Pedido de Reposição
Objetivo
Permitir registrar um pedido de reposição de estoque da Congregação.
Atores
•	Servo de Publicações
•	Administrador Geral
Fluxo Principal
1.	Criar pedido.
2.	Selecionar publicações.
3.	Informar quantidades.
4.	Confirmar.
5.	Sistema registra o pedido para acompanhamento.
Observação: O recebimento físico dessas publicações será registrado posteriormente no caso de uso Registrar Entrada de Estoque (UC-063).

UC-080 – Consultar Pedidos
Objetivo
Permitir pesquisar pedidos.
Filtros
•	Número;
•	Tipo;
•	Situação;
•	Solicitante;
•	Período;
•	Campanha;
•	Responsável pela entrega.
UC-081 – Atualizar Pedido
Objetivo
Permitir alterações enquanto o pedido estiver pendente.

UC-082 – Cancelar Pedido
Objetivo
Cancelar um pedido antes da entrega.
Regras
•	Deve registrar motivo.
•	A auditoria é obrigatória.
•	Itens reservados retornam ao estoque, quando aplicável.

UC-083 – Separar Pedido
Objetivo
Permitir que o Servo de Publicações prepare o pedido para entrega.
Fluxo Principal
1.	Abrir pedido.
2.	Separar os itens.
3.	Confirmar quantidades.
4.	Sistema altera o status para Em Separação.

UC-084 – Registrar Entrega do Pedido
Objetivo
Registrar oficialmente a entrega das publicações ao solicitante.
Fluxo Principal
1.	Localizar pedido.
2.	Confirmar entrega.
3.	Sistema registra:
o	data;
o	responsável;
o	destinatário.
4.	Atualiza o estoque.
5.	Altera o status para Entregue.
6.	Registra auditoria.

UC-085 – Registrar Entrega Parcial
Objetivo
Permitir entregar apenas parte dos itens solicitados.
Resultado
O pedido permanece em aberto até a conclusão ou cancelamento dos itens restantes.

UC-086 – Concluir Pedido
Objetivo
Finalizar definitivamente o pedido.
Condições
•	Todos os itens entregues; ou
•	Pedido encerrado administrativamente.

UC-087 – Consultar Histórico do Pedido
Objetivo
Apresentar todas as movimentações do pedido.
Informações
•	criação;
•	alterações;
•	separação;
•	entregas;
•	cancelamentos;
•	auditorias.

UC-088 – Consultar Meus Pedidos
Objetivo
Permitir que o Publicador acompanhe seus próprios pedidos.
Informações
•	Situação;
•	Data;
•	Itens;
•	Quantidades;
•	Responsável pela entrega;
•	Histórico.

UC-089 – Reimprimir Comprovante do Pedido
Objetivo
Gerar uma nova via do comprovante de entrega.
Formatos
•	PDF;
•	Impressão direta.

UC-090 – Dashboard de Pedidos
Objetivo
Apresentar indicadores operacionais.
Indicadores
•	Pedidos pendentes;
•	Em separação;
•	Prontos para entrega;
•	Entregues;
•	Cancelados;
•	Tempo médio de atendimento;
•	Pedidos por tipo;
•	Publicações mais solicitadas.

UC-091 – Exportar Pedidos
Objetivo
Exportar informações dos pedidos.
Formatos
•	PDF;
•	Excel;
•	CSV.

UC-092 – Consultar Estatísticas de Pedidos
Objetivo
Apresentar indicadores históricos para apoio à gestão.
Informações
•	Quantidade por período;
•	Quantidade por tipo;
•	Quantidade por publicador;
•	Quantidade por campanha;
•	Publicações mais distribuídas;
•	Tempo médio entre solicitação e entrega.

9.3 Resumo do Capítulo
Código	Caso de Uso
UC-077	Criar Pedido Individual
UC-078	Criar Pedido de Campanha
UC-079	Criar Pedido de Reposição
UC-080	Consultar Pedidos
UC-081	Atualizar Pedido
UC-082	Cancelar Pedido
UC-083	Separar Pedido
UC-084	Registrar Entrega do Pedido
UC-085	Registrar Entrega Parcial
UC-086	Concluir Pedido
UC-087	Consultar Histórico do Pedido
UC-088	Consultar Meus Pedidos
UC-089	Reimprimir Comprovante
UC-090	Dashboard de Pedidos
UC-091	Exportar Pedidos
UC-092	Consultar Estatísticas de Pedidos

10 – Campanhas
10.1 Introdução
O módulo Campanhas permite planejar, executar e acompanhar campanhas especiais promovidas pela Congregação.
Uma campanha pode estar relacionada à distribuição de uma ou mais publicações, ocorrer em um período determinado e envolver um grupo específico de publicadores.
Cada campanha pertence exclusivamente a uma Congregação e possui um ciclo de vida próprio.

10.2 Ciclo de Vida da Campanha
Planejada
    │
    ▼
Programada
    │
    ▼
Em Execução
    │
    ▼
Encerrada
Estados alternativos:
•	Cancelada;
•	Suspensa.

UC-093 – Cadastrar Campanha
Objetivo
Permitir criar uma nova campanha.
Atores
•	Administrador Geral
•	Servo de Publicações
Fluxo Principal
1.	Acessar o módulo Campanhas.
2.	Selecionar Nova Campanha.
3.	Informar:
o	Nome;
o	Descrição;
o	Objetivo;
o	Data inicial;
o	Data final;
o	Publicações envolvidas;
o	Quantidades previstas;
o	Observações.
4.	Salvar.
5.	O sistema valida os dados.
6.	Registra auditoria.

UC-094 – Consultar Campanhas
Objetivo
Pesquisar campanhas cadastradas.
Filtros
•	Nome;
•	Situação;
•	Período;
•	Publicação;
•	Responsável.

UC-095 – Atualizar Campanha
Objetivo
Alterar informações da campanha antes do início da execução.



UC-096 – Cancelar Campanha
Objetivo
Cancelar uma campanha antes ou durante sua execução.
Regras
•	Deve informar o motivo.
•	Os pedidos vinculados deverão ser tratados conforme sua situação.
•	Registrar auditoria obrigatoriamente.

UC-097 – Iniciar Campanha
Objetivo
Colocar uma campanha em execução.
Fluxo Principal
1.	Selecionar campanha.
2.	Confirmar início.
3.	Sistema altera o status para Em Execução.
4.	Sistema envia notificações aos participantes.
5.	Sistema libera pedidos vinculados.

UC-098 – Encerrar Campanha
Objetivo
Finalizar oficialmente uma campanha.
Fluxo Principal
1.	Selecionar campanha.
2.	Confirmar encerramento.
3.	Sistema encerra novos pedidos vinculados.
4.	Consolida indicadores.
5.	Registra auditoria.
UC-099 – Associar Publicações
Objetivo
Definir quais publicações fazem parte da campanha.
Funcionalidades
•	Adicionar publicação;
•	Remover publicação;
•	Definir quantidade prevista;
•	Definir prioridade.

UC-100 – Gerenciar Participantes
Objetivo
Definir quais publicadores participarão da campanha.
Funcionalidades
•	Adicionar participantes;
•	Remover participantes;
•	Consultar participantes;
•	Registrar observações.

UC-101 – Consultar Participação
Objetivo
Visualizar a participação dos publicadores na campanha.
Informações
•	Pedidos realizados;
•	Publicações entregues;
•	Participação ativa;
•	Observações.

UC-102 – Consultar Resultados da Campanha
Objetivo
Apresentar os resultados consolidados.
Indicadores
•	Publicações distribuídas;
•	Participantes;
•	Pedidos atendidos;
•	Pedidos pendentes;
•	Estoque consumido;
•	Período de execução.

UC-103 – Dashboard de Campanhas
Objetivo
Apresentar indicadores gerais das campanhas.
Indicadores
•	Campanhas planejadas;
•	Em execução;
•	Encerradas;
•	Canceladas;
•	Publicações distribuídas;
•	Participação por período.

UC-104 – Exportar Campanhas
Objetivo
Exportar dados das campanhas.
Formatos
•	PDF;
•	Excel;
•	CSV.

UC-105 – Consultar Histórico da Campanha
Objetivo
Apresentar todas as alterações ocorridas durante o ciclo de vida da campanha.
Informações
•	Cadastro;
•	Alterações;
•	Participantes;
•	Publicações;
•	Pedidos;
•	Início;
•	Encerramento;
•	Auditorias.

10.3 Resumo do Capítulo
Código	Caso de Uso
UC-093	Cadastrar Campanha
UC-094	Consultar Campanhas
UC-095	Atualizar Campanha
UC-096	Cancelar Campanha
UC-097	Iniciar Campanha
UC-098	Encerrar Campanha
UC-099	Associar Publicações
UC-100	Gerenciar Participantes
UC-101	Consultar Participação
UC-102	Consultar Resultados
UC-103	Dashboard de Campanhas
UC-104	Exportar Campanhas
UC-105	Consultar Histórico da Campanha

11 – Notificações e Comunicação
11.1 Introdução
O módulo Notificações e Comunicação é responsável pelo gerenciamento de todas as mensagens automáticas e comunicações geradas pelo GTP.
Seu objetivo é manter os usuários informados sobre eventos importantes, prazos, alterações de status e atividades que exijam atenção.
Todas as notificações deverão ser registradas para fins de auditoria e rastreabilidade.
As notificações poderão ser classificadas conforme:
•	Informativa
•	Aviso
•	Alerta
•	Confirmação
•	Erro
•	Comunicação Administrativa

11.2 Eventos que geram notificações
O sistema deverá gerar notificações automáticas para eventos como:
•	Novo pedido criado;
•	Pedido separado;
•	Pedido entregue;
•	Pedido cancelado;
•	Território reservado;
•	Território retirado;
•	Território devolvido;
•	Campanha iniciada;
•	Campanha encerrada;
•	Estoque abaixo do mínimo;
•	Inventário iniciado;
•	Inventário concluído;
•	Usuário bloqueado;
•	Senha redefinida;
•	Alteração de permissões;
•	Atualizações importantes do sistema.

UC-106 – Enviar Notificação Automática
Objetivo
Permitir que o sistema envie notificações automaticamente após eventos previamente configurados.
Atores
•	Sistema GTP
Fluxo Principal
1.	O sistema identifica um evento.
2.	Consulta as regras configuradas.
3.	Identifica os destinatários.
4.	Gera a mensagem.
5.	Registra a notificação.
6.	Disponibiliza ao usuário.
UC-107 – Criar Notificação Manual
Objetivo
Permitir que o Administrador Geral envie notificações para usuários da Congregação.
Atores
•	Administrador Geral
Fluxo Principal
1.	Selecionar destinatários.
2.	Informar título.
3.	Informar mensagem.
4.	Definir prioridade.
5.	Confirmar envio.
6.	Sistema registra auditoria.

UC-108 – Consultar Notificações
Objetivo
Permitir consultar notificações recebidas.
Filtros
•	Tipo
•	Data
•	Situação
•	Prioridade
•	Usuário

UC-109 – Marcar Notificação como Lida
Objetivo
Registrar que o usuário visualizou uma notificação.
Fluxo Principal
1.	Abrir notificação.
2.	Sistema registra leitura.
3.	Atualiza indicadores.

UC-110 – Excluir Notificação
Objetivo
Permitir remover notificações pessoais.
Regra
A exclusão será apenas lógica.
A auditoria permanece.

UC-111 – Configurar Preferências de Notificação
Objetivo
Permitir que cada usuário escolha quais notificações deseja receber.
Configurações
•	Pedidos
•	Territórios
•	Campanhas
•	Publicações
•	Estoque
•	Segurança
•	Administração

UC-112 – Enviar Comunicação Geral
Objetivo
Enviar comunicados para toda a Congregação.
Exemplos
•	Reuniões
•	Campanhas
•	Avisos
•	Eventos
•	Alterações administrativas

UC-113 – Agendar Comunicação
Objetivo
Permitir agendar uma comunicação futura.

UC-114 – Cancelar Comunicação Agendada
Objetivo
Cancelar uma comunicação antes do envio.

UC-115 – Consultar Histórico de Comunicações
Objetivo
Visualizar todas as comunicações enviadas.

UC-116 – Dashboard de Notificações
Objetivo
Apresentar indicadores.
Indicadores
•	Notificações enviadas
•	Pendentes
•	Lidas
•	Não lidas
•	Canceladas
•	Comunicações agendadas

UC-117 – Exportar Histórico de Notificações
Objetivo
Exportar registros.
Formatos
•	PDF
•	Excel
•	CSV

11.3 Resumo do Capítulo
Código	Caso de Uso
UC-106	Enviar Notificação Automática
UC-107	Criar Notificação Manual
UC-108	Consultar Notificações
UC-109	Marcar como Lida
UC-110	Excluir Notificação
UC-111	Configurar Preferências
UC-112	Enviar Comunicação Geral
UC-113	Agendar Comunicação
UC-114	Cancelar Comunicação
UC-115	Histórico de Comunicações
UC-116	Dashboard
UC-117	Exportar Histórico

12 – Configurações e Parametrizações
12.1 Introdução
Este módulo concentra todas as configurações que controlam o comportamento do GTP.
As configurações serão divididas em:
•	Globais (Desenvolvedor Geral)
•	Congregação
•	Usuário
Todas as alterações deverão ser auditadas.

12.2 Categorias de Configuração
Gerais
•	Nome da Congregação
•	Logotipo
•	Idioma
•	Fuso horário

Territórios
•	Prazo padrão de devolução
•	Permitir reservas
•	Limite de territórios
•	Controle por quadrante
•	Impressão automática

Publicações
•	Estoque mínimo
•	Controle de estoque
•	Inventário obrigatório
•	Categorias
•	Siglas

Pedidos
•	Aprovação obrigatória
•	Entrega parcial
•	Cancelamento
•	Quantidade máxima
•	Prazo

Campanhas
•	Participação automática
•	Limite de pedidos
•	Datas padrão
•	Notificações

Segurança
•	Tempo da sessão
•	Complexidade da senha
•	MFA (preparado para futuro)
•	Bloqueio por tentativas
•	Expiração da senha

UC-118 – Consultar Configurações
Objetivo
Visualizar os parâmetros do sistema.

UC-119 – Alterar Configurações Gerais
Permitir alterar parâmetros gerais.

UC-120 – Configurar Territórios
Permitir configurar regras operacionais dos territórios.

UC-121 – Configurar Publicações
Permitir configurar parâmetros do estoque.

UC-122 – Configurar Pedidos
Permitir definir regras de pedidos.

UC-123 – Configurar Campanhas
Permitir definir parâmetros das campanhas.

UC-124 – Configurar Segurança
Permitir alterar políticas de segurança.

UC-125 – Restaurar Configurações Padrão
Retornar aos parâmetros definidos pelo sistema.

UC-126 – Exportar Configurações
Gerar arquivo das parametrizações.


UC-127 – Importar Configurações
Importar configurações previamente exportadas.

UC-128 – Consultar Histórico de Configurações
Visualizar todas as alterações.

UC-129 – Gerenciar Categorias de Publicações
Cadastrar.
Editar.
Arquivar.
Consultar.

UC-130 – Gerenciar Tipos de Território
Administrar:
•	Urbano
•	Rural
•	Comercial
•	Misto

UC-131 – Gerenciar Situações
Administrar:
•	Usuários
•	Pedidos
•	Territórios
•	Campanhas
•	Publicações
UC-132 – Dashboard de Configurações
Indicadores administrativos.

12.3 Resumo do Capítulo
Código	Caso de Uso
UC-118	Consultar Configurações
UC-119	Alterar Configurações Gerais
UC-120	Configurar Territórios
UC-121	Configurar Publicações
UC-122	Configurar Pedidos
UC-123	Configurar Campanhas
UC-124	Configurar Segurança
UC-125	Restaurar Configurações
UC-126	Exportar Configurações
UC-127	Importar Configurações
UC-128	Histórico de Configurações
UC-129	Gerenciar Categorias
UC-130	Gerenciar Tipos de Território
UC-131	Gerenciar Situações
UC-132	Dashboard



	

13 – Relatórios e Indicadores
13.1 Introdução
O módulo Relatórios e Indicadores tem como objetivo transformar os dados operacionais do GTP em informações gerenciais que apoiem a tomada de decisão.
Os relatórios deverão permitir consultas operacionais, administrativas e estatísticas, sempre respeitando o perfil de acesso do usuário.
Os indicadores serão apresentados em dashboards interativos e atualizados em tempo real sempre que possível.

13.2 Objetivos do Módulo
•	Apoiar a administração da Congregação.
•	Acompanhar a utilização dos territórios.
•	Controlar o estoque de publicações.
•	Monitorar pedidos e campanhas.
•	Avaliar indicadores de desempenho.
•	Facilitar auditorias e inspeções.
•	Disponibilizar informações históricas.

13.3 Categorias de Relatórios
•	Administrativos
•	Operacionais
•	Estatísticos
•	Auditoria
•	Estoque
•	Territórios
•	Publicações
•	Pedidos
•	Campanhas
•	Usuários
•	Pessoas

UC-133 – Emitir Relatório de Territórios
Objetivo
Gerar relatório completo dos territórios da Congregação.
Informações
•	Territórios cadastrados
•	Disponíveis
•	Em utilização
•	Reservados
•	Em conferência
•	Arquivados
•	Histórico de utilização

UC-134 – Emitir Relatório de Publicações
Objetivo
Apresentar o estoque consolidado.
Informações
•	Estoque atual
•	Entradas
•	Saídas
•	Inventários
•	Ajustes
•	Estoque mínimo

UC-135 – Emitir Relatório de Pedidos
Objetivo
Consultar pedidos por diversos critérios.
Filtros
•	Tipo
•	Situação
•	Solicitante
•	Responsável
•	Período

UC-136 – Emitir Relatório de Campanhas
Objetivo
Consolidar informações das campanhas.
Indicadores
•	Participantes
•	Publicações distribuídas
•	Pedidos
•	Estoque consumido
•	Período

UC-137 – Emitir Relatório de Usuários
Objetivo
Consultar usuários cadastrados.

UC-138 – Emitir Relatório de Pessoas
Objetivo
Apresentar informações cadastrais da Congregação.
UC-139 – Emitir Relatório de Auditoria
Objetivo
Consultar eventos registrados na auditoria.
Filtros
•	Usuário
•	Data
•	Operação
•	Módulo
•	Severidade

UC-140 – Emitir Relatório de Estoque
Objetivo
Apresentar situação completa do estoque.

UC-141 – Consultar Dashboard Executivo
Objetivo
Apresentar um painel consolidado para o Administrador Geral.
Indicadores
•	Usuários ativos
•	Pedidos pendentes
•	Estoque
•	Campanhas
•	Territórios
•	Publicações
•	Alertas


UC-142 – Consultar Dashboard Operacional
Objetivo
Exibir indicadores específicos para cada área operacional.

UC-143 – Consultar Indicadores da Congregação
Objetivo
Apresentar métricas históricas.
Exemplos
•	Crescimento do estoque
•	Evolução dos pedidos
•	Utilização dos territórios
•	Campanhas realizadas

UC-144 – Comparar Períodos
Objetivo
Permitir comparação entre períodos distintos.

UC-145 – Exportar Relatórios
Objetivo
Exportar relatórios.
Formatos
•	PDF
•	Excel
•	CSV


UC-146 – Agendar Relatórios
Objetivo
Programar geração automática de relatórios.

UC-147 – Compartilhar Relatórios
Objetivo
Disponibilizar relatórios para usuários autorizados.

UC-148 – Gerenciar Favoritos
Objetivo
Permitir salvar consultas frequentemente utilizadas.

UC-149 – Consultar Histórico de Relatórios
Objetivo
Visualizar relatórios emitidos anteriormente.

UC-150 – Dashboard Geral do Sistema
Objetivo
Apresentar a visão consolidada do GTP.
Informações
•	Congregações
•	Usuários
•	Territórios
•	Estoque
•	Pedidos
•	Campanhas
•	Alertas
•	Auditorias

13.4 Resumo do Capítulo
Código	Caso de Uso
UC-133	Relatório de Territórios
UC-134	Relatório de Publicações
UC-135	Relatório de Pedidos
UC-136	Relatório de Campanhas
UC-137	Relatório de Usuários
UC-138	Relatório de Pessoas
UC-139	Relatório de Auditoria
UC-140	Relatório de Estoque
UC-141	Dashboard Executivo
UC-142	Dashboard Operacional
UC-143	Indicadores
UC-144	Comparar Períodos
UC-145	Exportar Relatórios
UC-146	Agendar Relatórios
UC-147	Compartilhar Relatórios
UC-148	Favoritos
UC-149	Histórico
UC-150	Dashboard Geral


14 – Integrações, Segurança Avançada e Regras Transversais
14.1 Introdução
Este capítulo reúne funcionalidades que sustentam toda a plataforma GTP e garantem segurança, integração e operação contínua.
São funcionalidades que não pertencem exclusivamente a um módulo, mas que impactam todo o sistema.

14.2 Áreas abrangidas
•	Segurança
•	Auditoria
•	Integrações
•	Backup
•	Logs
•	Monitoramento
•	APIs
•	Docker
•	Banco de Dados
•	Infraestrutura

UC-151 – Gerenciar Auditoria
Objetivo
Consultar e administrar os registros de auditoria do sistema.

UC-152 – Consultar Logs do Sistema
Objetivo
Permitir a visualização dos logs operacionais.
UC-153 – Exportar Auditoria
Objetivo
Exportar registros de auditoria.

UC-154 – Gerenciar Tokens JWT
Objetivo
Controlar emissão, renovação e revogação de tokens de autenticação.

UC-155 – Gerenciar Sessões
Objetivo
Monitorar sessões ativas.

UC-156 – Executar Backup
Objetivo
Realizar backup manual do banco de dados.

UC-157 – Restaurar Backup
Objetivo
Restaurar uma cópia de segurança.

UC-158 – Configurar Backup Automático
Objetivo
Definir políticas automáticas de backup.



UC-159 – Monitorar Serviços
Objetivo
Acompanhar o estado dos componentes do sistema.
Serviços
•	Backend
•	Frontend
•	PostgreSQL
•	Docker
•	APIs

UC-160 – Monitorar Integrações
Objetivo
Verificar a saúde das integrações externas.

UC-161 – Configurar Integrações
Objetivo
Cadastrar integrações futuras.
Exemplos
•	Serviço de e-mail
•	SMS
•	Mapas
•	Armazenamento em nuvem
•	APIs externas

UC-162 – Consultar Eventos de Segurança
Objetivo
Visualizar eventos relacionados à segurança.
UC-163 – Gerenciar Permissões Globais
Objetivo
Administrar permissões gerais do sistema.

UC-164 – Gerenciar Chaves de Segurança
Objetivo
Administrar certificados, chaves e segredos da aplicação.

UC-165 – Executar Diagnóstico do Sistema
Objetivo
Realizar verificações automáticas da infraestrutura.

UC-166 – Consultar Saúde da Aplicação
Objetivo
Apresentar indicadores de funcionamento.
Componentes
•	API
•	Banco
•	Cache (quando implementado)
•	Docker
•	Serviços

UC-167 – Gerenciar Ambientes
Objetivo
Administrar os ambientes de Desenvolvimento, Homologação e Produção.

UC-168 – Atualizar Sistema
Objetivo
Registrar e acompanhar atualizações da aplicação.

UC-169 – Consultar Histórico de Atualizações
Objetivo
Visualizar todas as versões implantadas.

UC-170 – Dashboard de Infraestrutura
Objetivo
Apresentar indicadores técnicos.
Indicadores
•	Uso de CPU
•	Memória
•	Disco
•	Banco
•	Sessões
•	APIs
•	Backups
•	Serviços

14.3 Resumo do Capítulo
Código	Caso de Uso
UC-151	Gerenciar Auditoria
UC-152	Consultar Logs
UC-153	Exportar Auditoria
UC-154	Gerenciar JWT
UC-155	Gerenciar Sessões
UC-156	Executar Backup
UC-157	Restaurar Backup
UC-158	Backup Automático
UC-159	Monitorar Serviços
UC-160	Monitorar Integrações
UC-161	Configurar Integrações
UC-162	Eventos de Segurança
UC-163	Permissões Globais
UC-164	Chaves de Segurança
UC-165	Diagnóstico
UC-166	Saúde da Aplicação
UC-167	Gerenciar Ambientes
UC-168	Atualizar Sistema
UC-169	Histórico de Atualizações
UC-170	Dashboard de Infraestrutura

15 - Conclusão Geral
15.1 Objetivo do Documento
O presente documento consolidou todos os Casos de Uso do Gestor de Territórios e Publicações (GTP), descrevendo as interações entre usuários e sistema para cada funcionalidade identificada durante o levantamento dos requisitos.
Cada Caso de Uso foi elaborado para representar o comportamento esperado do sistema, considerando os diferentes perfis de usuários, regras de negócio e fluxos operacionais.
Este documento complementa os seguintes artefatos do projeto:
•	Documento 00 – Introdução e Visão do Produto
•	Documento 01 – Modelo Conceitual do Domínio
•	Documento 02 – Requisitos Funcionais
•	Documento 03 – Regras de Negócio
Em conjunto, esses documentos estabelecem a base funcional para a arquitetura, implementação, testes e evolução do GTP.

15.2 Visão Geral dos Casos de Uso
Ao longo deste documento foram especificados 170 Casos de Uso, distribuídos pelos módulos do sistema.
Módulo	Casos de Uso
Autenticação	8
Congregações	10
Pessoas	10
Usuários	14
Territórios	17
Publicações	17
Pedidos	16
Campanhas	13
Notificações e Comunicação	12
Configurações e Parametrizações	15
Relatórios e Indicadores	18
Integrações, Segurança e Regras Transversais	20
Total Geral	170

15.3 Atores do Sistema
Os atores identificados durante a modelagem são:
Ator	Responsabilidade
Desenvolvedor Geral	Desenvolvimento, manutenção e evolução do GTP.
Administrador Geral	Administração global do sistema e parametrizações.
Superintendente de Serviço	Supervisão administrativa e operacional da Congregação.
Servo de Territórios	Gerenciamento dos territórios da Congregação.
Servo de Publicações	Controle do estoque, pedidos e distribuição de publicações.
Publicador	Solicitação de territórios, pedidos de publicações e consulta de informações.
Sistema GTP	Execução de processos automáticos, auditorias, notificações e integrações.

15.4 Matriz de Rastreabilidade
A rastreabilidade garante que todo requisito funcional possua regras de negócio e casos de uso associados.







Estrutura
Documento 02 (Requisitos Funcionais)
            │
            ▼
Documento 03 (Regras de Negócio)
            │
            ▼
Documento 04 (Casos de Uso)
            │
            ▼
Documento 05 (Arquitetura)
            │
            ▼
Implementação
            │
            ▼
Testes

15.5 Exemplo de Rastreabilidade
Requisito	Regra de Negócio	Caso de Uso
RF-001 – Autenticar usuário	RN-001	UC-001 – Realizar Login
RF-010 – Gerenciar Territórios	RN-032	UC-048 – Retirar Território
RF-020 – Controlar Publicações	RN-071	UC-063 – Registrar Entrada de Estoque
RF-030 – Gerenciar Pedidos	RN-110	UC-084 – Registrar Entrega do Pedido
RF-040 – Gerenciar Campanhas	RN-142	UC-097 – Iniciar Campanha
Observação: No Documento 05 ampliaremos essa matriz para relacionar também componentes de arquitetura, serviços, APIs e testes, permitindo rastrear cada funcionalidade desde o requisito até sua implementação.


15.6 Relacionamento entre os Documentos
Documento 00
      │
      ▼
Documento 01
      │
      ▼
Documento 02
      │
      ▼
Documento 03
      │
      ▼
Documento 04
      │
      ▼
Documento 05
      │
      ▼
Documento 06
      │
      ▼
Documento 07
      │
      ▼
Documento 08
      │
      ▼
Documento 09
      │
      ▼
Documento 10
      │
      ▼
Banco de Dados
      │
      ▼
Frontend
      │
      ▼
Backend

15.7 Convenções Utilizadas
Identificação
Prefixo	Significado
RF	Requisito Funcional
RN	Regra de Negócio
UC	Caso de Uso
API	Interface de Programação
DTO	Data Transfer Object
JWT	JSON Web Token
CRUD	Create, Read, Update e Delete

Padrões de Escrita
Todos os Casos de Uso seguem a mesma estrutura:
•	Objetivo;
•	Atores;
•	Pré-condições;
•	Fluxo Principal;
•	Fluxos Alternativos;
•	Fluxos de Exceção;
•	Pós-condições;
•	Regras Relacionadas.

15.8 Glossário
Termo	Definição
Congregação	Comunidade responsável pela administração dos territórios e publicações em sua área de atuação.
Território	Área geográfica designada para a pregação das boas novas.
Publicação	Material utilizado para distribuição e estudo.
Pedido	Solicitação de publicações por um publicador ou pela Congregação.
Campanha	Ação organizada para distribuição de publicações em um período específico.
Estoque	Quantidade disponível de publicações sob responsabilidade da Congregação.
Auditoria	Registro permanente das ações realizadas no sistema.
Dashboard	Painel de indicadores e informações gerenciais.

15.9 Critérios de Qualidade
Todos os Casos de Uso deverão atender aos seguintes critérios:
•	Clareza;
•	Objetividade;
•	Consistência;
•	Rastreabilidade;
•	Não ambiguidade;
•	Completude;
•	Padronização;
•	Reutilização.

15.10 Evolução Prevista
O GTP foi projetado para evoluir continuamente. Algumas funcionalidades planejadas para versões futuras incluem:
•	Aplicativo móvel (Android e iOS);
•	Funcionamento offline para territórios e pedidos;
•	Sincronização automática quando houver conexão;
•	Notificações push;
•	Integração com serviços de mapas;
•	Geração de QR Codes para territórios e pedidos;
•	Assinatura eletrônica de recebimento;
•	Dashboard analítico com gráficos avançados;
•	Módulo de documentos digitais;
•	Integração com serviços de armazenamento em nuvem;
•	Suporte a múltiplos idiomas.

15.11 Considerações Finais
O Documento 04 representa a consolidação funcional do GTP.
Com os 170 Casos de Uso documentados, todas as funcionalidades essenciais do sistema encontram-se especificadas de forma consistente e alinhadas aos requisitos e regras de negócio definidos anteriormente.
Este documento servirá como principal referência para:
•	desenvolvimento do backend;
•	desenvolvimento do frontend;
•	modelagem do banco de dados;
•	definição da API REST;
•	elaboração dos testes funcionais;
•	testes de integração;
•	homologação;
•	manutenção e evolução do sistema.




Resumo Geral 
Informação	Valor
Documento	Documento 04 – Casos de Uso
Versão	1.0
Status	Concluído
Total de Casos de Uso	170
Total de Módulos	12
Perfis de Usuário	7
Documento Relacionado	Documento 02 – Requisitos Funcionais
Documento Relacionado	Documento 03 – Regras de Negócio
Próximo Documento	Documento 05 – Arquitetura do Sistema


