package br.edu.ifpr.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.entidades.Livro;
import br.edu.ifpr.entidades.StatusLivro;



public class LivroRepositorioMemoria implements ILivroRepositorio{
	
	private static List<Livro> livros = new ArrayList<Livro>();
	
	@Override
	public List<Livro> buscarTodos(){
		return livros;
	}
	
	@Override
public Livro buscarPorId(String id) throws IllegalArgumentException {
		
		for (Livro livro : livros) {
			if(id.equals(livro.getId())) {
				return livro;
			}
		}
		
		throw new IllegalArgumentException("id inexistente");
	}

	@Override
	public Livro cadastrar(Livro livro) throws IllegalArgumentException {
		if(livro.getNome() == null || livro.getNome().isEmpty()) {
			
			throw new IllegalArgumentException("O nome da livro nao pode ser vazio");
			
		}else if(livro.getNome().length() <3) {
			
			throw new IllegalArgumentException("O nome da livro nao pode ter menos que 3 caracteres");
			
		}
		
		livros.add(livro);
		
		
		return livro;
	}

	@Override
	public void alterarStatus(String id, String status) throws IllegalArgumentException {
		
		Livro livro = this.buscarPorId(id);
		
		switch(status) {
		case "disponivel":
		    livro.setStatus(StatusLivro.DISPONIVEL);
		    break;
		
		
		case "emprestado":
			livro.setStatus(StatusLivro.EMPRESTADO);
			break;
			
			default:
				throw new IllegalArgumentException("Status inválido");			
			
		}
				
	}

	@Override
	public void excluir(String id) {
		
		for(int index = 0; index < livros.size(); index++) {
			
			Livro livro = livros.get(index);
			
			if(livro.getId().equals(id)) {
				livros.remove(index);
				
			}
			
		}
		
	}
	
	
	
	
	
	

}
