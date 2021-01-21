package proba.streamproba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsForEach
{

  public static void main(String[] args)
  {
    List<String> alphabets = Arrays.asList("aa", "bbb", "cat", "dog");

    alphabets.forEach( System.out::println);
  }
}
