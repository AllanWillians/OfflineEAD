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
				"Quando a Segurança da informação está comprometida, não adiante chorar!\r\n" + 
				"Nesse estudo de caso falaremos do Malware mais impactante do século XXI, o WannaCry.\r\n" + 
				"</h2>\r\n" + 
				"\r\n" + 
				"<h3> Ramsonwares </h3>\r\n" + 
				"<p>	\r\n" + 
				"<strong>Ransomwares são Malwares que exploram fragilidades dos SOs ou uso inseguro para infectar (silenciosamente) um sistema.</strong> \r\n" + 
				"A partir de um gatilho programado (ex: data e hora específicas) criptografam os arquivos do computador e exigem resgate para realizar a descriptografia dos dados.	\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"A autoria desse Ransomware é desconhecida.\r\n" + 
				"Explora uma vulnerabilidade dos Sistemas Windows (a mesma largamente explorada pela NSA e, provavelmente, por outros órgãos)\r\n" + 
				"Seu gatilho para criptografar os dados foi em 12/05/2017, mas se espalhava entre máquinas a meses.\r\n" + 
				"Em março de 2017(dois meses antes do ataque) a Microsoft liberou um patch de segurança corrigindo essa falha (após Exploit divulgado pelo grupo Shadow Brokers), entretanto, um enorme número de computadores (incluindo máquinas de empresas) não realizam a atualização.\r\n" + 
				"Após o ataque, há uma “corrida” de usuários em busca de atualizações de segurança do windows e aplicativos antimalwares.\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"Esta imagem mostra a abrangência da infecção do WannaCry até o dia 15/05/2017:\r\n" + 
				"</p>\r\n" + 
				"<img src = \"C:\\Users\\Rafael\\Desktop\\teste aula\\imagens\\Screenshot_1.png\" width = \"450\" height = \"260\">\r\n" + 
				"<p>\r\n" + 
				"O WannaCry se espalha de dois modos: Em arquivo malicioso anexo em Emails ou pela propagação entre máquinas interconectadas sem as devidas medidas de segurança.\r\n" + 
				"Em máquinas infectadas, o vírus exige pagamento de resgate em Bitcoins para que os dados fossem descriptografados.\r\n" + 
				"Os valores pedidos pelo resgate aumentar com o decorrer do tempo.\r\n" + 
				"O vírus ameaça que os dados serão permanentemente criptografados após 7 dias.\r\n" + 
				"</p>\r\n" + 
				"<h3>Programa WannaCry</h3>\r\n" + 
				"<p>\r\n" + 
				"Quando um computador é infectado, o plano de fundo da área de trabalho é alterado para uma imagem que diz que o computador está infectado e dá instruções do que fazer a seguir.\r\n" + 
				"O programa do WannaCry é executado com o sistema operacional, e sua tela é a seguinte:\r\n" + 
				"</p>\r\n" + 
				"<img src = \"C:\\Users\\Rafael\\Pictures\\Screenshots Allan\\imagens\\Screenshot_1.png\" width = \"450\" height = \"260\">\r\n" + 
				"<p>\r\n" + 
				"O WannaCry basicamente criptografa todos os arquivos do computador com extensões conhecidas, colocando nesses arquivos a extensão WCRY.\r\n" + 
				"</p>\r\n" + 
				"<h3>Boas práticas para prevenção</h3>\r\n" + 
				"<ul>\r\n" + 
				"<li>Permitir o uso de portas de compartilhamento (portas SMB 139 e 445) apenas quando realmente necessário e somente para máquinas interligadas na mesma rede;</li>\r\n" + 
				"<li>Manter uma política rígida para E-mails (em especial com anexos) em ambientes corporativos;</li>\r\n" + 
				"<li>Utilizar somente sistemas operacionais com suporte ativo (versões mais recentes/LTS); </li>\r\n" + 
				"<li>Garantir que está com a mais recente atualização de segurança do SO; </li>\r\n" + 
				"<li>Utilizar um bom antivírus em sua versão mais atual para proteção de vulnerabilidades D+0 (vulnerabilidades recém exploitadas, ainda sem correção por atualização de segurança); </li>\r\n" + 
				"<li>Utilizar técnicas de navegação segura; </li>\r\n" + 
				"<li>Permitir a usuários do sistema a navegação somente em sites pertencentes a lista de confiáveis; </li>\r\n" + 
				"<li>Não permitir a maioria dos usuários permissões especiais ao sistema. </li>\r\n" + 
				"<li>Manter backup atualizado e fisicamente separado de todos os documentos importantes; </li>\r\n" + 
				"<li>Isolar da rede toda máquina que esteja ou aparente estar contaminada para verificação e tratamento necessário (que pode variar de varredura por antivírus a restauração do sistema); </li>\r\n" + 
				"</ul>\r\n" + 
				"<h3>Considerações finais</h3>\r\n" + 
				"<p>\r\n" + 
				"Ransomwares não são ameaças recentes, entretanto o grande impacto do WannaCry (que embora não tenha faturado com resgates valores proporcionais ao alarde causado) servirá de incentivo a criminosos virtuais para o desenvolvimento de malwares semelhantes, explorando toda e qualquer vulnerabilidade de SO ou uso inseguro do sistema.\r\n" + 
				"As políticas de segurança das instituições devem contemplar ações de prevenção a malwares, contemplando as particularidades de Ransomwares; Os planos de continuidade devem prever formas de lidar com eventuais ransomwares, garantindo a continuidade da operação SEM A REALIZAÇÃO DE PAGAMENTOS DE RESGATE DE DADOS.\r\n" + 
				"NUNCA PAGUE RESGATES!\r\n" + 
				"As instituições e usuários domésticos devem aprender e divulgar formas de prevenção. Pagamentos de resgates servem como incentivo ao desenvolvimento de novos ransomwares. \r\n" + 
				"</p>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		aula.setAnotacoes("Não tenho anotações por hoje.");
		
		AtividadeDissertativa atividade1 = new AtividadeDissertativa();
		atividade1.setTitulo("Pergunta 1");
		atividade1.setEnunciado("Para qual time você torce?");
		
		AtividadeMultiplaEscolha atividade2 = new AtividadeMultiplaEscolha();
		atividade2.setTitulo("Pergunta 2");
		atividade2.setEnunciado("Qual a resposta incorreta:");
		atividade2.addOpcao("A soma dos quadrados dos catetos é igual a porra da hipotenusa.");
		atividade2.addOpcao("Nenhum esquerdista é hipócrita.");
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
