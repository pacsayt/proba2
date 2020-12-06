//: HumanExc.java
// Catching Exception Hierarchies
package proba.exceptionoverloading;

class Annoyance extends Exception {}

class Sneeze extends Annoyance {}

public class HumanExc
{
  public static void main(String[] args)
  {
    try
    {
      throw new Sneeze();
    }
    catch(Annoyance a)
    {
      System.out.println("Caught Annoyance");
    }
/*
    java: exception Sneeze has already been caught
    catch(Sneeze s) // catch not reached !!! ha ez a bazis exc. utan van !!!
    {
      System.out.println("Caught Sneeze");
    }
 */
  }
} ///:~