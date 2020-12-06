package funct;

/**
 * Java Magazine July Aug
 * Created by Tamas_Pacsay on 8/2/2017.
 */
public class Visibility
{
  private static void delay()
  {
    try
    {
      Thread.sleep((int) (Math.random() * 10));
    }
    catch (InterruptedException ie)
    {
      System.out.println( "Nem szep lenyelni ezt az exceptiont ...");
    }
  }

  public static void main(String[] args) {
    int[] x = {0};
    boolean[] hold = {true};
    new Thread(() -> {
                       delay();
                       x[0] = 99;
                       hold[0] = false;
                     }).start();

    new Thread(() -> {
                       delay();
                       while (hold[0]);
                      System.out.println("value is " + x[0]);
                     }).start();
  }
}

/*
  And, choosing from these behaviors:
  1. The program prints value is 0.
  2. The program prints value is 99.
  3. The JVM exits (the program stops).
  4. The JVM does not exit (the program does not stop).

  Which describes all the outcomes allowed by the specification?
  Choose one.
  a. 2 and 3
  b. Neither 1 nor 2, and 3
  c. Either 1 or 2, and 3
  d. Either 2 and 3; or neither 1 nor 2, and 4
+  e. 3 and either 1 or 2; or neither 1 nor 2, and 4
*/