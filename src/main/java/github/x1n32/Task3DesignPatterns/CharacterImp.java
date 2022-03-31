package github.x1n32.Task3DesignPatterns;

public class CharacterImp implements Character { //implements the Character Interface. Can override the methods to do things.
    @Override
    public void details(){
        System.out.println("My Stats:");
        System.out.println(job());
        System.out.println("Stength...: " + str());
        System.out.println("defence...: " + def());
        System.out.println("Magic.....: " + mag());
        System.out.println("Speed.....: " + spd());
        System.out.println("---------------");

    };


    
    @Override
    public String job() {
        return("Job: ");
    }

    @Override
    public int str() {
        return 10;
    }
    @Override
    public int def() {
        return 10;
    }

    @Override
    public int mag() {
      
        return 10;
    }

    @Override
    public int spd() {
      
        return 10;
    }
    
}
