package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		System.out.println("센트리:"
				+servletPath.substring(1, servletPath.indexOf(".")));
		cmd = Commander.order(request);
		System.out.println("cmd : "+cmd);
	}
}
