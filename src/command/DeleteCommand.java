package command;

public class DeleteCommand extends Command {
	public DeleteCommand(String domain,String action, String page) {
	setAction(action);
	setDomain(domain);
	setPage(page);
	execute();
	}
}
