package association;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GestionEvenement implements InterGestionEvenements {

	static List<Evenement> tableauDeEvenement = new ArrayList<>();

	@Override
	public Evenement creerEvenement(String nom, String lieu, int jour, Month mois, int annee, int heure, int minutes,
			int duree, int nbParticipants) {
		Evenement eve = new Evenement();
		if (jourValid(jour) && heureValid(heure) && minuteValid(minutes) ) {
			LocalDateTime dateTime = LocalDateTime.of(annee, mois, jour, heure, minutes);
			eve.setNom(nom);
			eve.setLieu(lieu);
			eve.setDuree(duree);
			eve.setDate(dateTime);
			eve.setNbParticipantsMax(nbParticipants);
			if(pasDeChevauchement(eve))
			{
			tableauDeEvenement.add(eve);
			return eve;
			}return eve;
		}
		return null;
	}

	private boolean jourValid(int jour) {
		return jour < 31 && jour > 0;
	}

	private boolean heureValid(int heure) {
		return heure < 23 && heure > 0;
	}

	private boolean minuteValid(int minutes) {
		return minutes > 0 && minutes < 59;
	}

	private boolean pasDeChevauchement(Evenement eve) {
		return tableauDeEvenement.stream()
				.allMatch(t -> t.pasDeChevauchementLieu(eve) && t.pasDeChevauchementTemps(eve));
	}

	@Override
	public void supprimerEvenement(Evenement evt) {
		tableauDeEvenement.removeIf(t -> t.equals(evt));
	}

	@Override
	public List<Evenement> ensembleEvenements() {
		return tableauDeEvenement;
	}

	@Override
	public List<Evenement> ensembleEvenementAvenir() {
		return tableauDeEvenement.stream().filter(t -> t.getDate().isAfter(LocalDateTime.now())).toList();
	}

	@Override
	public boolean inscriptionEvenement(Evenement evt, InterMembre mbr) {
		boolean existe = mbr.ensembleEvenementsAvenir().stream().anyMatch(t -> t.getDate().equals(evt.getDate()));
		if (evt.getParticipants().size() < evt.getNbParticipantsMax() && !existe) {
			evt.ajouterParticipant(mbr);
			mbr.AjouterensembleEvenements(evt);
			return true;
		}
		return false;
	}

	@Override
	public boolean annulerEvenement(Evenement evt, InterMembre mbr) {
		boolean existe = evt.getParticipants().stream()
				.anyMatch(t -> t.getInformationPersonnelle().getNom().equals(mbr.getInformationPersonnelle().getNom()));
		if (existe) {
			evt.getParticipants().remove(mbr);
			return true;
		}
		return false;
	}

}
