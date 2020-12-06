package proba.egyeb;

/**
 * Created by Tamas_Pacsay on 1/16/2017.
 */
public class ME9
{
  public static void main(String[] args)
  {
    int myValue = 0;
    int x = 3;

    while(myValue++ < 3)
    {
      int y = (1 + 2 * myValue) % 3;
      switch(y)
      {
        default:
        case 0: x -= 1; break;
        case 1: x += 5;
      }
    }

    System.out.println(x);
  }
}
