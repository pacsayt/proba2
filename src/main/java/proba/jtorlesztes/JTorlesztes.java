/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proba.jtorlesztes;

/**
 *
 * @author tamas
 */
public class JTorlesztes
{

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
      double dToke = 5_200_000.0 ;
      double dKamat = 1.10 ;
      double dEvesTorlesztes = 12.0*78000.0 ;
      int    nTorlEve = 0 ;
      
      while ( dToke > 0 )
      {
        dToke = dToke*dKamat ;
        dToke = dToke - dEvesTorlesztes ;
        nTorlEve++ ;
        System.out.println( nTorlEve + ". ev dToke=" + dToke) ;
      }

/*
     int nInt = 1 ;
     String sString = "abc" ;
     float  fFloat  = 1.0f ;
     float  fFloat2 = 0.0f ;
     long   lLong   = 1 ;
     double dDouble = 1.0d ;
    
     fFloat2 = fFloat ;
     
     Object aObjectTomb1[] = new Object[5]  ;
     Object aObjectTomb2[] = new Object[5]  ;
     
     aObjectTomb1[0] = (Object)nInt ;
     aObjectTomb1[1] = (Object)sString ;
     aObjectTomb1[2] = (Object)fFloat ;
     aObjectTomb1[3] = (Object)lLong ;
     aObjectTomb1[4] = (Object)dDouble ;
     
     aObjectTomb2[0] = (Object)nInt ;
     aObjectTomb2[1] = (Object)sString ;
     aObjectTomb2[2] = (Object)fFloat ;
     aObjectTomb2[3] = (Object)lLong ;
     aObjectTomb2[4] = (Object)dDouble ;
     
     for ( int nIdx=0 ; nIdx < aObjectTomb2.length ; nIdx++ )
     {
//       if ( aObjectTomb1[nIdx] == aObjectTomb2[nIdx] ) // lebegopontosra nem ad egyezest
       if ( aObjectTomb1[nIdx].equals(aObjectTomb2[nIdx]) ) // ez mindegyikre egyezest ad
       {
         System.out.println( "aObjectTomb1[" + nIdx + "] == aObjectTomb2[" + nIdx + "]") ;
       }
       else
       {
         System.out.println( "aObjectTomb1[" + nIdx + "] = " + aObjectTomb1[nIdx]) ;
         System.out.println( "aObjectTomb2[" + nIdx + "] = " + aObjectTomb2[nIdx]) ;
       }
     }

//       if ( (float)aObjectTomb1[2] == (float)aObjectTomb2[2] ) // true
       if ( aObjectTomb1[2].equals(aObjectTomb2[2]) ) // true
       {
         System.out.println( "aObjectTomb1[2] == aObjectTomb2[2]") ;
       }
       else
       {
         System.out.println( "aObjectTomb1[2] = " + aObjectTomb1[2]) ;
         System.out.println( "aObjectTomb2[2] = " + aObjectTomb2[2]) ;
       }
*/     
     
//     if ( aObjectTomb1[2] == aObjectTomb2[2] ) false
//     if ( 1.0f == 1.0f ) true
//     if ( fFloat == fFloat2 ) // true
//     if ( aObjectTomb1[2] == aObjectTomb2[2] )
  }
}
