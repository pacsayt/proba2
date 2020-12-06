package egyeb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Tamas_Pacsay on 8/7/2017.
 */
public class PathsPelda
{

  public static void listazA( Path dir) throws IOException
  {
    Files.list(dir).forEach(System.out::println); // Az adott konyvtarat listazza 1 melysegben : file + dir
  }

  public static void listazB( Path dir) throws IOException
  {
    Files.walk(dir).filter(Files::isDirectory).forEach(System.out::println); // Az adott konyvtarat listazza 1 melysegben : dir
  }

  public static void listazC( Path dir) throws IOException
  {
    //              /-> ...\proba\.\.idea\... -> ...\proba\.idea\...
    Files.walk(dir.normalize()).filter(Files::isRegularFile).forEach(System.out::println); // Az adott konyvtarat listazza rekurzivan : file + dir
  }

  public static void listazD( Path dir) throws IOException
  {
    Files.list(dir).forEach(System.out::println);
  }

  public static void listazE( Path dir) throws IOException
  {
     Files.find(dir, 1, (x, y) -> Files.isDirectory(x)).forEach(System.out::println);
  }

  public static void main( String args[])
  {
    Path dir = Paths.get("./.idea").toAbsolutePath();

    try
    {
      System.out.println( "AAAAAAAAAAAAAAAAAAA-----------------------------------------------------------------------");
      listazA( dir);

      System.out.println( "BBBBBBBBBBBBBBBBBBB-----------------------------------------------------------------------");
      listazB( dir);

      System.out.println( "CCCCCCCCCCCCCCCCCCC-----------------------------------------------------------------------");
      listazC( dir);

      System.out.println( "DDDDDDDDDDDDDDDDDDD-----------------------------------------------------------------------");
      listazD( dir);

      System.out.println( "EEEEEEEEEEEEEEEEEEE-----------------------------------------------------------------------");
      listazE( dir);
    }
    catch (IOException ioException)
    {
      System.out.println( "PathsPelda :" + ioException);
    }
  }
}
