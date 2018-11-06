package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;

@SuppressWarnings("serial")
public class OfflineEAD extends JFrame{
		
	private Aula aulaAtual;
	
	private List<Aula> aulasCarregadas;

	private JComboBox<String> cbAulas;
	private PainelConteudo panelConteudo;
	private PainelAtividades panelAtividades;
	private PainelAnotacoes panelAnotacoes;

	private JTabbedPane tbAula;
	private XStream xStream;

	private JButton btnSalvar;
	
	public static void main(String[] args) {
		
		OfflineEAD programa = new OfflineEAD();
		programa.iniciar();
	}

	private void iniciar() {
		
		//Método para definir a aparência do programa para a aparência padrão do sistema operacional.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//Inicialização do leitor de XML
		xStream = new XStream();
		xStream.alias("aula", Aula.class);
		xStream.alias("dissertativa", AtividadeDissertativa.class);
		xStream.alias("multiplaEscolha", AtividadeMultiplaEscolha.class);
		xStream.alias("multiResposta", AtividadeMultiResposta.class);
		
		xStream.aliasField("conteudo", Aula.class, "htmlConteudo");
		
		xStream.omitField(Aula.class, "arquivoXML");
		
		//Define o título da janela, tamanho e centraliza a janela na tela.
		this.setTitle("OfflineEAD");
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		//Painel de seleção é o que receberá os botões para selecionar a aula desejada.
		JPanel painelDeSelecao = new JPanel();
		
		FlowLayout layoutPainelDeSelecao = new FlowLayout();
		layoutPainelDeSelecao.setAlignment(FlowLayout.LEADING);
		
		painelDeSelecao.setLayout(layoutPainelDeSelecao);
		this.add(painelDeSelecao, BorderLayout.NORTH);
		
		JButton btnCarregarAula = new JButton("Carregar Nova Aula...");
		painelDeSelecao.add(btnCarregarAula);
		
		btnCarregarAula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				procurarXML();
			}
		});
		
		JLabel lblListaDeAulas = new JLabel("Lista de aulas carregadas:");
		painelDeSelecao.add(lblListaDeAulas);
		
		cbAulas = new JComboBox<>();
		painelDeSelecao.add(cbAulas);
		
		cbAulas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (aulaAtual.getTitulo() != cbAulas.getSelectedItem()) {
					for (Aula a : aulasCarregadas) {
						if (a.getTitulo().equals(cbAulas.getSelectedItem())) {
							setAulaAtual(a);
						}
					}
				}
				
			}
		});
		
		tbAula = new JTabbedPane();
		this.add(tbAula, BorderLayout.CENTER);
		
		panelConteudo = new PainelConteudo();
		JScrollPane scrollConteudo = new JScrollPane(panelConteudo);
		scrollConteudo.getVerticalScrollBar().setUnitIncrement(16);
		tbAula.addTab("Conteúdo", scrollConteudo);
		
		panelAtividades = new PainelAtividades();
		JScrollPane scrollAtividades = new JScrollPane(panelAtividades);
		scrollAtividades.getVerticalScrollBar().setUnitIncrement(16);
		tbAula.addTab("Atividades", scrollAtividades);
		
		panelAnotacoes = new PainelAnotacoes();
		JScrollPane scrollAnotacoes = new JScrollPane(panelAnotacoes);
		scrollAnotacoes.getVerticalScrollBar().setUnitIncrement(16);
		tbAula.addTab("Dúvidas e Anotações", scrollAnotacoes);
		
		
		JPanel panelSalvar = new JPanel();
		panelSalvar.setLayout(new GridBagLayout());
		panelSalvar.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		
		c.weightx = 1;
		
		c.anchor = GridBagConstraints.BASELINE_TRAILING;
		
		btnSalvar = new JButton("Salvar Alterações");
		btnSalvar.setEnabled(false);
		panelSalvar.add(btnSalvar, c);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				salvarAula();
				
			}
		});
		
		this.add(panelSalvar, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}

	private void salvarAula() {
		aulaAtual.setAtividades(panelAtividades.getAtividades());
		aulaAtual.setAnotacoes(panelAnotacoes.getAnotacoes());
		aulaAtual.setDuvidas(panelAnotacoes.getDuvidas());
		
		try {
			File arquivoXML = aulaAtual.getArquivoXML();
			
			FileOutputStream outStream = new FileOutputStream(arquivoXML);
			String stringXML = xStream.toXML(aulaAtual);
			outStream.write(stringXML.getBytes("UTF-8"));
			outStream.close();
			
			JOptionPane.showMessageDialog(this, "Alterações salvas.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possível salvar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void procurarXML() {
		JFileChooser selecionadorDeArquivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos XML", "xml");
		
		selecionadorDeArquivo.setFileFilter(filtro);
		
		int resultado = selecionadorDeArquivo.showOpenDialog(this);
		
		if (resultado == JFileChooser.APPROVE_OPTION) {
			Aula novaAula = new Aula();
			
			try {
				File arquivoNovaAula = selecionadorDeArquivo.getSelectedFile();
				
				novaAula = (Aula) xStream.fromXML(arquivoNovaAula);
				novaAula.setArquivoXML(arquivoNovaAula);
				
				addAula(novaAula);
				setAulaAtual(novaAula);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Houve um erro ao carregar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
				
				e.printStackTrace();
			}			
		}
	}
	
	private void setAulaAtual(Aula aula) {
		aulaAtual = aula;
		
		panelConteudo.setAula(aula);
		panelAtividades.setAula(aula);
		panelAnotacoes.setAula(aula);
		
		tbAula.setSelectedIndex(0);
		cbAulas.setSelectedItem(aula.getTitulo());
		btnSalvar.setEnabled(true);
	}

	public void addAula(Aula aula) {
		if (aulasCarregadas == null) aulasCarregadas = new ArrayList<>();
		
		if (aulaAtual == null) {
			aulaAtual = aula;
			setAulaAtual(aula);
		}
		
		if (aulasCarregadas.contains(aula)) {
			JOptionPane.showMessageDialog(this, "Uma aula com o mesmo título já está carregada no sistema.", "Atenção!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		aulasCarregadas.add(aula);
		cbAulas.addItem(aula.getTitulo());
	}
	
}
