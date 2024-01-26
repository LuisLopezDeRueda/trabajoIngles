package fct.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class OpenConnectionceufct {
	public Connection getConection() throws SQLException {
		String urlConexion = "jdbc:mariadb://localhost:3306/academia";
		String claseDriver = "org.mariadb.jdbc.Driver";
		String usuario = "academia";
		String password = "academia";

		try {
			Class.forName(claseDriver);
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra el driver JDBC. Revisa tu configuracion");
			throw new RuntimeErrorException(null, e.getMessage());
		}
		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
		return conn;

	}

}
