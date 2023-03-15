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

         String diffLetters = StringUtils.difference(this.word, secondWord);
         int count = 0;
         for(int i = diffLetters.length(); i > 0; i--) {
             count = count + 1;
         }
         return count;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        Levi object = (Levi) obj;
        return this.word.equals(object.word);
    }
}
