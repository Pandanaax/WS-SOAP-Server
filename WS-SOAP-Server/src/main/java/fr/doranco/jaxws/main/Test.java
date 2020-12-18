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
		etudiant.setSpecialite("écrivain");

		System.out.println("Test de la méthode d'ajout d'un étudiant : " + etudiant);
		Etudiant etudiantAdded = null;
		try {
			etudiantAdded = etudiantService.addEtudiant(etudiant);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (etudiantAdded != null && etudiantAdded.getId() != 0) {
			System.out.println("L'étudiant a bien été ajouté : " + etudiant);
		} else {
			System.out.println("L'étudiant n'a pas pu être ajouté !");
		}

		etudiant = new Etudiant();
		etudiant.setNom("Victor");
		etudiant.setPrenom("HUGO");
		etudiant.setSpecialite("romancier");

		System.out.println("");
		System.out.println("Test de la méthode d'ajout d'un étudiant : " + etudiant);
		try {
			etudiantAdded = etudiantService.addEtudiant(etudiant);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (etudiantAdded != null && etudiantAdded.getId() != 0) {
			System.out.println("L'étudiant a bien été ajouté : " + etudiant);
		} else {
			System.out.println("L'étudiant n'a pas pu être ajouté !");
		}

		System.out.println("");
		System.out.println("Test de la méthode de récupération de tous les étudiants :");
		List<Etudiant> listeEtudiants = null;
		try {
			listeEtudiants = etudiantService.getEtudiants();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (listeEtudiants != null && !listeEtudiants.isEmpty()) {
			System.out.println("Liste des étudiants : ");
			for (Etudiant student : listeEtudiants) {
				System.out.println(student);
			}
		} else {
			System.out.println("Liste des étudiants : NULL ou vide");
		}
	}
}
