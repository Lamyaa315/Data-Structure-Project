package structreproject;


class InvertedIndex {

    private LinkedList<Words> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new LinkedList<>();
    }

    public void add(String word, int documentID) {
        if (!searchWordInverted(word)) {
            Words newWord = new Words(word);
            newWord.addId(documentID);
            invertedIndex.insert(newWord);
        } else {
            Words existingWord = invertedIndex.retrieve();
            existingWord.addId(documentID);
        }
    }

    public boolean searchWordInverted(String word) {
        if (invertedIndex.empty()) return false;

        invertedIndex.findFirst();
        while (!invertedIndex.last()) {
            if (invertedIndex.retrieve().text.equals(word)) {
                return true;
            }
            invertedIndex.findNext();
        }

        return invertedIndex.retrieve().text.equals(word);
    }

    public void displayInvertedIndex() {
        if (invertedIndex.empty()) {
            System.out.println("Inverted index is empty.");
            return;
        }

        invertedIndex.findFirst();
        while (!invertedIndex.last()) {
            Words word = invertedIndex.retrieve();
            System.out.print("Word: " + word.text + "[");
            word.docID.print();
         System.out.print("]");
            invertedIndex.findNext();
        }

        Words lastWord = invertedIndex.retrieve();
        System.out.print("Word: " + lastWord.text);
        lastWord.docID.print();
        System.out.print("]");
    }
}