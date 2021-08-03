package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Rafaell Estevam
 *
 */
public class ConnectionFactory {

	DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("EuamooBarca");

//			OPCIONAL		
//		cpds.setMinPoolSize(5);
//		cpds.setInitialPoolSize(5);
//		cpds.setMaxPoolSize(15);
		
		this.dataSource = cpds;
	}

	public Connection recuperarConexao() throws SQLException {
		return dataSource.getConnection();
	}
}


