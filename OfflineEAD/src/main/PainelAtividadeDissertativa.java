package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PainelAtividadeDissertativa extends JPanel implements PainelAtividade {
	
	private AtividadeDissertativa atividade;
	private JTextArea resposta;
	
	public PainelAtividadeDissertativa(AtividadeDissertativa atividade) {
		this.atividade = atividade;
		
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		GridBagConstraints p = new GridBagConstraints();
		p.gridx = 0;
		p.gridy = GridBagConstraints.RELATIVE;
		p.ipady = 10;
		p.anchor = GridBagConstraints.BASELINE_LEADING;
		p.weightx = 1;
		
		JLabel titulo = new JLabel(atividade.getTitulo());
		titulo.setFont(new Font(titulo.getFont().getFontName(), Font.PLAIN, 16));
		this.add(titulo, p);
		
		JLabel enunciado = new JLabel(atividade.getEnunciado());
		this.add(enunciado, p);
		
		resposta = new JTextArea();
		resposta.setLineWrap(true);
		resposta.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(resposta);
		scroll.setPreferredSize(new Dimension(700, 100));
		
		p.weighty = 1;
		this.add(scroll, p);
		
		if (atividade.getResposta() != null) {
			resposta.setText(atividade.getResposta());
		}
	}
	
	public AtividadeDissertativa getAtividade() {
		atividade.setResposta(resposta.getText());
		
		return atividade;
	}

}
