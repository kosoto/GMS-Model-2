package Test;

import java.sql.*;
import java.util.*;

import pool.DBConstant;

public class Test {
	public static void main(String[] args) {
		List<String> list = TestDAO.getInstance().getAge();
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(
					DBConstant.CONNECTION_URL,
					DBConstant.USER_NAME,
					DBConstant.PASSWORD);
			Statement stmt = conn.createStatement();
			for(int i =0;i<list.size();i++) {
				stmt.executeQuery(
						String.format(
								"UPDATE MEMBER "
								+"SET SSN ='%s' "
								+"WHERE MEM_ID LIKE '%s'", 
								String.valueOf(
										(119-Integer.parseInt(list.get(i).split("/")[1])
										)					
									)
									+String.format("%02d", (int)((Math.random()*12)+1))
									+String.format("%02d", (int)((Math.random()*30)+1))
									+"-"
									+String.format("%d", (int)((Math.random()*2)+1)),
								list.get(i).split("/")[0]
						)
				);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
















