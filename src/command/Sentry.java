package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
	}
}
