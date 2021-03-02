
  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution_rotateRight {
    
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        if(head.next == null) return head;
        while(k > 0){    
        ListNode curr = head;
        while(curr.next.next !=null){
            curr = curr.next;
            
        }
        ListNode temp = curr.next;
        curr.next = null;
        temp.next = head;
        head = temp;
        k-- ;    
        } 
        ListNode curr = head;
        while(curr !=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
        
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
       
        rotateRight(head, 2);
        


    }
}