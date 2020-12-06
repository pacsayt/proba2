package proba.com.company;

/**
 * Created by Tamas_Pacsay on 3/10/2017.
 */
public class StringBuilderNull
{
  public static void main(String[] args) throws InterruptedException
  {
    StringBuilder stringBuilder = new StringBuilder();
    Long l = null;
    stringBuilder.append( l);

    System.out.println( ">" + stringBuilder.toString() + "<"); // -> >null<
  }
}
