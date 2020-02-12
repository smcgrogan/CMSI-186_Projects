/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Summer McGrogan
 *  Date          :  02.02.2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
   import java.io.BufferedReader;
   import java.io.InputStreamReader;
   import java.io.IOException;

   public class HighRoll{


      public static void main( String args[] ) {
        int count = Integer.parseInt(args [0]);
        int sides = Integer.parseInt(args [1]);
        int highScore = 0;
        DiceSet dSet = new DiceSet(count, sides);
        System.out.print( "Option 1 : ROLL ALL THE DICE \nOption 2 : ROLL A SINGLE DIE \nOption 3 : CALCULATE THE SCORE FOR THIS SET \nOption 4 : SAVE THIS SCORE AS HIGH SCORE \nOption 5 : DISPLAY THE HIGH SCORE \nOption 6 : ENTER 'Q' TO QUIT THE PROGRAM\n" ); //prompt gets changed to options
        // This line uses the two classes to assemble an "input stream" for the user to type
        // text into the program
         BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) ); //allows you to read the input
         while( true ) {
            System.out.println("start here: ");
            String inputLine = null;
            try {
               inputLine = input.readLine();
               if( '0' == inputLine.length() ) {
                  System.out.println("enter some text!:");
                  continue;
               }
               if( 'q' == inputLine.charAt(0) ) { //if this is 1, call dice.rollAll, if rollIndivid, as which one (add another read and add a parseInt to get the value)
                  break;
               }
               if( '1' == inputLine.charAt(0)) {
                 dSet.roll();
                 System.out.println("You rolled a: " + dSet.toString());
                 System.out.println("Play Again!!");
                 System.out.print( "Option 1 : ROLL ALL THE DICE \nOption 2 : ROLL A SINGLE DIE \nOption 3 : CALCULATE THE SCORE FOR THIS SET \nOption 4 : SAVE THIS SCORE AS HIGH SCORE \nOption 5 : DISPLAY THE HIGH SCORE \nOption 6 : ENTER 'Q' TO QUIT THE PROGRAM\n");
               }
               if( '2' == inputLine.charAt(0)) {
                 System.out.print("Enter the die you want to roll again: ");
                 dSet.rollIndividual(Integer.parseInt(input.readLine()) - 1);
                 System.out.println("You rolled a: " + dSet.toString());
                 System.out.println("Play Again!!");
                 System.out.print( "Option 1 : ROLL ALL THE DICE \nOption 2 : ROLL A SINGLE DIE \nOption 3 : CALCULATE THE SCORE FOR THIS SET \nOption 4 : SAVE THIS SCORE AS HIGH SCORE \nOption 5 : DISPLAY THE HIGH SCORE \nOption 6 : ENTER 'Q' TO QUIT THE PROGRAM\n");
               }
               if( '3' == inputLine.charAt(0)) {
                 System.out.println("Your scores sum is: " + dSet.sum());
                 System.out.println("Play Again!!");
                 System.out.print( "Option 1 : ROLL ALL THE DICE \nOption 2 : ROLL A SINGLE DIE \nOption 3 : CALCULATE THE SCORE FOR THIS SET \nOption 4 : SAVE THIS SCORE AS HIGH SCORE \nOption 5 : DISPLAY THE HIGH SCORE \nOption 6 : ENTER 'Q' TO QUIT THE PROGRAM\n");
               }
               if( '4' == inputLine.charAt(0)) {
                 highScore = dSet.sum();
                 System.out.println("Your highscore is: " + highScore);
                 System.out.println("Play Again!!");
                 System.out.print( "Option 1 : ROLL ALL THE DICE \nOption 2 : ROLL A SINGLE DIE \nOption 3 : CALCULATE THE SCORE FOR THIS SET \nOption 4 : SAVE THIS SCORE AS HIGH SCORE \nOption 5 : DISPLAY THE HIGH SCORE \nOption 6 : ENTER 'Q' TO QUIT THE PROGRAM\n");
               }
               if( '5' == inputLine.charAt(0)) {
                 System.out.print("Your highscore is: " + highScore);
                 System.out.println("Play Again!!");
                 System.out.print( "Option 1 : ROLL ALL THE DICE \nOption 2 : ROLL A SINGLE DIE \nOption 3 : CALCULATE THE SCORE FOR THIS SET \nOption 4 : SAVE THIS SCORE AS HIGH SCORE \nOption 5 : DISPLAY THE HIGH SCORE \nOption 6 : ENTER 'Q' TO QUIT THE PROGRAM\n");
               }
            }
            catch( IOException ioe ) {
               System.out.println( "Caught IOException" );
            }
         }
      }
   }
