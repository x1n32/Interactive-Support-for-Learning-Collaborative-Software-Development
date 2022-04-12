package github.x1n32.Task3DesignPatterns;

public abstract class KnightClass implements Character { 
    //This is a 'character' Decorator. Like Character Imp, it takes Character and overrides the methods to do something new.

    private Character knight;

    public KnightClass(Character knight)  {   //This has the ability to create more decorated objects.
        this.knight=knight;  
    }  

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
        return knight.job() + "Knight";
    }

    @Override
    public int str() {
        return knight.str();
    }

    @Override
    public int def() {
        return knight.def();
    }

    @Override
    public int mag() {
        
        return knight.mag();
    }

    @Override
    public int spd() {
     
        return knight.spd();
    }

}