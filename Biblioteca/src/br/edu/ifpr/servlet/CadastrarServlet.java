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

@WebServlet("/livros/cadastrar")
public class CadastrarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomeLivro = req.getParameter("inputNomeLivro");
		String nomeAutor = req.getParameter("inputNomeAutor");
		
		Livro livro = new Livro();
		livro.setNome(nomeLivro);
		livro.getAutor().getAutorNome();
		
		
		try {
			repositorio.cadastrar(livro);
			resp.sendRedirect("/Biblioteca");
			
		}catch(IllegalArgumentException e) {
			
			req.setAttribute("erros", e.getMessage());
			RequestDispatcher disp = req.getRequestDispatcher("/Biblioteca");
			disp.forward(req,resp);
		}		
		
	}	

}
