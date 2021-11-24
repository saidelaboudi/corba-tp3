package BanqueDelegation;

public class Compte_Impl implements CompteOperations{

	public float montant ;
	public Compte_Impl(float montant) {
		this.montant=montant;
	}

	@Override
	public float lire_montant() {
		return this.montant;
	}

	@Override
	public void crediter(float somme_credit) {
		if(this.montant>somme_credit)
			this.montant-=somme_credit;
	}

	@Override
	public void debiter(float somme_debit) {
		this.montant+=somme_debit;
		
	}

}
