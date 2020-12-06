package proba.mapexamples;

import java.util.HashMap;

/**
 * https://www.programiz.com/java-programming/library/hashmap/computeifabsent
 */
public class MapExamples
{
  public static void computeIfAbsentExample()
  {
    HashMap<String, Integer> prices = new HashMap<>();

    // insert entries to the HashMap
    prices.put("Shoes", 200);
    prices.put("Bag", 300);
    prices.put("Pant", 150);
    System.out.println("HashMap: " + prices);

    // compute the value of Shirt
    int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280); // nem volt benne, az uj erteket adja vissza (280)
    System.out.println("Price of Shirt: " + shirtPrice);

    // print updated HashMap
    System.out.println("Updated HashMap: " + prices);
  }

  public static void computeIfPresentExample()
  {
    // create an HashMap
    HashMap<String, Integer> prices = new HashMap<>();

    // insert entries to the HashMap
    prices.put("Shoes", 200);
    prices.put("Bag", 300);
    prices.put("Pant", 150);
    System.out.println("HashMap: " + prices);

    // recompute the value of Shoes with 10% VAT
    int shoesPrice = prices.computeIfPresent("Shoes", (key, value) -> value + 1); // a megnovelt erteket adja vissza
    System.out.println("Price of Shoes after VAT: " + shoesPrice);

    // print updated HashMap
    System.out.println("Updated HashMap: " + prices);
  }

  public static void computeExample()
  {
    // create an HashMap
    HashMap<String, Integer> prices = new HashMap<>();

    // insert entries to the HashMap
    prices.put("Shoes", 200);
    prices.put("Bag", 300);
    prices.put("Pant", 150);
    System.out.println("HashMap: " + prices);

    // recompute the value of Shoes with 10% discount
    int newPrice = prices.compute("Shoes", (key, value) -> value + 1);
    System.out.println("Discounted Price of Shoes: " + newPrice);

    // print updated HashMap
    System.out.println("Updated HashMap: " + prices);
  }

  public static void main(String[] args)
  {
    computeIfAbsentExample();
    computeIfPresentExample();
  }
}