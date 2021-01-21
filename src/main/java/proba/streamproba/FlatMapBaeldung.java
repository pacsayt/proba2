package proba.streamproba;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Q3. What Is the Difference Between Map and flatMap Stream Operation?
 * https://www.baeldung.com/java-8-interview-questions
 */

public class FlatMapBaeldung
{
  public static void main(String[] args)
  {
    Map<String, List<String>> people = new HashMap<>();
    people.put("John", Arrays.asList("555-1123", "555-3389"));
    people.put("Mary", Arrays.asList("555-2243", "555-5264"));
    people.put("Steve", Arrays.asList("555-6654", "555-3242"));

    List<String> phones = people.values().stream()
                                         .flatMap( p -> p.stream()) // pt++ : == Collection::stream
                                         .collect(Collectors.toList());

    System.out.println( "phones:" + phones);
  }
}
