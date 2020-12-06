// CKonvert.java
// CKonvert : bekeri a konvertalando elso ill. utolso file sorszamat
//                 valamint a file-okat tartalmazo konyvtarat

import java.io.* ;

/*
 * BufferedReader in
 *   = new BufferedReader(new FileReader("foo.in"));
*/

class CInFile extends BufferedReader
{
  public CInFile( String sFilename) throws FileNotFoundException
  {
    super( new FileReader( sFilename)) ;
  }

  public CInFile( File fFile) throws FileNotFoundException
  {
    this( fFile.getPath()) ;
  }
}

class COutFile extends BufferedWriter
{
  public COutFile( String filename) throws IOException
  {
    super( new BufferedWriter( new FileWriter(filename))) ;
  }

  public COutFile( File file) throws IOException
  {
    this( file.getPath()) ;
  }
}

public class CKonvert
{
  // Buffered input file
  // FileMegnyit nyitja meg, Konvertal zarja le oket
  // Konvertal olvassa
  CInFile  m_fInputFile = null ;
  // Kiir irja
  COutFile m_fOutFile   = null ;

  // Mivel nem tudom, hogy lehetne fv-nek ugy String-et atadni,
  // hogy a valtoztatas vissza is jojjon
  String m_sEgyInSor  = new String() ;
  String m_sEgyOutSor = new String() ;

  // href="http://www.letour.com/2000/us/classements.oft...
  // href="http://www.letour.com/2000/us/profil.oft...
  final String m_sFotipusTmb[] = {
                                   "classements.oft",
                                   "profil.oft"
                                 } ;

  final String m_sParameterTmb[]  = {
                                      "StageNumber=",
                                      "StandingType="
                                    } ;

  final String m_sFileTipTmb[][]  = {
                                      {
                                        "ITE",
                                        "ETE",
                                        "ITG",
                                        "ETG",
                                        "profil"
                                      } ,
                                      {
                                        "e.htm",
                                        "te.htm",
                                        "o.htm",
                                        "to.htm",
                                        "pr.htm"
                                      }
                                    } ;

  final String m_sFileSeparator = System.getProperty( "file.separator") ;

//                                                  public static Integer valueOf(String s) throws NumberFormatException
//                                                  public static int parseInt(String s[, int radix]) 
  public void Konvertal( String sEleresiUt, int nTol, int nIg) throws IOException
  {
    int i ;
    int nFileTipIdx    ;
    int nMaxFileTipIdx ;

    boolean bVoltCsere ;

    nMaxFileTipIdx = m_sFileTipTmb[0].length ;

    // Vegig a megadott etapokon
    for ( i = nTol ; i <= nIg ; i++ )
    {
      // Vegig a megadott etapokon eredmenyfile-jain : e/te/o/to/pr
      for ( nFileTipIdx = 0 ; nFileTipIdx < nMaxFileTipIdx ; nFileTipIdx++ )
      {
        try
        {
          FileMegnyit( sEleresiUt, i, nFileTipIdx) ;
        }
        catch ( IOException cIOException)
        {
          System.out.println( "IOException " + cIOException.getMessage()) ;

          // Nem baj, ha nem talalta a kerdeses file-t, menjen a kovetkezore...
          continue ;
        }

        m_sEgyInSor = m_fInputFile.readLine() ;

        // Vegig a file sorain
        while( m_sEgyInSor != null )
        {
          bVoltCsere = Csere() ;

          Kiir( bVoltCsere) ;

          m_sEgyInSor = m_fInputFile.readLine() ;
        }

        m_fInputFile.close() ;
        m_fOutFile.close() ;
      }
    }
  }

  void FileMegnyit( String sKonyvtar, int nEtapSzam, int nFileTip) throws IOException
  {
    String sTeljFilenev ;

    sTeljFilenev = new String() ;
/*
System.out.println( "sKonyvtar : " + sKonyvtar) ;
System.out.println( "m_sFileSeparator : " + m_sFileSeparator) ;
System.out.println( "nEtapSzam : " + Integer.toString( nEtapSzam)) ;
System.out.println( "nFileTip  : " + Integer.toString( nFileTip)) ;
System.out.println( "m_sFileTipTmb[1][nFileTip] : " + m_sFileTipTmb[1][nFileTip]) ;
*/
    sTeljFilenev = sKonyvtar + m_sFileSeparator + Integer.toString( nEtapSzam) + m_sFileTipTmb[1][nFileTip] ;

    m_fInputFile = new CInFile(  sTeljFilenev) ;
    m_fOutFile   = new COutFile( sTeljFilenev + "l" ) ;
  }

