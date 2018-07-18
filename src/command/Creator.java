package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberBean;
import service.MemberServiceImpl;

public class Creator {
	public static void create(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("creator 뷰:"+Sentry.cmd.getView());
		MemberBean member = new MemberBean();
		System.out.println("creator ID : "+member.getMemberId());
		member.setMemberId(request.getParameter("user-id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setSsn(request.getParameter("ssn"));
		System.out.println("creator : "+member.toString());
		//MemberServiceImpl.getInstance().createMember(member);
		/*request
		.getRequestDispatcher(Sentry.cmd.getView())
		.forward(request, response);*/
	}
}
