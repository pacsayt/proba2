//: CHivValt.java
// CHivValt Java proba program szisztematikusan osszefuggo *.html file-ok
//          hivatkozasainak lokalis hasznalatra valo alkalmassa tetelere

import java.awt.* ;
import java.awt.event.* ; // Must add this

interface IMFActionListener extends ActionListener
{
  // This final variable must be initialized: CHivValt m_cCHivValt miatt :
  CHivValt m_cCHivValt = new CHivValt() ;
}

// A file megnyitas rendszer dialogus ablak probaja
class CMegnyitListener implements IMFActionListener
{
  public void actionPerformed( ActionEvent e)
  {
    String cMegnyitandoFile ;
    // A file megnyitas dialogus ablak beuzemelese
    // Two arguments, defaults to open file:
    FileDialog d = new FileDialog( m_cCHivValt, "A feldologzando file megnyitasa") ;

    // Filename filter
    d.setFile( "*.htm") ;
    // Current directory
    d.setDirectory( "e:\tdf2000") ;
    d.show() ;
    cMegnyitandoFile = d.getFile() ;

    if( cMegnyitandoFile != null )
    {
      m_cCHivValt.m_cSzovegmezo.setText( cMegnyitandoFile) ;
//      directory.setText( d.getDirectory()) ;
    }
    else
    {
      m_cCHivValt.m_cSzovegmezo.setText( "Cancel") ;
//      directory.setText("") ;
    }
  }
}

// Fájl / Konvertálás indít
// A konvertalas fobb parametereinekbeolvasasa, a konvertalas inditasa
class CDlgKonvInditListener implements IMFActionListener
{
  public void actionPerformed( ActionEvent e)
  {                                              // IMFActionListener.m_cCHivValt
    CKonvInditDlg cKonvInditDlg = new CKonvInditDlg( m_cCHivValt) ;
    cKonvInditDlg.show() ;

    System.out.println("m_sKonyvtar  = " + cKonvInditDlg.m_sKonyvtar) ;
    System.out.println("m_sTol       = " + cKonvInditDlg.m_sTol     ) ;
    System.out.println("m_sIg        = " + cKonvInditDlg.m_sIg      ) ;
  }
}

// Program infó / Program információ
class CProgramInfoListener implements IMFActionListener
{
  public void actionPerformed( ActionEvent e)
  {                                              // IMFActionListener.m_cCHivValt
    CProgInfoDlg cProgInfoDlg = new CProgInfoDlg( m_cCHivValt) ;
    cProgInfoDlg.show() ;
  }
}

// Fájl / Kilép
// Kilepes a rendszergombokra
class CKilepListener extends WindowAdapter implements ActionListener
{
  public void actionPerformed( ActionEvent e)
  {
    System.exit(0) ;
  }

  public void windowClosing(WindowEvent e)
  {
    System.exit(0) ;
  }
}

public class CHivValt extends Frame
{
  public CHivValt()
  {
    IMFActionListener cTempMFActionListener ;
    int i ;
    int nHossz ;

    // ???
    setTitle( "HTML hivatkozasok valtoztatasa") ;

    // -------------------------------------------------
    // Konvertalas indit
    cTempMFActionListener = new CDlgKonvInditListener() ;
    m_cFajlMenuPont[0].addActionListener( cTempMFActionListener) ;

    // Megnyit
    cTempMFActionListener = new CMegnyitListener() ;
    m_cFajlMenuPont[1].addActionListener( cTempMFActionListener) ;

    cTempMFActionListener = new CProgramInfoListener() ;
    m_cProgramInfoMenuPont[0].addActionListener( cTempMFActionListener) ;

    nHossz = m_cFajlMenuPont.length ;
    for( i = 0 ; i < nHossz ; i++)
    {
      m_cFajlMenu.add( m_cFajlMenuPont[i]) ;
    }

    nHossz = m_cProgramInfoMenuPont.length ;
    for( i = 0 ; i < nHossz ; i++)
    {
      m_cProgramInfoMenu.add( m_cProgramInfoMenuPont[i]) ;
    }

    m_cMenuBar.add( m_cFajlMenu) ;
    m_cMenuBar.add( m_cProgramInfoMenu) ;

    setMenuBar( m_cMenuBar) ;
    // -------------------------------------------------
    m_cSzovegmezo.setEditable( false) ;
    add( m_cSzovegmezo, BorderLayout.CENTER);

    // -------------------------------------------------

//    Panel p = new Panel();
//    p.setLayout(new FlowLayout());
//    p.add(open);
//    p.add(save);
//    add("South", p);
//    directory.setEditable(false);
//    filename.setEditable(false);
//    p = new Panel();
//    p.setLayout(new GridLayout(2,1));
//    p.add(filename);
//    p.add(directory);
//    add("North", p);

  }

  // T A G V A L T O Z O K
  MenuBar m_cMenuBar = new MenuBar() ;

  Menu m_cFajlMenu        = new Menu("Fájl") ;
  Menu m_cProgramInfoMenu = new Menu("Program infó") ;

  MenuItem m_cFajlMenuPont[] = {
                                 new MenuItem( "Konvertálás indít"),
                                 new MenuItem( "Megnyit"),
                                 new MenuItem( "Kilép")
                               } ;

  MenuItem m_cProgramInfoMenuPont[] = {
                                        new MenuItem( "Program információ")
                                      } ;

  public TextField m_cSzovegmezo = new TextField("Nincs szoveg", 30) ;

  // A main() for the application:
  public static void main(String[] args)
  {
    CKilepListener cKilepListener ;

    cKilepListener = new CKilepListener() ;

    // A system kilepes gomb
    IMFActionListener.m_cCHivValt.addWindowListener( cKilepListener) ; 

    // Kilép
    IMFActionListener.m_cCHivValt.m_cFajlMenuPont[2].addActionListener( cKilepListener) ;

    IMFActionListener.m_cCHivValt.setSize( 250, 110) ; 
    IMFActionListener.m_cCHivValt.show() ; 
  }
}