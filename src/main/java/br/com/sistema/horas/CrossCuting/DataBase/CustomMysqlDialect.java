package br.com.sistema.horas.CrossCuting.DataBase;
import org.hibernate.dialect.MySQL5InnoDBDialect;

public class CustomMysqlDialect {
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
