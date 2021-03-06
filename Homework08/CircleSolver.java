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

//STILL NEED TO SAY IF THEY MEET AT ONE POINT OR MORE THAN ONE PT

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

      if(circle1.length() == 0){
        System.out.println("First line of file is empty!! Enter Numbers...");
        System.exit(0);
      }


      if(circle1 != null){
         circleA1 = circle1.split(" ");
         //System.out.println("Splitting Circle 1...");
      }


      try{
        for (int i = 0; i < circleA1.length; i++){
           //System.out.println("Circle 1 length of: " + circleA1.length);
           circleC1[i] = Integer.parseInt(circleA1[i]);
        }
      } catch (NumberFormatException e){
          System.out.println("All values must be numbers! Enter Numbers!");
          System.exit(0);
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

       if(circle2.length() == 0){
         System.out.println("Second line of file is empty!! Enter Numbers...");
         System.exit(0);
       }

       if(circle2 != null){
          circleA2 = circle2.split(" ");
          //System.out.println("Splitting Circle 2...");
       }


       try{
         for (int i = 0; i < circleA2.length; i++){
            circleC2[i] = Integer.parseInt(circleA2[i]);
         }
       } catch (NumberFormatException e){
          System.out.println("All values must be numbers! Enter Numbers!!!!");
          System.exit(0);
       }

       return circleC2;
    }




  /**
   * This is the main method of the program.  If opens a file, reads the first line to decide
   *  how big an array should be, then reads in enough lines to fulfill the "Y" dimension
   *  of the array.
   *
   * @param args [not used]
   */
   public static void main( String [] args ) {


      CircleSolver cs = new CircleSolver();
      String fileEntered = args[0];

      System.out.println( "\n   Lets do this! \n\n" );

      try{
        cs.coordsCircle1( fileEntered );
        cs.coordsCircle2( fileEntered );
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

      System.out.println("For Circle 1: \nX Coordinate: " + X1_coords + "\n Y Coordinate: " + Y1_coords + "\nRadius: " + R1_coords + "\n");
      System.out.println("For Circle 2: \nX Coordinate: " + X2_coords + "\n Y Coordinate: " + Y2_coords + "\nRadius: " + R2_coords + "\n");


      //if one is completely covering the other
      if((cs.circleC1[0] - cs.circleC2[0]) == 0){
         if((cs.circleC1[1] - cs.circleC2[1]) == 0){
           if((cs.circleC1[2] - cs.circleC2[2]) == 0){
             System.out.println("One circle is on top of the other!! (touch at all points)");
             System.exit(0);
           }
         }
       }

      //Circle inside and touching
      if((cs.circleC1[2] - cs.circleC2[2]) >= 0){
         //Circle 1 has bigger radius
         //testing if one circle is inside the other
         //int insidetest1 = Integer.parseInt((cs.circleC1[2]) - (cs.circleC2[2] + (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))));
         if((cs.circleC1[2] - cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) >= 0){
            //testing if one circle is touching inside
            //int insidetouch1 = Integer.parseInt((cs.circleC1[2] - cs.circleC2[2]) - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2))));
            if((cs.circleC1[2] - cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) < 0){
               System.out.println("One circle is inside the other and meet at more than 1 point (crossing)!");
            }
            else if((cs.circleC1[2] - cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) == 0){
               System.out.println("One circle is inside the other and touch at 1 point!");
            }
            else if((cs.circleC1[2] - cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) >= 0){
               System.out.println("One circle is inside the other (not touching or crossing)!");
            }
         }
       }
       else if((cs.circleC1[2] - cs.circleC2[2]) < 0){
         //Circle 2 has bigger radius
         //testing if one circle is inside the other
         if((cs.circleC2[2] + cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) >= 0){
            //testing if one circle is touching inside
            if ((cs.circleC2[2] - cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) < 0){
               System.out.println("One circle is inside the other and touch at 2 points (crossing)!");
            }
            else if((cs.circleC2[2] - cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) == 0){
               System.out.println("One circle is inside the other and touch at 1 point!");
            }
            else if((cs.circleC2[2] - cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) >= 0){
               System.out.println("One circle is inside the other (not touching or crossing)!");
            }
          }
        }

        //Circles Touching
        if((cs.circleC1[2] - cs.circleC2[2]) >= 0){
          if((cs.circleC1[2] + cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) > 0){
             System.out.println("The circles touch at 2 points (crossing)!!");
          }
          else if((cs.circleC1[2] + cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) == 0){
             System.out.println("The circles touch at 1 point!");
          }
          else if((cs.circleC1[2] + cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) < 0){
             System.out.println("Your circles do not touch");
          }
        }
        else if((cs.circleC2[2] - cs.circleC1[2]) > 0){
          System.out.println("GOT HERE");
          if ((cs.circleC2[2] + cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) > 0){
             System.out.println("The circles touch at 2 points!");
          }
          else if((cs.circleC2[2] + cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) == 0){
             System.out.println("The circles touch at 1 point!");
          }
          else if((cs.circleC2[2] + cs.circleC1[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) < 0){
             System.out.println("Your circles do not touch");
          }
        }



       if((cs.circleC1[2] + cs.circleC2[2] - (Math.sqrt(Math.pow(cs.circleC2[0] - cs.circleC1[0], 2) + Math.pow(cs.circleC2[1] - cs.circleC1[1], 2)))) < 0){
          System.out.println("Your circles do not touch");
       }

      System.exit( 0 );

   }
}
