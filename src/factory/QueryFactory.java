package factory;

import enums.Vendor;

public class QueryFactory {
	public static Query createQuery(Vendor v,String table, String column, String word) {
		Query query = null;
		switch(v) {
		case SELECT: 
			query = new SelectQuery(table,column, word);
			break;
		default:
			break;
		}
		return query;
		
	}
}
