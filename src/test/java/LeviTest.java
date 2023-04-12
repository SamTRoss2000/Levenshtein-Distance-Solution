import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeviTest {

    @Test
    void nullWordsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Levi.distance(null, "kitten");
        });
        assertEquals("The distance method cannot accept null", nullLeviThrown.getMessage());
    }

    @Test
    void nullSecondWordsAreIllegalArgumentsForDistance() {
        IllegalArgumentException nullDistanceThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Levi.distance("kitten", null);
        });

        assertEquals("The distance method cannot accept null", nullDistanceThrown.getMessage());
    }

    @Test
    void emptyDistanceDefersToInputLength() {
        String kittenString = "kitten";
        assertEquals(kittenString.length(), Levi.distance("kitten", ""));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        assertEquals(0, Levi.distance("emptyString" ,"emptyString"));
    }

    @Test
    void theDistanceMethodIgnoresBlankSpaces() {
        assertEquals(0, Levi.distance("kitten", "kit ten"));
        assertEquals(0, Levi.distance("kit ten", "kitten"));
    }

    @Test
    void theDistanceMethodIgnoresCapitalLetters() {
        assertEquals(0, Levi.distance("kitten", "Kitten"));
        assertEquals(0, Levi.distance("Kitten", "kitten"));
    }

    @Test
    void identicalStringsHaveNoDistance() {
        assertEquals(0, Levi.distance("kitten", "kitten"));
    }

    @Test
    void distanceIncreasesBasedOnInputLengthDifference() {
        assertEquals(1, Levi.distance("kitten", "kittens"));
        assertEquals(1, Levi.distance("kitten", "kitte"));
    }

    @Test
    void distanceIncreasesBasedOnCharacterDifference() {
        assertEquals(1, Levi.distance("kitten", "kipten"));
        assertEquals(1, Levi.distance("kitten", "mitten"));
        String adjacentCharacterDifference = "kanten";
        String nonAdjacentCharacterDifference = "kattin";
        assertEquals(2, Levi.distance("kitten", adjacentCharacterDifference));
        assertEquals(2, Levi.distance("kitten", nonAdjacentCharacterDifference));
    }

    // Does the distance() method return an accurate value when there are differing adjacent letters
    // and the words are of different lengths
    @Test
    void differenceReasonsCanBeCombined() {
        assertEquals(3, Levi.distance("kitten", "kantenn"));
        assertEquals(3, Levi.distance("kitten", "sitting"));
    }

    @Test
    void LeviNoInternalState() {
        assertEquals(1, Levi.distance("kitten", "kipten"));
    }
}
