package fr.doranco.jaxws;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.entity.Etudiant;

/**
 * @author Ryadh HADJ MOKHNECHE (hm_ryadh@yahoo.fr)
 */
@WebService(name = "EtudiantService", targetNamespace = "http://jaxws.doranco.fr")
public interface IEtudiantService {

	@WebMethod
	Etudiant addEtudiant(@WebParam(name = "etudiant") Etudiant p) throws Exception;
													// ne mettre que Exception sinon le wsimport ne fonctionnera pas.

	@WebMethod
	List<Etudiant> getEtudiants() throws Exception;

	@WebMethod
	Etudiant getEtudiantById(@WebParam(name = "id") Integer id) throws Exception;

}

