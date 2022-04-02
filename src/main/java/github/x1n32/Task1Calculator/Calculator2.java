package github.x1n32.Task1Calculator;

/**Try Making this class the Quadratic Formula. Search online on bbc bitesize if you don't know what it is.
=======

/**Try Making this class do some more things to the original calculator.
 * Such as the Quadratic Formula. Search online on BBC Bitesize if you don't know what it is.

     * Try using values a b c 
     * to create a method of using the quadratic formula.
     * The quadratic formula is used to solve a quadratic to find x: ax^2 + bx + c
     * The Equation: x = (-b +- square root(b^2 - 4ac))  / 2a
     * +- means plus or minus. x should have two answers.
     * Should return a positive x answer, and a negative x answer.
     * e.g. 2x^2 -5x - 6 
     *      Gives the answer: x = 3.860.... and x = -0.88....
 */
public class Calculator2 extends Calculator{

    /**
     * Return the value of b squared.
     *  Which is b * b
     */
    public float squareOfB(float b){
        return 0; // Change 0 to: b * b
    }

    /**
     * For the quadratic formula, it requires the value of 4ac.
     * Have it done here, so it can be tested.
     * Which is 4 * a * c
     */
    public float fourAC(float a, float c){
        return 0;
    }
  
    /**
     * Take the value of the square of b, and the value of 4ac
     * then square root it.
     * Hint: Math.sqrt(X)
     */
    public double squareRootAnswer(float squareOfB, float fourAC){
        return 0;
    }

    /**
     * Positive x answer gotten by filling in the rest of the formula using +
     * x = (-b + sqrt(b^2 - 4ac) )/2a
     */
    public double positiveAnswer(float a, float b, float c){
        //To help: all the code you need is here but in the wrong order.
        //Remove // below and reorder the code to make it work:


        // return positiveAns;
        //double sqr = squareRootAnswer(square, fourac); //Takes values square and 4ac to be square rooted. They need to be initialised first in order for this to be used.
        //float square = squareOfB(b);                   //Initialising the variable square with the value of b * b
        //float fourac = fourAC(a, c);                   //Initialising the variable fourac with the value of 4 * a * c
        //double positiveAns = (-b + sqr) /(2*a);        //Requires the value sqr to computer the answer.
        
        return 0; //DELETE THIS LINE
    }

    /**
     * Negative x answer gotten by filling in the rest of the formula with -
     * x = (-b - sqrt(b^2 - 4ac) )/2a
     */
    public double negativeAnswer(float a, float b, float c){
        //All the code you need is here, but with some values missing
        //Look at positive answer if you are struggling

        //float square = squareOfB(_);
        //float fourac = fourAC(a, c);
        //double sqr = squareRootAnswer(______, fourac);
        //double negativeAns = (________) /(2*a);
        //return negativeAns;

    
        return 0; //DELETE THIS LINE
    }


    /**
     * Output the answer here so you can just call this funtion in the main method below.
     */
    public void quadraticFormula(float a, float b, float c) {
        //Replace ___ with the right function below to call the positive and negative answer.
      //  System.out.println(______________(a, b, c)); 
      //  System.out.println(______________(a, b, c));
	}

    
    public static void main(String[] args) {
        System.out.println("Have a go at creating functions to perform the quadratic formula.");
        System.out.println("There are some empty methods to break down the steps to do it.");
        System.out.println("Once done, have a check at the testing: on the test folder");
        
        Calculator2 cal = new Calculator2();
        cal.quadraticFormula(-2,-5,-6); // Answer: x = 3.860.... and x = -0.88....
    }
}