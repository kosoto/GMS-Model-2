package enums;

public enum DBDriver {
	ORACLE_DRIVER,MYSQL_DRIVER,MARIADB_DRIVER,MSSQL_DRIVER;
	
	@Override
	public String toString() {
		String driver = "";
		switch(this) {
		case ORACLE_DRIVER: 
			driver = "oracle.jdbc.driver.OracleDriver";
			break;
		case MYSQL_DRIVER:
			driver = "";
			break;
		case MARIADB_DRIVER:
			driver = "";
			break;
		case MSSQL_DRIVER:
			driver = "";
			break;
		default  : break;
		}
		return driver;
	}
}
