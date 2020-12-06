package proba.hackerrank.arrays;

import java.util.Arrays;

public class LeftRotation
{
  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {

    int targetIndex = 0;
    int arrayLength = a.length;

    int rotatedArray[] = new int[arrayLength];

    for ( int sourceIndex = 0 ; sourceIndex < arrayLength ; sourceIndex++ )
    {
      rotatedArray[ (arrayLength+sourceIndex-d)%arrayLength] = a[sourceIndex];
    }

    return rotatedArray;
  }

  public static void main(String[] args)
  {
    int a[] = {1, 2, 3, 4, 5};// {1}; // {1, 2, 3, 4, 5};

    int b[] = rotLeft( a, 1);

    System.out.println( "" + Arrays.toString( b));
  }
}
