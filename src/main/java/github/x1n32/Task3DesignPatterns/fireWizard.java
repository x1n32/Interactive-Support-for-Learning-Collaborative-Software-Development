package github.x1n32.Task3DesignPatterns;

//create a "fireWizard.java" that extends WizardDecorator. Make magicSpell() output "Casting: Fireball!"


public class fireWizard extends WizardDecorator {


    public fireWizard(Character wizard, String name) {
        super(wizard, name);
    }

    //TO DO: override magic spell to make it return "Casting: Fireball". Hint: use super to call 'Casting: ' from the decorator class.
    
}

