package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		List<MemberBean> members = new ArrayList<>();
		if(!(request.getParameter("team_id")==null)) {
			members = MemberServiceImpl.getInstance().findByTeamId(
					request.getParameter("team_id"));
		}else {
			members = MemberServiceImpl.getInstance().memberList();
		}
		request.setAttribute("list", members);
		super.execute();
	}
}
