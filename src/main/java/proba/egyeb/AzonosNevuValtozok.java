package proba.egyeb;

/**
 * Created by Tamas_Pacsay on 8/7/2017.
 */
public class AzonosNevuValtozok
{

  public static void main( String args[])
  {
//    int x = 100; // already defined in the scope
    {
      int x = 100;
    }

    for ( int x = 0; x < 2 ; x++)
    {
//      {
//        int x = 100; // already defined in the scope
//      }

//        int x = 100; // already defined in the scope

      System.out.println( "x:" + x);
    }
  }
}
