/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package gpehfileroplength;
 
/**
*
* @author etampac
*/
public class GpehFileRopLength {
 
  // Figures out based on file name how long the ROP in case of this file is
  // nGpehFileRopLength = 0 -> error condition
  // Uses excessively GPEH file naming convention rules so it is not suitable for general purpose.
  // For example that both time values are in the same hour.
  private int gpehFileRopLength( String sGPEHFileName) {
    int nGpehFileRopLength = 0 ;

    int nStartTimeBegin = 0 ; 
    int nEndTimeBegin = 0 ; 
    Integer nStartTime = null ;
    Integer nEndTime   = null ;
    String  sStartTime =  null ;
    String  sEndTime   =  null ;
    
    if ( sGPEHFileName != null && sGPEHFileName.length() > 0 )
    {
 
      nStartTimeBegin = sGPEHFileName.indexOf( '.', 0) ;
 
      if ( nStartTimeBegin != -1 )
      {
          nEndTimeBegin = sGPEHFileName.indexOf( '-', nStartTimeBegin) ;
 
          if ( nEndTimeBegin != -1 )
          {
              sStartTime = sGPEHFileName.substring( nStartTimeBegin + 3, nStartTimeBegin + 5) ;
              sEndTime   = sGPEHFileName.substring( nEndTimeBegin + 3, nEndTimeBegin + 5) ;

              if ( sEndTime.equals( "00") == true )
              {
                sEndTime = "60" ;
              }
              
              try
              {
                nStartTime = new Integer( sStartTime) ;
                nEndTime   = new Integer( sEndTime) ;
                
                nGpehFileRopLength = nEndTime - nStartTime ;
              }
              catch ( NumberFormatException eNumberFormatException)
              {
                nGpehFileRopLength = 0 ;
              }
 
          }
      }
    }
 
    return nGpehFileRopLength ;
  }

  
  private int gpehFileRopLengthChar( String sGPEHFileName) {
    int nGpehFileRopLength = 0 ;

    int nStartTimeBegin = 0 ; 
    int nEndTimeBegin = 0 ; 
    Integer nStartTime = null ;
    Integer nEndTime   = null ;
    String  sStartTime =  null ;
    String  sEndTime   =  null ;
    
    if ( sGPEHFileName != null && sGPEHFileName.length() > 0 )
    {
 
      nStartTimeBegin = sGPEHFileName.indexOf( '.', 0) ;
 
      if ( nStartTimeBegin != -1 )
      {
          nEndTimeBegin = sGPEHFileName.indexOf( '-', nStartTimeBegin) ;
 
          if ( nEndTimeBegin != -1 )
          {
              sStartTime = sGPEHFileName.substring( nStartTimeBegin + 3, nStartTimeBegin + 5) ;
              sEndTime   = sGPEHFileName.substring( nEndTimeBegin + 3, nEndTimeBegin + 5) ;

              if ( sEndTime.equals( "00") == true )
              {
                sEndTime = "60" ;
              }
              
              try
              {
/*
char cSHi, cSLo ;
char cEHi, cELo ;

                cSHi = sStartTime.charAt( 0) ;
                cSLo = sStartTime.charAt( 1) ;
                
                cEHi = sEndTime.charAt( 0) ;
                cELo = sEndTime.charAt( 1) ;
*/              
                nGpehFileRopLength = (10*sEndTime.charAt( 0) + sEndTime.charAt( 1)) - (10*sStartTime.charAt( 0) + sStartTime.charAt( 1)) ;
              }
              catch ( NumberFormatException eNumberFormatException)
              {
                nGpehFileRopLength = 0 ;
              }
 
          }
      }
    }
 
    return nGpehFileRopLength ;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    String sGPEHFileName1 = new String( "MeContext=RNC01/A20121012.0847+0000-0848+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
    String sGPEHFileName2 = new String( "MeContext=RNC01/A20121012.0845+0000-0900+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
    String sGPEHFileName3 = new String( "MeContext=RNC01/A20120919.1520+0000-1521+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
    String sGPEHFileName4 = new String( "MeContext=RNC01/A20120919.1500+0000-1515+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
//    String sGPEHFileName5 = new String( "MeContext=RNC01/A20120919_1500+0000-1515+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0_bin") ;
//    String sGPEHFileName6 = new String( "MeContext=RNC01/A20120919.1500+0000_1515+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
//    String sGPEHFileName7 = new String( "MeContext=RNC01/A20120919.15aa+0000-1515+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
//    String sGPEHFileName8 = new String( "MeContext=RNC01/A20120919.1500+0000-15bb+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
    // Should not occur :
//    String sGPEHFileName9 = new String( "MeContext=RNC01/A20120919.1555+0000-1610+0000_SubNetwork=RNC01,MeContext=RNC01_rnc_gpehfile_Mp0.bin") ;
 
    GpehFileRopLength cGpehFileRopLength = new GpehFileRopLength() ;

    System.out.println( sGPEHFileName1 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName1)) ;
    System.out.println( sGPEHFileName2 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName2)) ;
    System.out.println( sGPEHFileName3 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName3)) ;
    System.out.println( sGPEHFileName4 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName4)) ;
//    System.out.println( sGPEHFileName5 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName5)) ;
//    System.out.println( sGPEHFileName6 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName6)) ;
//    System.out.println( sGPEHFileName7 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName7)) ;
//    System.out.println( sGPEHFileName8 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName8)) ;
//    System.out.println( sGPEHFileName9 + " -> " + cGpehFileRopLength.gpehFileRopLength( sGPEHFileName9)) ;

  
    System.out.println( sGPEHFileName1 + " -c> " + cGpehFileRopLength.gpehFileRopLengthChar( sGPEHFileName1)) ;
    System.out.println( sGPEHFileName2 + " -c> " + cGpehFileRopLength.gpehFileRopLengthChar( sGPEHFileName2)) ;
    System.out.println( sGPEHFileName3 + " -c> " + cGpehFileRopLength.gpehFileRopLengthChar( sGPEHFileName3)) ;
    System.out.println( sGPEHFileName4 + " -c> " + cGpehFileRopLength.gpehFileRopLengthChar( sGPEHFileName4)) ;

    // gpehFileRopLength : 0.057ms  gpehFileRopLengthChar : 0.016ms
    
/*
    char cEgy = '1' ;
    char cKetto = '2' ;
    
    int nEredmeny = 0 ;
    
    nEredmeny = cKetto - cEgy ;
    
    System.out.println( "2 - 1 = " + nEredmeny) ;
*/
  }
}