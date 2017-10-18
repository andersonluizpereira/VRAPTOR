package br.com.sistema.horas.CrossCuting.DataBase;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.mysql.jdbc.Connection;

@RequestScoped
public class DefaultConnectionProvider {
	private Connection connetion;

	@PostConstruct
	public void init() throws SQLException, IOException, ClassNotFoundException {
		System.out.println("[MySQL] Creating Default Connection");

		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));

		String url = properties.getProperty("jdbc.url").trim();
		String driver = properties.getProperty("jdbc.driver").trim();
		String username = properties.getProperty("jdbc.username").trim();
		String password = properties.getProperty("jdbc.password").trim();
		
		Class.forName(driver);

		this.connetion = (Connection) DriverManager.getConnection(url, username, password);
	}

	
	@Default
	@Produces
	public Connection getConnection() {
		return this.connetion;
	}

	@PreDestroy
	public void close() throws SQLException {
		System.out.println("[MySQL] Destroying Default Connection");
		if (!this.connetion.isClosed()) {
			this.connetion.close();
		}
	}

}
