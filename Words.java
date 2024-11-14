/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structreproject;
class Words {
    String text;
    LinkedList<Integer> docID;

    public Words(String word) {
        this.text = word;
        docID = new LinkedList<>();
    }

    public void addId(int id) {
        if (!existsInDocID(id)) {
            docID.insert(id);
        }
    }

    public boolean existsInDocID(Integer id) {
        if (docID.empty()) return false;

        docID.findFirst();
        while (!docID.last()) {
            if (docID.retrieve().equals(id)) {
                return true;
            }
            docID.findNext();
        }

        return docID.retrieve().equals(id);
    }
}