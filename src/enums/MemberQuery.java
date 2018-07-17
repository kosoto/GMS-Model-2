package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,EXIST_ID,COUNT_MEMBER,UPDATE_MEMBER,
	DELETE_MEMBER,MEMBER_LIST, FIND_BY_TEAM_ID, FIND_BY_ID;
	
	@Override
	public String toString() {	
		String query = "";
		switch(this) {
		case LOGIN : 
			query = "SELECT MEM_ID MEMID, "
					+" TEAM_ID TEAMID, "
					+" NAME, "
					+" SSN, "
					+" ROLL, "
					+" PASSWORD "
					+" FROM MEMBER "
					+" WHERE MEM_ID LIKE '%s' "
					+" AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER : 
			query = "INSERT INTO MEMBER "
					+ "(MEM_ID, NAME, SSN, PASSWORD, AGE) "
					+ "VALUES "
					+ "('%s','%s','%s','%s','%d')";
			break;
		case EXIST_ID : 
			query = "SELECT MEM_ID "
					+ "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		case COUNT_MEMBER : 
			query = " SELECT COUNT(*) AS count FROM MEMBER";
			break;
		case UPDATE_MEMBER : 
			query = "UPDATE MEMBER SET PASSWORD = %s "
				  + " WHERE MEM_ID LIKE '%s'";
			break;
		case DELETE_MEMBER : 
			query = "DELETE FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s' "
					+ "AND PASSWORD LIKE '%s'";
			break;
		case MEMBER_LIST : 
			query = "SELECT * FROM MEMBER";
			break;
		case FIND_BY_TEAM_ID : 
			query = "SELECT * FROM MEMBER "
					+ "WHERE TEAM_ID LIKE '%s'";
			break;
		case FIND_BY_ID : 
			query = "SELECT * FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		}
		return query;
	}
	
}
