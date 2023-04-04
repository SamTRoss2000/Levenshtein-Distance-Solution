import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviTest {

    private final String emptyString = "";
    String kittenString = "kitten";
    Levi kitten = new Levi(kittenString);  // could be a Levi calculator
    LeviCalculator container = new Levi(List.of(new LeviLength(kittenString)));
    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new Levi(kittenString));
        assertNotEquals(kitten, container);
    }

    @Test
    void differentClassesAreUnequal() {
        assertNotEquals(kitten, kittenString);
    }

    @Test
    void nullWordsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Levi((String) null);
        });
        assertEquals("The word within Levi cannot be null", nullLeviThrown.getMessage());
    }


    @Test
    void nullCalculatorsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Levi((List<LeviCalculator>) null);
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
        assertEquals(kittenString.length(), container.distance(emptyString));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        Levi emptyLevi = new Levi(emptyString);
        assertEquals(emptyString.length(), emptyLevi.distance(emptyString));
    }

    @Test
    void theDistanceMethodIgnoresBlankSpaces() {
        assertEquals(0, kitten.distance("kit ten"));
        Levi kittenWithSpace = new Levi("kit ten");
        assertEquals(0, kittenWithSpace.distance(kittenString));
    }

    @Test
    void theDistanceMethodIgnoresCapitalLetters() {
        assertEquals(0, kitten.distance("Kitten"));
        Levi kittenCapitalCase = new Levi("Kitten");
        assertEquals(0,kittenCapitalCase.distance(kittenString));
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

    @Test
    void distanceIncreasesBasedOnCharacterDifference() {
        assertEquals(1, kitten.distance("kipten"));
        assertEquals(1, kitten.distance("mitten"));
        String adjacentCharacterDifference = "kanten";
        String nonAdjacentCharacterDifference = "kattin";
        assertEquals(2, kitten.distance(adjacentCharacterDifference));
        assertEquals(2, kitten.distance(nonAdjacentCharacterDifference));
    }

    // Does the distance() method return an accurate value when there are differing adjacent letters
    // and the words are of different lengths
    @Test
    void differenceReasonsCanBeCombined() {
        assertEquals(3, kitten.distance("kantenn"));
        assertEquals(3, kitten.distance("sitting"));
    }
}
