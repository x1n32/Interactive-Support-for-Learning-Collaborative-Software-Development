package github.x1n32.Task3DesignPatterns;

/**
 *  TASKS: 
 *  Let's add 'name' as another parameter to WizardDecorator so that it can be displayed in the details() method.
 *  Set its base magic to 20. 
 *  Create a String method called magicSpell().
 */

/* DELETE THIS LINE AND THE LINE AT THE BOTTOM
public class WizardDecorator implements Character{

    private Character wizard;
    private String name = "";
package github.x1n32.Task3DesignPatterns;

/**
 *  TASKS: 
 *  Let's add 'name' to WizardDecorator so that it can be displayed in the details() method.
 *  The parameter has been added in wizard decorator creation, but the value needs to be set.
 * 
 *  Set its base magic to 20. 
 *  Create a String method called magicSpell().
 */


public class WizardDecorator implements Character{

    private Character wizard;
    private String name = "";

    //This has the ability to create more decorated objects.
    public WizardDecorator(Character wizard, String name)  {   
        this.wizard=wizard;  
        //TO DO: Set the private String name equal to the parameter value name.
    } 

    public String getName(){
        return name;
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
        return wizard.mag(); //Change this to make it return 20
    }

    @Override
    public int spd() {
        return wizard.spd();
    }

    //CREATE A public String called magicSpell(), that returns "Casting: "
    public String magicSpell(){
        return null;
    }

        
}


    public WizardDecorator(Character wizard ______ ____)  {   //This has the ability to create more decorated objects.
        this.wizard=wizard;  
        //TODO: Set name equal to the parameter value.
    } 

    public String getName(){
        return name;
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
        return wizard.mag(); //Change this to make it return 20
    }

    @Override
    public int spd() {
        return wizard.spd();
    }

    //CREATE A public String called magicSpell(), that returns "Casting: "
    ______ ______ __________ __ _
        ______ ___________ _
    _
        
}
*/DELETE THIS LINE
