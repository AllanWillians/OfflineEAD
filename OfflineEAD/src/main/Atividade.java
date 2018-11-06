package main;

public interface Atividade {
	
	public static final int TIPO_DISSERTATIVO = 0;
	public static final int TIPO_MULTIPLA_ESCOLHA = 1;
	public static final int TIPO_SELECIONE_VARIAS = 2;
	
	public int getTipo();

}
