package association;

import java.io.IOException;

/**
 * D�finition des actions de gestion de l'association.
 *
 * @author Eric Cariou
 */
public interface InterGestionAssociation {

  /**
   * Renvoie le gestionnaire d'�v�nements de l'association. L'objet retourn� est
   * unique. Au premier appel de la m�thode, il est cr�� et aux appels suivants,
   * c'est la r�f�rence sur cet objet qui est retourn�e.
   *
   * @return le gestionnaire d'�v�nements de l'association
   */
  InterGestionEvenements gestionnaireEvenements();

  /**
   * Renvoie le gestionnaire de membres de l'association. L'objet retourn� est
   * unique. Au premier appel de la m�thode, il est cr�� et aux appels suivants,
   * c'est la r�f�rence sur cet objet qui est retourn�e.
   *
   * @return le gestionnaire de membres de l'association
   */
  InterGestionMembres gestionnaireMembre();
  
  /**
   * Enregistre dans un fichier toutes les donn�es de l'association,
   * c'est-�-dire l'ensemble des membres et des �v�n�ments.
   *
   * @param nomFichier le fichier dans lequel enregistrer les donn�es
   * @throws IOException en cas de probl�me d'�criture dans le fichier
   */
  void sauvegarderDonnees(String nomFichier) throws IOException;

  /**
   * Charge � partir d'un fichier toutes les donn�es de l'association,
   * c'est-�-dire un ensemble de membres et d'�v�nements. Si des membres et des
   * �v�n�ments avaient d�j� �t� d�finis, ils sont �cras�s par le contenu trouv�
   * dans le fichier.
   *
   * @param nomFichier le fichier � partir duquel charger les donn�es
   * @throws IOException en cas de probl�me de lecture dans le fichier
   */
  void chargerDonnees(String nomFichier) throws IOException;
  InterMembre gestionnaireMembre1();
}
