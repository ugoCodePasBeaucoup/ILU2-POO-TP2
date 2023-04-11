package frontiere;

import java.util.InputMismatchException;
import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!(controlAcheterProduit.verifierIdentite(nomAcheteur))) {
			System.out.println("Vous devez faire partie de ce village");
		} else {
			System.out.println("Quel produit souhaitez-vous acheter ?");
			String produit = scan.next();
			System.out.println("Quelle quantité voulez-vous acheter ?");
			int quantite;
			try {
				quantite = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Cette quantité n'est pas valide");
				return;
			}
			Gaulois listeVendeurs[] = controlAcheterProduit.vendeursProduit(produit);
			if (listeVendeurs == null) {
				System.out.println("Pas de vendeurs pour le produit " + produit);
				return;
			}
			Gaulois VendeursEnStock[] = new Gaulois[listeVendeurs.length];
			System.out.println("Chez quel commerçant voulez-vous acheter ? :");
			int nbVendeurs = 0;
			for (int i = 0; i < listeVendeurs.length; i++) {
				if (controlAcheterProduit.quantiteProduitEtal(listeVendeurs[i]) >= quantite) {
					VendeursEnStock[nbVendeurs] = listeVendeurs[i];
					nbVendeurs++;
					System.out.println(nbVendeurs + "-" + listeVendeurs[i].getNom());
				}
			}

			if (nbVendeurs == 0) {
				System.out.println("\n Aucun vendeur ne possède autant de " + produit);
			} else {
				int vendeurCible;
				try {
					vendeurCible = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Ce vendeur n'est pas dans la liste");
					return;
				}
				vendeurCible--;
				if (vendeurCible < 0 || vendeurCible >= nbVendeurs) {
					System.out.println("Ce vendeur n'est pas dans la liste");
				} else {
					int quantiteAchete = controlAcheterProduit.acheterProduit(VendeursEnStock[vendeurCible], quantite);
					System.out.println(
							"Vous avez acheté " + quantiteAchete + " à " + VendeursEnStock[vendeurCible].getNom());
				}
			}

		}
	}
}
