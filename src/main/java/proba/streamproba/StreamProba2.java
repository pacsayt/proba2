package streamproba;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Tamas_Pacsay on 12/9/2016.
 */
public class StreamProba2
{
  public static void main()
  {
    // int a[] = new int[2]; -> a.getClass(); pt++ : elemi tipus tomb objektuma !!!

    // pt++ : IntStream ez egy interfesz !!! range() annak egy statikus metodusa
    IntStream intStream12 = IntStream.range( 1, 2);

    // intStream12.collect( Collectors.averagingInt( i -> Integer::new));

    OptionalDouble intStream12avg = intStream12.average();
    intStream12avg.ifPresent( avg -> System.out.print( avg));
  }
}