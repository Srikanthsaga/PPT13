class Node7 {
    int data;
    Node7 prev;
    Node7 next;

    Node7(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class LinkedList7 {
    Node7 head;

    void insert(int data) {
        Node7 newNode = new Node7(data);
        if (head == null) {
            head = newNode;
        } else {
            Node7 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    void display() {
        Node7 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void deleteNode(int position) {
        if (head == null)
            return;

        Node7 current = head;

        // If head needs to be removed
        if (position == 1) {
            head = current.next;
            if (head != null)
                head.prev = null;
            return;
        }

        // Find the node to be deleted
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        // If node was not found
        if (current == null)
            return;

        // Update the pointers
        if (current.prev != null)
            current.prev.next = current.next;
        if (current.next != null)
            current.next.prev = current.prev;
    }
}

public class ASSIGN138 {
    public static void main(String[] args) {
        LinkedList7 list7 = new LinkedList7();
        list7.insert(1);
        list7.insert(3);
        list7.insert(4);

        System.out.println("Original Doubly Linked List:");
        list7.display();

        int position = 3;
        list7.deleteNode(position);

        System.out.println("Doubly Linked List after deleting node at position " + position + ":");
        list7.display();
    }
}
