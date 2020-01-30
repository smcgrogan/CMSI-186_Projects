/** PiSolver
* author: Summer McGrogan
* class: CMSI 186
* date: Jan 30, 2020
*/
public class PiSolver {
  public static void main(String args[]) {
    double hits = 0;
    double maxcount = 1000;
    double x = 0.0;
    double y = 0.0;
    if (args.length != 0) {
      maxcount = Integer.parseInt(args[0]);
      /*changes number of arguments to integer 1000 if none entered */
    } /* use a if to check (args.length > 0)*/
    for (int i = 0; i <= maxcount; i++) {
      /* creates for loop to add to number of throws*/
      x = Math.random();
      /* assigns random number to x */
      y = Math.random();
      /* assigns random number to y */
      if (Math.round(Math.random()) == 0) {
        x = x * -1;
      }
      if (Math.round(Math.random()) == 0) {
        y = y * -1;
      }
      if ((Math.sqrt((x*x)+(y*y))) <= 1) {
        /* only adds to hit because it is inside of circle */
        hits++;
      }
    }
    System.out.println("Estimated value of Pi is: " + ((double)hits/(double)maxcount) * 4.0);
  }
}
