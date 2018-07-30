package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

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
		MemberBean member = 
				(MemberBean) request.getSession().getAttribute("user");
		String newPass = request.getParameter("newPass");
		System.out.println(member);
		if(!newPass.equals("") &&
			!newPass.equals(member.getPass())) {
			member.setPass(
					request.getParameter("newPass")
					);
			MemberServiceImpl.getInstance().updateMember(member);
		}
		String teamid = request.getParameter("teamid");
		System.out.println("팀아이디"+teamid);
		if(!teamid.equals("none")) {
			member.setTeamId(teamid);
			System.out.println("팀이름 바꾸러가기전"+member);
			MemberServiceImpl.getInstance().updateTeamid(member);
		}
		String roll = request.getParameter("roll");
		System.out.println("역할:"+roll);
		if(!roll.equals("none")) {
			member.setRoll(roll);
			System.out.println("역활 바꾸러가기전"+member);
			MemberServiceImpl.getInstance().updateRoll(member);
		}
		System.out.println("업데이트 성공");
		super.execute();
	}
}
