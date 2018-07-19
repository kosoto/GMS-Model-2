package controller;


import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.*;
import domain.*;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			Carrier.redirect(request, response, 
					"/member.do?action=move&page=my_page");
			break;
		default:break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
