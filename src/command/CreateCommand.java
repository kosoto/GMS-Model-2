package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1, 
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER : 
			System.out.println("회원 가입 진입");
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("user-id"));
			member.setPass(request.getParameter("pass"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			//MemberServiceImpl.getInstance().createMember(member);
			System.out.println("회원가입 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
