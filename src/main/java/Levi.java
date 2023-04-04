import java.util.Arrays;
import java.util.List;

public class Levi implements LeviCalculator {

    List<LeviCalculator> calculators;
    Levi(List<LeviCalculator> calculators) {
        if (calculators == null) throw new IllegalArgumentException("The word within Levi cannot be null");
        this.calculators = calculators;
    }

    Levi(String word) {
        if (word == null) throw new IllegalArgumentException("The word within Levi cannot be null");
        String intermediary = removeBlankSpaces(word);
        intermediary = lowerCase(intermediary);
        calculators = Arrays.asList(
                new LeviLength(intermediary),
                new LeviCharacter(intermediary)
        );
    }

    public int distance(String secondWord) {
        if (secondWord == null) throw new IllegalArgumentException("The distance method cannot accept null");
        secondWord = removeBlankSpaces(secondWord);
        secondWord = lowerCase(secondWord);
        return calculateDistance(secondWord);
    }

    private int calculateDistance(String secondWord) {
        return calculators.stream()
                .mapToInt(leviCalculator -> leviCalculator.distance(secondWord))
                .sum();
    }

    private String removeBlankSpaces(String word) {
        return word.replaceAll(" ", "");
    }

    private String lowerCase(String secondWord) {
        return secondWord.toLowerCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;
        Levi object = (Levi) obj;
        return this.calculators.equals(object.calculators);
    }
}
