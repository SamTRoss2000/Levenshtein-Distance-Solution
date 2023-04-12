public class Levi {

    static int distance(String word, String secondWord) {
        if (word == null || secondWord == null) throw new IllegalArgumentException("The distance method cannot accept null");
        word = removeBlankSpaces(word);
        secondWord = removeBlankSpaces(secondWord);
        word = lowerCase(word);
        secondWord = lowerCase(secondWord);
        if (word.equals(secondWord)) return 0;
        return calculateDistance(word, secondWord);
    }
    static private int calculateDistance(String word, String secondWord) {
        int diffCounter = calculateLengthDistance(word, secondWord);
        diffCounter += calculateCharacterDistance(word, secondWord);
        return diffCounter;
    }

    static public int calculateLengthDistance(String word, String secondWord) {
        return Math.abs(secondWord.length() - word.length());
    }

    static int calculateCharacterDistance(String word, String secondWord) {
        int result = 0;
        int shortestLength = Math.min(word.length(), secondWord.length());
        for (int i = 0; i < shortestLength; i++) {
            if (word.charAt(i) != secondWord.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    static private String removeBlankSpaces(String word) {
        return word.replaceAll(" ", "");
    }

    static private String lowerCase(String secondWord) {
        return secondWord.toLowerCase();
    }
}
