package proba.com.company;

public class FloatComparison
{
  public static void main(String[] args)
  {
    float f1 = 0.3f;
    float f2 = 0.3f;

    System.out.println("f1 = " + f1 + " f2 = " + f2);

    System.out.println("f1 == f2 => " + (f1 == f2));

    float f3 = f1 + f2;

    // Az eredmeny a varakozasoknak megfeleloen false irodik ki, de f3 a debuggerben 0.6 !
    System.out.println("f1 + f2 == 0.6; => " + (f3 == 0.6));
  }
}
