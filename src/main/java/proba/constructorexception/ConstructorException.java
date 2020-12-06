/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proba.constructorexception;

class A
{
  public int m_nInt = 1 ;
  
  public int m_aInt[] = null ;
  
  public A( B jB) throws Exception
  {
    m_aInt = new int[] { 1, 2, 3, 4, 5} ;
    
    jB.SetA( this);
    
    throw new Exception() ;
  }
}

class B
{
  public A m_jA = null ;
  
  public void SetA( A aObject)
  {
    m_jA = aObject ;
    
    System.out.println( "m_jA.m_nInt=" + m_jA.m_nInt) ;
  }
  
  public void PrintA()
  {
    System.out.println( "m_jA.m_nInt=" + m_jA.m_nInt) ;
    System.out.println( "m_jA.m_aInt=" + m_jA.m_aInt) ;
  }
}

/**
 *
 * @author tamas
 */
public class ConstructorException
{
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    B jB = new B() ;
    
    try
    {
      A jA = new A( jB) ;
    }
    catch ( Exception e)
    {
      jB.PrintA() ;
    }
  }
}
