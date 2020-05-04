/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: BinaryClockSolver<br />
 * purpose : A binary clock displays the hours, minutes, and seconds in binary number format
 * rather than in the decimal numbers we're used to seeing.
 * <p>
 * @author : Summer McGrogan
 * @since  : 2020-04-19
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;
import java.lang.NumberFormatException;
import java.util.Random;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Finds the probability that in a set of people there will be two who share the same birthday.
 * <p>
 * This implementation does NOT consider leap years, only standard years
 */
public class BinaryClockSolver {


  /**
   * Checks inputs of command line if they match string: HH:MM:SS
   *
   * @param  times  string number of the times entered on command line
   * @return String of clocktimes
   */


   public static String checkinputs(String[] times){
     String clocktimes = "";


     for(int i = 0; i < times.length; i++){
        clocktimes += times[i];
     }

     //System.out.println(" Your clocktime is: " + clocktimes);

     //positional integers used to check if inputs are numbers, not used again
     int p1;
     int p2;
     int p3;

     if((!clocktimes.substring(2, 3).equals(":")) || (!clocktimes.substring(5, 6).equals(":"))){
        System.out.println("Must separate number hours by ':', you did not!!");
        System.exit(0);
     }
     if(clocktimes.length() > 8 || clocktimes.length() < 7){
        System.out.println("Cannot use format that does not fit: 'HH:MM:SS'!");
        System.exit(0);
     }

     try{
       p1 = Integer.parseInt(clocktimes.substring(0,2));
       //System.out.println("p1 " + p1);
       p2 = Integer.parseInt(clocktimes.substring(3,5));
       p3 = Integer.parseInt(clocktimes.substring(6,8));
       //clocktimes[4] = Integer.parseInt(clocktimes[4]);
       //clocktimes[6] = Integer.parseInt(clocktimes[6]);
       //clocktimes[7] = Integer.parseInt(clocktimes[7]);
     }catch(NumberFormatException e){
       System.out.println("All values must be numbers! Enter numbers as format 'HH:MM:SS'!!!");
       System.exit(0);
     }
     //System.out.println("Finding : " + clocktimes.substring(0, 6));


     return clocktimes;

   }


   /**
    * Changes inputted value to a binary value
    * @param bin String version of a number you want to change to binary
    * @return String version of number as binary
    */

    public void convertbin(String bin){
      int binary[] = new int[bin.length()];
      int quotient = 0;
      String brep = "";
      int num = Integer.parseInt(bin);
      while(num > 0){
        for(int i = 0; i < bin.length(); i++){
           binary[i] = num%2;
           num = num/2;
           if(binary[i] == 1){
              brep += "*";
           }else{
              brep += "o";
           }

         }
       }
       String represent = "";
       for (int i = brep.length()-1; i >= 0; i--){
          represent += brep.charAt(i);
       }

      System.out.println(represent);// brep;
    }



   public static void main( String[] args ) {

     BinaryClockSolver cs = new BinaryClockSolver();
     cs.checkinputs(args);
     String argus = "";

     for(int i = 0; i < args.length; i++){
        argus += args[i];
     }


     String appender = "";
     String appender2 = "";
     String appender3 = "";

     for(int i = 0; i < 2; i++){
        appender += (argus.charAt(i));
     }

     int clockH = Integer.parseInt(appender.toString());

     for(int i = 3; i < 5; i++){
        appender2 += (argus.charAt(i));
     }
     int clockM = Integer.parseInt(appender2.toString());

     for(int i = 6; i < 8; i++){
        appender3 += (argus.charAt(i));
     }
     int clockS = Integer.parseInt(appender3.toString());


     if(clockH > 23){
        System.out.println("\n You have entered an hour that is too high, try again.");
        System.exit(0);
     }
     if(clockM > 59){
        System.out.println("\n You have entered a minute that is too high, try again.");
        System.exit(0);
     }
     if(clockS > 59){
        System.out.println("\n You have entered a second that is too high, try again.");
        System.exit(0);
     }

     cs.convertbin(Integer.toString(clockH));

     cs.convertbin(Integer.toString(clockM));

     cs.convertbin(Integer.toString(clockS));

   }

 }
