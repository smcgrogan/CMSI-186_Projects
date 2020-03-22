/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SkateRamp.java
 *  Purpose       :  Finds area under curve of skate ramp given functions
 *  @author       :  Summer McGrogan
 *  Date written  :  03-20-2020
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.lang.Math;
import java.lang.IllegalArgumentException;

public class SkateRamp{
   public static double percent;
   private double lower;
   private double upper;
   private double lastArea = 0.0;
   private double currentArea = 0.0;
   private static double[] coefficients;

   public static boolean checkpercent(String[] args){
      if (args[args.length-1].contains("%")){
         percent = Double.parseDouble(args[args.length-1].substring(0, args[args.length-1].length()-1));
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
           useMethod();
           System.out.println("You did not include enough arguments!");
           System.exit(0);
        }
      }
      else{
         if ((args.length) < 5){
            System.out.println("You did not include enough arguments!");
            useMethod();
            System.exit(0);
            return true;
         }
      }
      return true;
   }

   public static boolean checkfunc(String[] args){
      if( (args[0].equals("poly")) || (args[0].equals("sin")) || (args[0].equals("cos")) ||
          (args[0].equals("tan"))  || (args[0].equals("runMyTests")) ) {
         return true;
      }
      else{
         System.out.println("First input must be: poly or sin or cos or tan or runMyTests");
         System.exit(0);
         return false;
      }
   }

   public static void createCoef(String[] args){
      if (checkpercent(args)){
         for (int i = 1; i < args.length-3; i++){
            coefficients = new double[args.length-4];
            coefficients[i-1] += Double.parseDouble(args[i]);
            System.out.println("Coef at position: " + (i-1) + " is: " + coefficients[i]);
         }
      }
      else{
          for (int i = 1; i < args.length-2; i++){
            coefficients = new double[args.length-3];
            coefficients[i-1] += Double.parseDouble(args[i]);
            System.out.println("Coef at position: " + (i-1) + "is: " + coefficients[i]);
          }
      }
   }

   public double calculateY(double[] coefficients, double midpt){
      double power = coefficients.length-1;
      double y = 0.0;
      double yValue = 0.0;
      for (int i = 0; i <= coefficients.length; i++){
         y = coefficients[i] * Math.pow(midpt, power);
         yValue += y;
      }
      return yValue;
   }

   public double poly(int n, String[] args, double[] coefficients){
      double midpt  = 0.0;
      double sum    = 0.0;
      double width  = ((upper - lower) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lower + (width / 2.0) + (j * width);
         yValue = calculateY(coefficients, midpt);
         sum += yValue * width;
      }
      return sum;
      //double chunkWidth = (upper - lower)/n;
      //double midVal = (upper + (((lower - upper)/n)/2) );
      //double height = 0.0;
      //double areaTotal = 0.0;
      //double lastArea = 0.0;
      //double currentArea = 0.0;
      //double currentHeight = 0.0;
      //if (args[args.length-1].contains("%")){
      //   int power = args.length-5;
      //   for (int i = 0; i < n; i++){
      //      lastArea = currentArea;
      //      for (int j = 1; j < (args.length - 3); j++){
      //         if (Double.parseDouble(args[j]) == 0.0){
      //            height = 0.0;
      //         }
      //         else{
      //           height = Double.parseDouble(args[j]) * Math.pow(Double.parseDouble(args[j]), power);
      //         }
      //         power--;
      //         System.out.println("Height inside loop is: " + height);
      //         currentHeight += height;
      //      }
      //      areaTotal += currentHeight*chunkWidth*n;
      //      currentArea += areaTotal;
      //      System.out.println("Height and Width outside loop is: " + height + "\n Width: " + chunkWidth);
      //      System.out.println("Area total is: " + areaTotal);
      //   }

      //}
      //else{
      //  for (int i = 0; i < n; i++){
      //     int power = args.length-4;
      //     for (int j = 1; j < (args.length - 2); j++){
      //        height = Double.parseDouble(args[args.length - j]) * Math.pow(chunkWidth, j);
      //        power--;
      //        System.out.println("Height inside loop is: " + height);
      //        currentHeight += height;
      //     }
      //     areaTotal += currentHeight*chunkWidth*n;
           //midVal += chunkWidth;
      //     currentArea += areaTotal;
      //     System.out.println("Height is: " + height + "\n Width is: " +chunkWidth);
      //     System.out.println("Area total is: " + areaTotal);
      //  }
      //}
      //return areaTotal;
   }

    public double sin(int n, String[] args){
      double chunkWidth = (upper-lower)/n;
      double midVal = (upper +(((lower - upper)/n)/2));
      double height = 0.0;
      double areaTotal = 0.0;
      double lastArea = 0.0;
      double currentArea = 0.0;
      if (checkpercent(args)){ //DOES THIS ACTUALLY MAKE A DIFFERENCE (CHECK FOR SIN COS AND TAN)
         for (int i = 0; i < n; i++){
            height = Math.sin(midVal);
            areaTotal = chunkWidth * height;
            midVal += chunkWidth;
            currentArea += areaTotal;
         }
      }
      else{
        for (int i = 0; i < n; i++){
           height = Math.sin(midVal);
           areaTotal = chunkWidth * height;
           midVal += chunkWidth;
           currentArea += areaTotal;
         }
      }
      return areaTotal;
    }

    public double cos(int n, String[] args){
      double chunkWidth = (upper-lower)/n;
      double midVal = (upper +(((lower - upper)/n)/2));
      double height = 0.0;
      double areaTotal = 0.0;
      double lastArea = 0.0;
      double currentArea = 0.0;
      if (checkpercent(args)){
         for (int i = 0; i < n; i++){
            height = Math.cos(midVal);
            areaTotal = chunkWidth * height;
            midVal += chunkWidth;
            currentArea += areaTotal;
         }
      }
      else{
        for (int i = 0; i < n; i++){
           height = Math.cos(midVal);
           areaTotal = chunkWidth * height;
           midVal += chunkWidth;
           currentArea += areaTotal;
         }
      }
      return areaTotal;
    }

    public double tan(int n, String[] args){
      double chunkWidth = (upper-lower)/n;
      double midVal = (upper +(((lower - upper)/n)/2));
      double height = 0.0;
      double areaTotal = 0.0;
      double lastArea = 0.0;
      double currentArea = 0.0;
      if (checkpercent(args)){
         for (int i = 0; i < n; i++){
            height = Math.tan(midVal);
            areaTotal = chunkWidth * height;
            midVal += chunkWidth;
            currentArea += areaTotal;
         }
      }
      else{
        for (int i = 0; i < n; i++){
           height = Math.tan(midVal);
           areaTotal = chunkWidth * height;
           midVal += chunkWidth;
           currentArea += areaTotal;
         }
      }
      return areaTotal;
    }

   public void testPoly(){
      System.out.println("Testing poly function:");
      String[] testargs = {"poly", "0.0", "8.0", "-2.0", "1.0", "4.0", "1.0%"};
      checkpercent(testargs);
      checkinput(testargs);
      System.out.println("Test result for 10 rectangles is: " + poly(10, testargs, coefficients));
      System.out.println("Answer should be about 15.000 \n");
   }

   public void runMyTests(){
      testPoly();
   }

   public static void main (String[] args) {
      SkateRamp sr = new SkateRamp();
      sr.checkpercent(args);
      sr.checkfunc(args);
      sr.checkinput(args);
      sr.createCoef(args);
      int n = 2;
      // only run this if they ask you too sr.runMyTests();
      if (sr.checkpercent(args)){
         sr.lower = Double.parseDouble(args[args.length-3]);
         sr.upper = Double.parseDouble(args[args.length-2]);
         System.out.println("Contains percent.");
      }
      else {
         sr.lower = Double.parseDouble(args[args.length-2]);
         sr.upper = Double.parseDouble(args[args.length-3]);
         System.out.println("Input does not contain percent. Auto-percent is 1.00%");
      }
      if (sr.upper < sr.lower){
         sr.useMethod();
         System.exit(0);
      }
      if (args[0].equals("poly")){
         sr.poly(n, args, coefficients);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }
      if (args[0].equals("sin")){
         sr.sin(n, args);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }
      if (args[0].equals("cos")){
         sr.cos(n, args);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }
      if (args[0].equals("tan")){
         sr.tan(n, args);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }

   }



}