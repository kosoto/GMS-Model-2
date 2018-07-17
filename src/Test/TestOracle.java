package Test;

import java.sql.*;
import factory.DataBase;

public class TestOracle implements DataBase{
	private Connection conn;
	private String driver,url,id,pass;
	public TestOracle(String driver,String url,String id, String pass) {
		this.driver=driver;
		this.url=url;
		this.id=id;
		this.pass=pass;
	}
	@Override
	public Connection getConnection() {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(
					url,
					id,
					pass
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
