package egyeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tamas_Pacsay on 11/16/2016.
 */
interface Interfesz
{
  Object fuggveny1();
//  String fuggveny2();
}

public class DiffReturnTypeInInheritence<A> implements Interfesz
{
  public String fuggveny1()
  {
    return "A";
  }

//  public List<A> fuggveny2() // <- inkompatibilis visszateresi ertek
//  {
//      List<A> listA = new ArrayList<A>();
//    return listA;
//  }
}
