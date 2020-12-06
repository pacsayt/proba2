/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package iteratorvsforeach;
 
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
 
/**
*
* @author etampac
*/
public class IteratorVsForeach
{
  public static void main(String[] args)
  {
    final int nMAX = 500000 ;
    Integer aInteger[] = new Integer[nMAX] ;
 
    long lKezd = 0 ;
    long lVeg  = 0 ;
 
    int nMasikElem = 0 ;
 
    for ( int i = 0 ; i < nMAX ; i++ )
    {
      aInteger[i] = i ;
    }
 
    List<Integer> lList = Arrays.asList( aInteger) ;
 
    int nOsszeg = 0 ;
 
    lKezd = System.nanoTime() ;
 
    for ( int nEgyElem : lList )
    {
      nOsszeg = nOsszeg + nEgyElem ;
    }
 
    lVeg = System.nanoTime() ;
 
    System.out.println( "foreach : " + (lVeg - lKezd)) ;
 
    // -------------------------------------------------------------------------
 
    lKezd = System.nanoTime() ;
 
    Iterator<Integer> iIterator = lList.iterator() ;
 
    while ( iIterator.hasNext() )
    {
      nMasikElem = iIterator.next() ;   
 
      nOsszeg = nOsszeg + nMasikElem ;
    }
 
    lVeg = System.nanoTime() ;
 
    System.out.println( "Iterator : " + (lVeg - lKezd)) ;
 
  }
}