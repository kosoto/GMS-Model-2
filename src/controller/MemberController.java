package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import command.*;
import enums.Action;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
			Carrier.forward(request, response);
			break;
		case CREATE :
			Carrier.redirect(request, response,
					"/member.do?action=move&page=user_login_form");
			break;
		case SEARCH :
			Carrier.redirect(request, response,
					"/member.do?action=move&page=search_team_result");
			break;
		case RETRIEVE :
			Carrier.redirect(request, response, 
					"/member.do?action=move&page=search_member_result");
			break;
		case COUNT :
			Carrier.redirect(request, response, "");
			break;
		case UPDATE :
			System.out.println("업데이트 컨트롤러 진입");
			Carrier.redirect(request, response, 
					"/member.do?action=move&page=my_page");
			break;
		case DELETE :
			System.out.println("삭제 컨트롤러 진입");
			Carrier.redirect(request, response,"");
			break;
		case LOGIN :
			System.out.println("로그인 컨트롤러 진입");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response, 
						"/member.do?action=move&page=user_login_form");
			}
			break;
		default:break;
		}
	}

}
