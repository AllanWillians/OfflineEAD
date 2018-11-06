package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Aula {
	
	private File arquivoXML;
	
	private String titulo;
	private String htmlConteudo;
	private String anotacoes;
	private String duvidas;
	private List<Atividade> atividades;
	
	public File getArquivoXML() {
		return arquivoXML;
	}
	
	public void setArquivoXML(File xmlFile) {
		this.arquivoXML = xmlFile;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getHtmlConteudo() {
		return htmlConteudo;
	}
	
	public void setHtmlConteudo(String htmlConteudo) {
		this.htmlConteudo = htmlConteudo;
	}
	
	public String getAnotacoes() {
		return anotacoes;
	}
	
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	public String getDuvidas() {
		return duvidas;
	}
	
	public void setDuvidas(String duvidas) {
		this.duvidas = duvidas;
	}
	
	public List<Atividade> getAtividades() {
		return atividades;
	}
	
	public void setAtividades(List<Atividade> list) {
		this.atividades = list;
	}
	
	public void addAtividade(Atividade atividade) {
		if (atividades == null) atividades = new ArrayList<>();
		
		this.atividades.add(atividade);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj.getClass().equals(this.getClass())) {
			Aula comparacao = (Aula) obj;
			
			if (comparacao.getTitulo().equals(this.getTitulo())) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
