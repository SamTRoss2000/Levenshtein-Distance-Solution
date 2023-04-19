import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviLengthTest {
    
    LeviLength kitten = new LeviLength(StringConstants.KITTEN_STRING);

    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new LeviLength(StringConstants.KITTEN_STRING));
    }

    @Test
    void differentClassesAreUnequal() {
        assertNotEquals(kitten, StringConstants.KITTEN_STRING);
    }

    @Test
    void nullWordsAreTreatedAsEmptyStrings() {
        String NULL_STRING = null;
        LeviLength nullWord = new LeviLength(NULL_STRING);
        assertEquals(6, nullWord.distance(StringConstants.KITTEN_STRING));
    }

    @Test
    void nullSecondWordsAreTreatedAsEmptyStrings() {
        assertEquals(6, kitten.distance(null));
    }

    @Test
    void emptyDistanceDefersToInputLength() {
        assertEquals(StringConstants.KITTEN_STRING.length(), kitten.distance(StringConstants.EMPTY_STRING));
    }

    @Test
    void emptyStringsHaveNoDistance() {
        LeviLength emptyLevi = new LeviLength(StringConstants.EMPTY_STRING);
        assertEquals(StringConstants.EMPTY_STRING.length(), emptyLevi.distance(StringConstants.EMPTY_STRING));
    }

    @Test
    void identicalStringsHaveNoDistance() {
        assertEquals(0, kitten.distance(StringConstants.KITTEN_STRING));
    }

    @Test
    void distanceIncreasesBasedOnInputLengthDifference() {
        assertEquals(1, kitten.distance("kittens"));
        assertEquals(1, kitten.distance("kitte"));
    }

}
