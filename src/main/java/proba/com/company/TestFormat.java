package proba.com.company;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Tamas_Pacsay on 2/17/2017.
 * https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
 */
public class TestFormat {

  public static void main(String[] args) {
    long n = 461012;
    System.out.format("%d%n", n);      //  -->  "461012"
    System.out.format("%08d%n", n);    //  -->  "00461012"
    System.out.format("%+8d%n", n);    //  -->  " +461012"
    System.out.format("%,8d%n", n);    // -->  " 461,012"
    System.out.format("%+,8d%n%n", n); //  -->  "+461,012"

    System.out.format(">>>%5d%n", n);    //  -->  "461012"


    double pi = Math.PI;

    System.out.format("%f%n", pi);       // -->  "3.141593"
    System.out.format("%.3f%n", pi);     // -->  "3.142"
    System.out.format("%10.3f%n", pi);   // -->  "     3.142"
    System.out.format("%-10.3f%n", pi);  // -->  "3.142"
    System.out.format(Locale.FRANCE, "%-10.4f%n%n", pi); // -->  "3,1416"

    Calendar c = Calendar.getInstance();
    System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

    System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

    System.out.format("%tD%n", c);    // -->  "05/29/06"
  }
}
