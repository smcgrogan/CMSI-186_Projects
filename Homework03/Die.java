/* Author: Summer McGrogan
*  Class: CMSI 186
*  Homework: HW #3 part 1 of 3
*  Date: 02.05.2020
*Information: Die class
*/
import java.util.Random;
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int min_sides = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
     if (nSides < min_sides) {
       throw new IllegalArgumentException(" Not enough sides!");
     } else {
       sides = nSides;
     }
   }
  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
     Random r = new Random();
     pips = r.nextInt(sides) + 1;
     return pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
     return pips;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
     return "[" + pips + "]";
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d) { //is this what this is supposed to do?
      return d.toString();
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      Die d = new Die(17);
      d.roll();
      System.out.println("You rolled a " + d.pips + " there were " + d.sides + " sides on your die.");
   };
}
