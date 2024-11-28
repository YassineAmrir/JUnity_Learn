package association;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Membre implements InterMembre {
	
	
	private InformationPersonnelle info ;
	private List<Evenement> ensembleEvenements= new ArrayList<>() ;
	private List<Evenement> ensembleEvenementsAvenir= new ArrayList<>() ;
	private boolean isPresident ;
	

	@Override
	public List<Evenement> ensembleEvenements() { 
		return ensembleEvenements;
	}
	@Override
	public void AjouterensembleEvenements(Evenement e) { 
		 ensembleEvenements.add(e);
	}

	@Override
	public List<Evenement> ensembleEvenementsAvenir() {
         
		return ensembleEvenementsAvenir;
	}

	@Override
	public void definirInformationPersonnnelle(InformationPersonnelle info) {
	    this.info = info;
		
	}

	@Override
	public InformationPersonnelle getInformationPersonnelle() {
		
		return info;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ensembleEvenements, ensembleEvenementsAvenir, info);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre other = (Membre) obj;
		return this.info.getNom().equals(other.info.getNom())&& this.info.getPrenom().equals(other.info.getPrenom()) ;
	}

	
    @Override
	public boolean isPresident() {
		return isPresident;
	}

	@Override
	public void DesignerCommePresident() {
		this.isPresident=true;
	}
	
	
}
