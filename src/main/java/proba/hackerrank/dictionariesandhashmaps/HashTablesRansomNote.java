package proba.hackerrank.dictionariesandhashmaps;

import java.util.*;

public class HashTablesRansomNote
{
  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {

    Map<String, Integer> magazineMap = new HashMap<>(magazine.length);

    for ( String m : magazine )
    {
//      magazineSet.computeIfPresent( s, (key, val) -> magazineSet.getOrDefault( key, Integer.valueOf(0)) + 1);
      Integer i = magazineMap.get( m);

      if ( i != null )
      {
        magazineMap.put( m, i+1);
      }
      else
      {
        magazineMap.put( m, 1);
      }
    }

    for ( String n : note)
    {
      Integer i = magazineMap.get(n);

      if ( i != null )
      {
        if ( i > 0 )
        {
          magazineMap.put( n, i - 1);
        }
        else
        {
          System.out.println( "No");
          return;
        }
      }
      else
      {
        System.out.println( "No");
        return;
      }
    }

    System.out.println( "Yes");
  }

  // Complete the checkMagazine function below.
  static void checkMagazine2(String[] magazine, String[] note)
  {

    Map<String, Integer> magazineMap = new HashMap<>(magazine.length);

    for ( String m : magazine )
    {
      Integer result = magazineMap.merge( m, 1, (oldValue, newValue) -> { return oldValue + 1;});
      System.out.println( "result=" + result);
    }

    System.out.println( magazineMap);
  }

  public static void main(String[] args)
  {
//    String magazine[] = { "give", "me", "one", "grand", "today", "night"};
//    String note[] = { "give", "one", "grand", "today"};

//    String magazine[] = { "two", "times", "three", "is", "not", "four"};
//    String note[] = { "two", "times", "two", "is", "four"};

    String magazine[] = { "ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
    String note[] = { "ive", "got", "some", "coconuts"};

    checkMagazine( magazine, note);

//    String magazine[] = { "A", "A", "B", "C", "B", "B", "D", "B", "D"};
//    String note[] = { "ive", "got", "some", "coconuts"};
//
//    checkMagazine2( magazine, note); reszmegoldas csak ... https://www.programiz.com/java-programming/library/hashmap/putifabsent
  }
}
