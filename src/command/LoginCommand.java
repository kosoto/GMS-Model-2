package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(
				request.getServletPath().substring(1,
						request.getServletPath().indexOf("."))
				);
		setPage("my_page");
		execute();
	}
	
	@Override
	public void execute() {
		super.execute();
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("userid"));
		member.setPass(request.getParameter("pass"));
		if(MemberServiceImpl.getInstance().login(member)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", //세션에 담기
					MemberServiceImpl.getInstance()
					.retrieve(
							"member/mem_id/"+
							request.getParameter("userid")
							));
			
		}else {
			request.setAttribute("match", "FALSE");
		}
		
		
	}
}
