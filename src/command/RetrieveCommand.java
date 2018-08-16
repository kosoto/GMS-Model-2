package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.ImageServiceImpl;
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
		super.execute();
		if(request.getParameter("table") != null) {
			request.getSession().setAttribute("user", 
					MemberServiceImpl
					.getInstance()
					.retrieve(
							request.getParameter("table")+"/"+
							request.getParameter("option")+"/"+
							request.getParameter("word")
							)
					);
		}
		
		request.getSession().setAttribute("profile", 
						"/upload/"
						+(ImageServiceImpl.getInstance().retrieve(
						((MemberBean)(request.getSession().getAttribute("user"))).getMemberId()
						))
					);
	}
}
