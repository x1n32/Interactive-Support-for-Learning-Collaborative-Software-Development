package github.x1n32.Task3DesignPatterns;


/** TASK:
 *  Create a KnightWithAShield.java class, that extends knightClass.
 *  That provides 10 extra defence, and returns " + shield " when the job function is called.
 */
public class KnightWithAShield extends KnightClass  {
    
    public KnightWithAShield(Character knight) {   
        super(knight);  
    }  

    public String job() {
        return super.job() + decorateWithShield();
    }
    private String decorateWithShield() {
        return " + shield "; //Return " + shield" here.
    }

    @Override
    public int def() {
        return super.def() + 10; //Increase defence by 10 here.
    }

}
