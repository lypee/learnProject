package collections.s543;

import collections.TreeNode.TreeNode;

public class s543 {
}
class Solution {
    public int ans = 1 ;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root) ;
        return ans-1 ;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return  0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        ans = Math.max(ans , l+r+1) ;
        return Math.max(l ,r )+1 ;
    }
}