package collections.s34;

import collections.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class s34 {
}
class Solution {
   private Integer target ;
   private List<List<Integer>> res = new LinkedList<>() ;
   private LinkedList<Integer> list = new LinkedList<>() ;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.target = sum ;
        dfs(root , 0);
        return res ;
    }
    public void dfs(TreeNode root, int curSum){
        if(root != null){
            int val = root.val ;
            list.add(val);
            curSum += val ;
            if(curSum == target && root.left == null && root.right == null){
                res.add(new LinkedList<>(list));
            }else{
                dfs(root.left , curSum);
                dfs(root.right , curSum);
            }
            list.removeLast();
        }
    }
}