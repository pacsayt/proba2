package egyeb;

/**
 * Created by Tamas_Pacsay on 7/25/2017.
 */
public class NullCheck
{

  static Boolean getBooleanNull() {
    return null;
  }

  public static void main(String args[])
  {
    if ( Boolean.FALSE.equals( getBooleanNull())) {
      System.out.println( "main() : Boolean.FALSE.equals( getBooleanNull()) == TRUE");
    }

    if ( Boolean.TRUE.equals( getBooleanNull())) {
      System.out.println( "main() : Boolean.TRUE.equals( getBooleanNull()) == TRUE");
    }

    System.out.println( "main() : END");
  }
}
