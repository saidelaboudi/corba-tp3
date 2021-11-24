package BanqueDelegation;

public class CompteCourantRemunere_Impl extends CompteEpargne_Impl implements CompteCourantRemunereOperations {

	public CompteCourantRemunere_Impl(float montant, int taux, boolean decouvertAutorise) {
		super(montant, taux, decouvertAutorise);
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
