package com.github.dmmaycon.programa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroServelet
 */
@WebServlet(
		name = "/CadastroServelet",
		urlPatterns = "/cadastro"
)
public class CadastroServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("Veio via GET");
		
		String email = req.getParameter("email");
		String nome  = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		
		
		writer.write("<br>Nome: " + nome + " Email: " + email + " Tlefone: " + telefone);
		
		writer.close();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String nome  = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		
		
		req.setAttribute("nome", nome);
		req.setAttribute("email", email);
		req.setAttribute("telefone", telefone);
		req.getRequestDispatcher("jsp-cadastro.jsp").forward(req, resp);
	}

}
