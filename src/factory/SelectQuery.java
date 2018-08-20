package factory;

public class SelectQuery implements Query{
	private String query,table,column,word;
	public SelectQuery(String table, String column, String word) {
		this.table = table;
		this.column = column;
		this.word = word;
	}
	 
	public static String select(String table, String column, String word) {
		String query =
				"SELECT * FROM "+table
				+" WHERE "+column
				+" LIKE '%"+word.toUpperCase()+"%'";
		System.out.println("쿼리 클래스 쿼리 :"+query);
		return query;
	}

	@Override
	public String getQuery() {
		query =
				"SELECT * FROM "+table
				+" WHERE "+column
				+" LIKE '%"+word.toUpperCase()+"%'";
		return query;
	}
}
