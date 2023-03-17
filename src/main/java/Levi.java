import org.apache.commons.lang3.StringUtils;

public class Levi {

    String word;

    Levi(String word) {
        this.word = word;
    }

     int distance(String secondWord) {
        if (this.word.equals(secondWord)) return 0;
        if (this.word.length() != secondWord.length())
            return Math.abs(secondWord.length() - this.word.length());

         String diffSecondWord = StringUtils.difference(this.word, secondWord);
         String diffOriginalWord = StringUtils.difference(secondWord, this.word);
            if (diffOriginalWord.substring(1).equals(diffSecondWord.substring(1))) {
                return 1;
            }
         return 10;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        Levi object = (Levi) obj;
        return this.word.equals(object.word);
    }
}
