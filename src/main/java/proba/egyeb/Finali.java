package proba.egyeb;

import java.io.IOException;

/**
 * Created by Tamas_Pacsay on 11/17/2017.
 */
public class Finali
{
  public static void teszt()
  {
    int i = 2;

    try
    {
      switch ( i )
      {
        case 0 :
        {
          System.out.println("TRY RuntimeException");
          throw new RuntimeException("AAA");
        }

        case 1 :
        {
          System.out.println("TRY IOException");
          throw new IOException("BLA");
        }

        case 2 :
        {
          System.out.println("TRY System.exit( 0);");
          System.exit( 0);
        }
      }
    }
    catch(IOException ioException)
    {
      System.out.println("CATCH IOException");
    }
    finally
    {
      System.out.println("FINALLY");
    }

    System.out.println("UTANA");
  }

  public static void main(String[] args)
  {
    teszt();
  }
}
