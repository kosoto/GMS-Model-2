package command;

public class SearchCommand extends Command{
	public SearchCommand(String domain,String action,String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
