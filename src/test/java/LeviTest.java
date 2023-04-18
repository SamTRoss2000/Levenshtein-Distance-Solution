import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviTest {

    private final static String EMPTY_STRING = "";
    private final static String KITTEN_STRING = "kitten";
    Levi kitten = new Levi(KITTEN_STRING);  // could be a Levi calculator
    LeviCalculator container = new Levi(List.of(new LeviLength(KITTEN_STRING)));
    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new Levi(KITTEN_STRING));
        assertNotEquals(kitten, container);
    }

    @Test
    void differentClassesAreUnequal() {
        assertNotEquals(kitten, KITTEN_STRING);
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
        assertEquals(KITTEN_STRING.length(), kitten.distance(EMPTY_STRING));
        assertEquals(KITTEN_STRING.length(), container.distance(EMPTY_STRING));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        Levi emptyLevi = new Levi(EMPTY_STRING);
        assertEquals(EMPTY_STRING.length(), emptyLevi.distance(EMPTY_STRING));
    }

    @Test
    void theDistanceMethodIgnoresBlankSpaces() {
        assertEquals(0, kitten.distance("kit ten"));
        Levi kittenWithSpace = new Levi("kit ten");
        assertEquals(0, kittenWithSpace.distance(KITTEN_STRING));
    }

    @Test
    void theDistanceMethodIgnoresCapitalLetters() {
        assertEquals(0, kitten.distance("Kitten"));
        Levi kittenCapitalCase = new Levi("Kitten");
        assertEquals(0,kittenCapitalCase.distance(KITTEN_STRING));
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
