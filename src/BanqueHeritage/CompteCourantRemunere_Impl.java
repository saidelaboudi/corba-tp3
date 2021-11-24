package BanqueHeritage;

public class CompteCourantRemunere_Impl extends CompteCourantRemunerePOA{
	
	public float montant ;
	public int taux;
	public boolean decouvertAutorise;
	public CompteCourantRemunere_Impl(float montant,int taux,boolean decouvertAutorise) {
		this.montant=montant;
		this.taux=taux;
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

	@Override
	public int taux() {
		return this.taux;
	}

	@Override
	public void taux(int newTaux) {
		this.taux=newTaux;
	}

}
