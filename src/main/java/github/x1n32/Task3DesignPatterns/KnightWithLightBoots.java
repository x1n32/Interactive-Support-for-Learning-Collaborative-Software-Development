package github.x1n32.Task3DesignPatterns;

public class KnightWithLightBoots extends KnightClass{

    public KnightWithLightBoots(Character knight)  {   
        super(knight);  
    }  

    public String job() {
        return super.job() + decorateWithSword();
    }


    @Override
    public int str() {
        return super.str() ;
    }
    @Override
    public int def() {
        return super.def() ;
    }

    @Override
    public int mag() {
        return super.mag();
    }

    @Override
    public int spd() {
        return super.spd() + 10;
    }

    

    private String decorateWithSword() {
        return " + light boots ";
    }

}
