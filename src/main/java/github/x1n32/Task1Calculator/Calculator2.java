package github.x1n32.Task1Calculator;


public class Calculator2 extends Calculator{

    public float squareOfB(float b){
        return b * b;
    }
    public float fourAC(float a, float c){
        return (4 * a * c);
    }
  
    public double squareRootAnswer(float squareOfB, float fourAC){
       
        System.out.println(Math.sqrt(squareOfB - fourAC));
        return (Math.sqrt(squareOfB - fourAC));
    }

    public double positiveAnswer(float a, float b, float c){
        float square = squareOfB(b);
        float fourac = fourAC(a, c);
        double sqr = squareRootAnswer(square, fourac);
        double positiveAns = (-b + sqr) /(2*a);
        return positiveAns;
    }

    public double negativeAnswer(float a, float b, float c){
        float square = squareOfB(b);
        float fourac = fourAC(a, c);
        double sqr = squareRootAnswer(square, fourac);
        double negativeAns = (-b - sqr) /(2*a);
        return negativeAns;
    }



    public void quadraticFormula(float a, float b, float c) {
        System.out.println(positiveAnswer(a, b, c)); 
        System.out.println(negativeAnswer(a, b, c));
	}

    
    public static void main(String[] args) {

        Calculator2 superCalculator = new Calculator2();
        superCalculator.quadraticFormula(2, -5, -6);
    }
}