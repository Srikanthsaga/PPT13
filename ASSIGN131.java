class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    LinkedList createNewList(LinkedList list1, LinkedList list2) {
        LinkedList newList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data > current2.data) {
                newList.insert(current1.data);
                current1 = current1.next;
            } else {
                newList.insert(current2.data);
                current2 = current2.next;
            }
        }

        // If any list still has remaining elements
        while (current1 != null) {
            newList.insert(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            newList.insert(current2.data);
            current2 = current2.next;
        }

        return newList;
    }

	public void removeDuplicates() {
		// TODO Auto-generated method stub
		
	}
}

public class ASSIGN131 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(5);
        list1.insert(2);
        list1.insert(3);
        list1.insert(8);

        LinkedList list2 = new LinkedList();
        list2.insert(1);
        list2.insert(7);
        list2.insert(4);
        list2.insert(5);

        LinkedList newList = list1.createNewList(list1, list2);
        newList.display();
    }
}
