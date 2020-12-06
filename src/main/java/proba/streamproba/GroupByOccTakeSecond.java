package proba.streamproba;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Interview question :
-- get the max 2nd element according to frequency from a list using streams
https://stackoverflow.com/questions/25441088/group-by-counting-in-java-8-stream-api
 */

public class GroupByOccTakeSecond
{
  public static void main( String[] args )
  {
    Supplier<Stream<Integer>> randomIntStreamSupplier = () -> Stream.of( 3, 1, 9, 6, 3, 2, 7, 6, 4, 7, 3, 8, 1, 2, 6, 3, 8, 6, 5);

    // i -> i vs Function.identity() eredmenyeben u.a.
    // static <T> Function<T, T> identity() {  return t -> t; }
    // https://stackoverflow.com/questions/28032827/java-8-lambdas-function-identity-or-t-t
    Map< Integer, List<Integer>> groupedMap1 = randomIntStreamSupplier.get().collect( Collectors.groupingBy( Function.identity()));
    System.out.println( "Grouped map1 = " + groupedMap1);
    // Grouped map = {1=[1, 1], 2=[2, 2], 3=[3, 3, 3, 3], 4=[4], 5=[5], 6=[6, 6, 6, 6], 7=[7, 7], 8=[8, 8], 9=[9]}

    // Egy koztes lepes :
    Map<Integer, List<Integer>> collect = randomIntStreamSupplier.get().collect(Collectors.groupingBy(o -> o));
    collect.entrySet().forEach(e -> System.out.print(e.getKey() + " = " + e.getValue().size() + ", "));


    // A vegso megoldas :
    Map< Integer, Long> groupedMap2 = randomIntStreamSupplier.get().collect( Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println( "\n Grouped map2 = " + groupedMap2);
    // Grouped map2 = {1=2, 2=2, 3=4, 4=1, 5=1, 6=4, 7=2, 8=2, 9=1}

  }
}
