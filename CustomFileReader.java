package structreproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CustomFileReader {

    private static final HashSet<String> stopWords = new HashSet<>();
    
    public static void main(String[] args) {
        loadStopWords("C:\\Users\\mjdsa\\OneDrive\\Desktop\\stop.txt"); // Load stop words

        String filePath = "C:\\Users\\mjdsa\\OneDrive\\Desktop\\dataset.csv";
        processDocuments(filePath); // Process the documents in the file
    }

    private static void loadStopWords(String stopFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(stopFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processDocuments(String filePath) {
        // Create an instance of the InvertedIndex class
        InvertedIndex invertedIndex = new InvertedIndex();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();

            String line;
            int documentID = 0;  // Start document ID from 0

            // Process each line (representing a document)
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                String[] values = line.split(",");
                if (values.length >= 2) {
                    String content = values[1].toLowerCase();  // Document content

                    // Create a new LinkedList for the current document's words
                    LinkedList<String> wordList = new LinkedList<>();  

                    // Split content into words and process each word
                    for (String word : content.split("\\s+")) {
                        word = word.replaceAll("[^a-zA-Z0-9]", "");  // Remove punctuation
                        if (!stopWords.contains(word) && !word.isEmpty()) {
                            wordList.insert(word);  // Insert the word into the wordList
                        }
                    }

                    // Manually iterate through the wordList and add each word to the inverted index
                    wordList.findFirst(); // Start at the first element
                    while (!wordList.last()) {
                        String word = wordList.retrieve();  // Get the current word
                        invertedIndex.add(word, documentID);  // Add the word and documentID to the inverted index
                        wordList.findNext();  // Move to the next word
                    }

                    // Increment the document ID for the next document
                    documentID++;
                }
            }

            // Print the inverted index to verify the content
            invertedIndex.displayInvertedIndex();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}