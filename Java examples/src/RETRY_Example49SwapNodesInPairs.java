
/*Swap Nodes in Pairs
        Medium
        Topics
        premium lock icon
        Companies
        Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

        Example 1:

        Input: head = [1,2,3,4]

        Output: [2,1,4,3]

        Explanation:

        Example 2:

        Input: head = []

        Output: []

        Example 3:

        Input: head = [1]

        Output: [1]

        Example 4:

        Input: head = [1,2,3]

        Output: [2,1,3]


        Constraints:

        The number of nodes in the list is in the range [0, 100].
        0 <= Node.val <= 100*/

public class RETRY_Example49SwapNodesInPairs {


    public static void main(String [] args){

        ListNode head = new ListNode(1);
        ListNode current = head;

        for(int i = 2; i < 10; i++){

            ListNode listNode = new ListNode(i);
            current.setNext(listNode);
            current = listNode;
        }

        System.out.println(head);

        System.out.println("AFTER SWAP :"+swapLinks(head));
    }

    private static ListNode swapLinks(ListNode listNode){

        ListNode dummyNode = new ListNode(0);
        dummyNode.setNext(listNode);

        ListNode current = dummyNode;
        
        while (current.getNext() != null && current.getNext().getNext()!=null){


            ListNode firstNode = current.getNext();
            ListNode secondNode = current.getNext().getNext();

            firstNode.setNext(secondNode.getNext());
            secondNode.setNext(firstNode);
            current.setNext(secondNode);

            current = firstNode;

        }

        return dummyNode.next;
    }









}











/* Definition for singly-linked list.*/
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}
