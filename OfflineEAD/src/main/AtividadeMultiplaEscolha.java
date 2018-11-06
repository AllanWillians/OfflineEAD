package main;

import java.util.ArrayList;
import java.util.List;

public class AtividadeMultiplaEscolha implements Atividade {

	private String titulo;
	private String enunciado;
	private List<String> opcoes;
	private String opcaoSelecionada;
	
	@Override
	public int getTipo() {
		return Atividade.TIPO_MULTIPLA_ESCOLHA;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<String> getOpcoes() {
		return opcoes;
	}

	public void addOpcao(String opcao) {
		if (opcoes == null) opcoes = new ArrayList<>();
		
		this.opcoes.add(opcao);
	}

	public String getOpcaoSelecionada() {
		return opcaoSelecionada;
	}

	public void setOpcaoSelecionada(String opcaoSelecionada) {
		this.opcaoSelecionada = opcaoSelecionada;
	}

}
