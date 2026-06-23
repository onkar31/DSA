package leetcode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode("Apple");
        head.next = new ListNode("Pineapple");
        head.next.next = new ListNode("Orange");
        head.next.next.next = new ListNode("Mango");
        ListNode res = reverseList(head);
        printList(res);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    String val;
    ListNode next;
    ListNode(String x) { val = x; }
}
