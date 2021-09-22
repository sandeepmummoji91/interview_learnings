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
        System.out.println("=========After reversing the linked list=============");
        singlyLinkedList.reverseList();
        singlyLinkedList.printList();
        System.out.println();
        int nthElement = singlyLinkedList.findNthElement(3);
        System.out.println("Nth element in the list is:: " + nthElement);
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
        singlyLinkedList.addNodeAtIndex(2, 3);
        singlyLinkedList.addNodeAtIndex(2, 4);
        System.out.println("=========After adding node at the index=============");
        singlyLinkedList.printList();
        System.out.println();
        singlyLinkedList.removeDuplicates();
        System.out.println("=========After removing duplicates from the list=============");
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
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
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
        ListNode current = head;
        while (count < index - 1) {
            count++;
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    /**
     * Reverse linkedlist
     */
    private void reverseList() {
        ListNode current = head;
        ListNode next, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
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

    /**
     * Find nth element in the list
     */
    private int findNthElement(int index) {
        if (head == null)
            return 0;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        int count = 0;
        while (count < index) {
            pointer1 = pointer1.next;
            count++;
        }
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer2.data;
    }

    /**
     * Removes duplicates from the sorted list
     */
    private void removeDuplicates() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
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