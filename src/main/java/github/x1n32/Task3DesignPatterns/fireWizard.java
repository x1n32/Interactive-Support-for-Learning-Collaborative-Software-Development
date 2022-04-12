package github.x1n32.Task3DesignPatterns;

public class fireWizard extends WizardDecorator {

    /**
     * Takes character and a name variable
     * @param wizard
     * @param name
     */
    public fireWizard(Character wizard, String name) {
        super(wizard, name);
    }

    /**
     * Returns Casting: Fireball!
     */
    @Override
    public String magicSpell(){ 
        return super.magicSpell() + "Fireball!"; 
    }
    
}
