package proba.egyeb;

/**
 * Created by Tamas_Pacsay on 7/18/2017.
 */
public class DoubleEquals
{
  public static void egy()
  {
    Object object = null;
    if (object == null == object.equals( null) )
    {
      System.out.println( "DoubleEquals::main() : ^ NPE");
    }
  }

  public static void main(String args[])
  {
    egy();
  }
}

