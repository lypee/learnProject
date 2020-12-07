package collections.s226;

import collections.TreeNode.TreeNode;

public class s226 {
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null ;
        }
        TreeNode right = invertTree(root.right) ;
        TreeNode left = invertTree(root.left) ;
        root.left = right ;
        root.right = left ;
        return root ;
    }
}