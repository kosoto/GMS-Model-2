package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD :
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case SEARCH :
			Carrier.forward(request, response);
			break;
		case RETRIEVE :
			Carrier.forward(request, response);
			break;
		case COUNT :
			Carrier.redirect(request, response, "");
			break;
		case MODIFY : 
			Carrier.forward(request, response);
			break;
		case REMOVE :
			Carrier.redirect(request, response, 
					(request.getAttribute("match") != null)?
							"/member.do?action=retrieve&page=main"
							:""
					);
			break;
		case FILEUPLOAD : 
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=main");
			break;
		case MOVE : 
			Carrier.forward(request, response);
			break;
		case LOGIN :
			if(request.getAttribute("match") != null) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response, 
						"/member.do?action=move&page=login");
			}
			break;
		default:break;
		}
	}

}
