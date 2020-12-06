package proba.mapexamples;

public class AlternatingCharacters
{
  static int alternatingCharacters(String s)
  {
    int amtSubseqChars = 0;

    for ( int i = 0 ; i < s.length()-1 ; i++ )
    {
      char actChar = s.charAt( i);


      int j = i+1;
      for ( ; j < s.length() ; j++ )
      {

        if ( actChar == s.charAt( j))
        {
          amtSubseqChars++;
        }
        else
        {
          break;
        }
      }

      i = j-1;
    }

    return amtSubseqChars;
  }

  public static void main(String[] args)
  {
    String s = "AAAA"; // 3
//    String s = "BBBBB"; // 4
//    String s = "ABABABAB"; // 0
//    String s = "BABABA"; // 0
//    String s = "AAABBB"; // 4

    System.out.println( alternatingCharacters( s));
  }
}