  // m_sEgyInSor, m_sEgyOutSor -t implicit modositja
  boolean Csere()
  {
    int nFotipusIdx ;
    int nParameterVege ;
    int nParameterIdx ;
    int nFileTipIdx ;
    int nMaxFileTipIdx ;
    int nParamHossz ;
    int nTolIdx ;
    int nIgIdx  ;

    String sEtapSzam ;
    String sFileVegz ;

    sFileVegz = null ;

    // Eloszor a classements.oft
    nFotipusIdx = m_sEgyInSor.indexOf( m_sFotipusTmb[0]) ;

    if ( nFotipusIdx > 0 )
    {
      // Az adott fotipus parameterei
      // StageNumber=100&Language ... -----------------------------------------
      nParameterIdx = m_sEgyInSor.indexOf( m_sParameterTmb[0], nFotipusIdx) ;

      if ( nParameterIdx > 0 )
      {
        // A parameter vege
        nParameterVege = m_sEgyInSor.indexOf( '&', nParameterIdx) ;

        if ( nParameterVege > 0 )
        {
          // -2 : a lezaro "00" nem kell
          sEtapSzam = m_sEgyInSor.substring( nParameterIdx + m_sParameterTmb[0].length(),
                                             nParameterVege - 2) ;
        }
        else
        {
          // Ez tulajdonkeppen hiba, mert ha mar StageNumber= volt,
          // parameter vegenek is lennie kellett volna
          return false ;
        }
      }
      else
      {
        // Ez tulajdonkeppen hiba, mert ha mar classements.oft volt,
        // parameternek is lennie kellett volna
        return false ;
      }

      // &StandingType=ITG"><img  ---------------------------------------------
      nParameterIdx = m_sEgyInSor.indexOf( m_sParameterTmb[1], nFotipusIdx) ;
      if ( nParameterIdx > 0 )
      {
        // -1 : pr.html itt nem fordulhat ugysem elo
        nMaxFileTipIdx = m_sFileTipTmb[0].length - 1 ;
System.out.println( "Csere : m_sFileTipTmb[0].length : " + nMaxFileTipIdx) ;

        nParamHossz = nParameterIdx + m_sParameterTmb[1].length() ;
        for ( nFileTipIdx = 0 ; nFileTipIdx < nMaxFileTipIdx ; nFileTipIdx++ )
        {
          // \/ nParameterIdx
          // StandingType=ITG"
System.out.println( "Csere : m_sEgyInSor.substring() :" + m_sEgyInSor.substring( nParamHossz, nParamHossz+3)) ;
System.out.println( "Csere : m_sFileTipTmb[0][nFileTipIdx] : " + m_sFileTipTmb[0][nFileTipIdx]) ;
          if ( m_sEgyInSor.substring( nParamHossz, nParamHossz+3).equals(m_sFileTipTmb[0][nFileTipIdx]) )
          {
            sFileVegz = m_sFileTipTmb[1][nFileTipIdx] ;

System.out.println( "Csere : m_sFileTipTmb[1][" +  Integer.toString( nFileTipIdx) + "] : " + m_sFileTipTmb[1][nFileTipIdx]) ;

            break ;
          }
        }
      }
      else
      {
        // Ez tulajdonkeppen hiba, mert ha mar classements.oft volt,
        // parameternek is lennie kellett volna
        return false ;
      }
    }
    else
    {
      // profil.oft ? ha classements.oft nem volt a sorban
      // href="http://www.letour.com/2000/us/profil.oft?service=...&StageNumber=2000&
      nFotipusIdx = m_sEgyInSor.indexOf( m_sFotipusTmb[1]) ;
      if ( nFotipusIdx > 0 )
      {
        // Az adott fotipus parameterei
        // StageNumber=100&Language ... -----------------------------------------
        nParameterIdx = m_sEgyInSor.indexOf( m_sParameterTmb[0], nFotipusIdx) ;

        if ( nParameterIdx > 0 )
        {
          // A parameter vege
          nParameterVege = m_sEgyInSor.indexOf( '&', nParameterIdx) ;

          if ( nParameterVege > 0 )
          {
            sEtapSzam = m_sEgyInSor.substring( nParameterIdx + m_sParameterTmb[0].length(),
                                               nParameterVege - 2) ;

            sFileVegz = m_sFileTipTmb[1][4]  ;
          }
          else
          {
            // Ez tulajdonkeppen hiba, mert ha mar profil.oft volt,
            // parameter vegenek nek is lennie kellett volna
            return false ;
          }
        }
        else
        {
          // Ez tulajdonkeppen hiba, mert ha mar classements.oft volt,
          // parameternek is lennie kellett volna
          return false ;
        }
      }
      else
      {
        // Se classements.oft, se profil.oft -> ezt a sort nem kell modositani
        return false ;
      }
    }

    // classements.oft eseten nem minden filetipussal foglalkozunk m_sFileTipTmb
    if ( sFileVegz == null )
    {
      return false ;
    }

    // A modositott sor osszeallitasa
    nTolIdx = m_sEgyInSor.indexOf( "http") ;
    nIgIdx  = m_sEgyInSor.indexOf( "\"", nTolIdx) ;

    if ( nTolIdx <= 0 || nIgIdx <= 0 )
    {
      // Az eddigiek miatt itt talalnia kellett volna valamit -> gaz van
      return false ;
    }

    // A sor eleje valtozatlan + a hivatkozott filenev + l
    m_sEgyOutSor = m_sEgyInSor.substring( 0, nTolIdx)  + sEtapSzam + sFileVegz + "l" ;
//System.out.println( "CKonvert::Csere m_sEgyOutSor:" + m_sEgyOutSor) ;

    // A sor vege valtozatlanul
    m_sEgyOutSor = m_sEgyOutSor + m_sEgyInSor.substring( nIgIdx) ;
System.out.println( "Csere m_sEgyOutSor:" + m_sEgyOutSor) ;

//System.out.println( "CKonvert::Csere END (true)") ;
    return true ;
  }

  void Kiir( boolean bVoltCsere) throws IOException
  {
//System.out.println( "CKonvert::Kiir BEGIN") ;

    if ( bVoltCsere == true )
    {
//System.out.println( "CKonvert::Kiir m_sEgyOutSor:" + m_sEgyOutSor) ;

      m_fOutFile.write( m_sEgyOutSor + "\n", 0, m_sEgyOutSor.length() + 1) ;
    }
    else
    {
      m_fOutFile.write( m_sEgyInSor + "\n", 0, m_sEgyInSor.length() + 1) ;
    }

//System.out.println( "CKonvert::Kiir END") ;
  }
}
