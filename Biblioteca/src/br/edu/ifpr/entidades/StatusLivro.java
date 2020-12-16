package br.edu.ifpr.entidades;

public enum StatusLivro {
	DISPONIVEL("disponivel"),
	EMPRESTADO("emprestado"),;
	
	private final String status;

	StatusLivro(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
