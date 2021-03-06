/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: BirthdaySolver<br />
 * purpose : Estimates the probability that, among n randomly-chosen people,
 *             there is at least one duplicated birthdate
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
public class BirthdaySolver {

  //  private fields don't get documented in javadoc output
   private static final int DAYS_PER_YEAR = 365;
   private static final int DEFAULT_NUMBER_OF_EXPERIMENTS = 100000;
   private static final int NOTIFICATION_CUTOFF = 2999999;
   private static final boolean DEBUG_ON = false;        // set to false for release

  /**
   * Calculates the actual probability that from a certain number of people, at least two of them
   *  share the same birthday.  Based on calculating the probability that they DO NOT share a
   *  birthday, then subtracting that probability from 1.0 to get the other side of the coin.
   *
   * @param  numberOfPeople  integer number of people in the sample
   * @return double the probability value, range between zero and one
   * @see <a href="http://bjohnson.lmu.build/cmsi186web/homework07.html">Assignment Page</a>
   * @see <a href="https://betterexplained.com/articles/understanding-the-birthday-paradox/">Better Explained Page</a>
   * @see <a href="https://en.wikipedia.org/wiki/Birthday_problem">Wikipedia Page</a>
   */
   public double calculateActualProbability( int numberOfPeople ) {
      double proB = 1.0;
      double probaBL = 0.0;
      for (int i = 0; i < numberOfPeople; i++){
         proB = proB * (364 - i)/365;
      }
      probaBL = (1 - proB) * 100;
      return probaBL;
   }

  /**
   * This is the main method of the program.  It first verifies the arguments from
   *  the command line, then does a loop to calculate an approximate probability.
   *  After that, it calls the <code>calculateActualProbability</code> method and
   *  then displays both results for comparison.
   *
   * @param args two are used: [0] = number of people; [1] = number of experiments.
   * @throws NumberFormatException if args[0] is not an actual integer.
   * @throws ArrayIndexOutOfBoundsException if no arguments entered.
   */
   public static void main ( String [] args ) {

      DecimalFormat df = new DecimalFormat( "#.00" );
      BirthdaySolver b = new BirthdaySolver();
      int n = 0;
      double approX = 0.0;
      int npeople = 0;
      int nTests = 0;
      String s = "";

     // check the arguments

     try{
        if (args.length > 0){
           System.out.println("Valid number of args entered");
        }
     } catch (ArrayIndexOutOfBoundsException a){
        System.out.println( " \n Must enter arguments!!! \n" + a.toString() );
        System.exit(0);
     }


     try{
       npeople = Integer.parseInt(args[0]);
       System.out.println(" \n Valid number of people \n");
     }catch(NumberFormatException e){
       System.out.println("\n Not a valid number of people!!!! \n" + e.toString());
       System.exit(0);
     }

     if(args.length == 1){
         nTests = DEFAULT_NUMBER_OF_EXPERIMENTS;
         System.out.println("\n You did not enter a valid argument for number of experiments, \n default value is 100,000");
     }
     else if (args.length == 2){
       try{
           nTests = Integer.parseInt(args[1]);
       }catch(NumberFormatException e){
           nTests = DEFAULT_NUMBER_OF_EXPERIMENTS;
           System.out.println( e.toString() );
       }
     }



     // declare and initialize the duplicates counter

     double duplicates = 0.0;

     // notify the user that we're starting and let 'em know if it's gonna be looooooong

     System.out.println(" \n Counter initialized. \n Starting algorithm calculation....\n This will take a moment.");

     // actual programming loop; note the internal try/catch
     //  this loop runs "n" experiments, and counts whenever there is a duplicate
     //     random birthday

     OUTER_LOOP:
     for (int i = 0; i < nTests; i++){
        int[] bdaytracker = new int[365];
        INNER_LOOP:
        for (int j = 0; j < npeople; j++){
           Random bd = new Random();
           int ranbday = bd.nextInt((364-0) + 0) + 0;
           if (bdaytracker[ranbday] == 1){
              duplicates++;
              break INNER_LOOP;
           }
           else if(bdaytracker[ranbday] == 0){
              bdaytracker[ranbday] = 1;
           }
        }
     }

     approX = (duplicates/nTests) * 100;

     // done with the loop, now find the average probability by simple division
      System.out.println( "   Probability that two out of " + npeople + " people have the same birthday: " );
      System.out.println( "      Experimental value is: " + approX + "%" );
      System.out.println( "            Actual value is: " + b.calculateActualProbability(npeople) + "%\n\n" );
   }
}
