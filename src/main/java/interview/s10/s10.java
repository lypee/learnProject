package interview.s10;

import collections.ListNode.ListNode;

public class s10 {
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head ;
        }
        ListNode cur = head ;
        ListNode pre = null ;
        while(cur.next != null){
            ListNode tmp = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = tmp ;
        }
        if(cur != null){
            cur.next = pre ;
            return cur;
        }
        return pre ;
    }
}
