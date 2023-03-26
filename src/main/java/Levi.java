import org.apache.commons.lang3.StringUtils;

public class Levi {

    String word;
    int diffLength;


    Levi(String word) {
        if (word == null) throw new IllegalArgumentException("The word within Levi cannot be null");
        this.word = word;
    }

     int distance(String secondWord) {
        if (secondWord == null) throw new IllegalArgumentException("The distance method cannot accept null");
        this.word = removeBlankSpaces(this.word);
        secondWord = removeBlankSpaces(secondWord);
        if (this.word.equals(secondWord)) return 0;
        int diffCounter = 0;
        if (this.word.length() != secondWord.length()) {
            diffLength = Math.abs(secondWord.length() - this.word.length());
            diffCounter = diffCounter + diffLength;
        }
        if (this.word.length() > secondWord.length()) {
            this.word = reduceWordLength(this.word);
        }
        if (this.word.length() < secondWord.length()) {
            secondWord = reduceWordLength(secondWord);
        }

         String diffSecondWord = StringUtils.difference(this.word, secondWord);
         String diffOriginalWord = StringUtils.difference(secondWord, this.word);
         for (int i = 0; i < diffSecondWord.length(); i++) {
             if (!diffOriginalWord.substring(i, i+1).equals(diffSecondWord.substring(i, i+1))) {
                 diffCounter = diffCounter + 1;
             }
         }
         return diffCounter;
    }

    private String removeBlankSpaces(String word) {
        return word.replaceAll(" ", "");
    }

    private String reduceWordLength(String word) {
        return word.substring(0, (word.length() - diffLength));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        Levi object = (Levi) obj;
        return this.word.equals(object.word);
    }
}
