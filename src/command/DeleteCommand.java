package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("멤버 삭제 진입");
		MemberServiceImpl.getInstance().deleteMember((MemberBean) request.getSession().getAttribute("user"));
		System.out.println("멤버 삭제 성공");
		super.execute();
	}
}
