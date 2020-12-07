package interview.s12;

import collections.TreeNode.TreeNode;

import java.util.*;

public class s12 {
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer , List<Integer>> hashMap = new HashMap<>() ;
        List<List<Integer>> ans = new ArrayList<>() ;
        helper(root , hashMap , 0) ;
        for(int i = 0  ; hashMap.get(i) != null ; i++){
            ans.add(hashMap.get(i)) ;
        }
        return ans ;
    }
    public void helper(TreeNode node , HashMap<Integer , List<Integer>> hashMap , int depth ){
        if(node == null){
            return  ;
        }
        List<Integer> list = hashMap.get(depth) ;
        if(list == null){
            list = new ArrayList<>() ;
            hashMap.put(depth , list);
        }
        list.add(node.val);
        helper(node.left , hashMap , depth+1 );
        helper(node.right , hashMap , depth+1) ;
    }
}
