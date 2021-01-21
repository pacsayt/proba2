package proba.funct;

import java.util.function.Function;

/**
 * Created by Tamas_Pacsay on 11/29/2016.
 * "A lambda expression does not define a scope of its own." - http://www.java2s.com/Tutorials/Java/Java_Lambda/0170__Java_Lambda_expression_scope.htm
 * "We cannot use the jump statements to do non-local jump." -  - " -
 */
public class LambdaScope
{
  private static int privateStaticInt = 2;
  private int privateInt = 3;

  public void scope()
  {
    // int x= 0; // pt++ : variable \/ is already defined in the scope
    int y = 1;

    Function<String,String> func1 = x -> {System.out.println( " x=" + x + " y=" +  y + " privateInt=" +  privateInt + " privateStaticInt=" + privateStaticInt); return x; };
    System.out.println( func1.apply("scope2 ")) ;
  }

  public static void main( String[] args)
  {
    LambdaScope lambdaScope = new LambdaScope();
    lambdaScope.scope();
  }
}
