package egyeb;

/**
 * Created by Tamas_Pacsay on 1/16/2017.
 * http://www.java2s.com/Tutorials/Java/OCA_Mock_Exam_Questions/Q2-3.htm
 */
public class ME12
{
  interface InterfaceA
  {
    public default String getName()  // A
    {
      return null;                   // C
    }
  }

  interface InterfaceB
  {
    public default String getName() // B
    {
      return null;
    }
  }

  abstract class Otter implements InterfaceB, InterfaceA // pt++ : egyik sem lehet default
  {
    public abstract String getName(); //pt++

//    public String getName() pt++
//    {
//      return null;
//    }
  }
}
