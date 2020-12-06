package proba.egyeb;

/**
 * Created by Tamas_Pacsay on 6/21/2017.
 */
public class IntFloat
{

  public static void main( String args[])
  {
    int ossz = 100;
    int egyik = 40;
    int hatarertek = 40;

    double eredmeny = 100*(egyik/(double)ossz);
    System.out.println( "eredmeny=" + eredmeny + " szazalek=" + (eredmeny == hatarertek));
  }
}
