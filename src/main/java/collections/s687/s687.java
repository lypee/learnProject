package collections.s687;

import collections.TreeNode.TreeNode;

public class s687 {
}
class Solution {
    public int ans = 0 ;
    public int longestUnivaluePath(TreeNode root) {
            dfs(root) ;
            return ans ;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0 ;
        }
        int l = dfs(node.left);
        int r = dfs(node.right) ;
        int left = 0 ;
        int right = 0 ;
        if(node.left != null && node.left.val == node.val){
            left += l + 1 ;
        }
        if(node.right != null && node.right.val == node.val){
            right += r + 1 ;
        }
        ans = Math.max(ans , left + right) ;
        return Math.max(left , right) ;
    }
}