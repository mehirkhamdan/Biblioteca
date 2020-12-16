package br.edu.ifpr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.entidades.Livro;
import br.edu.ifpr.repositorio.ILivroRepositorio;
import br.edu.ifpr.repositorio.LivroRepositorioMemoria;

@WebServlet({"/livros","/livros/listar"})
public class ListarServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	
	@Override
	public void init() throws ServletException {
		
		Livro livro1 = new Livro();
		livro1.setNome("Dom Quixote");
		livro1.getAutor().setAutorNome("Miguel de Cervantes");
		repositorio.cadastrar(livro1);
		
		Livro livro2 = new Livro();
		livro2.setNome("O Conde de Monte Cristo");
		livro2.getAutor().setAutorNome("Alexandre Dumas");
		repositorio.cadastrar(livro2);
		
		Livro livro3 = new Livro();
		livro3.setNome("Cabe�a de Vaca");
		livro3.getAutor().setAutorNome("Paulo Markum");
		repositorio.cadastrar(livro3);
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("livroLivros", repositorio.buscarTodos());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}

}
