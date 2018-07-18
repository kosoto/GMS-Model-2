package command;

public class CreateCommand extends Command{
	public CreateCommand(String domain,String action,String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
