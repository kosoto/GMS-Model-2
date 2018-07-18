package command;

public class LoginCommand extends Command {
	public LoginCommand(String domain, String action,String page) {
		setAction(action);
		setDomain(domain);
		setPage(page);
		execute();
	}
}
