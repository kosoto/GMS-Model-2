package decorator;

public class ListQuery implements Query{

	@Override
	public String getQuery() {
		String query = 
				  "SELECT * FROM ( "
				+ "SELECT ROWNUM NO, A.* "
				+ "FROM ( "
				+ "SELECT * "
				+ "FROM MEMBER) A "
				+ "ORDER BY NO DESC) B "
				+ "WHERE NO BETWEEN ? AND ?";
		return query;
	}

}
