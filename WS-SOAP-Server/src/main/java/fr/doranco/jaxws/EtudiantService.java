package fr.doranco.jaxws;

import java.util.List;

import javax.jws.WebService;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.dao.EtudiantDao;

/**
 * @author Ryadh HADJ MOKHNECHE (hm_ryadh@yahoo.fr)
 */
@WebService(endpointInterface = "fr.doranco.jaxws.EtudiantService", serviceName = "EtudiantService", portName = "EtudiantPort")
public class EtudiantService implements IEtudiantService {

	private EtudiantDao etudiantDao = new EtudiantDao();

	public EtudiantService() {
	}

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		
		System.out.println("    --> 'addEtudiant' method has been invoked.");
		
			Etudiant etudiantAjoute = etudiantDao.addEtudiant(etudiant);
			if (etudiantAjoute == null) {
				throw new NullPointerException("L'object etudiant n'a pu être ajouté !");
			} else {
				return etudiantAjoute;
			}
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {

		System.out.println("    --> 'getEtudiants' method has been invoked.");

		List<Etudiant> listeEtudiants = etudiantDao.getEtudiants();
		if (listeEtudiants == null || listeEtudiants.isEmpty()) {
			throw new NullPointerException("Il n'existe aucun étudiant");
		} else {
			return listeEtudiants;
		}
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws Exception {
		
		System.out.println("    --> 'getEtudiantById' method has been invoked.");

		if (id == null || id <= 0) {
			throw new NullPointerException("l'id ne doit pas être NULL, vide ou <= 0 !");
		} else {
			Etudiant etudiant = etudiantDao.getEtudiantById(id);
			if (etudiant == null) {
				throw new NullPointerException("Il n'existe aucun étudiant avec l'id = " + id);
			} else {
				return etudiant;
			}
		}
	}
}
