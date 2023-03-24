import org.apache.commons.lang3.StringUtils;

public class Levi {

    String word;

    Levi(String word) {
        if (word == null) throw new IllegalArgumentException("The word within Levi cannot be null");
        this.word = word;
    }

     int distance(String secondWord) {
        if (secondWord == null) throw new IllegalArgumentException("The distance method cannot accept null");
        if (this.word.equals(secondWord)) return 0;
        if (this.word.length() != secondWord.length())
            return Math.abs(secondWord.length() - this.word.length());

         String diffSecondWord = StringUtils.difference(this.word, secondWord);
         String diffOriginalWord = StringUtils.difference(secondWord, this.word);
         for (int i = 1; i < diffSecondWord.length(); i++) {
             if (diffOriginalWord.substring(i).equals(diffSecondWord.substring(i))) {
                 return i;
             }
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
