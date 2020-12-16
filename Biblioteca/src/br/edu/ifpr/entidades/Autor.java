package br.edu.ifpr.entidades;

import java.util.UUID;

public class Autor {
	
	private String id;
	private String autorNome;
	
	
	public Autor(String id, String AutorNome, String Autorome) {
		this.id = UUID.randomUUID().toString();
		this.autorNome = AutorNome;
	}
	public Autor() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAutorNome() {
		return autorNome;
	}
	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}
	
	
	
	

}
