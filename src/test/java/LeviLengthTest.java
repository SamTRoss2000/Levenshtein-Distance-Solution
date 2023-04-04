import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviLengthTest {

    private final String emptyString = "";
    String kittenString = "kitten";
    LeviLength kitten = new LeviLength(kittenString);

    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new LeviLength(kittenString));
    }

    @Test
    void differentClassesAreUnequal() {
        assertNotEquals(kitten, kittenString);
    }

    @Test
    void nullWordsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LeviLength(null);
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
    void emptyDistanceDefersToInputLength() {
        assertEquals(kittenString.length(), kitten.distance(emptyString));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        LeviLength emptyLevi = new LeviLength(emptyString);
        assertEquals(emptyString.length(), emptyLevi.distance(emptyString));
    }

    @Test
    void identicalStringsHaveNoDistance() {
        assertEquals(0, kitten.distance(kittenString));
    }

    @Test
    void distanceIncreasesBasedOnInputLengthDifference() {
        assertEquals(1, kitten.distance("kittens"));
        assertEquals(1, kitten.distance("kitte"));
    }

}
