package proba.funct;

import java.util.function.Function;

/**
 * Java 8: Composing functions using compose and andThen
 * https://www.deadcoderising.com/2015-09-07-java-8-functional-composition-using-compose-and-andthen/
 *
 * Ugyan nem innen valo a pelda, egy osszefoglalo.
 * https://helpezee.wordpress.com/2018/08/16/functional-interfaces-in-java8/
 */
public class ComposeAndThen
{
  static void composeAndThen()
  {
    Function<Integer, Integer> times2 = e -> e * 2;
    Function<Integer, Integer> squared = e -> e * e;

    //                    2.      1.
    System.out.println( times2.compose( squared).apply( 4)); // Returns 32

    //                    1.      2.
    System.out.println( times2.andThen( squared).apply( 4)); // Returns 64
  }

  public static void main(String[] args)
  {
    composeAndThen();
  }
}
