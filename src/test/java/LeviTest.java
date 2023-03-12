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
    void compareLengthOfStrings() {
        assertEquals(kitten.distance("kittenss"), 2);
    }
}
