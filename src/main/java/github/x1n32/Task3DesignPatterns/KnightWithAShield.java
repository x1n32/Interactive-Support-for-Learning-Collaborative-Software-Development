package github.x1n32.Task3DesignPatterns;


/** TASK:
 * Create a KnightWithAShield.java class, that returns " + shield " when the job function is called.
 * Make KnightWithAShield.java class provide 10 extra defence.
 */


public class KnightWithAShield extends KnightClass{
    
    public KnightWithAShield(Character knight) {   
        super(knight);  
    }  

    public String job() {
        return super.job() + decorateWithShield();
    }
    private String decorateWithShield() {
        return " + ______ "; //return " + shield " here.
    }
    



}
 
