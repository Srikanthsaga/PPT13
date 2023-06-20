class Node5 {
    int data;
    Node5 next;

    Node5(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList5 {
    Node5 head;

    void insert(int data) {
        Node5 newNode = new Node5(data);
        if (head == null) {
            head = newNode;
        } else {
            Node5 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node5 current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    Node5 mergeLists(Node5 a, Node5 b) {
        // Base cases
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node5 result;
        // Pick either a or b and recur
        if (a.data <= b.data) {
            result = a;
            result.next = mergeLists(a.next, b);
        } else {
            result = b;
            result.next = mergeLists(a, b.next);
        }
        return result;
    }
}

public class ASSIGN136 {
    public static void main(String[] args) {
        LinkedList5 list5 = new LinkedList5();
        list5.insert(5);
        list5.insert(10);
        list5.insert(15);

        LinkedList5 list6 = new LinkedList5();
        list6.insert(2);
        list6.insert(3);
        list6.insert(20);

        System.out.println("List5:");
        list5.display();

        System.out.println("List6:");
        list6.display();

        Node5 mergedHead = list5.mergeLists(list5.head, list6.head);

        LinkedList5 mergedList = new LinkedList5();
        mergedList.head = mergedHead;

        System.out.println("Merged List:");
        mergedList.display();
    }
}
