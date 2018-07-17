package factory;

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
}
