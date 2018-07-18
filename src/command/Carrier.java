package command;
import javax.servlet.http.*;

public class Carrier {
	public static void send(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("뷰:"+Sentry.cmd.getView());
		request
		.getRequestDispatcher(Sentry.cmd.getView())
		.forward(request, response);
		
	}
}
