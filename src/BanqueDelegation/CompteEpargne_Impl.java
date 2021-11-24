package BanqueDelegation;

public class CompteEpargne_Impl extends Compte_Impl implements CompteEpargneOperations {

	public int taux;
	
	public CompteEpargne_Impl(float montant, int taux) {
		super(montant);
		this.taux=taux;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int taux() {
		return this.taux;
	}

	@Override
	public void taux(int newTaux) {
		this.taux=newTaux;
	}

}
