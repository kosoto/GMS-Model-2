package command;

import javax.servlet.http.HttpServletRequest;

public class FileCommand extends Command {

	public FileCommand(HttpServletRequest request) {
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
	}
	
}
