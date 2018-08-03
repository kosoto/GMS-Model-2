package factory;


import java.util.Map;

import enums.*;
import pool.DBConstant;

public class DataBaseFactory {
	public static DataBase createDataBase(
			Vendor v, String id, String pass) {
		DataBase db = null;
		switch(v) {
		case ORACLE :
			db = new Oracle(
					DBConstant.ORACLE_DRIVER,
					DBConstant.CONNECTION_URL,
					id,pass);
			break;
		case MARIADB : 
			db = new Oracle(
					DBConstant.ORACLE_DRIVER,
					DBConstant.CONNECTION_URL,
					id,pass);
			break;
		case MYSQL : 
			db = new Oracle(
					DBConstant.ORACLE_DRIVER,
					DBConstant.CONNECTION_URL,
					id,pass);
			break;
		case MSSQL : 
			db = new Oracle(
					DBConstant.ORACLE_DRIVER,
					DBConstant.CONNECTION_URL,
					id,pass);
			break;
		default : break;
		}
		return db;
		}
	public static DataBase createDataBase2(
			Map<String, ?> map) {
		DataBase db = null;
		String driver = "",url="";
		switch((Vendor) map.get("vendor")) {
		case ORACLE :
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(
					driver,
					url,
					(String) map.get("username"),
					(String) map.get("password"));
			break;
		case MARIADB : 
			db = new Oracle(
					driver,
					url,
					(String) map.get("username"),
					(String) map.get("password"));
			break;
		case MYSQL : 
			db = new Oracle(
					driver,
					url,
					(String) map.get("username"),
					(String) map.get("password"));
			break;
		case MSSQL : 
			db = new Oracle(
					driver,
					url,
					(String) map.get("username"),
					(String) map.get("password"));
			break;
		default : break;
		}
		return db;
		}
}
