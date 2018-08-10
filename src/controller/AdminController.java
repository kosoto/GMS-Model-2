package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case SEARCH : 
			Carrier.forward(request, response);
			break;
		case RETRIEVE : 
			Carrier.forward(request, response);
			break;
		case MOVE : 
			Carrier.forward(request, response);
			break;
		default:
			break;
		
		}
	}
	

}
