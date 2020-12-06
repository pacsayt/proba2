// CKonvInditDlg.java
// CKonvInditDlg : bekeri a konvertalando elso ill. utolso file sorszamat
//                 valamint a file-okat tartalmazo konyvtarat

import java.awt.* ;
import java.io.* ;
import java.awt.event.* ; // Must add this

// CProgInfoDlg.java : CDlgKilepListener ???
class CKnvIndtDlgKlpListener extends WindowAdapter //implements ActionListener
{
  public CKnvIndtDlgKlpListener( CKonvInditDlg cIniKonvInditDlg)
  {
    m_cKonvInditDlg = cIniKonvInditDlg ;
  }

  CKonvInditDlg m_cKonvInditDlg = null ;

//  public void actionPerformed( ActionEvent e)
//  {
//    m_cKonvInditDlg.dispose() ;
//  }

  public void windowClosing(WindowEvent e)
  {
    m_cKonvInditDlg.dispose() ;
  }
}

class COnOKListener implements ActionListener
{
  public COnOKListener( CKonvInditDlg cIniKonvInditDlg)
  {
    m_cKonvInditDlg = cIniKonvInditDlg ;
  }

  CKonvInditDlg m_cKonvInditDlg = null ;

  public void actionPerformed( ActionEvent e) // throws IOException
  {
    CKonvert cKonvert ;

    m_cKonvInditDlg.dispose() ;

    m_cKonvInditDlg.m_sKonyvtar = m_cKonvInditDlg.m_cKonyvtarTxtFld.getText() ;
    m_cKonvInditDlg.m_sTol      = m_cKonvInditDlg.m_cTolTxtFld.getText()      ;
    m_cKonvInditDlg.m_sIg       = m_cKonvInditDlg.m_cIgTxtFld.getText()       ;

    System.out.println("m_sKonyvtar  = " + m_cKonvInditDlg.m_sKonyvtar) ;
    System.out.println("m_sTol       = " + m_cKonvInditDlg.m_sTol     ) ;
    System.out.println("m_sIg        = " + m_cKonvInditDlg.m_sIg      ) ;

    cKonvert = new CKonvert() ;

    // Maga a tenyleges munka elinditasa
    try
    {
      cKonvert.Konvertal( m_cKonvInditDlg.m_sKonyvtar,
                          Integer.parseInt(m_cKonvInditDlg.m_sTol),
                          Integer.parseInt(m_cKonvInditDlg.m_sIg)   ) ;
    }
    catch ( IOException cIOException)
    {
      System.out.println( "Caught IOException") ;
      System.out.println( "getMessage(): " + cIOException.getMessage()) ;
      System.out.println( "toString(): " + cIOException.toString()) ;
      System.out.println( "printStackTrace():") ;
      cIOException.printStackTrace() ;
    }
  }
}

class COnCancelListener implements ActionListener
{
  public COnCancelListener( CKonvInditDlg cIniKonvInditDlg)
  {
    m_cKonvInditDlg = cIniKonvInditDlg ;
  }

  CKonvInditDlg m_cKonvInditDlg = null ;

  public void actionPerformed( ActionEvent e)
  {
    m_cKonvInditDlg.dispose() ;
  }
}

class CKonvInditDlg extends Dialog
{
  public CKonvInditDlg( Frame parent)
  {
    super( parent, "HTML hivatkozasok valtoztatasa", false) ;

    setLayout( new BorderLayout()) ;

    Panel cLblPnl = new Panel() ;
    cLblPnl.setLayout( new GridLayout( 3, 1)) ;
    cLblPnl.add( new Label( "Konyvtar", Label.LEFT)) ;
    cLblPnl.add( new Label( "Tol", Label.LEFT))      ;
    cLblPnl.add( new Label( "Ig", Label.LEFT))       ;

    add( "West", cLblPnl) ;

    Panel cTxTFldPnl = new Panel() ;
    cTxTFldPnl.setLayout( new GridLayout( 3, 1)) ;
    cTxTFldPnl.add( m_cKonyvtarTxtFld) ;
    cTxTFldPnl.add( m_cTolTxtFld)      ;
    cTxTFldPnl.add( m_cIgTxtFld)       ;

    add( "Center", cTxTFldPnl) ;

    Panel cBttnPnl = new Panel() ;
    cBttnPnl.setLayout( new GridLayout( 1, 2)) ;

    m_cOKButton.addActionListener(     new COnOKListener(     this)) ;
    m_cCancelButton.addActionListener( new COnCancelListener( this)) ;

    cBttnPnl.add( m_cOKButton)     ;
    cBttnPnl.add( m_cCancelButton) ;

    add( "South", cBttnPnl) ;

    addWindowListener( m_cKnvIndtDlgKilepListener) ;

    setSize( 400, 150) ;
  }

  // A beolvasando adatokat tartalmazo TextField-ek
  TextField m_cKonyvtarTxtFld = new TextField( 30) ;
  TextField m_cTolTxtFld      = new TextField( 30) ;
  TextField m_cIgTxtFld       = new TextField( 30) ;

  String    m_sKonyvtar = new String() ;
  String    m_sTol      = new String() ;
  String    m_sIg       = new String() ;

  Button m_cOKButton     = new Button( "OK")     ;
  Button m_cCancelButton = new Button( "Cancel") ;
  
  // A dialogus ablakbol valo kilepesre hasznalt 'boolean handleEvent( Event evt)'
  // helyett a COnOK-val lep ki a rendszergombok hatasara
  CKnvIndtDlgKlpListener  m_cKnvIndtDlgKilepListener = new CKnvIndtDlgKlpListener( this) ;
}