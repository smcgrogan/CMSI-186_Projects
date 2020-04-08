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

    public static BrobInt speedL = new BrobInt("149896229"); //149896229
    public static BrobInt distanceH = new BrobInt("2200000000000"); //2200000000000

   public static void main(String[] args){
      BrobInt neptuneEsc = new BrobInt("23500");
      BrobInt earthEsc = new BrobInt("11186");
      BrobInt speedE = new BrobInt("11186");
      BrobInt accelerat = new BrobInt(args[0]);
      int tm = 0;
      int seconds = 0;
      int minutes = 0;
      int hours = 0;
      System.out.println("inputted acceleration: " + accelerat + " meters per second");
        if (accelerat.compareTo(BrobInt.TWO) < 0) {
           System.out.println("NUMBER IS TOO SMALL. Enter a bigger number.");
           System.exit(0);
        }
        for (BrobInt i = BrobInt.ZERO; i.compareTo(speedL) < 0; i = i.add(accelerat)){
           tm += 1;
           speedE = speedE.add(accelerat);
           System.out.println("Leaving for Neptune now...\nSpeed is: " + speedE);
        }
        for (BrobInt j = BrobInt.ZERO; j.compareTo(neptuneEsc) <= 0; j = j.add(accelerat)){
           tm += 1;
           speedE = speedE.subtract(accelerat);
           System.out.println("Approaching Neptune now...\nSpeed is: " + speedE);
        }
        System.out.println("Reached Neptune at speed of: " + speedE + " in " + tm + " seconds ");
        for (BrobInt k = BrobInt.ZERO; k.compareTo(speedL) < 0; k = k.add(accelerat)){
           tm += 1;
           neptuneEsc = neptuneEsc.add(accelerat);
           System.out.println("Returning from Neptune now.... \n Speed is " + neptuneEsc + " Approaching light speed! ");
        }
        for (BrobInt x = BrobInt.ZERO; x.compareTo(earthEsc) <= 0; x = x.add(accelerat)){
           tm += 1;
           neptuneEsc = neptuneEsc.subtract(accelerat);
           System.out.println(" Slowing down to retun to earth at a speed of: " + neptuneEsc);
        }
        System.out.println("\n\nSafely returned to earth!\nAcceleration you choose: " + accelerat);

        if (tm < 60){
           seconds = tm;
           System.out.println("TIME TAKEN: <" + hours + ":" + minutes + ":" + seconds + ">");
        }
        if ((tm > 60) & (tm < 3600)){
           minutes = tm/60;
           seconds = tm%60;
           System.out.println("TIME TAKEN: <" + hours + ":" + minutes + ":" + seconds + ">");
        }
        if (tm > 3600){
           hours = tm/3600;
           minutes = tm%3600/60;
           seconds = minutes%60;
           System.out.println("TIME TAKEN: <" + hours + ":" + minutes + ":" + seconds + ">");
        }
      //}




   }
















 }
