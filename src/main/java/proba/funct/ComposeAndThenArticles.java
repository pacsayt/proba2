package proba.funct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Tamas_Pacsay on 11/17/2016.
 */

public class ComposeAndThenArticles
{
  private static final List<String> tags1 = Arrays.asList( "TAG1", "TAG2");
  private static final List<String> tags2 = Arrays.asList( "TAG2", "TAG3");
  private static final List<String> tags3 = Arrays.asList( "TAG1", "TAG4");

  private static String authorName1 = "Name 1";
  private static String authorName2 = "Name 2";

  private static Article article_1_1 = new Article( authorName1, 2010, tags1); // Article : String author/int publishedY/List<String> tags
  private static Article article_1_2 = new Article( authorName1, 2011, tags2);
  private static Article article_1_3 = new Article( authorName1, 2012, tags3);

  private static Article article_2_1 = new Article( authorName2, 2020, tags1);
  private static Article article_2_2 = new Article( authorName2, 2021, tags2);
  private static Article article_2_3 = new Article( authorName2, 2022, tags3);

  private static List<Article> articleList1 = Arrays.asList( article_1_1, article_1_2, article_1_3);
  private static List<Article> articleList2 = Arrays.asList( article_2_1, article_2_2, article_2_3);
  private static List<Article> articleList3 = new ArrayList<>();

  public static void composeAndThen()
  {
    articleList3.addAll( articleList1);
    articleList3.addAll( articleList2);

    // Alap epitokovek -------------------------------------------------------------------------------------------------
    // Interface BiFunction<T,U,R> : T - first argument, U - second argument, R - result
    BiFunction<String, List<Article>, List<Article>> byAuthor = (name, articles) -> articles.stream()
                                                                                    .filter( a -> a.getAuthor().equals( name))
                                                                                    .collect( Collectors.toList());

    BiFunction<String, List<Article>, List<Article>> byTag = (tag, articles) -> articles.stream()
                                                                                .filter( a -> a.getTags().contains( tag))
                                                                                .collect( Collectors.toList());

    // Interface Function<T,R> : T - argument, R - result
    Function<List<Article>, List<Article>> sortByDate = articles -> articles.stream()
                                                                    .sorted( ( x, y) -> y.published().compareTo( x.published()))
                                                                    .collect( Collectors.toList());

    Function<List<Article>, Optional<Article>> first =  a -> a.stream().findFirst();

    // Osszetett fuggvenyek---------------------------------------------------------------------------------------------
    Function<List<Article>, Optional<Article>> newest = first.compose( sortByDate);

    // Finding an author's newest masterpiece.
    BiFunction<String, List<Article>, Optional<Article>> newestByAuthor = byAuthor.andThen( newest);

    // Or just order an author's articles.
    BiFunction<String, List<Article>, List<Article>> byAuthorSorted = byAuthor.andThen( sortByDate);

    // You just want the newest article based on your favourite tag.
    BiFunction<String, List<Article>, Optional<Article>> newestByTag = byTag.andThen( newest);

    // -----------------------------------------------------------------------------------------------------------------
    Optional<Article> legujabbA1 = newestByAuthor.apply( authorName1, articleList3);
    System.out.println( "Legujabb author1-tol : " + legujabbA1.toString());

    List<Article> eredmenyek = byAuthorSorted.apply( authorName1, articleList3);
    System.out.println( "Rendezve author1-tol : " + eredmenyek.toString());

    Optional<Article> legujabbT1 = newestByTag.apply( "TAG2", articleList3);

    System.out.println( "Legujabb TAG1 : " + legujabbT1.toString());
  }


  public static void main(String[] args)
  {
    composeAndThen();
  }
}