package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder text = new StringBuilder("Bienvenue villageois");
					text.append(nomVisiteur);
					System.out.println(text.toString());
					int force = Clavier.entrerEntier("Quelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder text = new StringBuilder("Bienvenue druide");
		text.append(nomVisiteur);
		System.out.println(text.toString());
		int force = Clavier.entrerEntier("Quelle est votre force ?");
		int effetPotionMin = 1;
		int effetPotionMax = 0;
		do {
			effetPotionMin = Clavier
					.entrerEntier("Quelle est la force de la potion la plus faible que vous produisiez");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisiez");
			if (effetPotionMax < effetPotionMin)
				System.out.println("Attention druide, vous vous êtes trompé entre le min et le max");
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
