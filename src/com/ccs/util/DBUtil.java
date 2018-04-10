package com.ccs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 4月21日，完成DBUtil类，用于进行数据库连接
 * 
 * @author GaoYuxing
 * */
public class DBUtil {
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	public static Connection getConnection() {
		Connection connection = threadLocal.get();
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/ccs" +
						"?useUnicode=true&characterEncoding=UTF-8", "root", "y19950730");
				threadLocal.set(connection);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return connection;
	}

	public static void closeConnection() {
		Connection connection = threadLocal.get();
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		threadLocal.set(null);
	}
}
