package command;

public class UpdateCommand extends Command {
	public UpdateCommand(String domain, String action,String page) {
	setAction(action);
	setDomain(domain);
	setPage(page);
	execute();
	}
}
