package edu.ntnu.idatt2001.magnulal.view;

import edu.ntnu.idatt2001.magnulal.model.simulator.Army;
import edu.ntnu.idatt2001.magnulal.model.simulator.Battle;
import edu.ntnu.idatt2001.magnulal.model.units.CavalryUnit;
import edu.ntnu.idatt2001.magnulal.model.units.CommanderUnit;
import edu.ntnu.idatt2001.magnulal.model.units.InfantryUnit;
import edu.ntnu.idatt2001.magnulal.model.units.RangedUnit;

import static edu.ntnu.idatt2001.magnulal.utils.TerrainType.PLAINS;

public class MainClass { //not any task
    public static void main(String[] args) {

        Army humanArmy = new Army("Alliance");
        Army orcArmy = new Army("Horde");
        for (int i = 0; i < 20; i++) {
            humanArmy.add(new InfantryUnit("Footman", 100, 30, 7));
            orcArmy.add(new InfantryUnit("Grunt", 100, 34, 6));
        }
        for (int i = 0; i < 20; i++) {
            humanArmy.add(new CavalryUnit("Knight", 100, 40, 22));
            orcArmy.add(new CavalryUnit("Raider", 100, 42, 18));
        }
        for (int i = 0; i < 20; i++) {
            humanArmy.add(new RangedUnit("Archer", 100, 50, 5));
            orcArmy.add(new RangedUnit("SpearOrc", 100, 55, 3));
        }
        //Commanders
        humanArmy.add(new CommanderUnit("MountainKing", 180, 40, 25)); //if armor is too high,
        // the battle will go on forever
        orcArmy.add(new CommanderUnit("Gul'dan", 180, 45, 15));
        Battle battleOfAzeroth = new Battle(humanArmy, orcArmy, PLAINS);
    }
}
