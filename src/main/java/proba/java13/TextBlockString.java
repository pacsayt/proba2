package proba.java13;

public class TextBlockString {

  /**
   * JEP 355: Preview Feature
   *
   * "Not supported" : should be switched on using some command line switches
   */
  @SuppressWarnings("preview")
  public static void main(String[] args) {

    String string1 = "bla";
    String string2 = "bla";
    String string3 = new String( "bla");

    System.out.println( "string1 == string2 : " + (string1 == string2));
    System.out.println( "string1 == string3 : " + (string1 == string3));
//    String textBlock = """
//				Hi
//				Hello
//				Yes""";
//
//    String str = "Hi\nHello\nYes";
//
//    System.out.println("Text Block String:\n" + textBlock);
//    System.out.println("Normal String Literal:\n" + str);
//
//    System.out.println("Text Block and String Literal equals() Comparison: " + (textBlock.equals(str)));
//    System.out.println("Text Block and String Literal == Comparison: " + (textBlock == str));
  }

}
