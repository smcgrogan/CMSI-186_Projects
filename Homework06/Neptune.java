/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Neptune.java
 * @author    :  Summer McGrogan
 * Date       :  2020-04-07
 * Description:  Your program will take one command line argument,
                 which is the acceleration factor for the trip. Your
                 program with then use that number to speed the spacecraft
                 up to 1/2 the speed of light from a starting speed of
                 11,186 meters/second [the escape velocity of Earth], and
                 slow it down again in time to reach Neptune at a speed of
                 23,500 meters/second. We then need to reverse the c
                 alculation to get back to Earth.
 * Notes      :
     Can only travel 1/2 speed of light, so .5(299792458) meters/second

 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Neptune{

    public static BrobInt speedL = new BrobInt("149896229");
    public static BrobInt distanceH = new BrobInt("2200000000000");

   public static void main(String[] args){
      BrobInt neptuneEsc = new BrobInt("23500");
      BrobInt speedE = new BrobInt("11186");
      BrobInt accelerat = new BrobInt(args[0]);
      BrobInt tm = new BrobInt("0");
      System.out.println("inputted acceleration: " + accelerat + " meters per second");

      while(accelerat.compareTo(BrobInt.ONE) > 0){
        for (BrobInt i = BrobInt.ZERO; i.compareTo(speedL) < 0; i.add(accelerat)){
           tm = tm.add(BrobInt.ONE);
           speedE = speedE.add(accelerat);
        }
        for (BrobInt j = BrobInt.ZERO; j.compareTo(neptuneEsc) < 0; j.add(accelerat)){
           tm = tm.add(BrobInt.ONE);
           speedE = speedE.subtract(accelerat);
        }
        System.out.println("Reached Neptune at speed of: " + speedE + " in " + " seconds ");
      }




   }
















 }
