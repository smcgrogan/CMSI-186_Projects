/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Uses Ball.java to move soccer balls according to input
 *  @author       :  Summer McGrogan
 *  Date written  :  02-21-2020
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.util.Random;
import java.lang.Math;

public class SoccerSim{
     private static int numballs;
     private static double timeSlice = 1.00;
     private static Ball[] ball;

     private static double time = 0.0;
     private static double seconds = 0.0;
     private static double minutes = 0.0;
     private static double hours = 0.0;
     private static double[] poleLocation = {-234.50, 456.7};
     public static int OOBcount = 0;

     private static int countballs(String[] args) { //counts num of balls
        if((args.length % 4) - 1 == 0) {
           numballs = ((args.length - 1)/4);
        }
        if (args.length % 4 == 0){
           numballs = (args.length / 4);
        }
        if (args.length < 4){
           throw new IllegalArgumentException(" Must enter at least 4 numbers!!!");
        }
        System.out.println("There are " + numballs + " balls in your simulation.");
        return numballs;
     }

     private static void checkslice(String[] args){ //checks that time slice is valid
        if(args.length % 4 == 0){
           timeSlice = 1.00;
        }
        if ((Double.parseDouble(args[args.length-1]) > 1800.00) || ((Double.parseDouble(args[args.length-1])) <= 0)){
           throw new IllegalArgumentException(" TimsSlice must be between 0 and 1800 seconds!!!");
        }
        else{
           timeSlice = Double.parseDouble(args[args.length-1]);
        }
     }

     private static void makeBalls(String[] args){ //constructs balls
       int j = 0;
       int limit = args.length;
       if(args.length % 4 == 1){
          limit--;
       }
       ball = new Ball[numballs];
       for(int i = 0; i < limit; i += 4){
          ball[j] = new Ball(Double.parseDouble(args[i]),
                            Double.parseDouble(args[i+1]),
                            Double.parseDouble(args[i+2]),
                            Double.parseDouble(args[i+3]));
          j++;
       }
     }

     private static boolean polehit(){
        for (int i = 0; i < numballs; i++){
           System.out.println("Ball " + i + " is " + ball[i].toString());
           double [] location = ball[i].getCurrentPosition();
           double distance = Math.sqrt(Math.pow(poleLocation[0] - location[0], 2)+(Math.pow(poleLocation[1] - location[1], 2)));
           if (distance <= 4.45){
              System.out.println("Ball " + i + " collided with the pole at ball location " + location[0] + "," + location[1] + " pole location " + poleLocation[0] + "," + poleLocation[1]);
              return true;
           }
        }
        return false;
     }

     private static boolean ballhit(){ //checks if ball was hit
        for (int i = 0; i < (numballs - 1); i++){
           for (int j = (i + 1); j < numballs; j++){
              double[] locationA = ball[i].getCurrentPosition();
              double[] locationB = ball[j].getCurrentPosition();
              double distance = Math.sqrt(Math.pow(locationA[0] - locationB[0], 2) + Math.pow(locationA[1] - locationB[1], 2));
              if (distance <= 8.90){
                 System.out.println("Ball " + i + " collided with ball " + j + " at position " + ball[i].toString());
                 return true;
              }
           }
        }
        return false;
     }


     public static void main (String[] args){
        countballs(args);
        checkslice(args);
        makeBalls(args);
        while(true){
           polehit();
           ballhit();
           time += timeSlice;
           for (var b : ball){
             b.move(timeSlice);
             b.updateSpeedsForOneTick(timeSlice);
           }
           if (time < 60){
              seconds = time;
              System.out.println("TIME <" + hours + ":" + minutes + ":" + seconds + ">");
           }
           if ((time > 60) & (time < 3600)){
              minutes = time/60;
              seconds = time%60;
              System.out.println("TIME: <" + hours + ":" + minutes + ":" + seconds + ">");
           }
           if (time > 3600){
              hours = time/3600;
              minutes = time%3600/60;
              seconds = minutes%60;
              System.out.println("TIME: <" + hours + ":" + minutes + ":" + seconds + ">");
           }
           if (polehit()){
              System.out.println("TIME: <" + hours + ":" + minutes + ":" + seconds + ">");
              System.exit(0);
           }
           if (ballhit()){
              System.out.println("TIME: <" + hours + ":" + minutes + ":" + seconds + ">");
              System.exit(0);
           }
           for (var b: ball){
              if (!b.isStillMoving()){
                 b.setBallOutOfBounds(1000,1000);
              }
           }
           for ( var b: ball){
              double[] location = b.getCurrentPosition();
              double[] velocity = b.getCurrentSpeed();
              if ((Math.abs(location[0]) > 500) || (Math.abs(location[1]) > 500)){
                OOBcount++;
              }
              if ((velocity[0] <= 0.05) || (velocity[1] <= 0.05)){
                OOBcount++;
              }
           }
           if (OOBcount == numballs){
              System.out.println("All balls have stopped moving. Sim has ended.");
              System.exit(0);
           }
        }
     }
}
