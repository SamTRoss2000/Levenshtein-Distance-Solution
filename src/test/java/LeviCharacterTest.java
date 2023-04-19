import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviCharacterTest {
    
    LeviCharacter kitten = new LeviCharacter(StringConstants.KITTEN_STRING);

    @Test
    void identicalLeviObjectsAreEqual() {
        assertEquals(kitten, new LeviCharacter(StringConstants.KITTEN_STRING));
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
        assertEquals(0, kitten.distance(null));
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
