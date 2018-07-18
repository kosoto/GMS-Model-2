package command;

import enums.Action;

public class Commander {
	public static Command order(
			String domain,String action,String page) {
		Command cmd = null;
		System.out.println("commander.order() 진입");
		System.out.println(Action.valueOf(action.toUpperCase()));
		switch(Action.valueOf(action.toUpperCase())) {
		case MOVE:
			System.out.println("---무브진입---");
			cmd = new MoveCommand(domain,action,page);
			break;
		case CREATE : 
			System.out.println("---createMember진입---");
			cmd = new CreateCommand(domain, action, page);
			break;
		case LIST: 
			cmd = new ListCommand(domain, action, page);
			break;
		case SEARCH: 
			cmd = new SearchCommand(domain, action, page);
			break;
		case RETRIEVE:
			cmd = new RetrieveCommand(domain, action, page);
			break;
		case COUNT: 
			cmd = new CountCommand(domain, action, page);
			break;
		case UPDATE:
			cmd = new UpdateCommand(domain, action, page);
			break;
		case DELETE:
			cmd = new DeleteCommand(domain, action, page);
			break;
		case LOGIN: 
			cmd = new LoginCommand(domain, action, page);
			break;
		default:
			break;
		}
		return cmd;
	}

}
