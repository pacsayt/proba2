// CProgInfoDlg.java
// CProgInfoDlg : informaciokat jelenit meg a programrol
//          

import java.awt.* ;
import java.awt.event.* ; // Must add this

class CDlgKilepListener extends WindowAdapter implements ActionListener
{
  public CDlgKilepListener( CProgInfoDlg cIniProgInfoDlg)
  {
    m_cProgInfoDlg = cIniProgInfoDlg ;
  }

  CProgInfoDlg m_cProgInfoDlg = null ;

  public void actionPerformed( ActionEvent e)
  {
    m_cProgInfoDlg.dispose() ;
  }

  public void windowClosing(WindowEvent e)
  {
    m_cProgInfoDlg.dispose() ;
  }
}

class CProgInfoDlg extends Dialog
{
  public CProgInfoDlg( Frame parent)
  {
    super( parent, "HTML hivatkozasok valtoztatasa", false) ;

    setLayout( new GridLayout( 3, 1)) ;

    add( new Label( "Java proba program szisztematikusan osszefuggo *.html file-ok",
                    Label.CENTER)) ;

    add( new Label( "hivatkozasainak lokalis hasznalatra valo alkalmassa tetelere ",
                    Label.CENTER)) ;

    m_cOKButton.addActionListener( m_cDlgKilepListener) ;
    add( m_cOKButton) ;

    addWindowListener( m_cDlgKilepListener) ;

    setSize( 400, 150) ;
  }

  Button m_cOKButton = new Button( "OK") ;
  
  // A dialogus ablakbol valo kilepesre hasznalt 'boolean handleEvent( Event evt)'
  // helyett a COnOK-val lep ki a rendszergombok hatasara
  CDlgKilepListener  m_cDlgKilepListener = new CDlgKilepListener( this) ;
}
