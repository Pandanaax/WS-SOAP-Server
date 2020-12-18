package fr.doranco.jaxws.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Singleton de DataSource permettant la connexion à la BDD.
 * 
 * @author Ryadh HADJ MOKHNECHE (hm_ryadh@yahoo.fr)
 *
 */
public class DataSourceConnexion {

	private static DataSourceConnexion instance = null;
	
	private DataSourceConnexion() {
	}

	public static DataSourceConnexion getInstance() {
		if (instance == null) {
			instance = new DataSourceConnexion();
		}
		return instance;
	}	
	public Connection getConnection() {
		
		Connection connexion = null;

		ResourceBundle rb = ResourceBundle.getBundle("fr.doranco.jaxws.dbfile");
		
		String login = rb.getString("login");
		String mdp = rb.getString("mdp");
		String url = rb.getString("url");

		try {
			connexion = DriverManager.getConnection(url, login, mdp);
		} catch (SQLException e) {
			System.out.println("Impossible d'etablir une connexion avec la BDD, URL = " + url);
			e.printStackTrace();
		}
		return connexion;
	}

}
