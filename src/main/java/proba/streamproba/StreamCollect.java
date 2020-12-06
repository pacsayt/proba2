package streamproba;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person
{
  String name;
  int age;

  Person(String iniName, int iniAge)
  {
    name = iniName;
    age = iniAge;
  }

  @Override
  public String toString()
  {
    return name;
  }
}

/**
 * Created by Tamas_Pacsay on 11/16/2016.
 */
public class StreamCollect
{
  static List<Person> persons = Arrays.asList( new Person( "Max", 18),
                                               new Person( "Peter", 23),
                                               new Person( "Pamela", 23),
                                               new Person( "David", 12));

  static Stream<Person> personStream = persons.stream();

  static void collectToList()
  {
    List<Person> filtered = personStream.filter( p -> p.name.startsWith( "P")) // "Z" -> ures List, nem null
                                        .collect( Collectors.toList());

    System.out.println( filtered); // [Peter, Pamela]
  }

  // collect
  static void groupToMap()
  {
    Map<Integer, List<Person>> personsByAge = personStream.collect( Collectors.groupingBy( p -> p.age));

    personsByAge.forEach( (age, p) -> System.out.format( "age %s: %s\n", age, p));

// age 18: [Max]
// age 23: [Peter, Pamela]
// age 12: [David]
  }

  // collect
  static void average()
  {
    Double averageAge = personStream.collect( Collectors.averagingInt( p -> p.age));

    System.out.println(averageAge); // 19.0
  }

  public static void main(String[] args)
  {
//    Map<Integer, String> map = personStream.collect( Collectors.toMap( p -> p.age,
//                                                                       p -> p.name,
//                                                                      (name1, name2) -> name1 + ";" + name2)); // mit csinaljon, ha tobb azonos koru van

    collectToList();
    groupToMap();
    groupToMap();
    average();
  }
}