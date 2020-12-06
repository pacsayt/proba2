package funct;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tamas_Pacsay on 3/22/2017.
 */
class Rekord
{
  String szuro;
  String tartalom;

  public Rekord( String ujSzuro, String ujTartalom)
  {
    szuro = ujSzuro;
    tartalom = ujTartalom;
  }
}


public class OptionalNotFound
{
  public static void main(String args[])
  {
    List<Rekord> rekordok = Arrays.asList( new Rekord( "K1", "T1"),
                                           new Rekord( "K2", "T2"),
                                           new Rekord( "K3", "T3"));

    Optional<Rekord> rekordOptional = rekordok.stream().filter( r -> r.szuro.equals("K4")).findFirst();

    String eredmenyTartalom = "";
//    rekordOptional.ifPresent( r -> eredmenyTartalom = r.tartalom);

    if ( rekordOptional.isPresent() )
    {
      eredmenyTartalom = rekordOptional.get().tartalom;
    }

    System.out.println( "eredmenyTartalom=" + eredmenyTartalom);
  }
}
