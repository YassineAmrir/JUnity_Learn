package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import association.GestionMembres;
import association.InformationPersonnelle;
import association.InterMembre;
import association.Membre;

class TestGestionMembre {

	private GestionMembres gestionMembres=new GestionMembres();

	@Test
	void testAjouterMembre_NotExiste() {
		InformationPersonnelle info = new InformationPersonnelle("jack","daniel");
		InterMembre membre = new Membre();
		membre.definirInformationPersonnnelle(info);
		boolean existe=gestionMembres.ajouterMembre(membre);
        assertEquals(existe, true);
	}
	@Test
	void testAjouterMembre_Existe() {
		InformationPersonnelle info = new InformationPersonnelle("jack","daniel");
		//AJOUTER LE PREMIER MEMBRE
		InterMembre membre = new Membre();
		membre.definirInformationPersonnnelle(info);
		gestionMembres.ajouterMembre(membre);
		//AJOUTER LE DEUSIEME MEMBRE
		InterMembre membre2 = new Membre();
		membre2.definirInformationPersonnnelle(info);
		boolean existe=gestionMembres.ajouterMembre(membre2);
        assertEquals(existe, false);
	}
	@Test
	void testSupprimerMembre() {  
		InformationPersonnelle info = new InformationPersonnelle("jack","daniel");
		InterMembre membre = new Membre();
		membre.definirInformationPersonnnelle(info);
		gestionMembres.ajouterMembre(membre);
		boolean existe=gestionMembres.supprimerMembre(membre);
		 assertEquals(existe, true);
	}
	@Test
	void testDesignerPresident() {
		InformationPersonnelle info = new InformationPersonnelle("jack","daniel");
		InterMembre membre = new Membre();
		membre.definirInformationPersonnnelle(info);
		gestionMembres.ajouterMembre(membre);
		boolean existe = gestionMembres.designerPresident(membre);
		assertEquals(existe, true);
	}
}
