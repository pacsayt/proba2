package proba.streamproba;

import java.util.stream.Stream;

public class TwoStreamConcat
{
  public static void main(String[] args)
  {
    Stream<String> stream1 = Stream.of( "Java", "8");
    Stream<String> stream2 = Stream.of( "explained", "through", "programs");

    Stream<String> concatdStream = Stream.concat( stream1, stream2);
    concatdStream.forEach(str -> System.out.print(str + " "));
  }
}
