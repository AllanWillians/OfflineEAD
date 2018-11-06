package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PainelAnotacoes extends JPanel{
	
private JTextArea anotacoes;
private JTextArea duvidas;
	
	public PainelAnotacoes() {
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(20, 20, 0, 0));
		
		GridBagConstraints p = new GridBagConstraints();
		
		p.gridx = 0;
		p.gridy = GridBagConstraints.RELATIVE;
		
		p.anchor = GridBagConstraints.WEST;
		p.ipady = 10;
		
		p.weighty = 0;
		p.weightx = 1;
		
		p.fill = GridBagConstraints.VERTICAL;
		
		JLabel lblAnotacoes = new JLabel("Anotações");
		lblAnotacoes.setFont(new Font(lblAnotacoes.getFont().getFontName(), Font.BOLD, 20));
		this.add(lblAnotacoes, p);
		
		anotacoes = new JTextArea();
		anotacoes.setLineWrap(true);
		anotacoes.setWrapStyleWord(true);
		
		JScrollPane scrollAnotacoes = new JScrollPane(anotacoes);
		scrollAnotacoes.setPreferredSize(new Dimension(700, 200));
		
		p.weighty = 1;
		this.add(scrollAnotacoes, p);
		p.weighty = 0;
		
		JLabel lblDuvidas = new JLabel("Dúvidas");
		lblDuvidas.setFont(new Font(lblDuvidas.getFont().getFontName(), Font.BOLD, 20));
		this.add(lblDuvidas, p);
		
		duvidas = new JTextArea();
		duvidas.setLineWrap(true);
		duvidas.setWrapStyleWord(true);
		
		JScrollPane scrollDuvidas = new JScrollPane(duvidas);
		scrollDuvidas.setPreferredSize(new Dimension(700, 200));
		p.weighty = 1;
		this.add(scrollDuvidas, p);
	}
	
	public void setAula(Aula aula) {
		if (aula.getAnotacoes() != null) {
			anotacoes.setText(aula.getAnotacoes());
		}
		
		if (aula.getDuvidas() != null) {
			duvidas.setText(aula.getDuvidas());
		}
	}
	
	public String getDuvidas() {
		return duvidas.getText();
	}
	
	public String getAnotacoes() {
		return anotacoes.getText();
	}

}
