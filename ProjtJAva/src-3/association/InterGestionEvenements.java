package association;

import java.time.Month;
import java.util.List;

/**
 * Gestion des �v�nements d'une association.
 *
 * @author Eric Cariou
 *
 */
public interface InterGestionEvenements { 

  /**
   * Cr�e un nouvel �v�nement. Plusieurs v�rifications sont effectu�es : que les
   * dates et heures sont coh�rentes et qu'il n'y a pas un chevauchement sur la
   * m�me p�riode avec un autre �v�nement dans le m�me lieu.
   *
   * @param nom le nom de l'�v�nement
   * @param lieu le lieu
   * @param jour le jour dans le mois (nombre de 0 � 31)
   * @param mois le mois dans l'ann�e
   * @param annee l'ann�e
   * @param heure l'heure de la journ�e (nombre entre 0 et 23)
   * @param minutes les minutes de l'heure (nombre entre 0 et 59)
   * @param duree la dur�e (en minutes)
   * @param nbParticipants le nombre maximum de participants (0 signifie un
   *        nombre quelconque)
   * @return l'�v�nement cr�� ou <code>null</code> en cas de probl�me
   *         (param�tres non valides)
   */
  Evenement creerEvenement(String nom, String lieu, int jour, Month mois,
      int annee, int heure, int minutes, int duree, int nbParticipants);

  /**
   * Supprime un �v�nement. Les membres qui �taient inscrits sont
   * automatiquement d�sinscrits de l'�v�nement supprim�. Si l'�v�nement
   * n'existait pas, la m�thode ne fait rien.
   *
   * @param evt l'�v�nement � supprimer.
   */
  void supprimerEvenement(Evenement evt);

  /**
   * Renvoie l'ensemble des �v�nements de l'association.
   *
   * @return l'ensemble des �v�nements
   */
  List<Evenement> ensembleEvenements();

  /**
   * Renvoie l'ensemble des �v�nements � venir de l'association.
   *
   * @return l'ensemble des �v�nements � venir
   */
  List<Evenement> ensembleEvenementAvenir();

  /**
   * Un membre est incrit � un �v�nement.
   *
   * @param evt l'�v�nement auquel s'inscrire
   * @param mbr le membre qui s'inscrit
   * @return <code>true</code> s'il n'y a pas eu de probl�me, <code>false</code>
   *         si l'�v�nement est en conflit de calendrier avec un �v�nement
   *         auquel est d�j� inscrit le membre ou si le nombre de participants
   *         maximum est d�j� atteint
   */
  boolean inscriptionEvenement(Evenement evt, InterMembre mbr);

  /**
   * D�sincrit un membre d'un �v�nement.
   *
   * @param evt l'�v�nement auquel se d�sinscrire
   * @param mbr le membre qui se d�sincrit
   * @return si le membre �tait bien inscrit � l'�v�nement, renvoie
   *         <code>true</code> pour pr�ciser que l'annulation est effective,
   *         sinon <code>false</code> si le membre n'�tait pas inscrit �
   *         l'�v�nement
   */
  boolean annulerEvenement(Evenement evt, InterMembre mbr);
}
