package proba.generics;

import java.util.Arrays;
import java.util.List;

/**
 * How can I add to List<? extends Number> data structures?
 *
 * You can't add any object to List<? extends T> because you can't guarantee what kind of List it is really pointing to,
 * so you can't guarantee that the object is allowed in that List.
 * The only "guarantee" is that you can only read from it and you'll get a T or subclass of T.
 *
 * You can't read the specific type T (e.g. Number) from List<? super T> because you can't guarantee what kind
 * of List it is really pointing to.
 * The only "guarantee" you have is you are able to add a value of type T (or any subclass of T) without violating the
 * integrity of the list being pointed to.
 */
public class WildcardsWithExtends
{
  static void chapter2_2()
  {
    List<Integer> ints = Arrays.asList(1,2);
    List<? extends Number> nums = ints;
//    nums.add(3.14);  // compile-time error
//    nums.add( (new Integer(1))); // compile-time error

//    nums.add( new Object()); // extends Number ! -> compile-time error

    assert ints.toString().equals("[1, 2, 3.14]");  // uh oh!

//    List<? super Number> numsVagyFelette = ints; // compile-time error
    List<Object> objectLista = Arrays.asList( "A", 1, 3.14); // de lehetett volna szajbaragosan is Arrays.<Object>asList(...);
    List<? super Number> numsVagyFelette = objectLista;
  }

  public static void main(String[] args)
  {
    WildcardsWithExtends.chapter2_2();
  }
}
