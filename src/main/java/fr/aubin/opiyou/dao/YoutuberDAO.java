package fr.aubin.opiyou.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.aubin.opiyou.App;
import fr.aubin.opiyou.domaine.Youtuber;

public class YoutuberDAO {

	// cr�er un objet de connection BDD
	ConnectionBDD myConnection = new ConnectionBDD();
	// cr�er un youtuber temporaire pour r�cup�rer les infos
	Youtuber temporaryYT = null;
	// Une liste de Youtuber pour le get all
	ArrayList<Youtuber> listeYT = new ArrayList<Youtuber>();

	// Methode CRUD

	// Create de CRUD
	public void createYoutuber(Youtuber myYoutuber) {
		// cr�er la requete
		String requete = "INSERT INTO youtuber VALUES ('" + myYoutuber.getId() + "','" + myYoutuber.getName() + "','"
				+ myYoutuber.getFirstName() + "','" + myYoutuber.getUsername() + "','" + myYoutuber.getChannelName()
				+ "','" + myYoutuber.getSubCount() + "','" + myYoutuber.getLogin() + "','" + myYoutuber.getPass() + "','"+ myYoutuber.getLinkChannel() + "')";
		// se connecter � la base de donn�es
		myConnection.seConnecter();
		// ex�cuter al requte
		myConnection.updateData(requete);
		;
		// fermer la connection
		myConnection.closeConnection();

	}

	// Read de CRUD
	public Youtuber readYoutuberFromID(int idYT) {
		// cr�er la requete
		String requete = "SELECT * FROM youtuber WHERE idYoutuber=" + idYT;
		// Cr�er un resultset et y mettre le r�sultat
		ResultSet rs = myConnection.executeRequete(requete);
		// faire un try catch sur �a
		try {
			while (rs.next()) {
				String name = rs.getString("nameYoutuber");
				String firstName = rs.getString("firstNameYoutuber");
				String username = rs.getString("usernameYoutube");
				String channelName = rs.getString("channelNameYoutube");
				BigDecimal nbrAbos = rs.getBigDecimal("subscribersCountYoutube");
				String login = rs.getString("loginYoutuber");
				String pass = rs.getString("pwdYoutuber");
				String linkChannel = rs.getString("linkChannel");
				// mettre ce r�sultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(idYT, name, firstName, username, channelName, login, pass, linkChannel);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// fermer la co
		myConnection.closeConnection();
		return temporaryYT;
	}

	// Methode pour retourner la liste de youtuber
	public ArrayList<Youtuber> getAll() {
		// cr�er la requete
		String requete = "SELECT * FROM youtuber";
		// cr�er le resultset et y mettre le r�sultat
		ResultSet rs = myConnection.executeRequete(requete);
		// faire un try catch sur �a
		try {
			while (rs.next()) {
				int idYT = rs.getInt("idYoutuber");
				String name = rs.getString("nameYoutuber");
				String firstName = rs.getString("firstNameYoutuber");
				String username = rs.getString("usernameYoutube");
				String channelName = rs.getString("channelNameYoutube");
				BigDecimal nbrAbos = rs.getBigDecimal("subscribersCountYoutube");
				String login = rs.getString("loginYoutuber");
				String pass = rs.getString("pwdYoutuber");
				String linkChannel = rs.getString("linkChannel");
				// mettre ce r�sultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(idYT, name, firstName, username, channelName, login, pass, linkChannel);
				// et remplir l'arraylist
				listeYT.add(temporaryYT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// fermer la connection
		myConnection.closeConnection();
		return listeYT;
	}

	// Methode update de CRUD
	public void updateYoutuber(Youtuber oldVersion, Youtuber newVersion) {
		// creer la requete
		String requete = "UPDATE youtuber SET nameYoutuber='" + newVersion.getName() + "', firstNameYoutuber = '"
				+ newVersion.getFirstName() + "', usernameYoutube = '" + newVersion.getUsername()
				+ "', channelNameYoutube = '" + newVersion.getChannelName() + "', subscribersCountYoutube = '"
				+ newVersion.getSubCount() + "', linkChannel='" + newVersion.getLinkChannel() + "' WHERE idYoutuber="
				+ oldVersion.getId();
		// se connecter
		myConnection.seConnecter();
		// executer la requete
		myConnection.executeRequete(requete);
		// fermer la connection
		myConnection.closeConnection();
	}

	// Methode delete de CRUD
	public void deleteYoutuber(Youtuber myYoutuber) {
		// creer la requete
		String requete = "DELETE FROM youtuber WHERE idYoutuber = " + myYoutuber.getId();
		// executer la requete
		myConnection.executeRequete(requete);
		// fermer la connection
		myConnection.closeConnection();
	}

	// Method de check authentification
	public Youtuber checkConnect(String loginApp, String pwdApp) {
		// creation de la requete
		String requete = "SELECT * FROM youtuber WHERE login='" + loginApp + "' AND mdp='" + pwdApp + "'";

		// se connecter � la base de donner
		myConnection.seConnecter();

		// executer la requete et mettre dans un resultset
		ResultSet rs = myConnection.executeRequete(requete);

		try {
			while (rs.next()) {
				int idYT = rs.getInt("idYoutuber");
				String name = rs.getString("nameYoutuber");
				String firstName = rs.getString("firstNameYoutuber");
				String username = rs.getString("usernameYoutube");
				String channelName = rs.getString("channelNameYoutube");
				BigDecimal nbrAbos = rs.getBigDecimal("subscribersCountYoutube");
				String login = rs.getString("loginYoutuber");
				String pass = rs.getString("pwdYoutuber");
				String linkChannel = rs.getString("linkChannel");
				// mettre ce r�sultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(idYT, name, firstName, username, channelName, login, pass, linkChannel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temporaryYT;
	}
}
