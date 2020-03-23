/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SkateRamp.java
 *  Purpose       :  Finds area under curve of skate ramp given functions
 *  @author       :  Summer McGrogan
 *  Date written  :  03-22-2020
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
         if ((args.length) < 4){
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
         coefficients = new double[args.length-4];
         for (int i = 1; i < args.length-3; i++){
            coefficients[i-1] += Double.parseDouble(args[i]);
            System.out.println("Coef at position: " + (i-1) + " is: " + coefficients[i-1]);
         }
      }
      else{
          coefficients = new double[args.length-3];
          for (int i = 1; i < args.length-2; i++){
            coefficients[i-1] += Double.parseDouble(args[i]);
            System.out.println("Coef at position: " + (i-1) + " is: " + coefficients[i-1]);
          }
      }
   }

   public double calculateY( double[] coefficients, double midPoint ) {
       double yValue = 0.0;
       for( int i = 0; i < coefficients.length; i++ ) {
         yValue += coefficients[i] * Math.pow( midPoint, i );
       }
       return yValue;
   }

   public double poly(int n, String[] args, double[] coefficients, double upper, double lower){
      double midpt  = 0.0;
      double currentArea = 0.0;
      double width  = ((upper - lower) / n);
      double yValue = 0.0;
      double lastArea = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lower + (width / 2.0) + (j * width);
         yValue = calculateY(coefficients, midpt);
         currentArea += yValue * width;
         System.out.println("yVal: " + yValue + " width is: " + width);
      }
      System.out.println("Total area is: " + currentArea);
      lastArea = currentArea;
      return currentArea;
   }

    public double sin(int n, String[] args, double[] coefficients, double upper, double lower){
      double midpt  = 0.0;
      double currentArea = 0.0;
      double width  = ((upper - lower) / n);
      double yValue = 0.0;
      for (int j = 0; j < n; j++){
         yValue = 0.0;
         midpt = lower + (width / 2.0) + (j * width);
         yValue = calculateY(coefficients, midpt);
         currentArea += width * Math.sin(yValue);
         lastArea = currentArea;
      }
      System.out.println("Area total is: " + currentArea);
      return currentArea;
    }

    public double cos(int n, String[] args, double[] coefficients, double upper, double lower){
      double midpt  = 0.0;
      double currentArea = 0.0;
      double width  = ((upper - lower) / n);
      double yValue = 0.0;
      for (int j = 0; j < n; j++){
         yValue = 0.0;
         midpt = lower + (width / 2.0) + (j * width);
         yValue = calculateY(coefficients, midpt);
         currentArea += width * Math.cos(yValue);
      }
      System.out.println("Area total is: " + currentArea);
      lastArea = currentArea;
      return currentArea;
    }

    public double tan(int n, String[] args, double[] coefficients, double upper, double lower){
      double midpt  = 0.0;
      double currentArea = 0.0;
      double width  = ((upper - lower) / n);
      double yValue = 0.0;
      for (int j = 0; j < n; j++){
         yValue = 0.0;
         midpt = lower + (width / 2.0) + (j * width);
         yValue = calculateY(coefficients, midpt);
         currentArea += (Math.tan(yValue)) * width;
      }
      System.out.println("Area total is: " + currentArea);
      lastArea = currentArea;
      return currentArea;
    }

   public void testPoly(){
      System.out.println("Testing poly function:");
      String[] testargs = {"poly", "0.0", "8.0", "-2.0", "1.0", "4.0", "1.0%"};
      double[] testcoef = {0.0, 8.0, -2.0};
      double tupper = 4.0;
      double tlower = 1.0;
      checkpercent(testargs);
      checkinput(testargs);
      checkfunc(testargs);
      createCoef(testargs);
      System.out.println("Test result for 10 rectangles is: " + poly(10, testargs, testcoef, tupper, tlower));
      System.out.println("Answer should be about 15.000 \n");
   }

   public void testSin(){
     System.out.println("Testing sin function:");
     String[] testargs = {"sin", "-17.0", "3.0", "-11.0", "11.0", "1e-7%"};
     double[] testcoef = {-17.0, 3.0};
     double tupper = 11.0;
     double tlower = -11.0;
     checkpercent(testargs);
     checkinput(testargs);
     checkfunc(testargs);
     createCoef(testargs);
     System.out.println("Test result for 10 rectangles is: " + sin(10, testargs, testcoef, tupper, tlower));
     System.out.println("Answer should be 0.6409 \n");
   }

   public void testCos(){
     System.out.println("Testing cos function:");
     String[] testargs = {"cos", "-17.0", "3.0", "-11.0", "11.0", "1e-7%"};
     double[] testcoef = {-17.0, 3.0};
     double tupper = 11.0;
     double tlower = -11.0;
     checkpercent(testargs);
     checkinput(testargs);
     checkfunc(testargs);
     createCoef(testargs);
     System.out.println("Test result for 10 rectangles is: " + cos(10, testargs, testcoef, tupper, tlower));
     System.out.println("Answer should be -0.1834 \n");
   }

   public void testTan(){
     System.out.println("Testing tan function:");
     String[] testargs = {"tan", "0.0", "1.0", "-0.5", "1.25", "1.5e-4%"};
     double[] testcoef = {0.0, 1.0};
     double tupper = -0.5;
     double tlower = 1.25;
     checkpercent(testargs);
     checkinput(testargs);
     checkfunc(testargs);
     createCoef(testargs);
     System.out.println("Test result for 10 rectangles is: " + tan(10, testargs, testcoef, tupper, tlower));
     System.out.println("Answer should be 1.0235 \n");
   }

   public void runMyTests(){
      testPoly();
      testSin();
      testCos();
      testTan();
   }

   public static void main (String[] args) {
      SkateRamp sr = new SkateRamp();
      if (args[0].equals("runMyTests") || args[0].equals("runmytests")){
         sr.runMyTests();
         System.exit(0);
      }
      sr.checkpercent(args);
      sr.checkfunc(args);
      sr.checkinput(args);
      sr.createCoef(args);
      int n = 2;
      if (sr.checkpercent(args)){
         sr.lower = Double.parseDouble(args[args.length-3]);
         sr.upper = Double.parseDouble(args[args.length-2]);
         System.out.println("Contains percent.");
      }
      else {
         sr.lower = Double.parseDouble(args[args.length-2]);
         sr.upper = Double.parseDouble(args[args.length-1]);
         System.out.println("Input does not contain percent. Auto-percent is 1.00%");
      }
      if (sr.upper < sr.lower){
         sr.useMethod();
         System.out.println("Upper limit cannot be greater than lower");
         System.exit(0);
      }
      if (args[0].equals("poly")){
         sr.poly(n, args, coefficients, sr.upper, sr.lower);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }
      if (args[0].equals("sin")){
         sr.sin(n, args, coefficients, sr.upper, sr.lower);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }
      if (args[0].equals("cos")){
         sr.cos(n, args, coefficients, sr.upper, sr.lower);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }
      if (args[0].equals("tan")){
         sr.tan(n, args, coefficients, sr.upper, sr.lower);
         if ((((sr.currentArea - sr.lastArea)/sr.lastArea)*100) <= sr.percent){
             System.exit(0);
         }
      }

   }



}
