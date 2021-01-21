package proba.funct;

import java.util.Random;
import java.util.stream.IntStream;

public class LimitSkip
{

  public static void limit()
  {
    // pt++ mindketto parameter "inclusive"
    System.out.println( "limit( 6)");
    IntStream.rangeClosed( 0, 8)
            .limit( 6)
            .forEach( System.out::println);

  }

  public static void skip()
  {
    System.out.println( "skip( 6)");
    IntStream.rangeClosed( 0, 8)
            .skip(6 )
            .forEach( System.out::println);
  }
  public static void randomSorted()
  {
    System.out.println( "Random()");
    Random random = new Random();
    random.ints().limit(5).sorted().forEach(System.out::println);
  }

  public static void main(String[] args)
  {
    skip();
    limit();
    randomSorted();
  }
}
