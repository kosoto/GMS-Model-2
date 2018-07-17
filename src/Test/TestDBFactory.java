package Test;

import java.sql.*;

import enums.Vendor;
import factory.DataBase;
import factory.Oracle;
import pool.DBConstant;

public class TestDBFactory {
	public static DataBase createDatabase(Vendor v,String id, String pass) {
		DataBase db = null;
		switch(v) {
		case ORACLE: 
			db = new Oracle(
					DBConstant.ORACLE_DRIVER,
					DBConstant.CONNECTION_URL,
					id, pass);
			break;
		case MARIADB: break;
		case MYSQL: break;
		default :break;
		
		}
		return db;
	}
	public static void test() {
	
		try {		
			ResultSet rs = createDatabase(
					Vendor.ORACLE, 
					DBConstant.USER_NAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery("sql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}













