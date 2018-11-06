package main;

import com.thoughtworks.xstream.XStream;

public class Testes {

	public static void main(String[] args) {
		
		Aula aula = new Aula();
		
		aula.setHtmlConteudo("<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"h1 {\r\n" + 
				"	font-family: sans-serif;\r\n" + 
				"	font-size: 30px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h2 {\r\n" + 
				"	font-family: sans-serif;\r\n" + 
				"	font-size: 16px;\r\n" + 
				"	font-style: italic;\r\n" + 
				"	font-weight: normal;\r\n" + 
				"	text-align: justify;\r\n" + 
				"	width: 700px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h3 {\r\n" + 
				"	font-family: sans-serif;\r\n" + 
				"	font-size: 20px;\r\n" + 
				"	font-weight: bold;\r\n" + 
				"	text-align: justify;\r\n" + 
				"	width: 700px;\r\n" + 
				"	margin-top: 35px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"p {\r\n" + 
				"	font-family: sans-serif;\r\n" + 
				"	font-size: 14px;\r\n" + 
				"	text-align: justify;\r\n" + 
				"	text-indent: 0px;\r\n" + 
				"	width: 700px;\r\n" + 
				"	\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"li {\r\n" + 
				"	font-family: sans-serif;\r\n" + 
				"	font-size: 14px;\r\n" + 
				"	text-align: justify;\r\n" + 
				"	text-indent: 0px;\r\n" + 
				"	width: 660px;\r\n" + 
				"	list-style-position: outside;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"img {\r\n" + 
				"	display: block;\r\n" + 
				"    margin-left: auto;\r\n" + 
				"    margin-right: auto;\r\n" + 
				"	margin-top: 10px;\r\n" + 
				"	margin-bottom;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>	\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"<h1>Do you WannaCry?</h1>\r\n" + 
				"<h2>\r\n" + 
				"Quando a Seguran�a da informa��o est� comprometida, n�o adiante chorar!\r\n" + 
				"Nesse estudo de caso falaremos do Malware mais impactante do s�culo XXI, o WannaCry.\r\n" + 
				"</h2>\r\n" + 
				"\r\n" + 
				"<h3> Ramsonwares </h3>\r\n" + 
				"<p>	\r\n" + 
				"<strong>Ransomwares s�o Malwares que exploram fragilidades dos SOs ou uso inseguro para infectar (silenciosamente) um sistema.</strong> \r\n" + 
				"A partir de um gatilho programado (ex: data e hora espec�ficas) criptografam os arquivos do computador e exigem resgate para realizar a descriptografia dos dados.	\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"A autoria desse Ransomware � desconhecida.\r\n" + 
				"Explora uma vulnerabilidade dos Sistemas Windows (a mesma largamente explorada pela NSA e, provavelmente, por outros �rg�os)\r\n" + 
				"Seu gatilho para criptografar os dados foi em 12/05/2017, mas se espalhava entre m�quinas a meses.\r\n" + 
				"Em mar�o de 2017(dois meses antes do ataque) a Microsoft liberou um patch de seguran�a corrigindo essa falha (ap�s Exploit divulgado pelo grupo Shadow Brokers), entretanto, um enorme n�mero de computadores (incluindo m�quinas de empresas) n�o realizam a atualiza��o.\r\n" + 
				"Ap�s o ataque, h� uma �corrida� de usu�rios em busca de atualiza��es de seguran�a do windows e aplicativos antimalwares.\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"Esta imagem mostra a abrang�ncia da infec��o do WannaCry at� o dia 15/05/2017:\r\n" + 
				"</p>\r\n" + 
				"<img src = \"C:\\Users\\Rafael\\Desktop\\teste aula\\imagens\\Screenshot_1.png\" width = \"450\" height = \"260\">\r\n" + 
				"<p>\r\n" + 
				"O WannaCry se espalha de dois modos: Em arquivo malicioso anexo em Emails ou pela propaga��o entre m�quinas interconectadas sem as devidas medidas de seguran�a.\r\n" + 
				"Em m�quinas infectadas, o v�rus exige pagamento de resgate em Bitcoins para que os dados fossem descriptografados.\r\n" + 
				"Os valores pedidos pelo resgate aumentar com o decorrer do tempo.\r\n" + 
				"O v�rus amea�a que os dados ser�o permanentemente criptografados ap�s 7 dias.\r\n" + 
				"</p>\r\n" + 
				"<h3>Programa WannaCry</h3>\r\n" + 
				"<p>\r\n" + 
				"Quando um computador � infectado, o plano de fundo da �rea de trabalho � alterado para uma imagem que diz que o computador est� infectado e d� instru��es do que fazer a seguir.\r\n" + 
				"O programa do WannaCry � executado com o sistema operacional, e sua tela � a seguinte:\r\n" + 
				"</p>\r\n" + 
				"<img src = \"C:\\Users\\Rafael\\Pictures\\Screenshots Allan\\imagens\\Screenshot_1.png\" width = \"450\" height = \"260\">\r\n" + 
				"<p>\r\n" + 
				"O WannaCry basicamente criptografa todos os arquivos do computador com extens�es conhecidas, colocando nesses arquivos a extens�o WCRY.\r\n" + 
				"</p>\r\n" + 
				"<h3>Boas pr�ticas para preven��o</h3>\r\n" + 
				"<ul>\r\n" + 
				"<li>Permitir o uso de portas de compartilhamento (portas SMB 139 e 445) apenas quando realmente necess�rio e somente para m�quinas interligadas na mesma rede;</li>\r\n" + 
				"<li>Manter uma pol�tica r�gida para E-mails (em especial com anexos) em ambientes corporativos;</li>\r\n" + 
				"<li>Utilizar somente sistemas operacionais com suporte ativo (vers�es mais recentes/LTS); </li>\r\n" + 
				"<li>Garantir que est� com a mais recente atualiza��o de seguran�a do SO; </li>\r\n" + 
				"<li>Utilizar um bom antiv�rus em sua vers�o mais atual para prote��o de vulnerabilidades D+0 (vulnerabilidades rec�m exploitadas, ainda sem corre��o por atualiza��o de seguran�a); </li>\r\n" + 
				"<li>Utilizar t�cnicas de navega��o segura; </li>\r\n" + 
				"<li>Permitir a usu�rios do sistema a navega��o somente em sites pertencentes a lista de confi�veis; </li>\r\n" + 
				"<li>N�o permitir a maioria dos usu�rios permiss�es especiais ao sistema. </li>\r\n" + 
				"<li>Manter backup atualizado e fisicamente separado de todos os documentos importantes; </li>\r\n" + 
				"<li>Isolar da rede toda m�quina que esteja ou aparente estar contaminada para verifica��o e tratamento necess�rio (que pode variar de varredura por antiv�rus a restaura��o do sistema); </li>\r\n" + 
				"</ul>\r\n" + 
				"<h3>Considera��es finais</h3>\r\n" + 
				"<p>\r\n" + 
				"Ransomwares n�o s�o amea�as recentes, entretanto o grande impacto do WannaCry (que embora n�o tenha faturado com resgates valores proporcionais ao alarde causado) servir� de incentivo a criminosos virtuais para o desenvolvimento de malwares semelhantes, explorando toda e qualquer vulnerabilidade de SO ou uso inseguro do sistema.\r\n" + 
				"As pol�ticas de seguran�a das institui��es devem contemplar a��es de preven��o a malwares, contemplando as particularidades de Ransomwares; Os planos de continuidade devem prever formas de lidar com eventuais ransomwares, garantindo a continuidade da opera��o SEM A REALIZA��O DE PAGAMENTOS DE RESGATE DE DADOS.\r\n" + 
				"NUNCA PAGUE RESGATES!\r\n" + 
				"As institui��es e usu�rios dom�sticos devem aprender e divulgar formas de preven��o. Pagamentos de resgates servem como incentivo ao desenvolvimento de novos ransomwares. \r\n" + 
				"</p>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		aula.setAnotacoes("N�o tenho anota��es por hoje.");
		
		AtividadeDissertativa atividade1 = new AtividadeDissertativa();
		atividade1.setTitulo("Pergunta 1");
		atividade1.setEnunciado("Para qual time voc� torce?");
		
		AtividadeMultiplaEscolha atividade2 = new AtividadeMultiplaEscolha();
		atividade2.setTitulo("Pergunta 2");
		atividade2.setEnunciado("Qual a resposta incorreta:");
		atividade2.addOpcao("A soma dos quadrados dos catetos � igual a porra da hipotenusa.");
		atividade2.addOpcao("Nenhum esquerdista � hip�crita.");
		atividade2.addOpcao("O Palmeiras tem mundial.");
		
		aula.addAtividade(atividade1);
		aula.addAtividade(atividade2);
		
		XStream xStream = new XStream();
		
		xStream.alias("aula", Aula.class);
		xStream.alias("dissertativa", AtividadeDissertativa.class);
		xStream.alias("multiplaescolha", AtividadeMultiplaEscolha.class);
		xStream.alias("selecionevarias", AtividadeMultiResposta.class);
		
		xStream.aliasField("conteudo", Aula.class, "htmlConteudo");
		
		String xml = xStream.toXML(aula);
		
		System.out.println(xml);
		
		Aula retrieved = (Aula) xStream.fromXML(xml);
		
		//System.out.println(retrieved.toString());
	}

}
