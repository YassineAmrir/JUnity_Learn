package association;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Month;
import java.util.List;
import java.io.File;
import java.nio.file.*;
import java.io.*;

public class GestionAssociation implements InterGestionAssociation {

	@Override
	public InterGestionEvenements gestionnaireEvenements() {
		
		return new GestionEvenement();
	}

	@Override
	public InterGestionMembres gestionnaireMembre() {
		
		return new GestionMembres();
	}
	@Override
	  public InterMembre gestionnaireMembre1() {
		
		return new Membre();
	}

	@Override
	public void sauvegarderDonnees(String nomFichier) throws IOException {
		try {
		      File myObj = new File(nomFichier);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        FileOutputStream fileOut = new FileOutputStream("test");
		        ObjectOutputStream out = new ObjectOutputStream(fileOut);
		        out.writeObject(gestionnaireMembre().ensembleMembres());
		        out.writeObject(gestionnaireEvenements().ensembleEvenements());
		        out.close();
		        fileOut.close();
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

	@Override
	public void chargerDonnees(String nomFichier) throws IOException {
		 String str = new String(Files.readAllBytes(Paths.get(nomFichier)));
	     System.out.println(str);
		
	}

	
}
