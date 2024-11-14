/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structreproject;

class Document {
    int id;
    LinkedList<String> words;

    public Document(int id, LinkedList<String> words) {
        this.id = id;
        this.words = words;
    }
}