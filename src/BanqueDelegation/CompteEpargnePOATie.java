package BanqueDelegation;


/**
* BanqueDelegation/CompteEpargnePOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from BanqueDelegation.idl
* mercredi 24 novembre 2021 09 h 47 WEST
*/

public class CompteEpargnePOATie extends CompteEpargnePOA
{

  // Constructors

  public CompteEpargnePOATie ( BanqueDelegation.CompteEpargneOperations delegate ) {
      this._impl = delegate;
  }
  public CompteEpargnePOATie ( BanqueDelegation.CompteEpargneOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public BanqueDelegation.CompteEpargneOperations _delegate() {
      return this._impl;
  }
  public void _delegate (BanqueDelegation.CompteEpargneOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public int taux ()
  {
    return _impl.taux();
  } // taux
  public void taux (int newTaux)
  {
    _impl.taux(newTaux);
  } // taux

  public float lire_montant ()
  {
    return _impl.lire_montant();
  } // lire_montant

  public void crediter (float somme_credit)
  {
    _impl.crediter(somme_credit);
  } // crediter

  public void debiter (float somme_debit)
  {
    _impl.debiter(somme_debit);
  } // debiter

  private BanqueDelegation.CompteEpargneOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class CompteEpargnePOATie