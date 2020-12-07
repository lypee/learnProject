package collections.s113;

import collections.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s113 {
}
class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getlist(root , new ArrayList<>() ,sum);
        return ans ;
    }
    public void getlist(TreeNode node ,List<Integer> list ,  int sum){
        if(node == null){
            return ;
        }
        sum -= node.val ;
        list.add(node.val) ;
        if(sum == 0){
            ans.add(list) ;
            list.clear();
            return  ;
        }else if (sum < 0){
            list.remove(list.size()-1);
            return  ;
        }
        getlist(node.left , list , sum);
        getlist(node.right , list , sum);

    }
}
class Solution2{
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getlist(root , sum,new ArrayList<>() );
        return ans ;
    }
    public void getlist(TreeNode node , int sum , List<Integer> list){
        if(node == null){
            return ;
        }
        list.add(node.val) ;
        if( (node.left != null) && (node.right != null)){
            if(sum == node.val ){
                ans.add(list) ;
            }
        }
        getlist(node.left , sum - node.val , list);
        getlist(node.right , sum - node.val , list);
        list.remove(list.size()-1) ;
    }
}