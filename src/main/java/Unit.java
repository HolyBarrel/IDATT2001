/**
 * Abstract superclass Unit describing commonalities for all unit-types
 * throughout 'Wargames'
 * The Unit superclass is inherited by the subclasses:
 * InfantryUnit
 * CavalryUnit
 * RangedUnit
 *
 * @author Magnus Lutro Allison
 * @version 0.1
 * @since 12.02.2022
 */
public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;


    /**
     * Constructor for the superclass Unit
     * @param name, is a String, cannot be left blank
     * @param health, is an int, cannot drop to less than 0
     * @param attack, is an int, above -1
     * @param armor, is an int, above -1
     */
    public Unit(String name, int health, int attack, int armor) { //throws...
        //add exception handling here
        this.name = name; // cannot be blank
        this.health = health; // include !< 0 eventually here || use set-method
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Attack method containing the formula given how the logic behind a unit's attack
     * is in the game
     * @param opponent, is the opponent that is being attacked
     *                  The opponent's health is altered with it's own mutator-method
     *                  setHealth
     *                  The logic gets the pre-given health of the opponent,
     *                  subtracts this unit's attack and attackBonus,
     *                  additions the opponents armor and resistBonus,
     *                  and then sets the result as the new health
     *                  of the @param opponent
     */
    public void attack(Unit opponent){
        opponent.setHealth(opponent.getHealth()
                - (this.attack + this.getAttackBonus())
                + (opponent.getArmor() + opponent.getResistBonus()));
    }

    /**
     * Accessor method that returns the name of this Unit
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method that returns the health of this Unit
     * @return int health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Accessor method that returns the attack-quantity of this Unit
     * @return int attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Accessor method that returns the armor-quantity of this Unit
     * @return int armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Mutator method that alters the current health attribute of this Unit
     * @param health, is a positive integer
     */
    public void setHealth(int health) {
        //add exception, and param must be more than zero
        this.health = health;
    }

    @Override
    public String toString() {
        //revise later
        return "\nUNIT: \n" +
                "Name = "   + name + "\n" +
                "Health = " + health + "\n" +
                "Attack = " + attack + "\n" +
                "Armor = "  + armor;
    }

    /**
     * Abstract method shell to force a unique attack-bonus method for each of
     * the subclasses of Unit
     * @return int attackBonus
     */
    public abstract int getAttackBonus();

    /**
     * Abstract method shell to force a unique resist-bonus method for each of
     * the subclasses of Unit
     * @return int resistBonus
     */
    public abstract int getResistBonus();

}