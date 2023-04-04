public class LeviCharacter implements LeviCalculator {
    private final String word;

    LeviCharacter(String word){
        if (word == null) throw new IllegalArgumentException("The word within Levi cannot be null");
        this.word = word;
    }

    public int distance(String secondWord) {
        if (secondWord == null) throw new IllegalArgumentException("The distance method cannot accept null");
        int result = 0;
        int shortestLength = Math.min(this.word.length(), secondWord.length());
        for (int i = 0; i < shortestLength; i++) {
            if (word.charAt(i) != secondWord.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;
        LeviCharacter object = (LeviCharacter) obj;
        return this.word.equals(object.word);
    }



}
