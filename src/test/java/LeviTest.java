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

    @Test
    void doesTheForLoopStartAfterFirstDifference() {
        assertEquals(6, kitten.distance("mitten"));
        assertEquals(4, kitten.distance("kippan"));
    }
}
