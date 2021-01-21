package proba.hackerrank.trees;

class Node2
{
  public int data;
  public Node2 left;
  public Node2 right;
}

public class BSTLC
{
  public static Node2 lca(Node2 root, int v1, int v2)
  {
    Node2 leftIfFound = null;
    Node2 rightIfFound = null;

    if ( root.data == v1 || root.data == v2 )
    {
      return root;
    }

    if ( root.left != null )
    {
      leftIfFound = lca( root.left, v1, v2);
    }

    if ( root.right != null )
    {
      rightIfFound = lca( root.right, v1, v2);
    }

    if ( (leftIfFound != null  && rightIfFound != null) )
    {
      return root;
    }
    else
    {
      if ( leftIfFound != null )
      {
        return  leftIfFound;
      }
    }

    return rightIfFound;
  }

  public static void main(String[] args)
  {
    Node2 node4 = new Node2();
    node4.data = 4;

    Node2 node2 = new Node2();
    node2.data = 2;

    node4.left = node2;

    Node2 node1 = new Node2();
    node1.data = 1;

    node2.left = node1;

    Node2 node3 = new Node2();
    node3.data = 3;

    node2.right = node3;

    Node2 node7 = new Node2();
    node7.data = 7;

    node4.right = node7;

    Node2 node6 = new Node2();
    node6.data = 6;

    node7.right = node6;

    Node2 anchestor = lca( node4, 1, 7);

    System.out.println( anchestor.data);
  }
}
