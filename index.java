/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structreproject;
public class index {
    LinkedList<Document> allDocs;

    public index() {
        allDocs = new LinkedList<Document>();
    }

    public void addDocument(Document d) {
        allDocs.insert(d);
    }

    public void displayDocuments() {
        if (allDocs == null) {
            System.out.println("No documents found");
            return;
        } else if (allDocs.empty()) {
            System.out.println("Empty documents");
            return;
        }

        allDocs.findFirst();

        while (!allDocs.last()) {
            Document doc = allDocs.retrieve();
            System.out.println("ID: " + doc.id);
            System.out.println("The content of this document:");
            doc.words.print();
            System.out.println("\n___________________________");
            allDocs.findNext();
        }

        Document doc = allDocs.retrieve();
        System.out.println("\n_______________________________");
        System.out.println("ID: " + doc.id);
        doc.words.print();
    }
}
