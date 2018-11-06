package main;

public class AtividadeDissertativa implements Atividade {

	private String titulo;
	private String enunciado;
	private String resposta;
	
	@Override
	public int getTipo() {
		return Atividade.TIPO_DISSERTATIVO;
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
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	@Override
	public String toString() {
		return titulo + "\n" + enunciado + "\n" + resposta;
	}
}
