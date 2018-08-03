package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
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
		List<?> members ;
		if(!(request.getParameter("option")==null)) {
			members = MemberServiceImpl.getInstance().findSome(
					request.getParameter("table")+"/"+
					request.getParameter("option")+"/"+
					request.getParameter("word"));
		}else {
			members = MemberServiceImpl.getInstance().memberList();
		}
		request.setAttribute("count", MemberServiceImpl.getInstance().countMember());
		request.setAttribute("list", members);
		super.execute();
	}
}
