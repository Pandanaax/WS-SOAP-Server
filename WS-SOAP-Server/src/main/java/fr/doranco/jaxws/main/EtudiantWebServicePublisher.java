package fr.doranco.jaxws.main;

import javax.xml.ws.Endpoint;

import fr.doranco.jaxws.EtudiantService;

/**
 * @author Ryadh HADJ MOKHNECHE (hm_ryadh@yahoo.fr)
 */
public class EtudiantWebServicePublisher {
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			System.out.println("Publication du service Web 'EtudiantService' en cours...");
			
//			Endpoint endpoint = Endpoint.create(new EtudiantService());
//	        endpoint.publish("http://localhost:9991/ws/etudiantservice");
	        
			Endpoint.publish("http://localhost:9991/ws/etudiant-service", new EtudiantService());
			//Endpoint.publish("http://localhost:9991/ws/cours-service", new CoursService());
			
			System.out.println("Web service 'EtudiantService' publié avec succès.");
			System.out.println("======================================================================");
			
		} catch(Exception e) {
			System.err.println("ERROR : Web service non publié");
			System.out.println(e.getMessage());
		}
	}
}
