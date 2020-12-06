package proba.hackerrank.sorting;

import java.util.Arrays;
import java.util.Comparator;

class Player
{
  public Player(String name, int score)
  {
    this.name = name;
    this.score = score;
  }

  public String name;
  public int score;

  @Override
  public String toString()
  {
    return "Player{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
  }
}

class Checker implements Comparator<Player>
{
  // complete this method
  public int compare(Player a, Player b) {
    if ( a.score < b.score )
    {
      return 1;
    }
    else
    {
      if ( a.score == b.score )
      {
        return a.name.compareTo(b.name);
      }
    }

    return -1;
  }

}

public class SortingComparator
{


  public static void main(String[] args)
  {
    Player players[] = { new Player( "amy", 100),
                         new Player( "david", 100),
                         new Player( "heraldo", 50),
                         new Player( "aakansha", 75),
                         new Player( "aleksa", 150)};

    Arrays.sort( players, new Checker());

    System.out.println( Arrays.toString( players));
  }
}
