package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour " + nomVendeur + ",je vais regarder si je peux vous trouver un étal");
			if (controlPrendreEtal.resteEtals()) {
				String produit;
				int nbProduits;
				int numEtal;
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un étal pour vous !");
				System.out.println("Il me faudrait quelques renseignements : \n\nQuel produit souhaitez-vous vendre ?");
				produit = scan.next();
				System.out.println("Combien souhaitez-vous en vendre ?");
				nbProduits = scan.nextInt();
				numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
				if (numEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + numEtal);
				} else {
					System.out.println("Le vendeur " + nomVendeur + " n'a pas pu s'intaller finalement...");
				}
			} else {
				System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}
		} else {
			System.out.println("Je suis désolé " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		// TODO a completer
	}
}
