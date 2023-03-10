import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeviTest {

    @Test
    void creatingNewLeviClass() {
        Levi kitten = new Levi("kitten");
        assertEquals(kitten, kitten);
    }
}
