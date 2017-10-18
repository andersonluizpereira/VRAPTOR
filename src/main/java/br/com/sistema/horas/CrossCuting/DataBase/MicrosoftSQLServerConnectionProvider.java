package br.com.sistema.horas.CrossCuting.DataBase;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.caelum.vraptor.environment.Environment;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;


public class MicrosoftSQLServerConnectionProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8290339582921980138L;

	private final Environment environment;
	
	private SQLServerConnection connection;

	@Inject
	public MicrosoftSQLServerConnectionProvider(Environment environment) {
		this.environment = environment;
	}
	
	@Deprecated
	protected MicrosoftSQLServerConnectionProvider(){
		this(null);
	}

	@PostConstruct
	public void init() {
		System.out.println("[Microsoft SQL Connection] Creating Default Connection");
		try {
			Class.forName(this.environment.get("database.sqlserver.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.connection = (SQLServerConnection) DriverManager.getConnection(this.environment.get("database.sqlserver.connection"), this.environment.get("database.sqlserver.username").trim(),this.environment.get("database.sqlserver.password").trim());
		} catch (SQLException e) {
			System.out.println("[Microsoft SQL Connection] Could not stablish connection");
			e.printStackTrace();
		}
	}

	@Default
	@Produces 
	public SQLServerConnection getConnection() {
		return this.connection;
	}

	@PreDestroy
	public void close() throws SQLException {
		System.out.println("[Microsoft SQL Connection] Destroying Default Connection");
		if (!this.connection.isClosed()) {
			this.connection.close();
		}
	}


}
