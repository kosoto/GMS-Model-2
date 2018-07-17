package factory;

import java.sql.Connection;

public interface DataBase {
	public Connection getConnection();
}
