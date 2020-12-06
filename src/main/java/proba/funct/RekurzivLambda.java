package funct;

import java.util.function.IntFunction;

/**
 * Created by Tamas_Pacsay on 11/29/2016.
 */
public class RekurzivLambda
{
  public long factorial(int n)
  {
    if (n == 0)
    {
      return 1;
    }
    else
    {
      return n * factorial(n - 1);
    }
  }

  public static void main(String[] args)
  {
    RekurzivLambda rekurzivLambda = new RekurzivLambda();
    IntFunction<Long> factorialCalc = rekurzivLambda::factorial; // pt++ : ha static a fv : RekurzivLambda::factorial
    System.out.println(factorialCalc.apply(10));
  }
}
