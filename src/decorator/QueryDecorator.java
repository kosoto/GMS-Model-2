package decorator;

public abstract class QueryDecorator implements Query{
	protected Query decoratedQuery;
	
	public QueryDecorator(Query decoratedQuery) {
		this.decoratedQuery = decoratedQuery;
	}
	
	@Override
	public String getQuery() {
		return decoratedQuery.getQuery();
	}
}
