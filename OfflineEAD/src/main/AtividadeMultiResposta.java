package main;

import java.util.List;

public class AtividadeMultiResposta implements Atividade{
	
	private String titulo;
	private String enunciado;
	private List<String> opcoes;
	private List<String> opcoesSelecionadas;
	
	@Override
	public int getTipo() {
		return Atividade.TIPO_SELECIONE_VARIAS;
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

	public void setOpcoes(List<String> opcoes) {
		this.opcoes = opcoes;
	}

	public List<String> getOpcoesSelecionadas() {
		return opcoesSelecionadas;
	}

	public void setOpcoesSelecionadas(List<String> opcoesSelecionadas) {
		this.opcoesSelecionadas = opcoesSelecionadas;
	}

}
