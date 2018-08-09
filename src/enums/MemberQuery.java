package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST,SEARCH,RETRIEVE,COUNT,
	UPDATE,
	DELETE,  
	LOGIN,
	EXIST_ID;
	
	@Override
	public String toString() {	
		String query = "";
		switch(this) {
		case INSERT : 
			query = "INSERT INTO MEMBER "
					//+ ColumnFinder.find(Domain.MEMBER)
					+ "(MEM_ID, NAME, SSN, PASSWORD, AGE, "
					+ "GENDER, ROLL, TEAM_ID) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ? )";
			break;
		
		case LIST : 
			query = 
			  "SELECT * FROM ( "
			+ "SELECT ROWNUM NO, A.* "
			+ "FROM ( "
			+ "SELECT * "
			+ "FROM MEMBER) A "
			+ "ORDER BY NO DESC) B "
			+ "WHERE NO BETWEEN ? AND ? ";
			break;
		case SEARCH : 
			query = 
			  "SELECT * FROM ( "
			+ "SELECT ROWNUM NO, A.* "
			+ "FROM ( "
			+ "SELECT * "
			+ "FROM MEMBER "
			+ "WHERE %s LIKE ? ) A "
			+ "ORDER BY NO DESC) B "
			+ "WHERE NO BETWEEN ? AND ? ";
			break;
		case RETRIEVE : 
			query = "SELECT * FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			query = "SELECT "
					//+ColumnFinder.find(Domain.MEMBER)
					+"* "
					+"FROM MEMBER "
					+"WHERE MEM_ID "
					+"LIKE ? ";
				
			break;
		case COUNT : 
			query = " SELECT COUNT(*) AS count FROM MEMBER";
			break;
		case UPDATE : 
			query = "UPDATE MEMBER "
				  + "SET %s = ?, "
				  + "WHERE MEM_ID LIKE ? ";
			break;
		case DELETE : 
			query = "DELETE FROM MEMBER "
					+ "WHERE MEM_ID LIKE ? "
					+ "AND PASSWORD LIKE ? ";
			break;
		case LOGIN : 
			query = "SELECT "
					//+ColumnFinder.find(Domain.MEMBER)
					+"* "
					+" FROM MEMBER "
					+" WHERE MEM_ID LIKE ? "
					+" AND PASSWORD LIKE ? ";
			break;
		
		case EXIST_ID : 
			query = "SELECT MEM_ID "
					+ "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		}
		return query;
	}
	
}
