package main;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PainelAtividadeMultiplaEscolha extends JPanel implements PainelAtividade {
	
	private AtividadeMultiplaEscolha atividade;
	
	private List<JRadioButton> listaBotoes = new ArrayList<>();
	
	public PainelAtividadeMultiplaEscolha(AtividadeMultiplaEscolha atividade) {
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
		
		if (atividade.getOpcaoSelecionada() == null) {
			atividade.setOpcaoSelecionada("");
		}
		
		ButtonGroup grupo = new ButtonGroup();
		
		for (String s : atividade.getOpcoes()) {
			JRadioButton radioButton = new JRadioButton(s);
			grupo.add(radioButton);
			
			if (atividade.getOpcaoSelecionada().equals(s)) {
				radioButton.setSelected(true);
			}
			
			this.add(radioButton);
			this.add(Box.createRigidArea(new Dimension(5, 5)));
			
			listaBotoes.add(radioButton);
		}
	}
	
	public Atividade getAtividade() {
		for (JRadioButton botao : listaBotoes) {
			if (botao.isSelected()) {
				atividade.setOpcaoSelecionada(botao.getText());
			}
		}
		
		return atividade;
	}

}
