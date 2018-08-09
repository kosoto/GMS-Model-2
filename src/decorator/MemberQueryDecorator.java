package decorator;

public class MemberQueryDecorator extends QueryDecorator{

	public MemberQueryDecorator(Query decoratedQuery) {
		super(decoratedQuery);
	}
	
	@Override
	public String getQuery() {
		decoratedQuery.getQuery();
		setMemberQuery(decoratedQuery);
		return super.getQuery();
	}
	 private void setMemberQuery(Query decoratedQuery) {
		 
	 }

}
