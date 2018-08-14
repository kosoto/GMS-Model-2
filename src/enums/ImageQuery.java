package enums;

public enum ImageQuery {
	INSERT, RETRIEVE;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case INSERT:
			query = 
			"INSERT INTO IMAGE "
			+"(IMG_SEQ, IMG_NAME, EXTENSION, MEM_ID) "
			+"VALUES "
			+"(IMG_SEQ.NEXTVAL, ?, ?, ? )";
			break;
		case RETRIEVE :
			query = 
			"SELECT * FROM IMAGE "
			+ "WHERE %s LIKE ? ";
			break;
		default : break;
		}
		return query;
	}
	
}
