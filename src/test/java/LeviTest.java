import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeviTest {

    Levi kitten = new Levi("kitten");

    @Test
    void creatingNewLeviClass() {
        assertEquals(kitten, kitten);
    }

     @Test
    void doesTheDistanceMethodReturnZeroWhenIdenticalWords() {
        assertEquals(kitten.distance("kitten"), 0);
    }

    @Test
    void doesNotReturnZeroIfWordsAreDifferent() {
        assertEquals(kitten.distance("mitten"), 1);
    }

    @Test
    void compareLengthOfWords() {
        assertEquals(kitten.distance("kittenss"), 2);
        assertEquals(kitten.distance("kittens"), 1);
        Levi kittens = new Levi("kittens");
        assertEquals(kittens.distance("kitten"), 1);
    }
}
