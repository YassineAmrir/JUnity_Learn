package association;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Evenement implements java.io.Serializable {

	private String nom;

	private String lieu;

	private LocalDateTime date;

	private int duree;

	private int nbParticipantsMax;

	static Set<InterMembre> participants = new HashSet<>();

	// A impl�menter : retourne vrai si deux �v�nements ne se chevauchent pas
	// dans le m�me lieu en m�me temps
	public boolean pasDeChevauchementLieu(Evenement evt) {
		return Objects.equals(evt.lieu, this.lieu) ? false : true;
	}

	// A impl�menter : retourne vrai si deux �v�nements ne se chevauchent pas
	// dans le temps (ind�pendamment du lieu)
	public boolean pasDeChevauchementTemps(Evenement evt) {
		return Objects.equals(evt.date, this.date) ? false : true;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNbParticipantsMax() {
		return nbParticipantsMax;
	}

	public void setNbParticipantsMax(int nbParticipantsMax) {
		this.nbParticipantsMax = nbParticipantsMax;
	}

	public Set<InterMembre> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<InterMembre> participants) {
		this.participants = participants;
	}

	public void ajouterParticipant(InterMembre mbr) {
		participants.add(mbr);
	}

	@Override
	public String toString() {
		return "Evenement [nom=" + nom + ", lieu=" + lieu + ", date=" + date + ", duree=" + duree
				+ ", nbParticipantsMax=" + nbParticipantsMax + ", participants=" + participants + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, duree, lieu, nbParticipantsMax, nom, participants);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evenement other = (Evenement) obj;
		return Objects.equals(date, other.date) && duree == other.duree && Objects.equals(lieu, other.lieu)
				&& nbParticipantsMax == other.nbParticipantsMax && Objects.equals(nom, other.nom)
				&& Objects.equals(participants, other.participants);
	}

	// A compl�ter :
	//
	// - g�n�ration automatique des getters, setters, constructeurs,
	// des m�thodes hashCode, toString et equals.
	// Modifiez manuellement le code g�n�r� au besoin. Rajoutez notamment
	// les m�thodes de gestion des participants � l'�v�nement.
	//
	// - Rajoutez un/des constructeurs permettant de construire plus facilement
	// un �v�nement sans avoir besoin de passer un param�tre de type LocalDateTime
	//
	// - Ecrivez la JavaDoc compl�te de la classe
}
