package association;

import java.util.List;

/**
 * D�finit les actions pour un membre d'une association qui peut participer �
 * des �v�nements organis�s par l'association.
 *
 * @author Eric Cariou
 */
public interface InterMembre {
	boolean isPresident();
    void DesignerCommePresident ();
	
  /**
   * La liste des �v�nements auquel le membre est inscrit ou a particip�.
   *
   * @return la liste des �v�nements du membre
   */
  List<Evenement> ensembleEvenements();
  void AjouterensembleEvenements(Evenement e);

  /**
   * La liste des �v�nements auquel le membre est inscrit et qui n'ont pas
   * encore eu lieu.
   *
   * @return la liste des �v�nements � venir du memmbre
   */
  List<Evenement> ensembleEvenementsAvenir();

  /**
   * D�finit les informations personnelles du membre.
   *
   * @param info les informations personnelles du membre
   */
  void definirInformationPersonnnelle(InformationPersonnelle info);

  /**
   * Renvoie les informations personnelles du membre.
   *
   * @return l'objet contenant les informations personnelles du membre ou
   *         <code>null</code> si elles n'ont pas �t� d�finies
   */
  InformationPersonnelle getInformationPersonnelle();
}
