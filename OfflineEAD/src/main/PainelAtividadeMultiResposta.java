package main;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PainelAtividadeMultiResposta extends JPanel implements PainelAtividade {
	
	private AtividadeMultiResposta atividade;
	
	private List<JCheckBox> listaBotoes = new ArrayList<>();
	
	public PainelAtividadeMultiResposta(AtividadeMultiResposta atividade) {
		this.atividade = atividade;
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JLabel titulo = new JLabel(atividade.getTitulo());
		titulo.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		titulo.setFont(new Font(titulo.getFont().getFontName(), Font.PLAIN, 16));
		this.add(titulo);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		
		JLabel enunciado = new JLabel(atividade.getEnunciado());
		enunciado.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		this.add(enunciado);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		
		if (atividade.getOpcoesSelecionadas() == null) {
			atividade.setOpcoesSelecionadas(new ArrayList<>());;
		}
		
		for (String s : atividade.getOpcoes()) {
			JCheckBox checkBox = new JCheckBox(s);
			
			if (atividade.getOpcoesSelecionadas().contains(s)) {
				checkBox.setSelected(true);
			}
			
			this.add(checkBox);
			this.add(Box.createRigidArea(new Dimension(5, 5)));
			
			listaBotoes.add(checkBox);
		}
	}
	
	public Atividade getAtividade() {
		List<String> opcoesSelecionadas = new ArrayList<>();
		
		for (JCheckBox botao : listaBotoes) {
			if (botao.isSelected()) {
				opcoesSelecionadas.add(botao.getText());
			}
		}
		
		atividade.setOpcoesSelecionadas(opcoesSelecionadas);
		
		return atividade;
	}

}
