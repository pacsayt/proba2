package proba.hackerrank.arrays;

public class NewYearChaos
{
  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {

    int arrayLength = q.length;
    int actualSwapNo = 0;
    int minNoOfSwaps = 0;

    for( int idxOuter = 0; idxOuter < arrayLength-1 ; idxOuter++ )
    {
      actualSwapNo = 0;

      for ( int idxInner = idxOuter; idxInner < arrayLength && actualSwapNo < 3 ; idxInner++ )
      {
        if ( q[idxInner] < q[idxOuter] )
        {
          actualSwapNo++;
        }
      }

      if ( actualSwapNo < 3 )
      {
        minNoOfSwaps += actualSwapNo;
      }
      else
      {
        System.out.println( "Too chaotic");
        break;
      }
    }

    if ( actualSwapNo < 3 )
    {
      System.out.println( minNoOfSwaps);
    }
  }

  public static void main(String[] args)
  {
//    int a[] = { 2, 1, 5, 3, 4};
//    int a[] = { 2, 5, 1, 3, 4};
    int a[] = { 1, 2, 5, 3, 7, 8, 6, 4};

    minimumBribes( a);
  }
}
