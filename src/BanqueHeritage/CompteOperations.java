package BanqueHeritage;


/**
* BanqueHeritage/CompteOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Banque.idl
* mercredi 24 novembre 2021 09 h 12 WEST
*/

public interface CompteOperations 
{
  float lire_montant ();
  void crediter (float somme_credit);
  void debiter (float somme_debit);
} // interface CompteOperations