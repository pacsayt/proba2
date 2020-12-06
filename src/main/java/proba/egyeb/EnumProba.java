package proba.egyeb;

/**
 * Created by Tamas_Pacsay on 6/19/2017.
 * https://stackoverflow.com/questions/3978654/best-way-to-create-enum-of-strings
 * http://javahowto.blogspot.com/2006/10/custom-string-values-for-enum.html
 */
public enum EnumProba
{
  EGY,
  KET,
  HA
  {
    @Override
    public String toString()
    {
      // This is not an efficient way to do this. This creates a new custom class for every value in the enumeration.
      // In the above example, you'll see the following in the bin directory: EnumProba$EGY/KET/HA.class
      return "H A R O M - sajat feluldefinialt fv alapjan";
    }
  };

  public static void main(String args[])
  {
    System.out.println( "1: " + EnumProba.EGY);
    System.out.println( "2: " + KET);
    System.out.println( "3: " + HA);
  }
}


