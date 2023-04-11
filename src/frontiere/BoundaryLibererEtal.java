package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (controlLibererEtal.isVendeur(nomVendeur)) {
			String donneesEtal[] = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0].equals(String.valueOf(false))) {
				System.out.println(
						"Vous avez vendu " + donneesEtal[3] + " sur les " + donneesEtal[4] + " " + donneesEtal[2]);
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.");
			}
		} else {
			System.out.println("Mais vous n'êtes pas inscrit sur le marché aujourd'hui !");
		}
	}

}
