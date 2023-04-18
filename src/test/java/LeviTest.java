import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeviTest {
    private final static String KITTEN_STRING = "kitten";
    @Test
    void nullWordsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Levi.distance(null, KITTEN_STRING);
        });
        assertEquals("The distance method cannot accept null", nullLeviThrown.getMessage());
    }

    @Test
    void nullSecondWordsAreIllegalArgumentsForDistance() {
        IllegalArgumentException nullDistanceThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Levi.distance(KITTEN_STRING, null);
        });

        assertEquals("The distance method cannot accept null", nullDistanceThrown.getMessage());
    }

    @Test
    void emptyDistanceDefersToInputLength() {
        String kittenString = KITTEN_STRING;
        assertEquals(kittenString.length(), Levi.distance(KITTEN_STRING, ""));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        assertEquals(0, Levi.distance("emptyString" ,"emptyString"));
    }

    @Test
    void theDistanceMethodIgnoresBlankSpaces() {
        assertEquals(0, Levi.distance(KITTEN_STRING, "kit ten"));
        assertEquals(0, Levi.distance("kit ten", KITTEN_STRING));
    }

    @Test
    void theDistanceMethodIgnoresCapitalLetters() {
        assertEquals(0, Levi.distance(KITTEN_STRING, "Kitten"));
        assertEquals(0, Levi.distance("Kitten", KITTEN_STRING));
    }

    @Test
    void identicalStringsHaveNoDistance() {
        assertEquals(0, Levi.distance(KITTEN_STRING, KITTEN_STRING));
    }

    @Test
    void distanceIncreasesBasedOnInputLengthDifference() {
        assertEquals(1, Levi.distance(KITTEN_STRING, "kittens"));
        assertEquals(1, Levi.distance(KITTEN_STRING, "kitte"));
    }

    @Test
    void distanceIncreasesBasedOnCharacterDifference() {
        assertEquals(1, Levi.distance(KITTEN_STRING, "kipten"));
        assertEquals(1, Levi.distance(KITTEN_STRING, "mitten"));
        String adjacentCharacterDifference = "kanten";
        String nonAdjacentCharacterDifference = "kattin";
        assertEquals(2, Levi.distance(KITTEN_STRING, adjacentCharacterDifference));
        assertEquals(2, Levi.distance(KITTEN_STRING, nonAdjacentCharacterDifference));
    }

    // Does the distance() method return an accurate value when there are differing adjacent letters
    // and the words are of different lengths
    @Test
    void differenceReasonsCanBeCombined() {
        assertEquals(3, Levi.distance(KITTEN_STRING, "kantenn"));
        assertEquals(3, Levi.distance(KITTEN_STRING, "sitting"));
    }
}
