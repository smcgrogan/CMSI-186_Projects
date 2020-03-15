/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SkateRamp.java
 *  Purpose       :  Finds area under curve of skate ramp given functions
 *  @author       :  Summer McGrogan
 *  Date written  :  03-02-2020
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.lang.Math;
import java.lang.IllegalArgumentException;

public class SkateRamp{
   public static double percent;
   private double lower;
   private double upper;
   //NEED TO ADD TESTS

   public static boolean checkpercent(String[] args){
      if (args[args.length-1].contains("%")){
         percent = Double.parseDouble(args[args.length-1].substring(0, args[args.length-1].length()-1));
         System.out.print("Contains percent");
         return true;
      }
      else{
         percent = .01;
         return false;
      }
   }

   public static void useMethod(){
      System.out.println("This is how you use SkateRamp: \n" +
                         "  java SkateRamp <function> <coef1> <coef2>...<lower bound> <upper bound> [percent]% \n" +
                          "  where: \n" +
                          "   <function> = poly, sin, log, exp, or sqrt\n" +
                          "   <coef> = coefficient of the x-value(s) \n" +
                          "   <lower bound> = lower bound of skate ramp, must be less than upper bound \n" +
                          "   <upper bound> = upper bound of skate ramp, must be greater than lower bound \n" +
                          "   <percent> = optional percent of accuracy for area estimation, \n" +
                          "   assumed percent if none inputted = 1.00%");
   }

   public static boolean checkinput(String[] args){
      if (checkpercent(args)){
        if ((args.length-1) < 5) {
           // throw new IllegalArgumentException("You did not include enough arguments!");
           useMethod();
           System.exit(0);
           // return false;
        }
   // commented these out because if there is an error condition you'll output the message and
   //    quit the program, so the logical condition checks are superfluous.  I moved the return
   //    statement to the end which returns true
        // else if ((args.length-1) >= 5){
        //    return true;
        // }
      }
      else{
         if ((args.length) < 5){
            // throw new IllegalArgumentException("You did not include enough arguments!");
            useMethod();
            System.exit(0);
            return true;
         }
         // else if ((args.length) >= 5){
         //   return true;
         // }
      }
      return true;
   }

   public static boolean checkfunc(String[] args){
      if( (args[0].equals("poly")) || (args[0].equals("sin")) || (args[0].equals("cos")) ||
          (args[0].equals("tan"))  || (args[0].equals("log")) || (args[0].equals("exp")) ||
          (args[0].equals("sqrt")) || (args[0].equals("runmytests")) ) {
         return true;
      }
      else{
//         throw new IllegalArgumentException("First input must be: poly or sin or log or exp or sqrt");
         System.exit(0);
         return false;
      }
   }

   public double poly(int n, String[] args){
      double chunkWidth = (upper - lower)/n;
      double midVal = ( upper + (((lower - upper) / n) / 2) );
      double height = 0.0;
      double areaTotal = 0.0;
      double lastArea = 0.0;
      double currentArea = 0.0;
      if (checkpercent(args)){
         for (int i = 0; i < n; i++){
            for (int j = 1; j < (args.length - 3); j++){
               height = Double.parseDouble(args[args.length - j]) * Math.pow(midVal, j);
            }
            areaTotal += height*chunkWidth;
            midVal += chunkWidth;
            currentArea += areaTotal;
   // this section of code belongs in your main() method, not in the calculation methods.
   //    you should SET the values here and RETURN them to the main(), the check in main()
   //    to see if you are finished.
            // if ((((currentArea - lastArea) <= percent)/lastArea)*100){
            //    return currentArea;
            //    System.exit(0);
            // }
         }
      }
      else{
        for (int i = 0; i < n; i++){
           for (int j = 1; j < (args.length - 2); j++){
              height = Double.parseDouble(args[args.length - j]) * Math.pow(midVal, j);
           }
           areaTotal += height*chunkWidth;
           midVal += chunkWidth;
           currentArea += areaTotal;
   // same thing here
           // if( (((currentArea - lastArea) <= percent) / lastArea) * 100 ) {
           //    return currentArea;
           //    System.exit(0);
           // }
        }
      }
      return areaTotal;
   }

