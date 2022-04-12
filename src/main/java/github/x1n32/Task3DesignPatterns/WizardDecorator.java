package github.x1n32.Task3DesignPatterns;

/**
 *  TASK 3: 
 *  A new Decorator class for a Wizard has been created.  
 *  Fill in the missing words in the file marked with underscores.
 *  TASK 4 : 
 *  Set its base magic to 20. Create a String method called magicSpell().
 */
public class WizardDecorator implements Character{

    private Character wizard;
    private String name = "";

    public WizardDecorator(Character wizard, String name)  {   //This has the ability to create more decorated objects.
        this.wizard=wizard;  
        this.name = name;
    }  


    @Override
    public void details() {
        System.out.println(name +" Stats:");
        System.out.println(job());
        System.out.println("Stength...: " + str());
        System.out.println("defence...: " + def());
        System.out.println("Magic.....: " + mag());
        System.out.println("Speed.....: " + spd());
        System.out.println("---------------");
        
    }


    @Override
    public String job() {
        return wizard.job() + "wizard";
    }

    @Override
    public int str() {
        return wizard.str();
    }

    @Override
    public int def() {
        return wizard.def();
    }

    @Override
    public int mag() {
        return 20;
    }

    @Override
    public int spd() {
        return wizard.spd();
    }

    public String magicSpell(){
        return "Casting: ";
    }
}
