public class Levi {

    String word;

    Levi(String word) {
        if (word == null) throw new IllegalArgumentException("The word within Levi cannot be null");
        this.word = removeBlankSpaces(word);
    }

    int distance(String secondWord) {
        if (secondWord == null) throw new IllegalArgumentException("The distance method cannot accept null");
        secondWord = removeBlankSpaces(secondWord);
        if (this.word.equals(secondWord)) return 0;
        return calculateDistance(secondWord);
    }

    private int calculateDistance(String secondWord) {
        int diffCounter = calculateLengthDistance(secondWord);
        diffCounter += calculateCharacterDistance(secondWord);
        return diffCounter;
    }

    public int calculateCharacterDistance(String secondWord) {
        int result = 0;
        int shortestLength = Math.min(this.word.length(), secondWord.length());
        for (int i = 0; i < shortestLength; i++) {
            if (word.charAt(i) != secondWord.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public int calculateLengthDistance(String secondWord) {
        return Math.abs(secondWord.length() - this.word.length());
    }

    private String removeBlankSpaces(String word) {
        return word.replaceAll(" ", "");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;
        Levi object = (Levi) obj;
        return this.word.equals(object.word);
    }
}
