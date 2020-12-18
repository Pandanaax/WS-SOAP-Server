package fr.doranco.jaxws.main;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.IEtudiantService;
import fr.doranco.jaxws.EtudiantService;

public class Test {

	public static void main(String[] args) throws SQLException {

		IEtudiantService etudiantService = new EtudiantService();

		Etudiant etudiant = new Etudiant();
		etudiant.setNom("Albert");
		etudiant.setPrenom("CAMUS");
		etudiant.setSpecialite("�crivain");

		System.out.println("Test de la m�thode d'ajout d'un �tudiant : " + etudiant);
		Etudiant etudiantAdded = null;
		try {
			etudiantAdded = etudiantService.addEtudiant(etudiant);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (etudiantAdded != null && etudiantAdded.getId() != 0) {
			System.out.println("L'�tudiant a bien �t� ajout� : " + etudiant);
		} else {
			System.out.println("L'�tudiant n'a pas pu �tre ajout� !");
		}

		etudiant = new Etudiant();
		etudiant.setNom("Victor");
		etudiant.setPrenom("HUGO");
		etudiant.setSpecialite("romancier");

		System.out.println("");
		System.out.println("Test de la m�thode d'ajout d'un �tudiant : " + etudiant);
		try {
			etudiantAdded = etudiantService.addEtudiant(etudiant);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (etudiantAdded != null && etudiantAdded.getId() != 0) {
			System.out.println("L'�tudiant a bien �t� ajout� : " + etudiant);
		} else {
			System.out.println("L'�tudiant n'a pas pu �tre ajout� !");
		}

		System.out.println("");
		System.out.println("Test de la m�thode de r�cup�ration de tous les �tudiants :");
		List<Etudiant> listeEtudiants = null;
		try {
			listeEtudiants = etudiantService.getEtudiants();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (listeEtudiants != null && !listeEtudiants.isEmpty()) {
			System.out.println("Liste des �tudiants : ");
			for (Etudiant student : listeEtudiants) {
				System.out.println(student);
			}
		} else {
			System.out.println("Liste des �tudiants : NULL ou vide");
		}
	}
}
