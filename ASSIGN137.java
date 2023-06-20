class Node6 {
    int data;
    Node6 prev;
    Node6 next;

    Node6(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class LinkedList6 {
    Node6 head;

    void insert(int data) {
        Node6 newNode = new Node6(data);
        if (head == null) {
            head = newNode;
        } else {
            Node6 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    void display() {
        Node6 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void reverse() {
        Node6 temp = null;
        Node6 current = head;

        // Swap prev and next pointers for all nodes of the doubly linked list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Check if the list is empty or only has one node
        if (temp != null) {
            head = temp.prev;
        }
    }
}

public class ASSIGN137 {
    public static void main(String[] args) {
        LinkedList6 list6 = new LinkedList6();
        list6.insert(10);
        list6.insert(8);
        list6.insert(4);
        list6.insert(2);

        System.out.println("Original Linked List:");
        list6.display();

        list6.reverse();

        System.out.println("Reversed Linked List:");
        list6.display();
    }
}
