package command;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class CountCommand extends Command {
	int count;
	public int getCount() {
		return count;
	}
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute("count",
				MemberServiceImpl.getInstance().count());
		super.execute();
	}
}
