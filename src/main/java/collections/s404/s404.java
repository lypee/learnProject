package collections.s404;

import collections.TreeNode.TreeNode;

public class s404 {
}
class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        //判断节点是否是左叶子节点，如果是则将它的和累计起来
        if(root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
    }
}
class Solution {
    public int ans = 0 ;
    public int sumOfLeftLeaves(TreeNode root) {
    getNums(root) ;
    return ans ;
    }
    public int getNums(TreeNode node){
        if(node == null){
            return 0 ;
        }
        if(node.left != null && node.left.left == null && node.left.right == null){
            ans += node.left.val ;
        }
        return getNums(node.left) + getNums(node.right) ;

    }
}