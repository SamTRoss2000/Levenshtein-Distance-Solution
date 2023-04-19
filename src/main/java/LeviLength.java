public class LeviLength implements LeviCalculator {

    private final String word;

    LeviLength(String word){
        if (word == null) word = "";
        this.word = word;
    }

    public int distance(String secondWord) {
        if (secondWord == null) secondWord = "";
        return Math.abs(secondWord.length() - this.word.length());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;
        LeviLength object = (LeviLength) obj;
        return this.word.equals(object.word);
    }

}
