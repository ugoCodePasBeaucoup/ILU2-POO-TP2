package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(Gaulois vendeur, int nbProduits) {
		Etal etal = village.rechercherEtal(vendeur);
		return (etal.acheterProduit(nbProduits));
	}

	public boolean verifierIdentite(String nomVendeur) {
		return (controlVerifierIdentite.verifierIdentite(nomVendeur));
	}

	public Gaulois[] vendeursProduit(String produit) {
		return (village.rechercherVendeursProduit(produit));
	}

	public int quantiteProduitEtal(Gaulois vendeur) {
		Etal etal = village.rechercherEtal(vendeur);
		return (etal.getQuantite());
	}

}
