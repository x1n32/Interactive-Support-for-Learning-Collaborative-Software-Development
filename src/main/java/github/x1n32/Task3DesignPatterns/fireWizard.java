package github.x1n32.Task3DesignPatterns;

public class fireWizard extends WizardDecorator {

    public fireWizard(Character wizard, String name) {
        super(wizard, name);
    }

    @Override
    public String magicSpell(){
        return super.magicSpell() + "Fireball!";
    }
    
}
