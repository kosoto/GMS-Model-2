package controller;


import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Creator;
import command.Sentry;
import domain.MemberBean;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		MemberBean member = null;
		List<MemberBean> list = null;
		
		System.out.println("멤버 컨트롤러 진입");
		Sentry.init(request);
		System.out.println("액션: "+Sentry.cmd.getAction());
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
			System.out.println("무브 안으로 진입");
			try {
				Carrier.send(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case CREATE :
			System.out.println("createMember안으로 진입");
			/*try {
				Creator.create(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			member = new MemberBean();
			member.setMemberId(request.getParameter("user-id"));
			member.setPass(request.getParameter("pass"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			//MemberServiceImpl.getInstance().createMember(member);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=user_login_form"
					);
			break;
		case LIST :
			list = new ArrayList<>();
			list = MemberServiceImpl.getInstance().memberList();
			System.out.println(list.size());
			break;
		case SEARCH :
			list = new ArrayList<>();
			list = MemberServiceImpl.getInstance().findByTeamId(request.getParameter("team_id"));
			System.out.println(list.size());
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=search_team_result");
			break;
		case RETRIEVE :
			String name = MemberServiceImpl.getInstance().findById(request.getParameter("user_id")).getName();
			System.out.println(name);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=search_member_result");
			break;
		case COUNT :
			MemberServiceImpl.getInstance().countMember();
			break;
		case UPDATE :
			member = new MemberBean();
			member.setMemberId(request.getParameter("user-id"));
			member.setPass(
					request.getParameter("pass")+"/"+
					request.getParameter("newPass")
					);
			//MemberServiceImpl.getInstance().updateMember(member);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=my_page");

			break;
		case DELETE :
			member = new MemberBean();
			member.setMemberId(request.getParameter("user-id"));
			member.setPass(request.getParameter("pass"));
			//MemberServiceImpl.getInstance().deleteMember(member);
			response.sendRedirect(request.getContextPath());
			break;
		case LOGIN :
			member = new MemberBean();
			member.setMemberId(request.getParameter("user-id"));
			member.setPass(request.getParameter("pass"));
			if(MemberServiceImpl.getInstance().login(member)) {
				System.out.println("로그인 성공");
				response.sendRedirect(request.getContextPath()
						+"/member.do?action=move&page=my_page"
						); 
			}else {
				System.out.println("로그인 실패");
				response.sendRedirect(request.getContextPath()
						+"/member.do?action=move&page=user_login_form"
						);  
			}
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
