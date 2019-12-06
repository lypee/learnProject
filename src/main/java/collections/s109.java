package collections;

import collections.ListNode.ListNode;
import collections.TreeNode.TreeNode;

public class s109 {
}
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null ;
        }
        if(head.next == null){
            return new TreeNode(head.val) ;
        }
        ListNode pre = head ;
        ListNode p = head.next ;
        ListNode q = p.next ;
        while(q!= null && q.next != null){
            pre = pre.next ;
            p = pre.next ;
            q = q.next.next ;
        }
        pre.next = null ;
        TreeNode root = new TreeNode(p.val) ;
        root.left = sortedListToBST(head) ;
        root.right = sortedListToBST(p.next) ;
        return root ;
    }
}class Solution2{
    public TreeNode sortedListToBST(ListNode head){
        if(head == null){
            return null ;
        }
        if(head.next == null){
            return new TreeNode(head.val) ;
        }
        ListNode pre = head ;
        ListNode p = pre.next ;
        ListNode q = p.next ;
        while(q != null && q.next != null){
            pre = pre.next ;
            p = pre.next ;
            q = q.next.next ;
        }
        pre.next = null ;
        TreeNode root = new TreeNode(p.val) ;
        root.left = sortedListToBST(head) ;
        root.right = sortedListToBST(p.next) ;
        return root ;
    }
}