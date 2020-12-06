package proba.egyeb;

import java.util.Collections;
import java.util.Set;

/**
 * Created by Tamas_Pacsay on 11/8/2017.
 */
public class EmptySetIsImmutable
{
  public static void main(String[] args)
  {
    Set<Long> emptySet = Collections.emptySet();

    emptySet.add( new Long(0));
  }
}
