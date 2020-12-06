package egyeb;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Tamas_Pacsay on 7/10/2017.
 */
public class StrTokenizerProba
{
  private static final String PAGE_ROLE_URLS_DELIM = ";";

  private static Map<String, Boolean> createPageLoadRules( String disabledUrls) {
    Map<String, Boolean> pageLoadRules = new HashMap<>();

//        String disabledUrls = HostParameters.instance().getPageLoadRules();

    StringTokenizer stringTokenizer = new StringTokenizer( disabledUrls, PAGE_ROLE_URLS_DELIM);

    while ( stringTokenizer.hasMoreTokens()) {
      pageLoadRules.put( stringTokenizer.nextToken(), false);
    }

    return pageLoadRules;
  }

  public static void main( String args[]) {
//    Map<String,Boolean> eredmeny = createPageLoadRules( ""); // OK
//    Map<String,Boolean> eredmeny = createPageLoadRules( "egy"); // OK
//    Map<String,Boolean> eredmeny = createPageLoadRules( "egy;ket"); // OK
//    Map<String,Boolean> eredmeny = createPageLoadRules( "egy;ket;"); // OK
    Map<String,Boolean> eredmeny = createPageLoadRules( "egy;ket;;ha");
    System.out.println( "eredmeny=" + eredmeny);
  }
}