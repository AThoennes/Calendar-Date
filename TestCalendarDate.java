import java.util.Scanner;
import java.io.*;

/* Java application having as its purpose to exercise some of the methods of the
** CalendarDate class.  
**
** This program uses the first run argument as the name of the file containing the
** data to be read as input.
**
** For each non-empty string read the program constructs a CalendarDate object using
** that string as the actual argument value, and this referred to as the reference
** date.  Then a series of additional strings are read (until a blank line is 
** encountered) and used to construct another CalendarDate object.  Then each of the 
** various "toString" methods of the class are used to print the value of this object,
** and then it is compared to the reference date with these results printed too.  
**
** Authors: R.W.M. and P.M.J.
** Date: Sept. 30, 2015
*/

public class TestCalendarDate {

   private static final String YYYYMMDD  = "YYYYMMDD";
   private static final String yMMDD     = "yMMDD";
   private static final String Month_d_y = "Month_d,_y";
   private static final String d_Month_y = "d_Month_y";
   private static final String m_d_y     = "m/d/y";
   private static final String d_Mon_y   = "d-Mon-y";
   private static final String y_m_d     = "y-m-d";
   private static final String isLT      = "is LT";
   private static final String isGT      = "is GT";
   private static final String EQUALS    = "equals";
   private static final String COMPARETO = "compareTo";

   private static final int YYYYMMDD_MAX_WIDTH  = 8;
   private static final int yMMDD_MAX_WIDTH     = 8;
   private static final int Month_d_y_MAX_WIDTH = 18;
   private static final int d_Month_y_MAX_WIDTH = 17;
   private static final int m_d_y_MAX_WIDTH     = 10;
   private static final int d_Mon_y_MAX_WIDTH   = 11;
   private static final int y_m_d_MAX_WIDTH     = 10;
   private static final int isLT_MAX_WIDTH      = 5;
   private static final int isGT_MAX_WIDTH      = 5;
   private static final int EQUALS_MAX_WIDTH    = 6;   
   private static final int COMPARETO_MAX_WIDTH = 10;   

   private static final int    MAX_WIDTH = 18;
   private static final char   SPACE     = ' ';
   private static final char   UNDERLINE = '-';
   private static final String SPACES    = "   ";
 
   public static void main(String[] args) throws IOException {
      Scanner inputStream = new Scanner(new File(args[0]));
      String result;
      
      String input;
      CalendarDate reference;
      input = getStringFromInput(inputStream).trim();
      // Keep iterating as long as the input provides a non-empty string.
      while (input.length() > 0) {
         reference = new CalendarDate(input);
         printHeading(reference);
         printObserverResults(reference, input, reference);      
         printUnderlines();      
         CalendarDate sample;
         input = getStringFromInput(inputStream).trim();
         while (input.length() > 0) {
            sample = new CalendarDate(input);
            printObserverResults(reference, input, sample);      
            input = getStringFromInput(inputStream).trim();
         }
         System.out.println();
         input = getStringFromInput(inputStream).trim();
      }
   }

   /* Uses the given scanner to read and return a string.
   */
   private static String getStringFromInput(Scanner input) {
      return input.nextLine(); 
   }
   
   /* Prints the heading line for the output
   */
   private static void printHeading(CalendarDate referenceDate) {
      System.out.print(padRight("",MAX_WIDTH) + SPACES);
      System.out.println(padRight(YYYYMMDD,  YYYYMMDD_MAX_WIDTH)  + SPACES + 
                         padRight(yMMDD,     yMMDD_MAX_WIDTH)     + SPACES + 
                         padRight(Month_d_y, Month_d_y_MAX_WIDTH) + SPACES + 
                         padRight(d_Month_y, d_Month_y_MAX_WIDTH) + SPACES + 
                         padRight(m_d_y,     m_d_y_MAX_WIDTH)     + SPACES + 
                         padRight(d_Mon_y,   d_Mon_y_MAX_WIDTH)   + SPACES + 
                         padRight(y_m_d,     y_m_d_MAX_WIDTH)     + SPACES +
                         padRight(isLT,      isLT_MAX_WIDTH)      + SPACES +
                         padRight(isGT,      isGT_MAX_WIDTH)      + SPACES +
                         padRight(EQUALS,    EQUALS_MAX_WIDTH)    + SPACES +
                         padRight(COMPARETO, COMPARETO_MAX_WIDTH) 
                         );
      printUnderlines();
   }
   
