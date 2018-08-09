package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class RemoveCommand extends Command {
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		MemberServiceImpl.getInstance()
		.remove((MemberBean) request.getSession().getAttribute("user"));
		request.getSession().invalidate();
	}
}
