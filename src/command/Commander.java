package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Action;

public class Commander {
	public static Command order(
			HttpServletRequest request) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action")
				.toUpperCase())) {
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		case CREATE : 
		    cmd = new CreateCommand(request);
			break;
		case SEARCH: 
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			cmd = new RetrieveCommand(request);
			break;
		case COUNT : 
			cmd = new CountCommand(request);
			break;
		case UPDATE:
			cmd = new UpdateCommand(request);
			break;
		case DELETE:
			cmd = new DeleteCommand(request);
			break;
		case LOGIN: 
			cmd = new LoginCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}

}
