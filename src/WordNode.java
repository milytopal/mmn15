public class WordNode {
    private WordNode _next;
    private String _word;
    private int _numberOfAppearances;

    /**
     * a constructor for Word Node, witch gets a string (the word) and the value of the next word node
     * @param word - a given string representing a word
     * @param next - pointer to the next word node
     */
    public WordNode(String word, WordNode next)
    {
        // initialise instance variables
        this._word = word;
        this._next = next;
        if(word.isEmpty())
            this._numberOfAppearances = 0;                   // if the word constructed it at list one appearance
        else
            this.addAppearance();
    }

    public WordNode getNext() {
        return _next;
    }

    public String getWord() {
        return _word;
    }

    public void setNext(WordNode next) {
        this._next = next;
    }

    public void setWord(String word) {
        this._word = word;
    }

    public int getNumberOfAppearances() {
        return _numberOfAppearances;
    }


    public void addAppearance() {
        this._numberOfAppearances+=1;
    }
}
