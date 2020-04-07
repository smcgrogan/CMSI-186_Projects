/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  Summer McGrogan
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;
import java.io.BufferedReader;
import java.lang.StringBuffer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class BrobInt {

    public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
    public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
    public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
    public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
    public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
    public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
    public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
    public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
    public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
    public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
    public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"
    public static final BrobInt NEGO     = new BrobInt( "-1" );

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   // public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
   // public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
   // public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
   // public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public  String internalValue = "";        // internal String representation of this BrobInt
   public  byte   sign          = 0;         // "0" is positive, "1" is negative
  /// You can use this or not, as you see fit.  The explanation was provided in class
   private String reversed      = "";        // the backwards version of the internal String representation
   private int[] intArray = null;
   private int[] totalF = null;

   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
   private static final boolean DEBUG_ON = false;
   private static final boolean INFO_ON  = false;
   public boolean willbeneg = false;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
      if (value.charAt(0) == '+'){
         sign = 0;
         this.internalValue = value.substring(1);
      }
      else if (value.charAt(0) == '-'){
         sign = 1;
         this.internalValue = value.substring(1);
      }
      else{
         this.internalValue = value;
      }
      reversed = new String(new StringBuffer(internalValue).reverse());
      this.intArray = new int[reversed.length()];
      for (int i = 0; i < this.intArray.length; i++){
         this.intArray[i] = Character.digit(reversed.charAt(i), 10);
      }
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() throws IllegalArgumentException {
     for (int i = 0; i < internalValue.length(); i++){
        if (Character.isDigit(internalValue.charAt(i)) == false){
           throw new IllegalArgumentException("I only accept numbers. Invalid input at position " + i);
        }
        else{
           System.out.println("Character at position " + i + " is " + internalValue.charAt(i));
        }
     }
     return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  NOTE: you can use this or not, as you see fit; explanation was given in class
   *  @see StringBuffer API page for an easy way to do this
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser(BrobInt bint) {
      return new BrobInt(new String(new StringBuffer(bint.internalValue).reverse()));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobInt passed as argument
   *  Note: static method
   *  @param  bint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  NOTE: you can use this or not, as you see fit; explanation was given in class
   *  @see StringBuffer API page for an easy way to do this
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   //public static BrobInt reverser( BrobInt bint ) {
      //return
   //}
   //this creates an integer array of the reversed BrobInt string

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt add( BrobInt bint ) {
     int carry = 0;
     int[] totalA = null;
     int[] a = null;
     int[] b = null;
     //bint.intArray = new int[bint.internalValue.length()];
     //System.out.println("This array: " + Arrays.toString(this.intArray));
    // for (int i = 0; i < bint.intArray.length; i++){
      //  bint.intArray[i] = Integer.parseInt(removeLeadingZeros(reverser(bint)).charAt(i)));
     //}
    // System.out.println("Bint array: " + Arrays.toString(bint.intArray));
     if (this.intArray.length >= bint.intArray.length){
       a = this.intArray;
       b = bint.intArray;
       totalA = new int[this.intArray.length + 1];
       for (int i = 0; i < bint.intArray.length; i++){
          if (this.intArray[i] + bint.intArray[i] + carry >= 10){
             totalA[i] = this.intArray[i] + bint.intArray[i] + carry - 10;
             //System.out.println(" IF total: " + Arrays.toString(totalA) + " carry is: " + carry);
             carry = 1;
          }
          else{
             totalA[i] = this.intArray[i] + bint.intArray[i] + carry;
             //System.out.println(" ELSE total: " + Arrays.toString(totalA) + " carry is: " + carry);
             carry = 0;
          }
        }
        for (int i = bint.intArray.length; i < totalA.length; i++){
           if (i >= this.intArray.length){
              totalA[i] = carry;
           }
           else{
              totalA[i] = this.intArray[i] + carry;
              if (this.intArray[i] + carry >= 10){
                 totalA[i] = this.intArray[i] + carry - 10;
                 carry = 1;
              }
              else{
                 carry = 0;
              }
           }
        }
     }
     else if (this.intArray.length < bint.intArray.length){
         a = bint.intArray;
         b = this.intArray;
         totalA = new int[bint.intArray.length + 1];
         for (int i = 0; i < this.intArray.length; i++){
           if (bint.intArray[i] + this.intArray[i] + carry >= 10){
              totalA[i] = bint.intArray[i] + this.intArray[i] + carry - 10;
              //System.out.println("total: " + totalA + " carry is: " + carry);
              carry = 1;
           }
           else{
              totalA[i] = bint.intArray[i] + this.intArray[i] + carry;
              //System.out.println("total: " + totalA + " carry is: " + carry);
              carry = 0;
           }
         }
         for (int i = this.intArray.length; i <= bint.intArray.length; i++){
           totalA[i] = this.intArray[i] + carry;
           if (this.intArray[i] + carry >= 10){
              totalA[i] = this.intArray[i] + carry - 10;
              carry = 1;
           }
           else{
              carry = 0;
           }
         }
       }
       BrobInt sum = new BrobInt(Arrays.toString(totalA).substring(1, Arrays.toString(totalA).length()-1).replace(",","").replace(" ",""));
       return reverser(removeLeadingZeros(sum));
   }

////DID NOT UPDATE OTHER METHODS ON NEW ARRAYS!!!
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobInt passed as argument to this BrobInt
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtract( BrobInt bint ) {
     int[] a = null;
     int[] b = null;
     int[] totalA = null;
     if (this.intArray.length >= bint.intArray.length){
          a = this.intArray;
          b = bint.intArray;
          totalA = new int[this.intArray.length];
          for (int i = 0; i < b.length; i++){
             if (a[i]-b[i] <= 0){
                if((i+1 == a.length)&&((a[i]-b[i]) < 0)){
                   totalA[i] = (b[i] - a[i]);
                   willbeneg = true;
                }
                else if (a[i+1] == 0){
                   a[2+i] = a[2+i] - 1;
                   a[i+1] = a[i+1] + 9;
                   totalA[i] = a[i] + 10 - b[i];
                }
                else{
                   a[i+1] = a[i+1] - 1;
                   totalA[i] = a[i] + 10 - b[i];
                }
                //totalA[i] = a[i] - b[i];
             }
             else{
                totalA[i] = a[i] - b[i];
             }
          }
          for (int i = b.length; i < a.length; i++){
             totalA[i] = a[i];
          }
     }
     else if (this.intArray.length < bint.intArray.length){
         a = bint.intArray;
         b = this.intArray;
         totalA = new int[bint.intArray.length];
         for (int i = 0; i < b.length; i++){
            if (a[i]-b[i] <= 0){
              if((i+1 == a.length)&&((a[i]-b[i])<0)){
                 totalA[i] = (b[i] - a[i]);
                 willbeneg = true;
                 System.out.println("Total is: " + Arrays.toString(totalA));
              }
              else if (a[i+1] == 0){
                 a[2+i] = a[2+i] - 1;
                 a[i+1] = a[i+1] + 9;
                 a[i] = a[i] + 10;
              }
              else{
                 a[i+1] = a[i+1] - 1;
                 a[i] = a[i] + 10;
              }
              totalA[i] = a[i] - b[i];
            }
            else{
               totalA[i] = a[i] - b[i];
            }
         }
         for (int i = b.length; i < a.length; i++){
            totalA[i] = a[i];
         }
       }
       BrobInt diff = null;
       if (willbeneg){
          String minus = "-";
          diff = new BrobInt((Arrays.toString(totalA).substring(1, Arrays.toString(totalA).length()-1).replace(",","").replace(" ","") + minus).toString());
          System.out.println("you have a negative");
       }
       else{
          diff = new BrobInt(Arrays.toString(totalA).substring(1, Arrays.toString(totalA).length()-1).replace(",","").replace(" ",""));
       }
       return reverser(removeLeadingZeros(diff));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   //public BrobInt multiply( BrobInt bint ) {
    //  BrobInt total = new BrobInt("0");
    //  for (BrobInt i = BrobInt.ZERO; i.compareTo(bint) < 0; i = i.add(BrobInt.ONE)){
    //     total = total.add(new BrobInt(this.toString()));
    //  }
    //  return total;
   //}
   public BrobInt multiply( BrobInt bint ) {
      int m = Integer.valueOf(0); //check if this array is the correct way to add these
      for (int i = 0; i < Integer.parseInt(removeLeadingZeros(this).toString()); i++){
         m += Integer.parseInt(bint.add(BrobInt.ZERO).toString());
      }
      BrobInt multiple = new BrobInt(Integer.toString(m));
      return multiple;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt bint ) {
      //make an if that find bigger number
      //create a loop that divides bigger by smaller (count the number of loops) until total is less than the smaller #
      //stop the loop at this point and return the counter with the remainder total
      /**
      int i = 0;
      starter = this.subtract(bint);
      MIDD_LOOP:
      for (i = 1; i < Integer.parseInt(this.toString()); i++){
         container = starter.subtract(bint);
         System.out.println("container is: " + container);
         if(Integer.parseInt(container.toString()) < Integer.parseInt(bint.toString())){
            break MIDD_LOOP;
         }
      }
      total = i + ((Integer.parseInt(container.toString()))/Integer.parseInt(bint.toString()));
      System.out.println("total is: " + i);
      **/
      int c = 0;
      int total = 0;
      for (int i = 0; i < Integer.parseInt(this.toString()); i++){
          c = Integer.parseInt(this.subtract(bint).toString());
          System.out.println(c);
          if (c < Integer.parseInt(bint.toString())){
              total = i + (c/Integer.parseInt(bint.toString()));
              System.out.println("total is: " + total);
              break;
          }
       }
       BrobInt div = new BrobInt(Integer.toString(total));
       return div;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt bint ) {
     int r = 0;
     int c = 0;
     for (int i = 1; i < Integer.parseInt(this.toString()); i++){
         c = Integer.parseInt(this.subtract(bint).toString());
         if (c <= Integer.parseInt(bint.toString())){
             r = i;
             break;
         }
      }
      BrobInt rem = new BrobInt(Integer.toString(r));
      return rem;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to compare to this
   *  @return int   one of neg/0/pos if "this" BrobInt is less/equal/more than the "bint" BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt bint ) {

     // remove any leading zeros because we will compare lengths
      String me  = removeLeadingZeros( this ).toString();
      String arg = removeLeadingZeros( bint ).toString();

     // check if they are equal first, and return a zero if so
      if( this.equals( bint ) ) {
        return 0;
      }

     // handle the signs here
     //  if "this" is neg and "bint" is pos, "this" is smaller so return -1
      if( 1 == sign && 0 == bint.sign ) {
         return -1;

     // if "this" is pos and "bint" is neg, "this" is larger so return +1
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      }

     // otherwise, signs are the same, so we must check the lengths
     //  the longer one is going to be the MORE OF THAT SIGN
     //  e.g., "-1111" for "this" is more neg than "-222" for "arg" so return -1
      if( (1 == sign) && (1 == bint.sign) ) {
         if( me.length() < arg.length() ) {
            return 1;
         } else if( me.length() > arg.length() ) {
            return -1;
         }
      } else if( (0 == sign) && (0 == bint.sign) ) {
         if( me.length() < arg.length() ) {
            return -1;
         } else if( me.length() > arg.length() ) {
            return 1;
         }
      }

     // compare digit-by-digit
     // can only go to the length of the shortest if they are different lengths
      // int end = (me.length() < arg.length()) ? me.length() : arg.length();
      for( int i = 0; i < me.length(); i++ ) {
         if( me.charAt(i) < arg.charAt(i) ) {
            return -1;
         } else if( me.charAt(i) > arg.charAt(i) ) {
            return 1;
         }
      }
      return 0;      // if it gets here, just assume equality to fool the compiler
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt bint ) {
      return ( (sign == bint.sign) && (this.toString().equals( bint.toString() )) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  bint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt removeLeadingZeros( BrobInt bint ) {
      Character sign = null;
      String returnString = bint.toString();
      int index = 0;

      if( allZeroDetect( bint ) ) {
         return bint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return bint;
      }

      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = bint.toString().substring( index, bint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean allZeroDetect( BrobInt bint ) {
      for( int i = 0; i < bint.toString().length(); i++ ) {
         if( bint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( int[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display a prompt for the user to press 'ENTER' and wait for her to do so
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void pressEnter() {
      String inputLine = null;
      try {
         System.out.print( "      [Press 'ENTER' to continue]: >> " );
         inputLine = input.readLine();
      }
      catch( IOException ioe ) {
         System.out.println( "Caught IOException" );
      }

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      BrobInt test1 = new BrobInt("100");
      BrobInt test2 = new BrobInt ("2");
      System.out.println("100 + 2: " + test1.add(test2));
      System.out.println("100 - 2: " + test1.subtract(test2));
      System.out.println("100 * 2: " + test1.multiply(test2));
      //System.out.println("100 / 2: " + test1.divide(test2));
      BrobInt test3 = new BrobInt("456");
      BrobInt test4 = new BrobInt("789");
      System.out.println("456 + 789: " + test3.add(test4));
      System.out.println("456 - 789: " + test3.subtract(test4));
      System.out.println("456 * 789: " + test3.multiply(test4));

      /**

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester, but here are a few...\n" );

      BrobInt b1 = null;;
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "147258369789456123" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 147258369789456123\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Multiplying 82832833 by 3: " );
      try { System.out.println( "      expecting: 248498499\n        and got: " + new BrobInt("82832833").add( BrobInt.THREE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Adding 3 to 82832833: " );
      try { System.out.println( "      expecting: 82832836\n        and got: " + reverser(BrobInt.THREE).add(reverser(( new BrobInt( "82832833" ) )))); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "\n\n   Making a new BrobInt: " ); b1 = new BrobInt( "-99999" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      System.out.println( "\n   Testing equals() method on b1 of -99999 and b2 of 99999: " );
      try { System.out.println( "      expecting: false\n        and got: " + b1.equals( new BrobInt( "99999" ) ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.out.println( "\n   Testing equals() method on b1 of -99999 and b2 of -99999: " );
      try { System.out.println( "      expecting: true\n        and got: " + b1.equals( new BrobInt( "-99999" ) ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.exit( 0 ); **/

   }
}
