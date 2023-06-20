class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList2 {
    Node2 head;

    void insert(int data) {
        Node2 newNode = new Node2(data);
        if (head == null) {
            head = newNode;
        } else {
            Node2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    Node2 reverseKNodes(Node2 head, int k) {
        Node2 current = head;
        Node2 next = null;
        Node2 prev = null;
        int count = 0;

        // Reverse first k nodes
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If there are remaining nodes, recursively reverse them
        if (next != null) {
            head.next = reverseKNodes(next, k);
        }

        return prev;
    }
}

public class ASSIGN133 {
    public static void main(String[] args) {
        LinkedList2 list2 = new LinkedList2();
        list2.insert(1);
        list2.insert(2);
        list2.insert(2);
        list2.insert(4);
        list2.insert(5);
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);

        System.out.println("Original List2:");
        list2.display();

        int k = 4;
        list2.head = list2.reverseKNodes(list2.head, k);

        System.out.println("List2 after reversing every " + k + " nodes:");
        list2.display();
    }
}
