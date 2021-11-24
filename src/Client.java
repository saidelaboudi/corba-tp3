import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import BanqueHeritage.CompteCourantRemunere;
import BanqueHeritage.CompteCourantRemunereHelper;

class Client {
	public static void main(String args[]) {
		// ....
		// Liaison à un compte
		Properties props = System.getProperties();
		Scanner sc = new Scanner(System.in);

		Object obj = null;
		try {
			ORB orb = ORB.init(args, props);
			String refFile = "Compte.ref";
			BufferedReader reader = new BufferedReader(new FileReader(refFile));
			String ref = reader.readLine();
			obj = orb.string_to_object(ref);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Déclaration de l’objet compte et des variables
		BanqueDelegation.CompteCourantRemunere compte = BanqueDelegation.CompteCourantRemunereHelper.narrow((Object)obj);
		// Boucle de saisie du choix du client
		char ch = lire_choix();
		while (ch != '0') {
			switch (ch) {
			case '1':
				// Lecture du montant du compte
				System.out.println("Montant"+compte.lire_montant());
				break;
			case '2':
				// Crediter le compte
				float montantC = sc.nextFloat();
				compte.crediter(montantC);
				break;
			case '3':
				// Debiter le compte
				float montantD = sc.nextFloat();
				compte.debiter(montantD);
				break;
			case '4':
				// Lecture du taux de rémunération
				System.out.println("Taux"+compte.taux());
				break;
			case '5':
				// Mise à jour du taux de rémunération
				int taux=sc.nextInt();
				compte.taux(taux);
				break;
			case '6':
				// Lecture de l’autorisation de découvert
				System.out.println("Autorisation de decouvert : "+compte.DecouvertAutorise());
				break;
			case '7':
				// Mise à jour de l’autorisation de découvert
				boolean autorisation=sc.nextBoolean();
				compte.DecouvertAutorise(autorisation);
				break;
			default:
				System.out.println("Taper le code de l'operation a effectuer : ");
				break;
			}
			ch = lire_choix();
		}
	}
//      catch(SystemException ex) //

	static char lire_choix() {
		System.out.println("+------------------+");
		System.out.println("| Service bancaire |");
		System.out.println("+------------------+\n");
		System.out.println("1 : Lecture du montant du compte");
		System.out.println("2 : Credit du compte");
		System.out.println("3 : Debit du compte\n");
		System.out.println("4 : Lecture du taux de rémunération\n");
		System.out.println("5 : Mise a jour du taux de remuneration");
		System.out.println("6 : Lecture de l'autorisation de decouvert");
		System.out.println("7 : Mise a jour de l'autorisation de decouvert\n");
		System.out.println("0 : Quitter\n");
		System.out.println("Taper le code de l'operation a effectuer : ");
		return (lire_char());
	}

	static char lire_char() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (' ');
		}
		return (chaine.charAt(0));
	}

	static float lire_float() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (0);
		}
		return (Float.parseFloat(chaine));
	}

	static int lire_int() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (0);
		}
		return (Integer.parseInt(chaine));
	}
}
