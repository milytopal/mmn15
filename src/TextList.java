import java.util.ArrayList;

public class TextList {
    private WordNode  _headOfList;

    public TextList()
    {
        // initialise instance variables
        this._headOfList= null;
    }
    public TextList(String text) {
        // this._headOfList = new WordNode("",null);
        this._headOfList = null;
        if (text.isEmpty())
            return;
        String splitedWord = "";

        for (int i = 0, j = 0; i < text.length(); ) {
            int EndOfWord = text.indexOf(' ');
            if (EndOfWord != -1) {
                splitedWord = text.substring(0, EndOfWord);
                addToData(splitedWord);
            }
            i = text.indexOf(' ');
            text = text.substring(EndOfWord + 1);
        }
    }
//            if(text.charAt(i) == ' ')
//            {
//                toReturn[j++] = word;
//                word = "";
//            }
//
//            if(text.charAt(i) != ' ')
//                word += text.charAt(i);


//        while (!text.isEmpty())
//        {
//            int EndOfWord = text.indexOf(' ');
//            if (EndOfWord != -1)
//                addToData(text.substring(0, EndOfWord));
//            else {
//                addToData(text);         // in case there are no spaces left in the text string
//                continue;
//            }
//            if(text.length()>1)          // check if there any chars left to cut
//                text = text.substring(EndOfWord+1);
//        }
//    }

//            if(text.length()>1)          // check if there any chars left to cut
//                text = text.substring(EndOfWord+1);
//            for (String ss : MySplit(text))
//            {
//                if(ss != null)
//                    addToData(ss);
//            }
//    }
//
//    private String[] MySplit(String text) {
//        String[] toReturn = new String[10];
//        String word = "";
//        for(int i = 0, j = 0 ; i < text.length() ; i++)
//        {
//            if(text.charAt(i) == ' ')
//            {
//                toReturn[j++] = word;
//                word = "";
//            }
//
//            if(text.charAt(i) != ' ')
//                word += text.charAt(i);
//        }
//
//        return toReturn;
//    }

    /**
     * this method adds a word to the list
     * @param word
     */
    public void addToData (String word)
    {
        if(this._headOfList == null) {        // the list is empty
            this._headOfList = new WordNode(word, this._headOfList);
            return;
        }
        // if the list is not empty continue
        WordNode ptrCurrent = _headOfList;
        WordNode ptrPrevious = null;
        while(ptrCurrent!= null && (ptrCurrent.getWord().compareTo(word) < 0) && ptrCurrent.getNext() != null ) {
            // if the new word is after the current word
            ptrPrevious = ptrCurrent;
            ptrCurrent = ptrCurrent.getNext();

         //   debug(ptrCurrent.getWord(), word);
        }
        if(ptrCurrent.getWord().compareTo(word) == 0)       //the new word is already in the list -> increase count only
        {
            ptrCurrent.addAppearance();
            // in this point the new word is before the current word

          //  debug(ptrCurrent.getWord(), word);

        }
        else if(ptrCurrent.getWord().compareTo(word) > 0)        //only in case the new word becomes the new head of the list)
        {
          //  debug(ptrCurrent.getWord(), word);

            if(ptrPrevious!=null)
                ptrPrevious.setNext(new WordNode(word , ptrCurrent));
            else
            {
                WordNode node = new WordNode(word, ptrCurrent);
                this._headOfList = node;
            }
        }
        else
        {
          //  debug(ptrCurrent.getWord(), word);

            WordNode node = new WordNode(word, null);
            ptrCurrent.setNext(node);
        }

    }

    private void debug(String current, String word){
        System.out.println("Current ->" + current + "\nword -> " + word + "\ncompare -> " + current.compareTo(word));
    }

    private boolean lecsicographicOrderResult(String currentWord, String newWord)
    {
        if(currentWord.compareTo(newWord) < 0)
            return true;
        else if(currentWord.compareTo(newWord) > 0)
            return false;
        else
            return false;

    }

    public int howManyWords ()
    {
        WordNode ptrCurrent;
        int sumOfWords = 0;
        for(ptrCurrent=this._headOfList; ptrCurrent!= null; ptrCurrent=ptrCurrent.getNext())
            sumOfWords+= ptrCurrent.getNumberOfAppearances();
        return sumOfWords;
    }

    /**
     * this method returns the number of different words in a text.
     * because the list contains the different words from the text (there are no different nodes containing the same word)
     * the method counts the number of word nodes in the list.
     * @return - integer representing the number of different words
     */
    public int howManyDifferentWords ()
    {
        WordNode ptrCurrent;
        int count = 0;
        for(ptrCurrent = _headOfList; ptrCurrent!=null;ptrCurrent = ptrCurrent.getNext())
            count++;
        return count;
    }
    public String mostFrequentWord ()
    {
        WordNode ptrCurrent=this._headOfList;
        String MostFrequentWord = "";
        if(ptrCurrent == null)
            return "";
        int MostFrequentAppeared=0;
        for(ptrCurrent = _headOfList; ptrCurrent!=null;ptrCurrent = ptrCurrent.getNext())
            if(MostFrequentAppeared < ptrCurrent.getNumberOfAppearances())
                MostFrequentWord = ptrCurrent.getWord();
        return MostFrequentWord;
    }
//    public int howManyStarting (char letter)
//    {
//        WordNode ptr;
//        int count = 0;
//        for(ptr = _headOfList; ptr!=null;ptr = ptr.getNext())
//            count++;
//        return count;
//    }
 //   public char mostFrequentStartingLetter ()
 //   {
//
 //   }
    public String toString()
    {
        String tmpStr = "";
        WordNode ptr;
        for(ptr = this._headOfList; ptr!=null;ptr = ptr.getNext())
        {
            tmpStr = tmpStr + ptr.getWord() + "\t" + ptr.getNumberOfAppearances() + "\n";
        }
        return tmpStr;
    }
}
