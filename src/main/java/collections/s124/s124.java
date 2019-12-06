package collections.s124;

import collections.TreeNode.TreeNode;

public class s124 {
}
class Solution {
    public int ans = Integer.MIN_VALUE ;

    public int maxPathSum(TreeNode root) {
            getMax(root) ;
            return ans ;
    }
    public int getMax(TreeNode node){
        if(node == null){
            return 0 ;
        }
        int left = Math.max(0 , getMax(node.left)) ;
        int right = Math.max(0 , getMax(node.right)) ;
        ans = Math.max(ans , node.val + left  + right) ;
        return Math.max(left , right) + node.val ;
    }
}