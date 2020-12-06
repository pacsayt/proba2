package proba.funct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tamas_Pacsay on 11/18/2016.
 */
class Article
{
  private String author;

  private int    publishedY;
  private List<String> tags = new ArrayList<>();

  public Article(String inAuthor, int inPublishedY, List<String> inTags)
  {
    author = inAuthor;
    publishedY = inPublishedY;
    tags.addAll( inTags);
  }

  public String getAuthor()
  {
    return author;
  }

  public Integer published()
  {
    return publishedY;
  }

  public List<String> getTags()
  {
    return tags;
  }

  @Override
  public String toString()
  {
    return "Article{" +
                   "author='" + author + '\'' +
                   ", publishedY=" + publishedY +
                   ", tags=" + tags +
                   '}';
  }
}
