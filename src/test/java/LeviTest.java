import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeviTest {

    Levi kitten = new Levi("kitten");

    @Test
    void creatingNewLeviClass() {
        assertEquals(kitten, kitten);
    }

    // Next - add another test that forces comparing equality of the word & secondWord
    @Test
    void doesTheDistanceMethodReturnAnInteger() {
        assertEquals(kitten.distance("kitten"), 0);
    }
}
