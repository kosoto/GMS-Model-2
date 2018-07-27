package command;

import java.io.UnsupportedEncodingException;

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
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER : 
			System.out.println("회원 가입 진입");
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setPass(request.getParameter("pass"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setGender(request.getParameter("gender"));
			member.setAge(request.getParameter("age"));
			member.setRoll(request.getParameter("roll"));
			member.setTeamId(request.getParameter("teamid"));
			member.setSubject(ParamMap.getValues(request, "subject"));
			System.out.println("createCommond"+member);
			MemberServiceImpl.getInstance().createMember(member);
			System.out.println("회원가입 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
