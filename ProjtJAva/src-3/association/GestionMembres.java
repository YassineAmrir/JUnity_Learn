package association;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GestionMembres implements InterGestionMembres{
	
	
	static List<InterMembre> tableauDeMembres= new ArrayList<>();
	@Override
	public boolean ajouterMembre(InterMembre membre) {
		 
		 boolean existeDeja = tableauDeMembres.stream().anyMatch(
				 currentMembre -> currentMembre.equals(membre)) ;
		 if (!existeDeja)
		 {
			 tableauDeMembres.add(membre);
		     return true;
		 }
	 return false;
	}
	@Override
	public boolean modifierMembre(InterMembre membre) {
		  
		boolean removed=tableauDeMembres.removeIf( currentMembre -> currentMembre.equals(membre));
		
		 if (removed)
		 {
			 tableauDeMembres.add(membre);
		     return true;
		 }
	 return false;
	}
	
	@Override
	public boolean supprimerMembre(InterMembre membre) {
	   return tableauDeMembres.removeIf(t -> t.equals(membre));
	}
	@Override
	public boolean designerPresident(InterMembre membre) {
		 
		boolean existeDeja = tableauDeMembres.stream().anyMatch(
				 currentMembre -> currentMembre.equals(membre)) ;
		 if (existeDeja)
		 {
			 membre.DesignerCommePresident();
		     return true;
		 }
	 return false;
	}
	@Override
	public Set<InterMembre> ensembleMembres() {
		return Set.copyOf(tableauDeMembres);
	}
	@Override
	public InterMembre president() {
        return tableauDeMembres.stream().filter(InterMembre::isPresident).findFirst().orElseGet(null);
	}
}
