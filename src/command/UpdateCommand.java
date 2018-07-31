package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
	setRequest(request);
	setAction(request.getParameter("action"));
	execute();
	}
	
	@Override
	public void execute() {
		MemberBean member = 
				(MemberBean) request.getSession().getAttribute("user");
		member.setPass(request.getParameter("newPass"));
		member.setTeamId(request.getParameter("teamid"));
		member.setRoll(request.getParameter("roll"));
		MemberServiceImpl.getInstance().updateMember(member);
	}
}
