package Test;

import java.sql.*;
import java.util.*;

import pool.DBConstant;

public class TestDAO {
	private static TestDAO instance = new TestDAO();
	private Connection conn;
	private Statement stmt;
	public static TestDAO getInstance() {return instance;}
	private TestDAO() {
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			conn = DriverManager .getConnection(
					DBConstant.CONNECTION_URL, 
					DBConstant.USER_NAME, 
					DBConstant.PASSWORD);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getAge() {
		List<String> list = new ArrayList<>();
		try {			
			String sql = String.format(
					"SELECT MEM_ID, AGE FROM MEMBER "
					);
			ResultSet rs = stmt.executeQuery(sql);			
			while(rs.next()) {
				list.add(rs.getString("MEM_ID")
						+"/"
						+rs.getString("AGE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
