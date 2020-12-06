package proba.hackerrank.dictionariesandhashmaps;

import java.util.Arrays;

public class SherlockAndAnagrams
{
  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s)
  {
    int anagramsFound = 0;

    for ( int length = 1 ; length < s.length() ; length++)
    {
// System.out.println( "\nlength : " + length);
      for ( int start = 0 ; start < s.length() - length ; start++)
      {
        String substring = s.substring( start, start + length);
        int posArray[] = new int[substring.length()];
        for ( int i = 0 ; i < substring.length() ; i++) // megkeressuk a substring betuinek elofordulasi helyeit
        {
          posArray[i] = s.indexOf( substring.charAt(i), start + 1);
        }

        Arrays.sort( posArray); // majd megnezzuk, hogy a talalt posiciok egymas utan vannak-e == sztringet alkotnak-e

        if ( posArray[0] != -1 )
        {
          int i = 0 ;
          while ( i < posArray.length - 1 && (posArray[i+1] - posArray[i]) == 1 )
          {
            i++;
          }

          if ( i == posArray.length - 1)
          {
            anagramsFound++;
          }

        }
        //^ kell ismetelni az adott poziciotol a fo sztring vegeig

        //----------------
/*
        if ( length > 1 )
        {
          reverse = reverseString( reverse);
        }
// System.out.println( "reverse : " + reverse);

        int reverseFoundAt = s.indexOf(reverse, start + 1);

// System.out.println( "reverseFoundAt : " + reverseFoundAt);

        while ( reverseFoundAt > 0 )
        {
          anagramsFound++;
          reverseFoundAt = s.indexOf(reverse, reverseFoundAt + 1);
// System.out.println( "reverseFoundAt : " + reverseFoundAt);
        }
*/
      }
    }

    return anagramsFound;
  }

  private static String reverseString( String original)
  {
    StringBuffer stringBuffer = new StringBuffer( original);

    stringBuffer.reverse();

    return stringBuffer.toString();
  }

  public static void main(String[] args)
  {
//    String s = "abba"; // -> 4 +
//    String s = "mom"; // -> 2 +
//    String s = "abcd";  // -> 0 +
    String s = "ifailuhkqq";  // -> 3 -
//    String s = "kkkk";  // -> 10 +
//    String s = "cdcd";  // -> 5 -

    System.out.println( sherlockAndAnagrams( s));
  }
}