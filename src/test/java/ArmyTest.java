import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class ArmyTest {
    @Nested
    @DisplayName("Positive tests for the class 'Army'")
    class methodsReturnsAsExpected {
        @Test
        @DisplayName("Checking that the constructor accepts just NAME")
        public void checkConstructorWithNameString() {
            Army testArmy = new Army("Alliance");
            assertEquals("Alliance", testArmy.getNAME());
        }
        @Test
        @DisplayName("Checking that the constructor accepts NAME and list")
        public void checkConstructorWithNameStringAndList() {
            //tests with some random units
            CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
            CavalryUnit cavalryUnit2 = new CavalryUnit("GrandLancer", 65, 10, 10);
            RangedUnit rangedUnit1 = new RangedUnit("CrossbowMan", 40, 20,2);
            ArrayList<Unit> unitsTestArray = new ArrayList<>();
            unitsTestArray.add(cavalryUnit1);
            unitsTestArray.add(cavalryUnit2);
            unitsTestArray.add(rangedUnit1);
            Army testArmy = new Army("Alliance", unitsTestArray);
            assertEquals(
                    "[| Name: 'GrandLancer'  Health: 75   Attack: 12   Armor: 10   , | Name: 'GrandLancer'  " +
                            "Health: 65   Attack: 10   Armor: 10   , | Name: 'CrossbowMan'  Health: 40   Attack: 20   " +
                            "Armor: 2    ]", testArmy.getAllUnits().toString());
        }
        @Test
        @DisplayName("Testing if the add()-method functions correctly")
        public void testAddToArmyMethod() {
            Army testArmy = new Army("Alliance");
            assertNotNull(testArmy.getAllUnits());
            assertEquals(0, testArmy.getArmySize());
            testArmy.add(new CavalryUnit("GrandLancer", 75, 12, 10));
            assertEquals(1, testArmy.getArmySize());
        }
        @Test
        @DisplayName("Testing addAll()-method to add multiple units to army")
        public void testAddAllUnitsOfAListMethod() {
            Army testArmy = new Army("Alliance");
            assertNotNull(testArmy.getAllUnits());
            assertEquals(0, testArmy.getArmySize());
            //tests adding some random units
            CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
            CavalryUnit cavalryUnit2 = new CavalryUnit("GrandLancer", 65, 10, 10);
            RangedUnit rangedUnit1 = new RangedUnit("CrossbowMan", 40, 20,2);
            ArrayList<Unit> unitsTestArray = new ArrayList<>();
            unitsTestArray.add(cavalryUnit1);
            unitsTestArray.add(cavalryUnit2);
            unitsTestArray.add(rangedUnit1);
            testArmy.addAll(unitsTestArray);
            assertEquals(3, testArmy.getArmySize());
        }
        @Test
        @DisplayName("Testing if the remove()-method functions correctly")
        public void testRemoveFromArmyMethod() {
            Army testArmy = new Army("Alliance");
            assertNotNull(testArmy.getAllUnits());
            assertEquals(0, testArmy.getArmySize());
            CavalryUnit testCavalryUnit = new CavalryUnit("GrandLancer", 75, 12, 10);
            testArmy.add(testCavalryUnit);
            assertEquals(1, testArmy.getArmySize());
            testArmy.remove(testCavalryUnit);
            assertEquals(0, testArmy.getArmySize());
        }
        @Test
        @DisplayName("Testing if the hasUnits method functions correctly")
        public void testHasUnitsMethod() {
            Army testArmy = new Army("Alliance");
            assertFalse(testArmy.hasUnits());
            CavalryUnit testCavalryUnit = new CavalryUnit("GrandLancer", 75, 12, 10);
            testArmy.add(testCavalryUnit);
            assertTrue(testArmy.hasUnits());
        }
        @Test
        @DisplayName("Testing getRandomListIndex-method")
        public void testGetRandomListIndexMethod() {
            CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
            CavalryUnit cavalryUnit2 = new CavalryUnit("GrandLancer", 65, 10, 10);
            RangedUnit rangedUnit1 = new RangedUnit("CrossbowMan", 40, 20,2);
            ArrayList<Unit> unitsTestArray = new ArrayList<>();
            unitsTestArray.add(cavalryUnit1);
            unitsTestArray.add(cavalryUnit2);
            unitsTestArray.add(rangedUnit1);
            Army testArmy = new Army("Alliance", unitsTestArray);
            //using a while-loop to confirm that the random integer picker actually is within the
            //targeted range
            int num = 0;
            while (num < 10*testArmy.getAllUnits().size()){
                int chosenRandomIndex = testArmy.getRandomListIndex();
                assertTrue(chosenRandomIndex >= 0 &&
                        chosenRandomIndex < testArmy.getAllUnits().size());
                num++;
            }
        }
        @Test
        @DisplayName("Testing getRandom unit method")
        public void testGetRandomMethod() {
            CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
            CavalryUnit cavalryUnit2 = new CavalryUnit("GrandLancer", 65, 10, 10);
            RangedUnit rangedUnit1 = new RangedUnit("CrossbowMan", 40, 20, 2);
            ArrayList<Unit> unitsTestArray = new ArrayList<>();
            unitsTestArray.add(cavalryUnit1);
            unitsTestArray.add(cavalryUnit2);
            unitsTestArray.add(rangedUnit1);
            Army testArmy = new Army("Alliance", unitsTestArray);
            Unit randomPickedUnit = testArmy.getRandom();
            assertTrue(testArmy.getAllUnits().contains(randomPickedUnit));
        }
        @Test
        @DisplayName("Testing toString method for an army")
        public void testToStringMethod() {
            CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
            CavalryUnit cavalryUnit2 = new CavalryUnit("GrandLancer", 65, 10, 10);
            RangedUnit rangedUnit1 = new RangedUnit("CrossbowMan", 40, 20, 2);
            ArrayList<Unit> unitsTestArray = new ArrayList<>();
            unitsTestArray.add(cavalryUnit1);
            unitsTestArray.add(cavalryUnit2);
            unitsTestArray.add(rangedUnit1);
            Army testArmy = new Army("Alliance", unitsTestArray);
            String underLine = "\n|_______________________________________________________________\n";
            String testStr = underLine + "| Units of the army: 'Alliance'" + underLine +
                    "| Name: 'GrandLancer'  Health: 75   Attack: 12   Armor: 10   " + underLine +
                    "| Name: 'GrandLancer'  Health: 65   Attack: 10   Armor: 10   " + underLine +
                    "| Name: 'CrossbowMan'  Health: 40   Attack: 20   Armor: 2    " + underLine +
                    "'Alliance' is an army with 3 total units";
            assertEquals(testStr, testArmy.toString());
        }
        //TODO: test EQUALS AND HASH?

    }
    @Nested
    @DisplayName("Negative tests for the class 'Army'")
    class methodsReturnsUnexpectedValues {
        @Test
        @DisplayName("Testing constructor 1 of 'Army' class with empty string-parameter")
        public void constructor1TestWithStringAsParameter() {
            try{
                //TEST
                assertThrows(IllegalArgumentException.class,
                        () -> new Army(""));
                //EXCEPTION THROWER
                new Army("");
                fail("Should have thrown an exception");
            }catch (IllegalArgumentException e){
                assertEquals("The name for an army cannot be inputted as an" +
                        " empty string, please try again.", e.getMessage());
            }
        }
        @Test
        @DisplayName("Testing constructor 2 of 'Army' class with empty string-parameter")
        public void constructor2TestWithStringAsParameter() {
            try{
                CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
                ArrayList<Unit> unitsTestArray = new ArrayList<>();
                unitsTestArray.add(cavalryUnit1);
                //TEST
                assertThrows(IllegalArgumentException.class,
                        () -> new Army("", unitsTestArray));
                //EXCEPTION THROWER
                new Army("", unitsTestArray);
                fail("Should have thrown an exception");
            }catch (IllegalArgumentException e){
                assertEquals("The name for an army cannot be inputted as an" +
                        " empty string, please try again.", e.getMessage());
            }
        }
        @Test
        @DisplayName("Testing constructor 2 of 'Army' class with unwanted list-parameter")
        public void constructor2TestWithUnwantedListParameter() {
            try{
                CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
                ArrayList<Unit> unitsTestArray = new ArrayList<>();
                unitsTestArray.add(cavalryUnit1);
                //TEST
                assertThrows(IllegalArgumentException.class,
                        () -> new Army("", unitsTestArray));
                //EXCEPTION THROWER
                new Army("", unitsTestArray);
                fail("Should have thrown an exception");
            }catch (IllegalArgumentException e){
                assertEquals("The name for an army cannot be inputted as an" +
                        " empty string, please try again.", e.getMessage());
            }
        }
        @Test
        @DisplayName("Testing addAll method with wrong list-parameter")
        public void testingAddAllMethodWithWrongListTypeAsParameter() {
            try{
                CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
                Vector<Unit> unitsTestArray = new Vector<>();
                unitsTestArray.add(cavalryUnit1);
                //TEST
                assertThrows(IllegalArgumentException.class,
                        () -> new Army("Alliance", unitsTestArray));
                //EXCEPTION THROWER
                new Army("Alliance", unitsTestArray);
                fail("Should have thrown an exception");
            }catch (IllegalArgumentException e){
                assertEquals("The inputted list-type must be either an arraylist, " +
                        "or a linked list, please try again.", e.getMessage());
            }
        }
        @Test
        @DisplayName("Testing remove unit method on an empty army")
        public void testingRemoveUnitMethodWithEmptyArmy() {
            try{
                Army testArmy = new Army("Alliance");
                CavalryUnit cavalryUnit1 = new CavalryUnit("GrandLancer", 75, 12, 10);
                //TEST
                assertThrows(IllegalArgumentException.class,
                        () -> testArmy.remove(cavalryUnit1));
                //EXCEPTION THROWER
                testArmy.remove(cavalryUnit1);
                fail("Should have thrown an exception");
            }catch (IllegalArgumentException e){
                assertEquals("The given unit is not in the army and therefore cannot be removed," +
                        " please try again.", e.getMessage());
            }
        }
        @Test
        @DisplayName("Testing getRandom unit method on an empty army")
        public void testingGetRandomUnitMethodWithEmptyArmy() {
            try{
                Army testArmy = new Army("Alliance");
                //TEST
                assertThrows(NullPointerException.class,
                        testArmy::getRandom);
                //EXCEPTION THROWER
                testArmy.getRandom();
                fail("Should have thrown an exception");
            }catch (NullPointerException n){
                assertEquals("The getRandom method cannot return a random unit from an" +
                        " empty army list, please try again.", n.getMessage());
            }
        }
        //TODO: add equals????
    }
}
