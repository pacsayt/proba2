package egyeb;

/**
 * Created by Tamas_Pacsay on 8/29/2017.
 */

class Szulo
{
  static void fooStatic()
  {
    System.out.println( "Szulo::fooStatic()");
  }

  public void foo()
  {
    System.out.println( "Szulo::foo()");
  }
}

class Gyerek extends Szulo
{
  public static void fooStatic()
  {
    System.out.println( "Gyerek::fooStatic()");
  }

  public void foo()
  {
    System.out.println( "Gyerek::foo()");
  }
}

public class StaticOverload
{
  public static void main(String args[])
  {
    Gyerek gyerek = new Gyerek();
    Szulo szulo = gyerek;

    System.out.print( "gyerek.foo() : ");
    gyerek.foo();

    System.out.print( "gyerek.fooStatic() : ");
    gyerek.fooStatic();

    System.out.print( "szulo.foo() : ");
    szulo.foo();

    System.out.print( "szulo.fooStatic() : ");
    szulo.fooStatic();
  }
}
