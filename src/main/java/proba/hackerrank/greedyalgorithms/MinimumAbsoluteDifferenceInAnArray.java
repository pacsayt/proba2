package proba.hackerrank.greedyalgorithms;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInAnArray
{
  static int minimumAbsoluteDifference(int[] arr)
  {
    int minAbsDiff = Integer.MAX_VALUE;
    Arrays.sort( arr);

    for ( int i = 0 ; i < arr.length - 1 ; i++ )
    {
      int actualDiff = Math.abs( arr[i] - arr[i+1]);
      if ( minAbsDiff > actualDiff )
      {
        minAbsDiff = actualDiff;
      }
    }

    return minAbsDiff;
  }

  public static void main(String[] args)
  {
//    int a[] = {3, -7, 0} ;
//    int a[] = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75} ;
    int a[] = {1, -3, 71, 68, 17};
    System.out.println( minimumAbsoluteDifference( a));
  }
}
