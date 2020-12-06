//: Alias2.java
// Method calls implicitly alias their
// arguments.
package proba.Alias2;

class CProba
{
  public static void StringBeallit( String sString)
  {
    sString = "visszateresi ertek" ;
    System.out.println("fv-en belul :" + sString) ;
  }

  static void f(Alias2 handle)
  {
    handle.i++;
  }

  static void foo(CSztringProba cSztringProba)
  {
    cSztringProba.m_sSztring  = "visszateresi ertek" ;;
  }

}

class CSztringProba
{
  public CSztringProba( String sKezdoertek)
  {
    m_sSztring = sKezdoertek ;
  }

  public String m_sSztring = new String() ;
}

public class Alias2
{
  int i;

  Alias2(int ii)
  {
    i = ii ;
  }

  public static void main(String[] args)
  {
    Alias2 x = new Alias2(7);
    System.out.println("x: " + x.i);
    System.out.println("Calling f(x)");
    CProba.f(x);
    System.out.println("x: " + x.i);


    String sProbaSztring = new String( "kezdoertek") ;

    System.out.println("fv hivas elott :" + sProbaSztring) ;

    CProba.StringBeallit( sProbaSztring) ;

    System.out.println("fv hivas utan :" + sProbaSztring) ;


    CSztringProba sSztringProba = new CSztringProba( "kezdoertek") ;

    System.out.println("fv hivas elott :" + sSztringProba.m_sSztring) ;

    CProba.foo( sSztringProba) ;

    System.out.println("fv hivas utan :" + sSztringProba.m_sSztring) ;
  }
} ///:~