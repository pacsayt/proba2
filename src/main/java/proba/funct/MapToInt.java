package proba.funct;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Q #22) Write a Java 8 program to square the list of numbers and then filter out
 *        the numbers greater than 100 and then find the average of the remaining numbers?
 https://www.softwaretestinghelp.com/java-8-interview-questions/
 */
public class MapToInt
{

  public static void main(String[] args)
  {
     OptionalDouble average = Stream.of( 100, 100, 9, 8, 200).mapToDouble(i -> i*i).filter(i -> i > 100).average();

    System.out.println( "average=" + average);

    Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
                            .max(Comparator.comparing(Integer::valueOf)) // pt++ : max(Comparator::comparing) ketertelmu lenne
                            .get();
  }
}
