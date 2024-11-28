package association;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Gestion des membres de l'association.
 *
 * @author Eric Cariou
 */
public interface InterGestionMembres {
  /**
   * Ajoute un membre dans l'association. Ne fait rien si le membre �tait d�j�
   * pr�sent dans l'association.
   *
   * @param membre le membre � rajouter
   * @return <code>true</code> si le membre a bien �t� ajout�,
   *         <code>false</code> si le membre �tait d�j� pr�sent (dans ce cas il
   *         n'est pas ajout� � nouveau)
   */
  boolean ajouterMembre(InterMembre membre);
  boolean modifierMembre(InterMembre membre);
  
  /**
   * Supprime un membre de l'association.
   *
   * @param membre le membre � supprimer
   * @return <code>true</code> si le membre �tait pr�sent et a �t� supprim�,
   *         <code>false</code> si le membre n'�tait pas dans l'association
   */
  boolean supprimerMembre(InterMembre membre);
  
  /**
   * D�signe le pr�sident de l'association. Il doit �tre un des membres de
   * l'association.
   *
   * @param membre le membre � d�signer comme pr�sident.
   * @return <code>false</code> si le membre n'�tait pas dans l'association (le
   *         pr�sident n'est alors pas positionn�), <code>true</code> si le
   *         membre a �t� nomm� pr�sident
   */
  boolean designerPresident(InterMembre membre);
  
  /**
   * Renvoie l'ensemble des membres de l'association.
   *
   * @return l'ensemble des membres de l'association.
   */
  Set<InterMembre> ensembleMembres();
  
  /**
   * Renvoie le pr�sident de l'association.
   *
   * @return le membre pr�sident de l'association s'il avait �t� d�sign� sinon
   *         retourne <code>null</code>
   */
  InterMembre president();
}
