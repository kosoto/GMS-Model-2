package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import enums.Action;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
			System.out.println("admin컨트롤러 무브케이스");
			Carrier.forward(request, response);
			break;
		case SEARCH : 
			System.out.println("admin컨트롤러 서치케이스");
			Carrier.redirect(request, response, 
					"/admin.do?action=move&page=memberList");
			break;
		case RETRIEVE : 
			Carrier.redirect(request, response, "url");
			break;
		default:
			break;
		
		}
	}
	

}
