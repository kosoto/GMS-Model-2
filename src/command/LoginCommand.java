package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(
				request.getServletPath().substring(1,
						request.getServletPath().indexOf("."))
				);
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		super.execute();
		System.out.println("로그인 진입");
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("user-id"));
		member.setPass(request.getParameter("pass"));
		if(MemberServiceImpl.getInstance().login(member)) {
			request.setAttribute("match", "TRUE");
			request.setAttribute("user", 
					MemberServiceImpl.getInstance()
					.findById(
							request.getParameter("user-id")));
			
		}else {
			request.setAttribute("match", "FALSE");
		}
		
		
	}
}
