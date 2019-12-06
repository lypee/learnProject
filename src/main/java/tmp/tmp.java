package tmp;
import collections.TreeNode.*;
public class tmp {
    public static void main(String[] args){
        System.out.println(~(1 << 8));
    }
}
class isBalanced{
    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true ;
        }
        int heightDff = getHeight(root.right) - getHeight(root.left) ;
        if (Math.abs(heightDff) > 1 ){
            return false ;
        }else{
            return true ;
        }
    }
    public static int getHeight(TreeNode node){
        if(node == null){
            return 0 ;
        }
        return Math.max(getHeight(node.left) , getHeight(node.right))+1;
    }
    // 查 -1
    public static int checkHeight(TreeNode node){
        if(node == null){
            return 0 ;
        }
        int leftHeight = checkHeight(node.left) ;

        int rightHeight = checkHeight(node.right) ;
        if(leftHeight == -1 || rightHeight == -1 ){
            return -1 ;
        }
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if(heightDiff > 1 ){
            return -1 ;
        }else{
            return Math.max(leftHeight , rightHeight);
        }
    }

}