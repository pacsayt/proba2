/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proba.jproba;

/**
 *
 * @author tamas
 */
public class JProba {

   public void Teszt( Integer cInteger)
   {
     System.out.println( "JProba::Teszt() -> " + cInteger) ;
   }
   
   public void ValtArgbaTombot( int... aIntTomb)
   {
     for ( int nAktErt : aIntTomb )
     {
       System.out.println( "nAktErt=" + nAktErt) ;
     }
   }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      // TODO code application logic here
      int nTesztErtek = 2 ;
      
      int aTomb[] = {0, 1, 2} ;
      
      JProba cProba = new JProba() ;
      
      cProba.Teszt( nTesztErtek) ;
      
      cProba.ValtArgbaTombot( aTomb) ;

//      String sString = null ;
//      System.out.println( "Igy irja ki a null-t : " + sString + " valamit utana");
    }
}
