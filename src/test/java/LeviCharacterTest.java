import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviCharacterTest {

    String kittenString = "kitten";
    LeviCalculator kitten = new LeviCharacter(kittenString);

    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new LeviCharacter(kittenString));
    }

    @Test
    void differentClassesAreUnequal() {
        assertNotEquals(kitten, kittenString);
    }

    @Test
    void nullWordsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LeviCharacter(null);
        });
        assertEquals("The word within Levi cannot be null", nullLeviThrown.getMessage());
    }

    @Test
    void nullSecondWordsAreIllegalArgumentsForDistance() {
        IllegalArgumentException nullDistanceThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            kitten.distance(null);
        });

        assertEquals("The distance method cannot accept null", nullDistanceThrown.getMessage());
    }

    @Test
    void distanceIncreasesBasedOnCharacterDifference() {
        assertEquals(1, kitten.distance("kipten"));
        assertEquals(1, kitten.distance("mitten"));
        String adjacentCharacterDifference = "kanten";
        String nonAdjacentCharacterDifference = "kattin";
        assertEquals(2, kitten.distance(adjacentCharacterDifference));
        assertEquals(2, kitten.distance(nonAdjacentCharacterDifference));
    }
}
