package proba.streamproba;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Interview question :
-- get the max 2nd element according to value from a list using streams
 */
public class TakeSecond
{
  public static void main( String[] args )
  {
    Supplier<Stream<Integer>> randomIntStreamSupplier = () -> Stream.of( 3, 1, 9, 6, 3, 2, 7);

    randomIntStreamSupplier.get().sorted().skip( 1).findFirst().ifPresent( System.out::println);
//    randomIntStreamSupplier.get().sorted( (i, j) -> j.compareTo( i)).skip( 1).findFirst().ifPresent( System.out::println);
  }
}