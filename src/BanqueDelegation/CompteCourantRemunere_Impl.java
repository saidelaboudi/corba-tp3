package BanqueDelegation;

public class CompteCourantRemunere_Impl extends CompteEpargne_Impl implements CompteCourantRemunereOperations {


	public boolean decouvertAutorise;
	public CompteCourantRemunere_Impl(float montant, int taux, boolean decouvertAutorise) {
		super(montant, taux);
		this.decouvertAutorise=decouvertAutorise;
	}

	@Override
	public boolean DecouvertAutorise() {
		return this.decouvertAutorise;
	}

	@Override
	public void DecouvertAutorise(boolean newDecouvertAutorise) {
		this.decouvertAutorise=newDecouvertAutorise;
	}

}
