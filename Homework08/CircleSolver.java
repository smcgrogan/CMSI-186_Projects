/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: CircleSolver.java < br />
 * purpose : Determine if two circles intersect
 * <p>
 * @author : Summer McGrogan
 * @since  : 2020-04-27
 * Notes: Make a Java program, CircleSolver.java, that determines if two circles intersect. Your program must:
 * 1. Read the circle parameters from a file.
 * 2. Each line in the file will give parameters for one circle.
 * 3. File lines will be formatted with the X-coordinate, then the Y-coordinate, then the radius of the circle, IN THAT ORDER, separated by spaces
 * 4. Your program must output the parameters for each circle pair that includes the X and Y value of the center and the radius of each circle.
 * 5. Your program must output whether the circles intersect, and at how many points they meet. If they meet at more than one point, just state that fact.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Arrays;
import java.lang.Float;

/**
 * Demonstrates a simple input mechanism for reading a text file and writing its
 *    contents into a 1D array of String objects.
 * <p>
 * This is a demonstrator only and does not *DO* anything with the array other
 *    than print it to the display; however, it does contain a method that will read
 *    the named file and return an array of Strings contining the maze description.
 *    I left the name to be "FileDemo" because it includes a main method that shows
 *    how it can be used.
 */
public class CircleSolver {

   private static final int X_INDEX = 0;
   private static final int Y_INDEX = 1;
   private static final int Z_INDEX = 2;
   int[] circleC1 = new int[3];
   int[] circleC2 = new int[3];


  /**
   * Reads a file that contains a description of Circle1
   *
   * @param filename String that contains the name of the file; file is assumed to be
   *           in the same directory as the program which calls this method
   * @return integer array of circle1 coordinates
   * @throws NumberFormatException if circleC1[i] or circleC2[i] is not an actual integer.
   */
   public int[] coordsCircle1( String filename ) throws IOException {
      String [] circleA1 = null;

     // open the file
      File file = new File( filename );
      BufferedReader br = new BufferedReader( new FileReader( file ) );

      String circle1 = br.readLine();


      if(circle1 != null){
         circleA1 = circle1.split(" ");
         System.out.println("Splitting...");
      }
      else{
         System.out.println("First line of file is empty!!");
         System.exit(0);
      }


      try{
        for (int i = 0; i < circleA1.length; i++){
           //System.out.println("Circle 1 length of: " + circleA1.length);
           circleC1[i] = Integer.parseInt(circleA1[i]);
        }
      } catch (NumberFormatException e){
          System.out.println("All values must be numbers!");
      }
      return circleC1;
   }

   /**
    * Reads a file that contains a description of Circle2
    *
    * @param filename String that contains the name of the file; file is assumed to be
    *           in the same directory as the program which calls this method
    * @return integer array of circle2 coordinates
    * @throws NumberFormatException if circleC1[i] or circleC2[i] is not an actual integer.
    */
    public int[] coordsCircle2( String filename ) throws IOException {

      String [] circleA2 = null;

      // open the file
       File file = new File( filename );
       BufferedReader br = new BufferedReader( new FileReader( file ) );

       String notuse = br.readLine();

       String circle2 = br.readLine();

       if(circle2 != null){
          circleA2 = circle2.split(" ");
          System.out.println("Splitting1...");
       }
       else{
          System.out.println("Second line of file is empty!!");
          System.exit(0);
       }


       try{
         for (int i = 0; i < circleA2.length; i++){
            circleC2[i] = Integer.parseInt(circleA2[i]);
         }
       } catch (NumberFormatException e){
          System.out.println("All values must be numbers!");
       }

       return circleC2;
    }

    /**
     * String representation of the coordinates
     * @param circle integer array that contains the coordinates of the circle
     * @return  String-y version of circle coordinates
     */

     public String toString(int[] circle) {
        String output = "\nX Coordinate: " + circle[0] + " Y Coordinate: " + circle[1] + "\nRadius: " + circle[2];
        return output;
     }



