package proba.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * How To Work With Files In Java
 * https://www.marcobehler.com/guides/java-files
 */
public class HowToWorkWithFilesInJava
{
  public static void path() throws URISyntaxException
  {
    // Java11+  : Path.of()

    Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
    System.out.println(path);

    path = Path.of("c:/dev/licenses/windows/readme.txt");
    System.out.println(path);

    path = Path.of("c:" , "dev", "licenses", "windows", "readme.txt");
    System.out.println(path);

    path = Path.of("c:" , "dev", "licenses", "windows").resolve("readme.txt"); // resolve == getChild()
    System.out.println(path);

    path = Path.of(new URI("file:///c:/dev/licenses/windows/readme.txt"));
    System.out.println(path);

    // Java < 11 equivalent: Paths.get()
    path = Paths.get("c:/dev/licenses/windows/readme.txt");
    System.out.println(path);

    path = Path.of( ".");
    System.out.println(path.toAbsolutePath());
    System.out.println(path); // pt++ -> .
  }

  public static void tempFiles() throws IOException
  {
    Path path = Path.of( "proba.txt");

    Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".tmp"); // -> /tmp/somePrefixOrNull6582638720860106564.tmp
    System.out.println("tempFile1 = " + tempFile1);

    Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".tmp");
    System.out.println("tempFile2 = " + tempFile2);

    Path tmpDirectory = Files.createTempDirectory("prefix");
    System.out.println("tmpDirectory = " + tmpDirectory);
  }

  public static void writingReadingFiles() throws IOException
  {
    final Path path = Paths.get("/tmp/proba2filename.txt");
    Files.write(path, Arrays.asList("New line to append"), StandardCharsets.UTF_8, Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

    Path utfFile = Files.createTempFile("some", ".txt");
    Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8
    System.out.println("utfFile = " + utfFile);

    Path iso88591File = Files.createTempFile("some", ".txt");
    Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
    System.out.println("iso88591File = " + iso88591File);
  }

  public static void writingReadingBufferedFiles() throws IOException
  {
    Path utfFile = Files.createTempFile("buffered", ".tmp");

    try ( BufferedWriter bufferedWriter = Files.newBufferedWriter(utfFile))
    {
      int offset = 5;
      int length = 5;
      bufferedWriter.write( "0123456789", offset, length);
      bufferedWriter.newLine();
      bufferedWriter.append( "ABCDEFGHIJ");
      bufferedWriter.newLine();
//      bufferedWriter.close(); // try with resources miatt nem kell
    }

    String s = new String(Files.readAllBytes( utfFile), StandardCharsets.UTF_8); // az egesz file-t (!) benyalja
    System.out.println("s = '" + s + "'");
  }

  public static void main(String[] args) throws URISyntaxException, IOException
  {
    //path();
    //tempFiles();
    writingReadingBufferedFiles();
  }
}
