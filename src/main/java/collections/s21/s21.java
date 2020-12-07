package collections.s21;

import collections.ListNode.ListNode;

public class s21 {
}
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode header = node ;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1 ;
                l1 = l1.next;
            }else{
                node.next = l2 ;
                l2 = l2.next ;
            }
            node = node.next ;
        }
         if(l2 != null){
            node.next = l2 ;
        }else if(l1 != null){
            node.next = l1 ;
        }
        return header.next ;
    }
}