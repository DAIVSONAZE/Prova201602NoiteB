package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Aplicativo;
import dao.AplicativoDao;



	@WebServlet(urlPatterns = "/adicionaAplicativo")

	public class AdicionarAplicativoServlet extends HttpServlet {

		private static final long serialVersionUID = 7563781277786590359L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String tituloApp = request.getParameter("tituloApp");
			String descricao = request.getParameter("descricao");
			String autor = request.getParameter("autor");
			String quantidadeDownloads = request.getParameter("quantidadeDownloads");
			String valor = request.getParameter("valor");
			String dataLiberacao = request.getParameter("dataLiberacao");

			Aplicativo aplicativos = new Aplicativo();
			aplicativos.setTituloApp(tituloApp);
			aplicativos.setDescricao(descricao);
			aplicativos.setAutor(autor);
			aplicativos.setQuantidadeDownloads(Integer.parseInt(quantidadeDownloads));
			aplicativos.setValor(Float.parseFloat(valor));

			boolean ocorreuErroConversao = false;

			try {
				Date dataLibConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(dataLiberacao);
				aplicativos.setDataLiberacao(dataLibConvertida);
			} catch (ParseException e) {
				ocorreuErroConversao = true;
			}

			if (ocorreuErroConversao == false) {

				AplicativoDao apdao = new AplicativoDao();
				apdao.inserir(aplicativos);

				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("Brinquedo " + aplicativos.getDescricao() + " inserido com sucesso");
				out.println("</body>");
				out.println("</html>");

			} else {

				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("Data informada invalida!!!");
				out.println("</body>");
				out.println("</html>");

			}

		}

	}

