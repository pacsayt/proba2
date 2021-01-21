package proba.network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Eleg oskovulet
 * https://docs.oracle.com/javase/tutorial/networking/urls/urlInfo.html
 *
 *
 * https://www.baeldung.com/java-buffered-reader
 */
public class UrlUsage
{
  public static void parseURL() throws MalformedURLException
  {
      URL aURL = new URL("http://example.com:80/docs/books/tutorial" + "/index.html?name=networking#DOWNLOADING");

      System.out.println("protocol = " + aURL.getProtocol());
      System.out.println("authority = " + aURL.getAuthority());
      System.out.println("host = " + aURL.getHost());
      System.out.println("port = " + aURL.getPort());
      System.out.println("path = " + aURL.getPath());
      System.out.println("query = " + aURL.getQuery());
      System.out.println("filename = " + aURL.getFile());
      System.out.println("ref = " + aURL.getRef());

      /*
      protocol = http
      authority = example.com:80
      host = example.com
      port = 80
      path = /docs/books/tutorial/index.html
      query = name=networking
      filename = /docs/books/tutorial/index.html?name=networking
      ref = DOWNLOADING
      */
  }

  public static void readingDirectlyFromAUrl() throws IOException
  {
    // v.o. : new FileReader( new File( "file.txt");
    //        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
    URL oracle = new URL("http://www.oracle.com/");
    BufferedReader in = new BufferedReader( new InputStreamReader(oracle.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
    {
      System.out.println( inputLine);
    }

    in.close();
  }

  /**
   * A new URLConnection object is created every time by calling the openConnection method of the protocol handler for this URL.
   *
   * You are not always required to explicitly call the connect method to initiate the connection.
   * Operations that depend on being connected, like getInputStream, getOutputStream, etc, will implicitly perform the connection, if necessary.
   *
   * Now that you've successfully connected to your URL, you can use the URLConnection object to perform actions such as reading from or writing to the connection.
   * The next section shows you how.
   * https://docs.oracle.com/javase/tutorial/networking/urls/connecting.html
   */
  public static void connectToUrl()
  {
    try {
      URL myURL = new URL("http://example.com/");
      URLConnection myURLConnection = myURL.openConnection();
      myURLConnection.connect();
    }
    catch (MalformedURLException e) {
      // new URL() failed
      // ...
    }
    catch (IOException e) {
      // openConnection() failed
      // ...
    }
  }

  public static void main(String[] args) throws MalformedURLException, IOException
  {
    // parseURL();
    readingDirectlyFromAUrl();
  }
}
