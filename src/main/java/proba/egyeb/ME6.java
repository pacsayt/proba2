package proba.egyeb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tamas_Pacsay on 1/16/2017.
 */
public class ME6
{

  public static void main(String[] args)
  {
    int[] array = {6, 9, 8};
    List<Integer> list = new ArrayList<>();

    list.add( array[0]);
    list.add( array[2]);
    list.set( 1, array[1]);
    list.remove(0);
    System.out.println( list);
  }
}
