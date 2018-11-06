package main;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit;

@SuppressWarnings("serial")
public class PainelConteudo extends JPanel {
	
	private JLabel conteudo;
	
	public PainelConteudo() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(20, 20, 0, 0));
		
		conteudo = new JLabel();
		this.add(conteudo, BorderLayout.CENTER);
	}
	
	public void setAula(Aula aula) {
		//Criamos um arquivo que representa a pasta na qual o arquivo XML da aula está guardado.
		File pasta = aula.getArquivoXML().getParentFile();
		
		//Nesta string, é salvo o caminho da pasta que contém o arquivo XML no formato URI.
		String uriPasta = pasta.toURI().toString();
		
		//Por fim, substituímos todas as ocorrências
		//da string img src = " no texto HTML que representa o conteúdo da aula
		//pela string img src = " mais a URI da pasta. Desta forma,
		String html = aula.getHtmlConteudo().replaceAll("img src = \"", "img src = \"" + uriPasta);
		
		conteudo.setText(html);
		System.out.println(html);
		
		repaint();
		revalidate();
	}

}
