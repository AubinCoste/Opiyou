package fr.aubin.opiyou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import fr.aubin.opiyou.App;


public class ConnectionBDD {
	// attributs n�cessaire � la connexion
		private String url;
		private String login;
		private String pass;
		private Connection connect = null;
		private Statement st = null;
		private String laRequete;
		

		//Constructeurs
		/**
		 * @param url
		 * @param login
		 * @param pass
		 * @param connect
		 * @param st
		 * @param laRequete
		 */
		/**
		 * 
		 * Constructeur de niveau 1 permettant de modifier les param�tres de connexion
		 */
		public ConnectionBDD(String url, String login, String pass) {
			super();
			this.url = url;
			this.login = login;
			this.pass = pass;
		
		}
		
		/**
		 * Surcharge de constructeur permettant une initialisation basique des param�tres de connexion
		 */
		public ConnectionBDD() {
			super();
			this.url = "jdbc:mysql://localhost/opiyou";
			this.login = "root";
			this.pass = "";
			this.connect = null;
			this.st = null;
			this.laRequete = "";
		}


		/**
		 * M�thode de connection � la base de donn�e
		 */
		public void seConnecter() {
			// TODO ici mettre le code pour se connecter � la bdd
			try {
				// Charger le driver
				Class.forName("com.mysql.jdbc.Driver");

				// R�cup�rer la connection dans mon objet de type Connection
				connect = DriverManager.getConnection(this.url, this.login, this.pass);
				
				// Pr�parer le statement et la requ�te
				this.st = connect.createStatement();

			} catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		

		/**
		 * @param query
		 */
		/**
		 * 
		 * M�thode permettant d'executer une requete, attention n�cessite une connectio BDD ! (voir seConnecter)
		 */
		public ResultSet executeRequete(String query) {
			this.laRequete = query;
			ResultSet rs = null;
			try {
			  rs = this.st.executeQuery(laRequete);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		/**
		 * @param query
		 */
		/**
		 * 
		 * Methode permettant de mettre � jour les donn�es en BDD, attention n�cessite une connectio BDD ! (voir seConnecter)
		 */
		public void updateData(String query) {
			this.laRequete = query;
			try {
				this.st.executeUpdate(laRequete);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * M�thode permettant de fermer la connection active et donc lib�rer de la m�moire
		 */
		public void closeConnection() {
			try {
				// lib�rer la m�moire
				connect.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
