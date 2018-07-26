package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
	setRequest(request);
	setAction(request.getParameter("action"));
	setDomain(request.getServletPath().substring(1, 
			request.getServletPath().indexOf(".")));
	setPage(request.getParameter("page"));
	execute();
	}
	
	@Override
	public void execute() {
		System.out.println("업데이트 커맨드 진입");
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("userid"));
		member.setPass(
				request.getParameter("pass")+"/"+
				request.getParameter("newPass")
				);
		//MemberServiceImpl.getInstance().updateMember(member);
		System.out.println("업데이트 성공");
		super.execute();
	}
}
