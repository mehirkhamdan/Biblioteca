package br.edu.ifpr.entidades;

import java.util.Date;
import java.util.UUID;

public class Livro {
	private String id;
	private String nome;
	private Date dataCadastro;
	private StatusLivro status;
	private Autor autor;
	
	public Livro() {
		this.id = UUID.randomUUID().toString();
		this.dataCadastro = new Date();
		this.status = StatusLivro.DISPONIVEL;
	    this.autor = new Autor();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public StatusLivro getStatus() {
		return status;
	}
	public void setStatus(StatusLivro status) {
		this.status = status;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	

}
