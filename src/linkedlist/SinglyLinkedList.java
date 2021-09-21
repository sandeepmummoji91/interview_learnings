package linkedlist;

public class SinglyLinkedList {

    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.createNodes();
        System.out.println("=========Initial nodes=============");
        singlyLinkedList.printList();
        System.out.println();
        singlyLinkedList.addNodeAtTheBeginning(20);
        singlyLinkedList.addNodeAtTheBeginning(10);
        System.out.println("=========After adding nodes at the beginning=============");
        singlyLinkedList.printList();
        System.out.println();
        singlyLinkedList.addNodeAtTheEnd(60);
        singlyLinkedList.addNodeAtTheEnd(70);
        System.out.println("=========After adding nodes at the end=============");
        singlyLinkedList.printList();
        System.out.println();
        singlyLinkedList.deleteFirstNode();
        singlyLinkedList.deleteFirstNode();
        System.out.println("=========After deleting node at the beginning=============");
        singlyLinkedList.printList();
        System.out.println();
        singlyLinkedList.deleteLastNode();
        singlyLinkedList.deleteLastNode();
        System.out.println("=========After deleting node at the end=============");
        singlyLinkedList.printList();
        System.out.println();
        singlyLinkedList.addNodeAtIndex(1, 1);
        singlyLinkedList.addNodeAtIndex(2, 2);
        System.out.println("=========After adding node at the index=============");
        singlyLinkedList.printList();
        System.out.println();
    }

    /**
     * Adds nodes one after the other
     */
    private void createNodes() {
        head = new ListNode(30);
        ListNode l2 = new ListNode(40);
        ListNode l3 = new ListNode(50);
        head.next = l2;
        l2.next = l3;
    }

    /**
     * Adds nodes at the beginning
     */
    private void addNodeAtTheBeginning(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = new ListNode(data);
        current.next = head;
        head = current;
    }

    /**
     * Adds nodes at the end
     */
    private void addNodeAtTheEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Adds nodes at the given indes
     */
    private void addNodeAtIndex(int data, int index) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        int count = 0;
        ListNode previous = head;
        while (count < index - 1) {
            count++;
            previous = previous.next;
        }
        newNode.next = previous.next;
        previous.next = newNode;
    }

    /**
     * deletes nodes at the beginning
     */
    private void deleteFirstNode() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        current = current.next;
        head.next = null;
        head = current;
    }

    /**
     * deletes nodes at the end
     */
    private void deleteLastNode() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    /**
     * Prints all the nodes with number of nodes in the list
     */
    private void printList() {
        if (head == null)
            return;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("Number of nodes in the list are:: " + count);
    }

    public static class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

}