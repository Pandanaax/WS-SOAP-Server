package fr.doranco.jaxws.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.entity.Etudiant;

public interface IEtudiantDao {

	List<Etudiant> getEtudiants() throws SQLException;
	Etudiant getEtudiantById(Integer id) throws SQLException;
	Etudiant addEtudiant(Etudiant etudiant) throws SQLException;
}
