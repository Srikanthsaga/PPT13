class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList1 {
    Node1 head;

    void insert(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
        } else {
            Node1 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node1 current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node1 current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
}

public class ASSIGN132 {
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.insert(11);
        list.insert(11);
        list.insert(11);
        list.insert(21);
        list.insert(43);
        list.insert(43);
        list.insert(60);

        System.out.println("Original List:");
        list.display();

        System.out.println("List after removing duplicates:");
        list.removeDuplicates();
        list.display();
    }
}
