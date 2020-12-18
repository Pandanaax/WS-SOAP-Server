package fr.doranco.jaxws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.connexion.DataSourceConnexion;

public class EtudiantDao implements IEtudiantDao {

	private Connection connexion = null;

	public EtudiantDao() {
		if (connexion == null) {
			connexion = DataSourceConnexion.getInstance().getConnection();
		}
	}

	@Override
	public List<Etudiant> getEtudiants() throws SQLException {

		List<Etudiant> listeEtudiants = null;
		ResultSet rs = null;
		String query = "SELECT * FROM etudiant";
		Statement statement = connexion.createStatement();
		rs = statement.executeQuery(query);

		if (rs != null) {
			listeEtudiants = new ArrayList<Etudiant>();
			while (rs.next()) {
				Etudiant etudiant = new Etudiant();
				etudiant.setId(rs.getInt("id"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setSpecialite(rs.getString("specialite"));
				etudiant.setAge(rs.getInt("age"));
				listeEtudiants.add(etudiant);
			}
		}
		return listeEtudiants;
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws SQLException {

		Etudiant etudiant = null;
		ResultSet rs = null;
		String query = "SELECT * FROM etudiant WHERE id = ?";
		PreparedStatement ps = connexion.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		if (rs != null && rs.next()) {
			etudiant = new Etudiant();
			etudiant.setId(rs.getInt("id"));
			etudiant.setNom(rs.getString("nom"));
			etudiant.setPrenom(rs.getString("prenom"));
			etudiant.setSpecialite(rs.getString("specialite"));
			etudiant.setAge(rs.getInt("age"));
		}
		return etudiant;
	}

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws SQLException {

		String query = "INSERT INTO etudiant(nom, prenom, specialite, age) VALUES(?, ?, ?, ?)";

		PreparedStatement ps = connexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, etudiant.getNom());
		ps.setString(2, etudiant.getPrenom());
		ps.setString(3, etudiant.getSpecialite());
		ps.setInt(4, etudiant.getAge());
		int nbLineInserted = ps.executeUpdate();
		if (nbLineInserted == 1) {
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				etudiant.setId(rs.getInt(1));
			}
			return etudiant;
		} else {
			System.out.println("Erreur lors de l'ajout d'un étudiant à la BDD !");
			return null;
		}
	}

}
