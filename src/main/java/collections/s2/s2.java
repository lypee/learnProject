package collections.s2;

import collections.ListNode.ListNode;

public class s2 {
}
class Solutio22n {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head ;
        ListNode p = l1 ;
        ListNode q = l2 ;
        int carry = 0 ;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0 ;
            int y = (q != null) ? q.val : 0 ;
            int sum = x + y + carry ;
            carry = sum / 10 ;
            curr.next = new ListNode(sum % 10) ;
            curr = curr.next ;
            if(p != null){
                p = p.next ;
            }
            if(q != null){
                q = q.next ;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0) ;
        ListNode cur = head , p = l1 , q = l2 ;
        int carry = 0 ;
        while (q != null || p != null){
            int x = (p != null) ? p.val : 0 ;
            int y = (q != null) ? q.val : 0 ;
            int sum = carry + x + y ;
            carry  = sum / 10 ;
            cur.next = new ListNode(sum % 10);
            cur = cur.next ;
            if(q != null){
                q = q.next;
            }
            if(p !=  null){
                p = p.next;
            }
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return head.next ;
    }
}
