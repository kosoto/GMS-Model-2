package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {
	public ModifyCommand(HttpServletRequest request) {
	setRequest(request);
	setAction(request.getParameter("action"));
	setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
	execute();
	}
	
	@Override
	public void execute() {
		super.execute();
		MemberBean member = 
				(MemberBean) request.getSession().getAttribute("user");
		
		if(!request.getParameter("newPass").equals("")) {
			member.setPass(request.getParameter("newPass"));
		}
		
		member.setTeamId(
				((request.getParameter("teamid") != null)?
						request.getParameter("teamid")
						:((MemberBean)request.getSession().getAttribute("user")).getTeamId())
				.toUpperCase()
		);
		
		member.setRoll(request.getParameter("roll"));
		Map<String,Object> map = new HashMap<>();
		map.put("member", member);
		MemberServiceImpl.getInstance().modify(map);
	}
}
