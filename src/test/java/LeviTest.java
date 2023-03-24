import org.junit.jupiter.api.Assertions;
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
    void isLeviObjectNullCovered() {
        IllegalArgumentException nullLeviThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Levi(null);
        });
        assertEquals("The word within Levi cannot be null", nullLeviThrown.getMessage());
    }

    @Test
    void isDistanceMethodNullCovered() {
        IllegalArgumentException nullDistanceThrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            kitten.distance(null);
        });

        assertEquals("The distance method cannot accept null", nullDistanceThrown.getMessage());
    }

    @Test
    void usingTheDistanceMethodOnAnEmptyString() {
        assertEquals(6, kitten.distance(""));
    }

    @Test
    void comparingTwoEmptyStringsUsingTheDistanceMethod() {
        Levi emptyString = new Levi("");
        assertEquals(0, emptyString.distance(""));
    }

     @Test
    void doesTheDistanceMethodReturnZeroWhenIdenticalWords() {
        assertEquals(0, kitten.distance("kitten"));
    }

    @Test
    void compareLengthOfWords() {
        assertEquals(2, kitten.distance("kittenss"));
        assertEquals(1, kitten.distance("kittens"));
    }

    @Test
    void compareLengthOfShorterWordtoLonger() {
        Levi kittens = new Levi("kittens");
        assertEquals(1, kittens.distance("kitten"));
    }

    // Does the distance() method return 1 if only one letter differs between the words
    @Test
    void ifTheWordsAreEqualAfterTheFirstDifferenceReturnOne() {
        assertEquals(1, kitten.distance("kipten"));
        assertEquals(1, kitten.distance("mitten"));
    }

    // Does the distance() method count how many differing adjacent letters there are
    @Test
    void canMultipleDifferentLettersBeCounted() {
        assertEquals(2, kitten.distance("kanten"));
    }

    @Test
    void canDifferentLettersSeperatedByIdenticalLettersBeCounted() {
        assertEquals(3, kitten.distance("kantenn"));
    }

    // Next step is adding more coverage to this test for if the differing letters are separated
    // by identical letters
}
