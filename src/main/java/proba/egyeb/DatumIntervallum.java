package proba.egyeb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tamas_Pacsay on 4/28/2017.
 */
public class DatumIntervallum
{
  private static char DATE_SEPARATOR = '.';

  public static String[] sortDates(List<String> datumLista)
  {
    String dateArray[] = (String[])datumLista.toArray(); // ez mas kornyezetben ClassCastExceptionnel meghal
    Arrays.sort( dateArray);

    System.out.println( "dateArray=" + datumLista);

    return dateArray;
  }

  public static String yyyymmddToddmm1( String datum) {
    StringBuilder ddmmSb = new StringBuilder("");

    if ( datum != null && datum.length() == 10 ) {
      int firstDotPos = datum.indexOf( DATE_SEPARATOR);
      int lastDotPos  = datum.lastIndexOf( DATE_SEPARATOR);

      if ( firstDotPos > -1 && lastDotPos > -1 && firstDotPos != lastDotPos) {
        String month = datum.substring( firstDotPos, lastDotPos);
        String day = datum.substring( lastDotPos);
        ddmmSb.append( day).append( DATE_SEPARATOR).append( month).append( DATE_SEPARATOR);
      }
    }

    return ddmmSb.toString();
  }

  // datum is expected to be yyyy.mm.dd
  public static String yyyymmddToddmm(String datum) {
    StringBuilder ddmmSb = new StringBuilder("");

    if ( datum != null && datum.length() == 10 && datum.charAt( 4) == DATE_SEPARATOR && datum.charAt( 7) == DATE_SEPARATOR ) {
      ddmmSb.append( datum.charAt( 8)).append( datum.charAt( 9)).append( DATE_SEPARATOR).append( datum.charAt( 5)).append( datum.charAt( 6)).append( DATE_SEPARATOR);
    }

    return ddmmSb.toString();
  }

  // datum is expected to be yyyy.mm.dd
  public static String yyyymmddToyyyy( String datum) {
    String yyyy = "";

    if ( datum != null && datum.length() == 10 && datum.charAt( 4) == DATE_SEPARATOR && datum.charAt( 7) == DATE_SEPARATOR ) {
      yyyy = datum.substring( 0, 4);
    }

    return yyyy;
  }

  // "2017.05.02", "2017.04.30", "2017.05.01", "2017.04.29" -> 29.04. - 02.05.2017
  // "2018.01.02", "2017.12.31", "2018.01.01", "2017.12.30" -> 12.30. - 02.01.2018
  public static String datesToInterval( List<String> dates) {
    StringBuilder dateIntervalSb = new StringBuilder();

    Collections.sort( dates);

    if ( dates.size() > 0 ) {
      if ( dates.size() == 1 ) {
        dateIntervalSb.append( yyyymmddToddmm( dates.get(0)));//.append( yyyymmddToyyyy( dates.get(0)));
      }
      else {
        dateIntervalSb.append( yyyymmddToddmm( dates.get(0)));
        dateIntervalSb.append( " - ");
        dateIntervalSb.append( yyyymmddToddmm( dates.get(dates.size()-1)));
//        dateIntervalSb.append( yyyymmddToyyyy( dates.get(dates.size()-1)));
      }
    }

    return dateIntervalSb.toString();
  }


  // 29/04, 30/04, 01/05 og 02/05.2017
  public static void main(String args[])
  {
    List<String> datumListaTobb = Arrays.asList( "2017.05.02", "2017.04.30", "2017.05.01", "2017.04.29");

    sortDates( datumListaTobb);

    List<String> datumListaEgy = Arrays.asList( "2017.04.29");

    sortDates( datumListaEgy);

    String dateInterval = datesToInterval( datumListaTobb);

    System.out.println( "dateInterval=" + dateInterval);

    dateInterval =  datesToInterval( datumListaEgy);

    System.out.println( "dateInterval=" + dateInterval);
  }
}
