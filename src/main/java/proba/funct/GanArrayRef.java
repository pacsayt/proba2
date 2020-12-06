package funct;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Tamas_Pacsay on 11/29/2016.
 */
public class GanArrayRef
{
  public static void main(String[] argv)
  {
    Function<String[],List<String>> asList = Arrays::<String>asList; // pt++ : nem jo itt a <>

    System.out.println( asList.apply( new String[]{ "a","b","c"}));
  }

}
