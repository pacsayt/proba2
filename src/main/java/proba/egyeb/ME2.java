package egyeb;

/**
 * Created by Tamas_Pacsay on 1/16/2017.
 * http://www.java2s.com/Tutorials/Java/OCA_Mock_Exam_Questions/Q1-5.htm
 * ^ nem fordul : B miatt (ellentetben a linken allitottal)
 */
class Shape
{
  public Shape()
  {
    System.out.print("Shape");
  }

  public Shape(int edge)
  {
    System.out.print("ShapeEdge");
  }

  private boolean hasEdges()
  {
    return false;
  }
}

class Rectangle extends Shape
{
  public Rectangle(int age)
  {
    System.out.print("Rectangle");
  }

  public boolean hasEdges()  // C
  {
    return true;
  }
}

public class ME2
{
  public static void main(String[] args)
  {
    Shape rectangle = new Rectangle(5);  // A
// pt++    System.out.println(","+rectangle.hasEdges()); // B
  }
}
