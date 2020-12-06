package proba.lnko;//: Lnko.java
// Sebessegteszt ket egesz szam legnagyobb kozos osztojanak kikeresesevel
// C++  :  16'' ( A, B tagvaltozok) 7'' ( A, B LnkoKeres() lokalis register tip valtozok)
// Java : 228'' 14,25*

public class Lnko
{
  public Lnko()
  {
    m_nA = 0 ;
    m_nB = 0 ;
  }

  int m_nA ;
  int m_nB ;

  public void Init( int nAInit, int nBInit)
  {
    m_nA = nAInit ;
    m_nB = nBInit ;
  }

  int LnkoKeres()
  {
    while ( m_nA != m_nB )
    {
      if ( m_nA > m_nB )
      {
        m_nA = m_nA - m_nB ;
      }
      else
      {
        m_nB = m_nB - m_nA ;
      }
    }

    return m_nA ;
  }

  public static void main( String[] args)
  {
    int  nEredmeny ;
    Lnko pLnko = new Lnko() ;

    pLnko.Init(  214748364, 1) ;

    nEredmeny = pLnko.LnkoKeres() ;

    System.out.println( "Lnko : " + nEredmeny) ;
  }
}
///:~