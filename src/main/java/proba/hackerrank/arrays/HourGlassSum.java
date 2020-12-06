package proba.hackerrank.arrays;

import java.util.Arrays;

public class HourGlassSum
{
  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr)
  {
    int sumMax = 0;

    int[][] sums = new int[4][4];

    for ( int idxX = 0; idxX < 4; idxX++ )
    {
      for ( int idxY = 0; idxY < 4; idxY++ )
      {
        int localSum = 0;
        localSum = arr[0 + idxY][0 + idxX] + arr[0 + idxY][1 + idxX] + arr[0 + idxY][2 + idxX];
        localSum = localSum + arr[1 + idxY][1 + idxX];
        localSum = localSum + arr[2 + idxY][0 + idxX] + arr[2 + idxY][1 + idxX] + arr[2 + idxY][2 + idxX];

        sums[idxY][idxX] = localSum;
        System.out.println( idxY + " " + idxX + " localSum=" + localSum);
      }
    }

    sumMax = Arrays.stream(sums).flatMapToInt(Arrays::stream).max().orElse(0);

    return sumMax;
  }

  public static void main(String[] args)
  {
    int[][] arr = {{-9, -9, -9, 1, 1, 1},
            {0, -9, 0, 4, 3, 2},
            {-9, -9, -9, 1, 2, 3},
            {0, 0, 8, 6, 6, 0},
            {0, 0, 0, -2, 0, 0},
            {0, 0, 1, 2, 4, 0}};

    int result = hourglassSum( arr);

    System.out.printf("result=" + result);
  }
}
