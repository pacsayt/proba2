package proba.egyeb;

import java.util.StringJoiner;

/**
 * Q #35) Write a Java 8 program to add prefix and suffix to the String?
 * https://www.softwaretestinghelp.com/java-8-interview-questions/
 */
public class Java8StringJoiner
{
  public static void main(String[] args) {

    StringJoiner stj = new StringJoiner(",", "(", ")");

    // Separated the elements with a comma in between.
    //Added a prefix "(" and a suffix ")"

    stj.add("Saket");
    stj.add("John");
    stj.add("Franklin");
    stj.add("Ricky");
    stj.add("Trevor");

    // Added elements into StringJoiner “stj”

    System.out.println(stj);
  }
}
