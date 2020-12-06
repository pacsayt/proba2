package proba.hackerrank.stringmanipulation;

import java.util.HashMap;
import java.util.Map;

public class StringsMakingAnagrams
{
  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b)
  {
    int deduction = 0;

    Map<String, Integer> mapA = new HashMap<>( a.length());
    Map<String, Integer> mapB = new HashMap<>( b.length());

    for ( int i = 0 ; i < a.length() ; i++ )
    {
      mapA.merge(a.substring(i, i+1), 1, (vA, vB) -> vA + 1);
    }

    for ( int i = 0 ; i < b.length() ; i++ )
    {
      mapB.merge(b.substring(i, i+1), 1, (vA, vB) -> vA + 1);
    }

    for ( Map.Entry<String,Integer> entryA : mapA.entrySet() )
    {
      Integer valueB = mapB.get( entryA.getKey());

      if ( valueB == null )
      {
        deduction = deduction + entryA.getValue();
      }
      else
      {
        deduction = deduction + Math.abs( valueB - entryA.getValue());
        mapB.remove( entryA.getKey());
      }
    }

    for ( Map.Entry<String,Integer> entryB : mapB.entrySet() )
    {
      deduction = deduction + entryB.getValue();
    }

    return deduction;
  }

  public static void main(String[] args)
  {
//    String a = "cde";
//    String b = "dcf";
    String a = "cde";
    String b = "abc";

    System.out.println( makeAnagram( a, b));
  }
}
