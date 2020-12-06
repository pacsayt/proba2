package proba.funct;

/**
 * Created by Tamas_Pacsay on 4/4/2017.
 * http://www.concretepage.com/java/jdk-8/java-8-stream-allmatch-anymatch-nonematch-example
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

class Employee
{
  public int id;
  public String name;
  public int sal;
  public Employee(int id,String name,int sal  )
  {
    this.id = id;
    this.name = name;
    this.sal = sal;
  }

  public static List<Employee> createList()
  {
    // Stream.of( ..., ..., ...);

    List<Employee> list = new ArrayList<>();
    list.add(new Employee(1, "A", 2000));
    list.add(new Employee(2, "B", 3000));
    list.add(new Employee(3, "C", 4000));
    list.add(new Employee(4, "D", 5000));

    return list;
  }
}

public class MatchDemo
{
  public static void main(String[] args)
  {
    Predicate<Employee> p1 = e -> e.id < 10 && e.name.startsWith("A");
    Predicate<Employee> p2 = e -> e.sal < 10000;
    List<Employee> list = Employee.createList();
    //using allMatch
//    boolean b1 = list.stream().allMatch(p1);
//    System.out.println(b1);
//    boolean b2 = list.stream().allMatch(p2);
//    System.out.println(b2);
//    //using anyMatch
//    boolean b3 = list.stream().anyMatch(p1);
//    System.out.println(b3);
//    boolean b4 = list.stream().anyMatch(p2);
//    System.out.println(b4);
//    //using noneMatch
//    boolean b5 = list.stream().noneMatch(p1);
//    System.out.println(b5);

    Optional<proba.funct.Employee> firstMatch = list.stream().filter(p2).findFirst();

    if ( firstMatch.isPresent() )
    {
      proba.funct.Employee talaltEmployee = firstMatch.get();
      System.out.print( "talaltEmployee" + talaltEmployee);
    }

    List<Employee> uresList = new ArrayList<>();
    boolean uresLista = uresList.stream().anyMatch(p1);
  }
}
