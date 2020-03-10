package collections.s257;

import collections.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s257 {
    public static void main(String[] args){
        HashMap<Integer , Integer> hashMap = new HashMap<>() ;
        hashMap.put(1,2);
        hashMap.put(3,4);
        hashMap.put(5,6);
        for(Map.Entry entry : hashMap.entrySet()){
            System.out.print(entry.getKey()+ " ");
            System.out.println(entry.getValue());
        }
    }
}
class Solution {
    List<String> ans = new ArrayList<>() ;
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root , new StringBuilder());
        return ans ;
    }
    public void helper(TreeNode node , StringBuilder stringBuilder){
        if(node == null){
            return ;
        }
        stringBuilder.append(node.val) ;
        stringBuilder.append("->") ;
        if(node.right != null){
            helper(node.right , stringBuilder);
        }
        if(node.left!= null){
            helper(node.left , stringBuilder);
        }
        ans.add(stringBuilder.toString()) ;
    }
}