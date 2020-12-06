package proba.hackerrank.greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

public class LuckBalance
{
  static int luckBalance(int k, int[][] contests)
  {
    int sum = 0;

    List<Integer> importantValues = new ArrayList<Integer>(contests.length);

    for ( int i = 0; i < contests.length ; i++ )
    {
      if ( contests[i][1] == 1 )
      {

        importantValues.add( contests[i][0]);
      }
      else
      {

        sum = sum + contests[i][0];
      }
    }

    importantValues.sort( Integer::compareTo);

    int max = Math.max( importantValues.size()-k, 0);
    int minus = 0;
    for ( int i = 0 ; i < max; i++)
    {
      minus = minus + importantValues.get( i);
    }

    for ( int i = max ; i < importantValues.size() ; i++ )
    {
      sum = sum + importantValues.get( i);
    }

    return sum - minus;
  }

  public static void main(String[] args)
  {
//    int arr[][] = { {5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}};
//    int k = 3;
    int arr[][] = { {5, 1}, {1, 1}, {4, 0}};
    int k = 2;

    System.out.println( luckBalance( k, arr));
  }
}
