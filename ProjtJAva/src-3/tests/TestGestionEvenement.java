package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;

import association.GestionMembres;
import association.InformationPersonnelle;
import association.InterMembre;
import association.Membre;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


import association.Evenement;
import association.GestionEvenement;
import association.InformationPersonnelle;
import association.InterMembre;
import association.Membre;

 class TestGestionEvenement {

	GestionEvenement gestionEvenement = new GestionEvenement();

	@Test
	 void testCreerEvenement_PasDeChevauchement() {
		Evenement eve = gestionEvenement.creerEvenement("festival", "Megarama", 2, Month.JUNE, 2022, 6, 59, 90, 2000);
		assertNotNull(eve);
		assertEquals(eve.getNom(), "festival");
		assertEquals(eve.getLieu(), "Megarama");
		assertEquals(eve.getDate(), LocalDateTime.of(2022,Month.JUNE, 2, 6, 59));
	}
	@Test
	 void testCreerEvenement_AvecChevauchement() {
		Evenement eveFestival = gestionEvenement.creerEvenement("festival", "Casablanca", 2, Month.JUNE, 2022, 6, 59, 90, 2000);
		Evenement eveMatch = gestionEvenement.creerEvenement("match", "Casablanca", 2, Month.JUNE, 2022, 6, 59, 90, 2000);
		assertNotNull(eveFestival);
		assertNull(eveMatch);
	}
	
	 @Test
	 void testSuprimerEvenement() {
		 Evenement eve = gestionEvenement.creerEvenement("festival", "Megarama", 2, Month.JUNE, 2022, 6, 59, 90, 2000);
		 gestionEvenement.supprimerEvenement(eve);
		 assertNull(gestionEvenement.ensembleEvenements());
	 }
	 

}