     //double distance = Math.sqrt(Math.pow(locationA[0] - locationB[0], 2) + Math.pow(locationA[1] - locationB[1], 2));



  /**
   * This is the main method of the program.  If opens a file, reads the first line to decide
   *  how big an array should be, then reads in enough lines to fulfill the "Y" dimension
   *  of the array.
   *
   * @param args [not used]
   */
   public static void main( String [] args ) {

      CircleSolver cs = new CircleSolver();

      System.out.println( "\n   Howdy li'l pardner! \n\n" );
      // FileDemo fd = new FileDemo();
      String [] myLineArray1 = null;
      String [] myLineArray2 = null;

      cs.toString(cs.circleC1);
      cs.toString(cs.circleC2);

      /**
      try {
         // myLineArray = fd.getMazeFromFile( "CirclesInside.txt" );
         myLineArray1 = cs.coordsCircle1( "CirclesInside.txt" ).toString();
         myLineArray2 = cs.coordsCircle2( "CirclesInside.txt" ).toString();
      }
      catch( IOException ioe ) {
         System.out.println( "\n   Error on open/read... exiting\n" );
         System.exit( -1 );
      } **/
      try{
        cs.coordsCircle1( "CirclesInside.txt" );
        cs.coordsCircle2( "CirclesInside.txt" );
      }
      catch( IOException ioe ) {
         System.out.println( "\n   Error on open/read... exiting\n" );
         System.exit( -1 );
      }

      //double distance = Math.sqrt(Math.pow(locationA[0] - locationB[0], 2) + Math.pow(locationA[1] - locationB[1], 2));
      float X1_coords = cs.circleC1[0];
      float Y1_coords = cs.circleC1[1];
      float R1_coords = cs.circleC1[2];
      float X2_coords = cs.circleC2[0];
      float Y2_coords = cs.circleC2[1];
      float R2_coords = cs.circleC2[2];



      if((cs.circleC1[2] + cs.circleC2[2]) == (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2)))){
         System.out.println("Your Circles Touch! \n");
      }
      //One circle is inside the other
      if((cs.circleC1[2] + cs.circleC2[2]) >= (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2)))){
         if(cs.circleC1[2] > cs.circleC2[2]){
            //Circle 1 has bigger nadius
            //testing if one circle is inside the other
            if((cs.circleC1[2]) > (cs.circleC2[2] + (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2))))){
               //testing if one circle is touching inside
               if((cs.circleC1[2] - cs.circleC2[2]) < (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2)))){
                  System.out.println("One circle is inside the other and crossing!");
               }
               else if((cs.circleC1[2] - cs.circleC2[2]) == (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2)))){
                  System.out.println("One circle is inside the other and touching!");
               }
            }
            else{
               System.out.println("One circle is inside the other (not touching or crossing)!");
            }
          }
          else if(cs.circleC1[2] < cs.circleC2[2]){
            //Circle 2 has bigger nadius
            //testing if one circle is inside the other
            if((cs.circleC2[2]) > (cs.circleC1[2] + (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2))))){
               //testing if one circle is touching inside
               if ((cs.circleC2[2] - cs.circleC1[2]) <= (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2)))){
                  System.out.println("One circle is inside the other and crossing!");
               }
               else if ((cs.circleC2[2] - cs.circleC1[2]) == (Math.sqrt(Math.pow(X2_coords - X1_coords, 2) + Math.pow(Y2_coords - Y1_coords, 2)))){
                  System.out.println("One circle is inside the other and touching!");
               }
            }
            else{
               System.out.println("One circle is inside the other (not touching or crossing)!");
            }
         }
      }
      if((X1_coords - X2_coords) == 0){
         if((Y1_coords - Y2_coords) == 0){
           if((R1_coords - R2_coords) == 0){
             System.out.println("One circle is on top of the other!!");
           }
         }
       }
       else{
         System.out.println("Circles do not touch each other. \n");
       }

     // output the results to the display then exit
      //for( int index = 0; index < myLineArray.length; index++ ) {
        // System.out.println( myLineArray[index] );
      //}
      System.exit( 0 );

   }
}
