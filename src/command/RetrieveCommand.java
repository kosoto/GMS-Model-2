package command;

public class RetrieveCommand extends Command{
	public RetrieveCommand(String domain,String action,String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
