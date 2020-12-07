package learn.Tree;

import collections.TreeNode.TreeNode;

import java.util.*;

public class Tree {
    public static void preOrder(TreeNode root){
        if(root == null){
            return  ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root) ;
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop() ;
            System.out.println(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left) ;
            }
        }
    }
    public static void midOrder(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root) ;
        while(!stack.isEmpty()){
            if(root.left != null){
                stack.push(root.left);
            }else{
                root = stack.pop() ;
                System.out.println(root.val);
                if(root.right != null){
                    stack.push(root.right);
                }
            }
        }
    }
    public static void midOrder_2(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root);
        while(!stack.isEmpty() || root != null){
            if(root.left != null){
                stack.push(root.left);
            }else{
                root = stack.pop() ;
                System.out.println(root.val);
                if(root.right != null){
                    stack.push(root);
                }
            }
        }
    }
    public static void midOrder_3(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root) ;
        while(!stack.isEmpty() || root != null){
            if(root.left != null){
                stack.push(root.left);
            }else{
                root = stack.pop() ;
                System.out.println(root.val);
                if(root.right != null){
                    stack.push(root.right);
                }
            }
        }
    }
    public static void laterOrder(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> s1 = new Stack<>() ;
        Stack<TreeNode> s2 = new Stack<>() ;
        s1.push(root) ;
        while(!s1.isEmpty()){
            root = s1.pop() ;
            s2.push(root);
            if(root.right != null){
                s1.push(root.right);
            }
            if(root.left != null){
                s1.push(root.left);
            }
        }
        while(!s2.isEmpty()){
            root = s2.pop() ;
            System.out.println(root.val);
        }
    }
}
class print{
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root) ;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop() ;
            System.out.println(node.val);
            if(node.right != null){
                stack.push(node.right) ;
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
    public void midOrder(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root) ;
        while(!stack.isEmpty() || root != null ){
            if(root.left != null){
                stack.push(root.left);
            }else{
                root = stack.pop() ;
                System.out.println(root.val);
                if(root.right != null){
                    stack.push(root.right);
                }
            }
        }
    }
    public void midOrder2(TreeNode root){
        if(root == null){
            return  ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root) ;
        while(!stack.isEmpty() || root != null){
            if(root.left != null){
                stack.push(root.left);
            }else{
                root = stack.pop() ;
                System.out.println(root.val);
                if(root.right != null){
                    stack.push(root.right);
                }
            }
        }
    }
    public void afterOrder2(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>() ;
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode node = s1.pop() ;
            s2.push(node);
            if(node.right != null){
                s1.push(node.right);
            }
            if(node.left != null){
                s1.push(node.left) ;
            }
        }
    }

    public void afterOrder(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> s1 = new Stack<>() ;
        Stack<TreeNode> s2 = new Stack<>() ;
        s1.push(root);
      while(!s1.isEmpty()){
          TreeNode node = s1.pop() ;
          s2.push(node) ;
          if(node.right != null){
              s1.push(node.right) ;
          }
          if(node.left != null){
              s1.push(node.left);
          }
      }
      while(!s1.isEmpty()){
          System.out.println(s1.pop().val);
      }
    }
    public void afterOrder_2(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> s1 = new Stack<>() ;
        Stack<TreeNode> s2 = new Stack<>() ;
        s1.push(root) ;
        while(!s1.isEmpty()){
            TreeNode node = s1.pop() ;
            s2.push(node);
            if(node.right != null){
                s1.push(node.right);
            }
            if(node.left != null){
                s1.push(node.left) ;
            }
        }
        while(!s2.isEmpty()){
            System.out.println(s2.pop().val);
        }
    }

    public void preOrder_2(TreeNode root){
        if(root == null){
            return  ;
        }
        Stack<TreeNode> stack = new Stack<>() ;
        stack.push(root) ;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop() ;
            System.out.println(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left) ;
            }
        }
    }
    public List<List<Integer>>  leverOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>() ;
        if(root == null){
            return ans ;
        }
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>() ;
            int size = queue.size() ;
            for(int i = 0 ; i < size ;i++){
                TreeNode node = queue.poll() ;
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right) ;
                }
            }
            ans.add(level) ;
        }
        return ans ;
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return null ;
        }
        List<List<Integer>> ans = new ArrayList<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            List<Integer> level = new LinkedList<>() ;
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll() ;
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right) ;
                }
            }
            ans.add(level) ;
        }
        return ans ;
    }
    public List<List<Integer>> levelOrder_2(TreeNode root){
        if(root == null){
            return null ;
        }
        List<List<Integer>> ans = new ArrayList<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size=  queue.size() ;
            List<Integer> level = new ArrayList<Integer>() ;
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll() ;
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right) ;
                }
            }
            ans.add(level);
        }
        return ans ;
    }
    public List<List<Integer>> levelOrder_3(TreeNode root){
        if(root == null){
            return null ;
        }
        List<List<Integer>> ans = new ArrayList<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            List<Integer> list = new ArrayList<>() ;
            for(int i = 0 ; i < size  ; i++){
                TreeNode node = queue.poll() ;
                list.add(node.val) ;
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans ;
    }
    public List<List<Integer>> levelOrder_4(TreeNode root){
        if(root == null){
            return null ;
        }
        List<List<Integer>> ans = new ArrayList<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>() ;
            int size=  queue.size() ;
            for(int i = 0 ; i <size ; i++){
                TreeNode node = queue.poll() ;
                list.add(node.val) ;
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right) ;
                }
            }
            ans.add(list);
        }
        return ans ;
    }
    public List<List<Integer>> levelOrder_5(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            ArrayList<Integer> list = new ArrayList<>() ;
            for(int i = 0 ; i <size ; i++){
                TreeNode node = queue.poll() ;
                list.add(node.val) ;
                if(node.right != null){
                    queue.offer(node.right) ;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
            ans.add(list) ;
        }
        return ans ;
    }
    }
class levelOrder{
   public static  ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public void levelOrder(TreeNode root){
        if(root == null ){
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            ArrayList<Integer> list = new ArrayList<>() ;
            for(int i = 0 ;i  < size ; i++){
                TreeNode node = queue.poll() ;
                list.add(node.val) ;
                if(node.right != null){
                    queue.offer(node.right) ;
                }
                if(node.left != null){
                    queue.offer(node.left) ;
                }
            }
            ans.add(list) ;
        }
      //  return ans ;
    }
    public void levelOrder2(TreeNode root){
        if(root == null){
            return  ;
        }
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            ArrayList<Integer> list = new ArrayList<>() ;
            for(int i = 0 ;i  <size ; i++){
                TreeNode node = queue.poll() ;
                list.add(node.val) ;
                if(node.left != null){
                    queue.offer(node.left) ;
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
    }
}