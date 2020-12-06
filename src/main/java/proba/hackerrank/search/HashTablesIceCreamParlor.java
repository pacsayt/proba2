package proba.hackerrank.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class C implements Comparator<int[]>
{
  @Override
  public int compare(int[] o1, int[] o2)
  {
    int compResult = Integer.compare( o1[0], o2[0]);

    if ( compResult == 0 )
    {
      compResult = Integer.compare( o1[0], o2[0]);
    }

    return compResult;
  }
}

public class HashTablesIceCreamParlor
{
  static void whatFlavors(int[] cost, int money)
  {
    int halfMoney = money / 2;
    int costsWithIndex[][] = new int[cost.length][2];

    int k = 0;
    for ( int i = 0; i < cost.length ; i++ )
    {
      if ( cost[i] < money )
      {
        costsWithIndex[k][0] = cost[i];
        costsWithIndex[k][1] = i + 1;
        k++;
      }
    }

    Arrays.sort( costsWithIndex, new C());

    int halfMoneyIndex = 0;
    while ( (halfMoneyIndex < costsWithIndex.length) && (costsWithIndex[halfMoneyIndex][0] <= halfMoney)  )
    {
      int actValue = costsWithIndex[halfMoneyIndex][0];
      halfMoneyIndex++;

      if ( actValue == halfMoney )
      {
        break;
      }
    }

    Map<Integer,Integer> higherThanHalfMoneyMap = new HashMap<>(costsWithIndex.length-halfMoneyIndex);

    for ( int i = halfMoneyIndex ; i < costsWithIndex.length ; i++ )
    {
      higherThanHalfMoneyMap.putIfAbsent( costsWithIndex[i][0], costsWithIndex[i][1]);
    }

    for ( int i = 0 ; i < halfMoneyIndex ; i++ )
    {
      Integer restMoney = money -  costsWithIndex[i][0];

//System.out.println( "first price " + costsWithIndex[i][0] +  "restMoney " + restMoney + " higherThanHalfMoneyMap.containsKey( restMoney)" + higherThanHalfMoneyMap.containsKey( restMoney));

      if ( costsWithIndex[i][0] != 0 && higherThanHalfMoneyMap.containsKey( restMoney) )
      {
        if ( higherThanHalfMoneyMap.get( restMoney) < costsWithIndex[i][1] )
        {
          System.out.println(higherThanHalfMoneyMap.get(restMoney) + " " + costsWithIndex[i][1]);
          return;
        }

        System.out.println( costsWithIndex[i][1] + " " + higherThanHalfMoneyMap.get(restMoney));
        return;
      }
    }
  }

  public static void main(String[] args)
  {
//    int costs[] = { 1, 4, 5, 3, 2}; // 1 4
//    int money = 4;

//    int costs[] = { 2, 2, 4, 3}; // 1 2
//    int money = 4;

    int costs[] = { 7, 2, 5, 4, 11}; // 1 3
    int money = 12;

    whatFlavors( costs, money);
  }
}