   // public double sin(int n){
   //   double chunkWidth = (upper-lower)/n;
   //   double midVal = (upper +(((lower - upper)/n)/2));
   //   double height = 0.0;
   //   double areaTotal = 0.0;
   //   if (checkpercent(args)){ //DOES THIS ACTUALLY MAKE A DIFFERENCE (CHECK FOR SIN COS AND TAN)
   //      for (int i = 0; i < n; i++){
   //         height = Math.sin(midVal);
   //         areaTotal = chunkWidth * height;
   //         midVal += chunkWidth;
   //         currentArea += areaTotal;
   //         if ((((currentArea - lastArea) <= percent)/lastArea)*100){
   //            return currentArea;
   //            System.exit(0);
   //         }
   //      }
   //   }
   //   else{
   //     for (int i = 0; i < n; i++){
   //        height = Math.sin(midVal);
   //        areaTotal = chunkWidth * height;
   //        midVal += chunkWidth;
   //        currentArea += areaTotal;
   //        if ((((currentArea - lastArea) <= percent)/lastArea)*100){
   //           return currentArea;
   //           System.exit(0);
   //        }
   //      }
   //   }
   //   return areaTotal;
   // }

   // public double cos(int n){
   //   SkateRamp SR = new SkateRamp();
   //   double chunkWidth = (upper-lower)/n;
   //   double midVal = (upper +(((lower - upper)/n)/2));
   //   double height = 0.0;
   //   double areaTotal = 0.0;
   //   if (checkpercent(args)){
   //      for (int i = 0; i < n; i++){
   //         height = Math.cos(midVal);
   //         areaTotal = chunkWidth * height;
   //         midVal += chunkWidth;
   //         currentArea += areaTotal;
   //         if ((((currentArea - lastArea) <= percent)/lastArea)*100){
   //            return currentArea;
   //            System.exit(0);
   //         }
   //      }
   //   }
   //   else{
   //     for (int i = 0; i < n; i++){
   //        height = Math.cos(midVal);
   //        areaTotal = chunkWidth * height;
   //        midVal += chunkWidth;
   //        currentArea += areaTotal;
   //        if ((((currentArea - lastArea) <= percent)/lastArea)*100){
   //           return currentArea;
   //           System.exit(0);
   //        }
   //      }
   //   }
   //   return areaTotal;
   // }

   // public double tan(int n){
   //   double chunkWidth = (upper-lower)/n;
   //   double midVal = (upper +(((lower - upper)/n)/2));
   //   double height = 0.0;
   //   double areaTotal = 0.0;
   //   if (checkpercent(args)){
   //      for (int i = 0; i < n; i++){
   //         height = Math.tan(midVal);
   //         areaTotal = chunkWidth * height;
   //         midVal += chunkWidth;
   //         currentArea += areaTotal;
   //         if ((((currentArea - lastArea) <= percent)/lastArea)*100){
   //            return currentArea;
   //            System.exit(0);
   //         }
   //      }
   //   }
   //   else{
   //     for (int i = 0; i < n; i++){
   //        height = Math.tan(midVal);
   //        areaTotal = chunkWidth * height;
   //        midVal += chunkWidth;
   //        currentArea += areaTotal;
   //        if ((((currentArea - lastArea) <= percent)/lastArea)*100){
   //           return currentArea;
   //           System.exit(0);
   //        }
   //      }
   //   }
   //   return areaTotal;
   // }

   public static void main (String[] args) {
      SkateRamp sr = new SkateRamp();
      sr.checkfunc(args);
      sr.checkinput(args);
      // checkpercent(args);  // you're calling this in the "if()" you don't need two of 'em'
      if (sr.checkpercent(args)){
         sr.lower = Double.parseDouble(args[args.length-3]);
         sr.upper = Double.parseDouble(args[args.length-2]);
      }
      else {
         sr.lower = Double.parseDouble(args[args.length-2]);
         sr.upper = Double.parseDouble(args[args.length-3]);
      }
      if (sr.upper < sr.lower){
         sr.useMethod();
         System.exit(0);
      }

   }



}
