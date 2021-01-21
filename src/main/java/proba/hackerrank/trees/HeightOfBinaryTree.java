package proba.hackerrank.trees;

class Node
{
  public int data;
  public   Node left;
  public Node right;
}

public class HeightOfBinaryTree
{
  static int maxHeight = 0;
  static int actHeight = 0;

  public static int height(Node root)
  {
    actHeight++;

    if ( root.left != null )
    {
      height( root.left);
      actHeight--;
    }

    if ( root.right != null )
    {
      height( root.right);
      actHeight--;
    }

    if ( actHeight > maxHeight)
    {
      maxHeight = actHeight;
    }

    return maxHeight-1;
  }

  public static void main(String[] args)
  {

  }
}
