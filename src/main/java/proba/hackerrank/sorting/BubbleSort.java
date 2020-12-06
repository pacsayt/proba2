package proba.hackerrank.sorting;


public class BubbleSort
{


  // Complete the countSwaps function below.
  static void countSwaps(int[] a)
  {
    int numSwaps = 0;

    int n = a.length;

    for ( int i = 0; i < n; i++ )
    {

      for ( int j = 0; j < n - 1; j++ )
      {
        // Swap adjacent elements if they are in decreasing order
        if ( a[j] > a[j + 1] )
        {
          int swap = a[j];
          a[j] = a[j + 1];
          a[j + 1] = swap;

          numSwaps++;
        }
      }
    }

    System.out.println("Array is sorted in " + numSwaps + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[n - 1]);
  }

  public static void main(String[] args)
  {
    int a[] = { 3, 2, 1};
    countSwaps(a);
  }
}
