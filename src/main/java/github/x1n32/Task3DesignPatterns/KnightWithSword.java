package github.x1n32.Task3DesignPatterns;

public class KnightWithSword extends KnightClass{

    public KnightWithSword(Character knight)  {   
        super(knight);  
    }  

    public String job() {
        return super.job() + decorateWithSword();
    }

    @Override
    public int str() {
        return super.str() + 10;
    }
    @Override
    public int def() {
        return super.def() + 2;
    }

    @Override
    public int mag() {
        return super.mag();
    }
    @Override
    public int spd() {
        return super.spd() -2;
    }


    

    private String decorateWithSword() {
        return " + sword ";
    }

}
