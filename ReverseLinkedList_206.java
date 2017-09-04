public class ReverseLinkedList_206 {
//    public ListNode reverseList(ListNode head){
//        ListNode preNode = null;
//        while(head != null){
//            ListNode tmpNode = head.next;
//            head.next = preNode;
//            preNode = head;
//            head = tmpNode;
//        }
//        return preNode;
//    }

    public ListNode reverseList(ListNode head){
        return  reverse(head, null);
    }
    ListNode reverse(ListNode head,ListNode newNode){
        if(head == null){
            return newNode;
        }
        ListNode nextNode = head.next;
        head.next = newNode;
        return reverse(nextNode,head);
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;}
}
