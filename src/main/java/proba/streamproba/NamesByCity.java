package proba.streamproba;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

class Person
{
  private String name;
  private String city;

  public Person(String iniName, String iniCity)
  {
    name = iniName;
    city = iniCity;
  }

  public String getName()
  {
    return name;
  }

  public String getCity()
  {
    return city;
  }
}

public class NamesByCity
{
/* Collectors.java-bol :
  <p>For example, to compute the set of last names of people in each city:
        * <pre>{@code
     * Map<City, Set<String>> namesByCity
     *   = people.stream().collect(
          *     groupingBy(Person::getCity,
          *                mapping(Person::getLastName,
          *                        toSet())));
     * }</pre>
*/
  public static void main(String[] args)
  {
    Stream<Person> s = Stream.of(  new Person( "Name1", "City1"),
                                   new Person( "Name2", "City2"),
                                   new Person( "Name3", "City3"),
                                   new Person( "Name4", "City4"),
                                   new Person( "Name32", "City3"),
                                   new Person( "Name42", "City4"),
                                   new Person( "Name43", "City4"),
                                   new Person( "Name44", "City4"),
                                   new Person( "Name12", "City1"),
                                   new Person( "Name22", "City2"));

    Map<String, Set<String>> b = s.collect( groupingBy( Person::getCity, Collectors.mapping( Person::getName, toSet())));

    System.out.println( "" + b);
  }
}
