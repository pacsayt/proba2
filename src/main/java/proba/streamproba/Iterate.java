package proba.streamproba;

import java.util.stream.Stream;

/**
 * Q #36) Write a Java 8 program to iterate a Stream using the forEach method?
 * https://www.softwaretestinghelp.com/java-8-interview-questions/
 */
public class Iterate
{
  public static void main(String[] args)
  {
    // Counter Started from 2, incremented by 1
    Stream.iterate(2, count -> count + 1)
          .filter(number -> number % 2 == 0)
          .limit(5)
          .forEach(System.out::println);
    // Limit is set to 5, so only 5 numbers will be printed
  }
}
