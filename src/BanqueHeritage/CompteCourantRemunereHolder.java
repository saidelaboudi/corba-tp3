package BanqueHeritage;

/**
* BanqueHeritage/CompteCourantRemunereHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Banque.idl
* mercredi 24 novembre 2021 09 h 12 WEST
*/

public final class CompteCourantRemunereHolder implements org.omg.CORBA.portable.Streamable
{
  public BanqueHeritage.CompteCourantRemunere value = null;

  public CompteCourantRemunereHolder ()
  {
  }

  public CompteCourantRemunereHolder (BanqueHeritage.CompteCourantRemunere initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BanqueHeritage.CompteCourantRemunereHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BanqueHeritage.CompteCourantRemunereHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BanqueHeritage.CompteCourantRemunereHelper.type ();
  }

}