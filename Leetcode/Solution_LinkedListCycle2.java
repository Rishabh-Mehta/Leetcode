package Leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
     }
 }


public class Solution_LinkedListCycle2 {
    
    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast ){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while(fast != slow){
            slow= slow.next;
            fast = fast.next;
        }
        
        return slow;
        
    }
public static void main(String[] args) {
    
    ListNode node = new ListNode(3);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(0);
    ListNode node3 = new ListNode(-4);
    node.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node2;
    ListNode cycle = detectCycle(node);
    System.out.println(cycle.val);
    
}
    
}
