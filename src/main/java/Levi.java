public class Levi {

    String word;

    Levi(String word) {
        this.word = word;
    }

     int distance(String secondWord) {
        if (this.word.equals(secondWord)) return 0;
        if (this.word.length() != secondWord.length())
            return Math.abs(secondWord.length() - this.word.length());
        return 1;
    }
}
