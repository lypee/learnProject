package collections.s102;

import collections.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s102 {
}
class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null ;
        }
        HashMap<Integer , List<Integer>> hashMap = new HashMap<>() ;
        helper(root , hashMap , 0);
        for(Map.Entry entry : hashMap.entrySet()){
            ans.add((List<Integer>)entry.getValue()) ;
        }
        return ans ;
    }
    public void helper(TreeNode node , HashMap<Integer , List<Integer>> hashMap , int depth){
        if(node == null){
            return ;
        }
        List<Integer> list = hashMap.get(depth);
        if(list == null){
            list = new ArrayList<>() ;
            hashMap.put(depth ,list) ;
        }
        list.add(node.val) ;
        helper(node.left , hashMap , depth+1);
        helper(node.right , hashMap , depth+1);
    }
}