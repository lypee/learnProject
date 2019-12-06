package collections.s206;

import collections.ListNode.ListNode;

public class s206 {
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null ;
        }
        ListNode pre = null ;
        ListNode cur = head ;
        while(cur.next != null){
            ListNode tmp = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = cur.next  ;
        }
        if (cur != null){
            cur.next = pre ;
            return cur ;
        }
        return pre ;

    }
}
class Solution2{
    public ListNode reverseList(ListNode head){
        if (head == null){
            return null ;
        }
        ListNode pre = null ;
        ListNode cur = head ;
        while(cur.next != null){
            ListNode tmp = cur.next ;
            cur = pre ;
            pre = cur ;
            cur = cur.next ;
        }
        if(cur.next != null){
            cur.next = pre ;
            return cur;
        }
        return pre ;
    }
}