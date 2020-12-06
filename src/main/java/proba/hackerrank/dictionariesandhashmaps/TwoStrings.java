package proba.hackerrank.dictionariesandhashmaps;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings
{
  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2)
  {
    Set<String> s1CharSet = new HashSet<>( s1.length());

    for ( int i = 0; i < s1.length(); i++ )
    {
      s1CharSet.add( s1.substring( i, i+1));
    }

       for ( int j = 0 ; j < s2.length(); j++)
       {

         char c = s2.charAt( j);
         if ( s1CharSet.contains(  String.valueOf(c)) )
         {
           return "YES";
         }
       }

     return "NO";
  }

  public static void main(String[] args)
  {
//    String s1 = "hello";
//    String s2 = "world";

    String s1 = "hi";
    String s2 = "world";

    System.out.println( twoStrings( s1, s2));
  }
}
