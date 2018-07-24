package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CONTEXT,CSS,JS,IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		for(Resources r : Resources.values()) {
			request.getSession()
			.setAttribute(
					r.toString().toLowerCase(),
					request.getContextPath()+
						((i==0)?
						"":
						Term.RESOURCES.toString()
						+r.toString().toLowerCase()
						)
					);
			i++;
		}
		/*request.getSession().
		setAttribute(Term.CONTEXT.toString(),
				request.getContextPath());*/
		request.getRequestDispatcher(
				Term.WEBPATH.toString()+
				Term.MAIN.toString())
		.forward(request, response);
	}
}
