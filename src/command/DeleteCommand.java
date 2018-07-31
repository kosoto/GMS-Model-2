package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		MemberServiceImpl.getInstance()
		.deleteMember((MemberBean) request.getSession().getAttribute("user"));
		request.getSession().invalidate();
	}
}
