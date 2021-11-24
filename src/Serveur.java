

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;


import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManager;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import BanqueDelegation.CompteCourantRemunere;
import BanqueDelegation.CompteCourantRemunerePOATie;
import BanqueDelegation.CompteCourantRemunere_Impl;


// import …
public class Serveur {
	public static void main(String args[]) {
		Properties props = System.getProperties();
		
		System.out.println("+------------------+");
		System.out.println("| Service bancaire |");
		System.out.println("+------------------+\n");

// Création de l’objet d’implantation

// Copie de la référence dans un fichier
		try {
			ORB orb = ORB.init(args, props);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			POAManager manager = rootPOA.the_POAManager();
			
			//Hertitage
			/*
			BanqueHeritage.CompteCourantRemunere_Impl unCompte = new BanqueHeritage.CompteCourantRemunere_Impl(10000,0,false);
			BanqueHeritage.CompteCourantRemunere compte = unCompte._this(orb);
			*/
			//delegation
			
			BanqueDelegation.CompteCourantRemunere_Impl compteDelege = new BanqueDelegation.CompteCourantRemunere_Impl(10000,0,false);
			BanqueDelegation.CompteCourantRemunerePOATie unCompte = new BanqueDelegation.CompteCourantRemunerePOATie(compteDelege);
			BanqueDelegation.CompteCourantRemunere compte = unCompte._this(orb);
			
			
			String ref = orb.object_to_string(compte);
			String refFile = "Compte.ref";
			
			FileOutputStream file = new FileOutputStream(refFile);
			PrintWriter out = new PrintWriter(file);
			
			out.println(ref);
			
			out.flush();
			file.close();
			
			manager.activate();
			
			orb.run();
		} catch (java.io.IOException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdapterInactive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
