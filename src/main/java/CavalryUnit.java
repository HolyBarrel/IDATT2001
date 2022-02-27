/**
 * Class for a CavalryUnit with specification of the abstract methods of its
 * superclass 'Unit'
 * attackBonus is either 6 or 2 depending on whether the object of this class is charging
 *  = attackBonus: 6, or not = attackBonus: 2
 *  A cavalryUnit is set to charge on the first attack it makes
 *  resistBonus = 1, specific for objects of this subclass
 * @author Magnus Lutro Allison
 * @version 0.4
 */
public class CavalryUnit extends Unit{
    private int successfulAttacks = 0;
    /**
     * Constructor 1 for the class CavalryUnit
     * Creates an object with the following parameters:
     * @param name, String value, cannot be inputted as blank
     * @param health, integer value, cannot be inputted as less than zero
     * @param attack, integer value, cannot be inputted as less than zero
     * @param armor, integer value, cannot be inputted as less than zero
     * @throws IllegalArgumentException, is an exception thrown when the arguments are outside the
     *         logical input-range, or is blank
     *         Is thrown from the constructor of the superclass, 'Unit'
     */
    public CavalryUnit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        super(name, health, attack, armor);
    }
    /**
     * Constructor 2 for the class InfantryUnit with some default stats
     * Creates an object with the following parameters:
     * @param name, String value, cannot be inputted as blank
     * @param health, integer value, cannot be inputted as less than zero
     * @throws IllegalArgumentException, is an exception thrown when the arguments are outside the
     *         logical input-range, or is blank
     *         Is thrown from the constructor of the superclass, 'Unit'
     */
    public CavalryUnit(String name, int health) throws IllegalArgumentException {
        super(name, health, 20, 12);
    }
    /**
     * Accessor method that returns the number of attacks this CavalryUnit has done
     * @return int successfulAttacks
     */
    public int getSuccessfulAttacks() {
        return successfulAttacks;
    }
    /**
     * Help-method to increase this unit's current number of successful attacks
     * -helper for method beneath V
     */
    private void attackSuccess(){
        this.successfulAttacks++;
    }

    /**
     * Attack method containing the formula given how the logic behind a unit's attack
     * is in the game
     *
     * @param opponent, is the opponent that is being attacked
     *                  The opponent's health is altered with its own mutator-method
     *                  setHealth
     *                  The logic gets the pre-given health of the opponent,
     *                  subtracts this unit's attack and attackBonus,
     *                  additions the opponents armor and resistBonus,
     *                  and then sets the result as the new health
     *                  of the @param opponent
     *                  if the opponent is a ranged unit, the ranged unit's hitsReceived is incremented
     *                  via it's method called 'enemyHitsThisUnit'
     *                  In this unit, the 'opponent' parameter is sent to the superclass 'Units''s
     *                  attack-method
     * The attack-method is overridden to be able to increment this unit's number of successful
     *                  attacks
     */
    @Override
    public void attack(Unit opponent) {
        super.attack(opponent);
        attackSuccess();
    }

    /**
     * Method that returns an attack bonus for charge attack and melee combat
     * @return1 integer value 6, is returned if charging
     * @return2 integer value 2, is returned if not charging
     */


    @Override
    public int getAttackBonus() {
        int defaultAtkBonus = 2;
        //The cavalry unit will get a further charge-bonus in its first attack
        boolean charge = this.getSuccessfulAttacks() == 0;
        if(charge) return defaultAtkBonus + 4; //additional 4 attackBonus when in charge
        return defaultAtkBonus;
    }

    /**
     * Method that returns a small resist bonus in close defense
     * @return integer value 1
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
