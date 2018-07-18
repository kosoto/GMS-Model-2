package command;

public class CountCommand extends Command{
	public CountCommand(String domain,String action,String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
