import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviLengthTest {

    private final String EMPTY_STRING = "";
    String KITTEN_STRING = "kitten";
    LeviLength kitten = new LeviLength(KITTEN_STRING);

    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new LeviLength(KITTEN_STRING));
    }

    @Test
    void differentClassesAreUnequal() {
        assertNotEquals(kitten, KITTEN_STRING);
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
        assertEquals(KITTEN_STRING.length(), kitten.distance(EMPTY_STRING));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        LeviLength emptyLevi = new LeviLength(EMPTY_STRING);
        assertEquals(EMPTY_STRING.length(), emptyLevi.distance(EMPTY_STRING));
    }

    @Test
    void identicalStringsHaveNoDistance() {
        assertEquals(0, kitten.distance(KITTEN_STRING));
    }

    @Test
    void distanceIncreasesBasedOnInputLengthDifference() {
        assertEquals(1, kitten.distance("kittens"));
        assertEquals(1, kitten.distance("kitte"));
    }

}
