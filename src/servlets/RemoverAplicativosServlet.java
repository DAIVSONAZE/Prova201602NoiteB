package servlets;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AplicativoDao;

@WebServlet(urlPatterns = "/removerAplicativos")

public class RemoverAplicativosServlet extends HttpServlet  {
	
	
	

	 

		private static final long serialVersionUID = 7563781277786590359L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String id = request.getParameter("id");

			AplicativoDao dao = new AplicativoDao();
			dao.remover(Integer.parseInt(id));

			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Brinquedo Removido com Sucesso!");
			out.println("<a href=\"adicionaAplicativo.html\">Voltar a Adicionar</a><br><br><br><br>");
			out.println("</body>");
			out.println("</html>");
			
			
			
	}

}
	

