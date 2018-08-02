package command;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("리트리버 커맨드 테이블 :"+request.getParameter("table"));
		System.out.println("리드리버 커맨드 옵션 : "+request.getParameter("option"));
		request.setAttribute("user", 
				MemberServiceImpl
				.getInstance()
				.findById(
						request.getParameter("table")+"/"+
						request.getParameter("option")+"/"+
						request.getParameter("word")
						)
				);
		super.execute();
	}
}
