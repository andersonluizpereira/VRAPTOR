package br.com.sistema.horas.configuration;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.caelum.vraptor.environment.Environment;

import com.mysql.jdbc.MySQLConnection;

public class MySQLConnectionProvider {
	private static final long serialVersionUID = 8290339582921980138L;

	private MySQLConnection connection;

	@Inject
	private Environment environment;

	@PostConstruct
	public void init() {
		System.out.println("[MySQL] Creating Default Connection");
		try {
			Class.forName(this.environment.get("database.mysql.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		try {
			this.connection = (MySQLConnection) DriverManager.getConnection(this.environment.get("database.mysql.connection"), this.environment.get("database.mysql.username").trim(),this.environment.get("database.mysql.password").trim());
		} catch (SQLException e) {
			System.out.println("[MySQL] Could not stablish connection");
			e.printStackTrace();
			return;
		}
	}

	@Default
	@Produces
	public MySQLConnection getConnection() {
		 if (this.connection == null){
			 this.connection = (MySQLConnection) new MySQLConnectionProvider();
    }
		
		return this.connection;
	}

	@PreDestroy
	public void close() throws SQLException {
		System.out.println("[MySQL] Destroying Default Connection");
		if (!this.connection.isClosed()) {
			this.connection.close();
		}
	}

}
