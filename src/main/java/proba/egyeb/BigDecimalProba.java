package proba.egyeb;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Tamas_Pacsay on 4/25/2017.
 */
public class BigDecimalProba
{
  static void bigDecimalProba()
  {
    BigDecimal bd1 = new BigDecimal( "-0.999");
    BigDecimal bd2 = new BigDecimal( "0.999");

    System.out.println( bd1 + " BigDecimal.round(MathContext( 0, RoundingMode.HALF_UP)) : " + bd1.round( new MathContext( 0, RoundingMode.HALF_UP))); // precison=0 -> nincs kerekites
    System.out.println( bd2 + " BigDecimal.round(MathContext( 0, RoundingMode.HALF_UP)) : " + bd2.round( new MathContext( 0, RoundingMode.HALF_UP)));
    System.out.println( bd1 + " BigDecimal.round(MathContext( 1, RoundingMode.HALF_UP)) : " + bd1.round( new MathContext( 1, RoundingMode.HALF_UP)));
    System.out.println( bd2 + " BigDecimal.round(MathContext( 1, RoundingMode.HALF_UP)) : " + bd2.round( new MathContext( 1, RoundingMode.HALF_UP)));
    System.out.println( bd1 + " BigDecimal.round(MathContext( 2, RoundingMode.HALF_UP)) : " + bd1.round( new MathContext( 2, RoundingMode.HALF_UP)));
    System.out.println( bd2 + " BigDecimal.round(MathContext( 2, RoundingMode.HALF_UP)) : " + bd2.round( new MathContext( 2, RoundingMode.HALF_UP)));
    System.out.println( bd1 + " BigDecimal.round(MathContext( 3, RoundingMode.HALF_UP)) : " + bd1.round( new MathContext( 3, RoundingMode.HALF_UP)));
    System.out.println( bd2 + " BigDecimal.round(MathContext( 3, RoundingMode.HALF_UP)) : " + bd2.round( new MathContext( 3, RoundingMode.HALF_UP)));

    System.out.println( bd1 + " BigDecimal.setScale( 0, BigDecimal.ROUND_HALF_UP) : " + bd1.setScale( 0, BigDecimal.ROUND_HALF_UP));
    System.out.println( bd2 + " BigDecimal.setScale( 0, BigDecimal.ROUND_HALF_UP) : " + bd2.setScale( 0, BigDecimal.ROUND_HALF_UP));
    System.out.println( bd1 + " BigDecimal.setScale( 1, BigDecimal.ROUND_HALF_UP) : " + bd1.setScale( 1, BigDecimal.ROUND_HALF_UP));
    System.out.println( bd2 + " BigDecimal.setScale( 1, BigDecimal.ROUND_HALF_UP) : " + bd2.setScale( 1, BigDecimal.ROUND_HALF_UP));
    System.out.println( bd1 + " BigDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP) : " + bd1.setScale( 2, BigDecimal.ROUND_HALF_UP));
    System.out.println( bd2 + " BigDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP) : " + bd2.setScale( 2, BigDecimal.ROUND_HALF_UP));

    if ( bd1.compareTo( new BigDecimal( "-1")) == 1 && bd1.compareTo( new BigDecimal( "1")) == -1 )
    {
      System.out.println( bd1 + " -> 0");
    }

    if ( bd1.compareTo( new BigDecimal( "-1")) == 1 && bd1.compareTo( new BigDecimal( "1")) == -1 )
    {
      System.out.println( bd2 + " -> 0");
    }
  }

  static void eredetiKerekites()
  {
//    double price = 123.456D; OK
    // http://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java?rq=1
    // Be very careful when using this method (or any rounding of floating points).
    // It fails for something as simple as 265.335.
    // The intermediate result of 265.335 * 100 (precision of 2 digits) is 26533.499999999996.
    // This means it gets rounded down to 265.33.
    // There simply are inherent problems when converting from floating point numbers to real decimal numbers.
    // See EJP's answer here at stackoverflow.com/a/12684082/144578 – Sebastiaan van den Broek
    double price = 265.335D; // hibas erre !!!

    double priceRounded = price * 100;
    priceRounded = Math.round(priceRounded);
    priceRounded = priceRounded / 100;

    System.out.println( price + " -*100/100-> " + priceRounded);
  }

  static void setScale() {
    //    BigDecimal bd1 = new BigDecimal( "123.456");
    BigDecimal bd1 = new BigDecimal( "265.335");

    BigDecimal bd2 = bd1.setScale( 2, BigDecimal.ROUND_HALF_UP);

    System.out.println( bd1 + "  BigDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP) : " + bd2);

  }

  public static void main(String args[])
  {
    bigDecimalProba();

    eredetiKerekites();

    setScale();
  }
}
