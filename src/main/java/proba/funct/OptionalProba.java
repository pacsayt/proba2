package proba.funct;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Tamas_Pacsay on 11/18/2016.
 */
public class OptionalProba
{
  private static final List<String> tags1 = Arrays.asList( "TAG1", "TAG2");
  private static final List<String> tags2 = Arrays.asList( "TAG2", "TAG3");
  private static final List<String> tags3 = Arrays.asList( "TAG1", "TAG4");

  private static String authorName1 = "Name 1";
  private static String authorName2 = "Name 2";

  private static Article article_1_1 = new Article( authorName1, 2010, tags1);
  private static Article article_1_2 = new Article( authorName1, 2011, tags2);
  private static Article article_1_3 = new Article( authorName1, 2012, tags3);

  private static Article article_2_1 = new Article( authorName2, 2020, tags1);
  private static Article article_2_2 = new Article( authorName2, 2021, tags2);
  private static Article article_2_3 = new Article( authorName2, 2022, tags3);

  private static List<Article> articleList1 = Arrays.asList( article_1_1, article_1_2, article_1_3);
  private static List<Article> articleList2 = Arrays.asList( article_2_1, article_2_2, article_2_3);
  private static List<Article> articleList3 = new ArrayList<>();

  // Nehany jatek az Optionallal
  public static void optionalLehetosegek()
  {
    articleList3.addAll( articleList1);
    articleList3.addAll( articleList2);

    BiFunction<String, List<Article>, List<Article>> byTag = (tag, articles) -> articles.stream()
                                                                                        .filter( a -> a.getTags().contains( tag))
                                                                                        .collect( Collectors.toList());

    Function<List<Article>, List<Article>> sortByDate = articles -> articles.stream()
                                                                            .sorted( ( x, y) -> y.published().compareTo( x.published()))
                                                                            .collect( Collectors.toList());

    Function<List<Article>, Optional<Article>> first = a -> a.stream().findFirst();
    Function<List<Article>, Optional<Article>> newest = first.compose( sortByDate);

    // Kicsit ismetlos, de legalabb sajat kutfobol ;-) Lenyeg, hogy Optional legyen az eredmeny
    BiFunction< String, List<Article>, Optional<Article>> newestByTag = ( tag, articleList) -> articleList.stream()
                                                                                                       .filter( a -> a.getTags().contains( tag))
                                                                                                       .sorted( (a1, a2) -> a1.published().compareTo( a2.published()))
                                                                                                       .findFirst();

    newestByTag.apply( "TAG3", articleList3).ifPresent( a -> System.out.println( a));

    System.out.println( "TAG9 -> orElse( article_1_3)" + newestByTag.apply( "TAG9", articleList3).orElse( article_1_3));

    // Masodik verzio : osszetetellel ...
    BiFunction< String, List<Article>, Optional<Article>> newestByTagOsszetetel = byTag.andThen( sortByDate).andThen( first);

    // A vegrehajtas
    Optional<Article> legujabbArticleByTag = newestByTagOsszetetel.apply( "TAG1", articleList3);

    legujabbArticleByTag.ifPresent( a -> System.out.println( a)); // pt++ : jobb lenne egy olyan pelda, amikor nem egyszeru kiirasra hasznaljak

    Optional<Article> legujabbArticleByTag2 = newestByTagOsszetetel.apply( "TAG1", articleList3);

//    legujabbArticleByTag.ifPresent();

    // pt++ :                         \/ Supplier l. Supplier::get() <- ez mindenkeppen meghivja a fv-t az argumentumban, az orElseGet() nem
    Article articleEredmeny = legujabbArticleByTag2.orElseGet( () -> article_1_3);

    System.out.println( "akos articleEredmeny=" + articleEredmeny);
  }

  public static void main(String[] args)
  {
    optionalLehetosegek();

    int x = 1;

    x++;

    MouseListener listener = new MouseListener()
    {
      @Override
      public void mouseClicked(MouseEvent e)
      {
        int x = 2;

      }

      @Override
      public void mousePressed(MouseEvent e)
      {
//        System.out.print( x);
      }

      @Override
      public void mouseReleased(MouseEvent e)
      {

      }

      @Override
      public void mouseEntered(MouseEvent e)
      {

      }

      @Override
      public void mouseExited(MouseEvent e)
      {

      }
    };
  }
}