   /* Prints sequences of dashes aligned with the heading, as printed by printHeading()
   */
   private static void printUnderlines() {
      System.out.print(padRight("",MAX_WIDTH) + SPACES);
      System.out.println (padRight("",YYYYMMDD_MAX_WIDTH,UNDERLINE)  + SPACES + 
                          padRight("",yMMDD_MAX_WIDTH,UNDERLINE)     + SPACES + 
                          padRight("",Month_d_y_MAX_WIDTH,UNDERLINE) + SPACES + 
                          padRight("",d_Month_y_MAX_WIDTH,UNDERLINE) + SPACES + 
                          padRight("",m_d_y_MAX_WIDTH,UNDERLINE)     + SPACES + 
                          padRight("",d_Mon_y_MAX_WIDTH,UNDERLINE)   + SPACES +
                          padRight("",y_m_d_MAX_WIDTH,UNDERLINE)     + SPACES + 
                          padRight("",isLT_MAX_WIDTH,UNDERLINE)      + SPACES +
                          padRight("",isGT_MAX_WIDTH,UNDERLINE)      + SPACES +
                          padRight("",EQUALS_MAX_WIDTH,UNDERLINE)    + SPACES +
                          padRight("",COMPARETO_MAX_WIDTH,UNDERLINE) 
                          );
   }
   
   /* Prints the output obtained from the calls to the observer methods for the object sample.
   ** As appropriate the sample is compared to the reference object.
   */
   private static void printObserverResults(CalendarDate reference, String input, CalendarDate sample) {
      //-------------------------------------------------------------------------------------
      System.out.print(padRight(input,MAX_WIDTH) + SPACES);
      System.out.print(padRight(sample.toString()           , YYYYMMDD_MAX_WIDTH)  + SPACES);
      System.out.print(padRight(sample.toString_yMMDD()     , yMMDD_MAX_WIDTH)     + SPACES);
      System.out.print(padRight(sample.toString_Month_d_y() , Month_d_y_MAX_WIDTH) + SPACES);
      System.out.print(padRight(sample.toString_d_Month_y() , d_Month_y_MAX_WIDTH) + SPACES);
      System.out.print(padRight(sample.toString_m_d_y()     , m_d_y_MAX_WIDTH)     + SPACES);
      System.out.print(padRight(sample.toString_d_Mon_y()   , d_Mon_y_MAX_WIDTH)   + SPACES);
      System.out.print(padRight(sample.toString_y_m_d()     , y_m_d_MAX_WIDTH)     + SPACES);
      //-------------------------------------------------------------------------------------
      System.out.printf("%5b"+SPACES+"%5b"+SPACES+"%6b"+SPACES,sample.isEarlierThan(reference),
                                                               sample.isLaterThan(reference),
                                                               sample.equals(reference) );
      System.out.printf("%10d",sample.compareTo(reference));
      //-------------------------------------------------------------------------------------
      System.out.println();
   }
   
   /* Returns the given string with extra spaces "padded" to the right as
   ** necessary in order to make the resultant length of the string equal
   ** the given width.
   */
   private static String padRight(String s, int width) {
      return padRight(s, width, SPACE);
   }
   
   /* Returns the given string with extra characters "padded" to the right as
   ** necessary in order to make the resultant length of the string equal
   ** the given width.  The character used for the padding is given as the
   ** third parameter.
   */
   private static String padRight(String s, int width, char c) {
      String result = s;
      while(result.length() < width) {
         result = result + c;
      }
      return result;
   }
}
