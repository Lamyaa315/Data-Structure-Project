package structreproject;

class LinkedList<T> {

    private Node<T> head;
    private Node<T> current;

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T val) {
            data = val;
            next = null;
        }
    }

    public LinkedList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        if (current != null) {
            current = current.next;
        }
    }

    public T retrieve() {
        return current != null ? current.data : null;
    }

    public void insert(T val) {
        Node<T> tmp;
        if (empty()) {
            current = head = new Node<T>(val);
        } else {
            tmp = current.next;
            current.next = new Node<T>(val);
            current = current.next;
            current.next = tmp;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("There are no nodes in the list");
            return;
        }
        Node<T> n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println(); // New line after the list is printed
    }
}
