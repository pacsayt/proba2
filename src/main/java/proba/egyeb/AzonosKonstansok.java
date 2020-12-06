package proba.egyeb;

/**
 * Created by Tamas_Pacsay on 11/2/2017.
 */
public class AzonosKonstansok
{
  public static void strings()
  {
    String a1 = "AAAAA";
    String a2 = "AAAAA";

    System.out.println( "a1(" + a1 + ") == a2(" + a2 + ") = " + (a1 == a2));

    String a3 = new String( "AAAAA");

    System.out.println( "a1(" + a1 + ") == a3(" + a3 + ") = " + (a1 == a3));
  }

  public static void integers()
  {
    Integer a1 = 65535;
    Integer a2 = 65535;

    System.out.println( "a1(" + a1 + ") == a2(" + a2 + ") = " + (a1 == a2));

    Integer a3 = new Integer( 65535);

    System.out.println( "a1(" + a1 + ") == a3(" + a3 + ") = " + (a1 == a3));
  }

  public static void main(String[] args)
  {
    strings();

    integers();
  }
}
