package command;

public class MoveCommand extends Command{
	public MoveCommand(String domain,String action,String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
