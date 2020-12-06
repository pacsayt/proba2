package egyeb;

/**
 * Itt is kb ez van :
 * https://dzone.com/articles/dealing-with-diamond-problem-in-java
 *
 * http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
 *
 * Created by Tamas_Pacsay on 8/8/2017.
 */
interface A
{
  default void foo()
  {
    System.out.println( "A");
  }
}

interface B extends A
{
  default void foo()
  {
    System.out.println( "B");
  }
}

interface C extends A
{
  default void foo()
  {
    System.out.println( "C");
  }
}

public class Diamond implements B, C // inherits unrelated defaults for foo() from types B and C
{
  // A public void Diamond::foo() definialasa megnyugvast hoz :
  public void foo()
  {
    // igy lehet szulo metodust hivni
    B.super.foo();
    // super.foo(); // Cannot resolve method foo in Object
  }

  public static void main(String[] args)
  {
    Diamond diamond = new Diamond();

    diamond.foo();
  }
}
