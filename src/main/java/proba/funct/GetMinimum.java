package proba.funct;

import java.util.stream.Stream;

/**
 * https://www.geeksforgeeks.org/stream-min-method-in-java-with-examples/
 */
public class GetMinimum
{
  public static void main(String[] args)
  {
    // Ehelyett a kokorszaki megoldas helyett ...
    //    List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);

    Stream<Integer> intStream = Stream.of( -9, -18, 0, 25, 4);

    // A min()-nek nincs parameter nelkuli verzioja
    Integer var = intStream.min( Integer::compareTo).get();

    System.out.print(var);
  }
}
