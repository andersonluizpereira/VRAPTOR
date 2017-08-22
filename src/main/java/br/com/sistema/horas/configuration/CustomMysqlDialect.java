package br.com.sistema.horas.configuration;
import org.hibernate.dialect.MySQL5InnoDBDialect;

public class CustomMysqlDialect {
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
