package streamproba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Tamas_Pacsay on 11/16/2016.
 */
public class StreamProba
{
  public static void main( String[] args)
  {
    List<String> lista = Arrays.asList( "D", "C", "E", "B", "A");

//     lista.stream().sorted().forEach( System.out::println);

    lista.stream().map( s -> s.toLowerCase()).filter( s -> s.startsWith( "d")).forEach( System.out::println);

    boolean kezdobetu = lista.stream().map( s -> s.toLowerCase()).anyMatch( s -> s.startsWith( "d"));
    System.out.println( "kezdobetu : " + kezdobetu);

    Stream<String> sztrim = lista.stream();

    sztrim.filter( s -> s.startsWith( "D")).forEach( System.out::println);
//    System.out.println( "sztrim count : " + sztrim.count()); // java.lang.IllegalStateException: stream has already been operated upon or closed

    Stream.of( "a1", "a2", "a3")
          .findFirst()
          .ifPresent( System.out::println);

    // Primitiv stream
    Arrays.stream(new int[] {1, 2, 3})
          .map(n -> 2 * n + 1)
          .average()
          .ifPresent(System.out::println);  // 5.0

    Stream.of( "a1", "a2", "a3")
          .map( s -> s.substring(1))
          .mapToInt( Integer::parseInt) // mapToLong() / mapToDouble()
          .max()
          .ifPresent( System.out::println);  // 3

//     Stream.of( "D", "C", "E", "B", "A")
  }
}
