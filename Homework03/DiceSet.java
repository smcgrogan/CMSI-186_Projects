/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Summer McGrogan
 *  Date          :  02.02.2020
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] theSet = null;
   private int totalDots = 0;
   private String sConcat = "";

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      theSet = new Die[count];
      this.count = count;
      this.sides = sides;
      for (int i = 0; i < count; i++){
        theSet[i] = new Die(sides);
      }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     for (int i = 0; i < count; i++){
       totalDots = totalDots + theSet[i].getValue();
     }
     return totalDots;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for (int i = 0; i < count; i++){
       theSet[i].roll();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     theSet[dieIndex].roll();
     return theSet[dieIndex].getValue();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return theSet[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() { //loop through everything and concatinate, create a new string stringResult = ""; inside for loop result += theSet.toString();
      for (int i = 0; i < theSet.length; i++){
        return sConcat += theSet[i].toString();
      }
      return sConcat;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet theSet ) {
      return theSet.toString(); //is this correct?
    }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet theSet ) {
      if (this.theSet.toString().equals(theSet.toString())){
        return true;
      }
      else{
        return false;
      }
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      DiceSet dies = new DiceSet(6, 5);
      dies.roll();
      System.out.println( dies.sum());
      System.out.println( dies.getIndividual(3));
   }
}
