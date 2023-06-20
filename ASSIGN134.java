class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList3 {
    Node3 head;

    void insert(int data) {
        Node3 newNode = new Node3(data);
        if (head == null) {
            head = newNode;
        } else {
            Node3 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node3 current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    Node3 reverseAlternateKNodes(Node3 head, int k) {
        Node3 current = head;
        Node3 next = null;
        Node3 prev = null;
        int count = 0;

        // Reverse first k nodes
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If there are remaining nodes, skip k nodes
        if (current != null) {
            head.next = current;
            count = 0;
            while (count < k - 1 && current != null) {
                current = current.next;
                count++;
            }
            if (current != null) {
                current.next = reverseAlternateKNodes(current.next, k);
            }
        }

        return prev;
    }
}

public class ASSIGN134 {
    public static void main(String[] args) {
        LinkedList3 list3 = new LinkedList3();
        list3.insert(1);
        list3.insert(2);
        list3.insert(3);
        list3.insert(4);
        list3.insert(5);
        list3.insert(6);
        list3.insert(7);
        list3.insert(8);
        list3.insert(9);

        System.out.println("Original List3:");
        list3.display();

        int k = 3;
        list3.head = list3.reverseAlternateKNodes(list3.head, k);

        System.out.println("List3 after reversing every alternate " + k + " nodes:");
        list3.display();
    }
}
