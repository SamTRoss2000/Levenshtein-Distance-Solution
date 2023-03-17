import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeviTest {

    Levi kitten = new Levi("kitten");

    @Test
    void creatingNewLeviClass() {
        assertEquals(kitten, new Levi("kitten"));
    }

    @Test
    void areDifferentClassesInequal() {
        assertNotEquals(kitten, "kitten");
    }

     @Test
    void doesTheDistanceMethodReturnZeroWhenIdenticalWords() {
        assertEquals(0, kitten.distance("kitten"));
    }

    @Test
    void compareLengthOfWords() {
        assertEquals(2, kitten.distance("kittenss"));
        assertEquals(1, kitten.distance("kittens"));
        Levi kittens = new Levi("kittens");
        assertEquals(1, kittens.distance("kitten"));
    }

    // Does the distance() method return 1 if only one letter differs between the words
    @Test
    void ifTheWordsAreEqualAfterTheFirstDifferenceReturnOne() {
        assertEquals(1, kitten.distance("kipten"));
        assertEquals(1, kitten.distance("mitten"));
    }
}
