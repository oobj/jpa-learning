package br.com.oobj.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.oobj.servico.FuncionarioServico;

@WebServlet(urlPatterns = {"/meuServlet"})
public class MeuServlet extends HttpServlet {

	private static final long serialVersionUID = -5898810828698910131L;
	
	@Inject
	private FuncionarioServico bean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("create")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			bean.criarFuncionario(Integer.parseInt(id), name, Long.parseLong(salary));
		}
		// ...
	}
}
