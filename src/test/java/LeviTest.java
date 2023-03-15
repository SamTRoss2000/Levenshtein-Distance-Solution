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
        assertEquals(kitten.distance("kitten"), 0);
    }

    @Test
    void compareLengthOfWords() {
        assertEquals(kitten.distance("kittenss"), 2);
        assertEquals(kitten.distance("kittens"), 1);
        Levi kittens = new Levi("kittens");
        assertEquals(kittens.distance("kitten"), 1);
    }

    @Test
    void doesTheForLoopStartAfterFirstDifference() {
        assertEquals(kitten.distance("mitten"), 6);
        assertEquals(4, kitten.distance("kippan"));
    }
}
