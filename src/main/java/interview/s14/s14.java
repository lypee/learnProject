package interview.s14;

import collections.ListNode.ListNode;

public class s14 {
}
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null ;
        }
        ListNode nodeA = headA ;
        ListNode nodeB = headB ;
        while(nodeA != nodeB){
            nodeA = nodeA == null ? headB : nodeA.next ;
            nodeB = nodeB == null ? headA : nodeB.next ;
        }
        return nodeA ;
    }
}