/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package structreproject;
public class IndexManager {

    public static void main(String[] args) {
        // Initialize InvertedIndex
        InvertedIndex invertedIndex = new InvertedIndex();

        // Process the documents in the CSV file
        String filePath = "C:\\Users\\mjdsa\\OneDrive\\Desktop\\dataset.csv";
        processDocuments(filePath, invertedIndex);

        // Display the content of the inverted index after processing
        invertedIndex.displayInvertedIndex();
    }

    // This method should be responsible for processing documents and indexing words.
    public static void processDocuments(String filePath, InvertedIndex invertedIndex) {
        CustomFileReader.processDocuments(filePath);  // Call to the CustomFileReader to process documents
    }
}
