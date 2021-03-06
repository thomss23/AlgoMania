package LinkedList;

public class Node {
    
    int data;
    Node prev;
    Node next;

    public Node(int x) {
        data = x;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);

        head.next = node1;
        node1.prev = head;

        node1.next = node2;
        node2.prev = node1;

        head = insertBegin(head, 5);
        printList(head);
        System.out.println();
        head = insertEnd(head, 44);
        printList(head);

    }

    private static Node insertBegin(Node head, int data) {
        Node node = new Node(data);

        if(head == null) {
            return node;
        } else {
            node.next = head;
            head.prev = node;
        }

        return node;


    }

    private static void printList(Node head) {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    private static Node insertEnd(Node head, int data) {

        Node curr = head;
        Node node = new Node(data);
        if(head == null) {
            return node;
        }
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = node;
        node.prev = curr;

        return head;
    }



}
