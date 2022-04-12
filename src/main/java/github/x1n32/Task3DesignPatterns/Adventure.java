package github.x1n32.Task3DesignPatterns;

public class Adventure {

    /**
     * Main method to test the decorators
     * @param args
     */
    public static void main(String args[]) {

        //Using Character Imp class to be used into other classes
        CharacterImp StarterCharacter = new CharacterImp(); //A Character Implementation called Stater Character
        StarterCharacter.details();
        Character KnightFromStarterCharacter= new KnightWithSword(StarterCharacter); //StarterCharacter is used here 

        // ----------------

        //Creating new Characters from NEW Implementations
	Character decoratedKnight = new KnightWithSword(new CharacterImp()); //A new Character Imp is used here instead.
        decoratedKnight.details();

        Character speedyKnight = new KnightWithLightBoots(new CharacterImp());
        speedyKnight.details();

        Character speedyDecoratedKnight = new KnightWithSword(new KnightWithLightBoots(new CharacterImp()));
        speedyDecoratedKnight.details();


        //Task: Create a shield knight class that provides 10 extra defence and its job description includes + shield.
	    
/*	DELETE THIS LINE WHEN YOU START CREATING KNIGHT WITH A SHIELD    
        Character shieldKnight = new KnightWithAShield(new CharacterImp());
        shieldKnight.details();
DELETE THIS LINE WHEN YOU START CREATING KNIGHT WITH A SHIELD*/

        //--------------------
        //Wizards
/*DELETE THIS LINE WHEN YOU START CREATING Wizards classes

        WizardDecorator basicWizard = new WizardDecorator(new CharacterImp(),"Mage boy");
        basicWizard.details();
        System.out.println(basicWizard.magicSpell());

        fireWizard myFireWizard = new fireWizard(new CharacterImp(), "Merlin");
        myFireWizard.details();
        System.out.println(myFireWizard.magicSpell());
DELETE THIS LINE WHEN YOU START CREATING Wizard classes*/


    }
}
