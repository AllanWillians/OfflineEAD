package main;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PainelAtividades extends JPanel {
	
	private List<PainelAtividade> listaPaineis;
	
	public PainelAtividades() {
		this.setLayout(new GridBagLayout());	
		this.setBorder(new EmptyBorder(20, 20, 0, 0));
	}
	
	public void setAula(Aula aula) {
		GridBagConstraints p = new GridBagConstraints();
		p.gridx = 0;
		p.gridy = GridBagConstraints.RELATIVE;
		
		p.anchor = GridBagConstraints.WEST;
		p.ipady = 10;
		
		p.weighty = 0;
		p.weightx = 1;
		
		this.removeAll();
		
		JLabel titulo = new JLabel("Atividades");
		titulo.setFont(new Font(titulo.getFont().getFontName(), Font.BOLD, 20));
		this.add(titulo, p);
		
		if (aula.getAtividades() == null) {
			JLabel conteudo = new JLabel("Não há atividade para esta aula.");
			this.add(conteudo, p);
			
			return;
		}
	
		listaPaineis = new ArrayList<>();
		for (Atividade atividade : aula.getAtividades()) {
			if (atividade.getClass() == AtividadeDissertativa.class) {
				PainelAtividadeDissertativa painel = new PainelAtividadeDissertativa((AtividadeDissertativa) atividade);
				
				p.weighty = 1;
				this.add(painel, p);
				listaPaineis.add(painel);
				p.weighty = 0;
				
			} else if (atividade.getClass() == AtividadeMultiplaEscolha.class) { 
				PainelAtividadeMultiplaEscolha painel = new PainelAtividadeMultiplaEscolha((AtividadeMultiplaEscolha) atividade);
				this.add(painel, p);
				listaPaineis.add(painel);
				
			} else if (atividade.getClass() == AtividadeMultiResposta.class) {
				PainelAtividadeMultiResposta painel = new PainelAtividadeMultiResposta((AtividadeMultiResposta) atividade);
				this.add(painel, p);
				listaPaineis.add(painel);
				
			} else {
				this.add(new JLabel(atividade.getClass().toString()));
			}
		}
		
		repaint();
		revalidate();
	}
	
	public List<Atividade> getAtividades() {
		List<Atividade> atividades = new ArrayList<>();
		
		for (PainelAtividade painel : listaPaineis) {
			atividades.add(painel.getAtividade());
		}
		
		return atividades;
	}

}
