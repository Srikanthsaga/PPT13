class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList4 {
    Node4 head;

    void insert(int data) {
        Node4 newNode = new Node4(data);
        if (head == null) {
            head = newNode;
        } else {
            Node4 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node4 current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    void deleteLastOccurrence(int key) {
        if (head == null)
            return;

        Node4 keyNode = null;
        Node4 current = head;
        Node4 prev = null;
        Node4 prevKeyNode = null;
        Node4 lastKeyNode = null;

        while (current != null) {
            if (current.data == key) {
                lastKeyNode = prevKeyNode;
                prevKeyNode = current;
            }
            prev = current;
            current = current.next;
        }

        // If the key node is found
        if (prevKeyNode != null) {
            // If it is the last node, update the previous node's next pointer
            if (prevKeyNode.next == null) {
                lastKeyNode.next = null;
            } else {
                // Otherwise, update the next pointer of the previous key node
                lastKeyNode.next = prevKeyNode.next;
            }
        }
    }
}

public class ASSIGN135 {
    public static void main(String[] args) {
        LinkedList4 list4 = new LinkedList4();
        list4.insert(1);
        list4.insert(2);
        list4.insert(3);
        list4.insert(5);
        list4.insert(2);
        list4.insert(10);

        System.out.println("Original List4:");
        list4.display();

        int key = 2;
        list4.deleteLastOccurrence(key);

        System.out.println("List4 after deleting last occurrence of " + key + ":");
        list4.display();
    }
}

