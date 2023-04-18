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
    void nullWordsAreTreatedAsEmptyStrings() {
        String NULL_STRING = null;
        Levi nullWord = new Levi(NULL_STRING);
        assertEquals(6, nullWord.distance(KITTEN_STRING));
    }
    @Test
    void nullSecondWordsAreTreatedAsEmptyStrings() {
        assertEquals(6, kitten.distance(null));
    }

    @Test
    void nullCalculatorsAreIllegalArguments() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Levi((List<LeviCalculator>) null);
        });
        assertEquals("The word within Levi cannot be null", nullLeviThrown.getMessage());
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
        String ADJACENT_CHARACTER_DIFF = "kanten";
        String NON_ADJACENT_CHARACTER_DIFF = "kattin";
        assertEquals(2, kitten.distance(ADJACENT_CHARACTER_DIFF));
        assertEquals(2, kitten.distance(NON_ADJACENT_CHARACTER_DIFF));
    }

    // Does the distance() method return an accurate value when there are differing adjacent letters
    // and the words are of different lengths
    @Test
    void differenceReasonsCanBeCombined() {
        assertEquals(3, kitten.distance("kantenn"));
        assertEquals(3, kitten.distance("sitting"));
    }
}
