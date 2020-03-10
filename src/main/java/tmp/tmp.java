package tmp;
import collections.TreeNode.*;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
class People{
    Integer age ;
    public People(){}
    public People(Integer age) {
        this.age = age;
    }
    public void Speak(){
        System.out.println("my age is "+ age);
    }
}
class Student extends People{
    Integer age ;
    String name ;
    public Student(){}
    public Student(Integer age, Integer age1) {
        super(age);
        this.age = age1;
    }
    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    public void Say(){
        System.out.println(name + " is Saying  , his age is "+ age);
    }
    public void Speak(){
        System.out.println(name + " is Speaking "+ age);

    }
}
public class tmp {
    public static void main(String[] args){
        dupl temp = new dupl() ;

    }
    public static void tmp3(){
        Queue<Student> queue = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.age - o1.age;
            }
        }) ;
        List<Student> list = new LinkedList<Student>() ;
        for(int i = 0 ; i < 10 ; i++){
            queue.offer(new Student(i ,i + "")) ;
        }
        queue.offer(new Student(3 ,"s3"))  ;
        queue.offer(new Student(7 , "s7")) ;
        while(!queue.isEmpty()){
            Student student = queue.poll() ;
           student.Say();
        }

    }
    public static void tmp2(){
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1 ;
            }
        }) ;
        for(int i = 0 ; i < 10 ; i++){
            queue.offer(i) ;
        }
        queue.offer(7) ;
        queue.offer(3) ;
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
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
class isBST{
    public static int lastNumber = Integer.MAX_VALUE ;
    public boolean isBST(TreeNode root){
      return   helper2(root , Integer.MAX_VALUE , Integer.MIN_VALUE);

    }
    public boolean helper(TreeNode node){
        if(node == null){
            return true ;
        }
        if(helper(node.left)){
            return false ;
        }
        if(lastNumber >= node.val){
            return false ;
        }
        if(helper(node.right)){
            return false ;
        }
        return true ;
    }


    public boolean helper2(TreeNode node , int max , int min){
        if(node == null){
            return true ;
        }
        if(node.val > max || node.val < min){
            return false ;
        }
        if(!helper2(node.left , node.val , min ) ||
        !helper2(node.right , max , node.val)){
            return false ;
        }
        return true ;
    }
}

class commonAncestorHelper{
    public boolean covers(TreeNode root , TreeNode node){
        if(root == null){
            return false ;
        }
        if(root == node){
            return true ;
        }
        return (covers(root.left , node) || covers(root.right , node));
    }
    public TreeNode commonAncestorHelper(TreeNode node , TreeNode p , TreeNode q){
        if(node == null){
            return null ;
        }
        if(node == p || node == q){
            return node ;
        }
        boolean pLocat = covers(node , p) ;
        boolean qLocat = covers(node , q) ;
        TreeNode childNode ;
        if(pLocat != qLocat){
            return node ;
        }else {
            childNode = pLocat ? node.left  : node.right ;
        }
       return  commonAncestorHelper(childNode , p , q );

    }
}
class bitSwapRequired implements Callable<Integer> {
    public int bitSwapRequired(int a , int b) {
        int count = 0 ;
        for(int c = a ^ b ; c != 0 ; c = c >> 1){
            count++ ;
        }
        return count ;
    }

    @Override
    public Integer call() throws Exception {
        return Integer.valueOf(9);
    }
}

class Channel extends Thread{
    public void testChannel(){
        List<Integer> arrayList = new ArrayList();
        arrayList.add(9);
    }

}
class MyQueue {
    Stack<Integer> s1 ;
    Stack<Integer> s2 ;
    /** Initialize your data structure here. */
    public MyQueue() {
    s1 = new Stack<>() ;
    s2 = new Stack<>() ;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s1.isEmpty()){
            return -1 ;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans = s2.pop() ;
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return ans ;
    }

    /** Get the front element. */
    public int peek() {
        if(s1.isEmpty()){
            return -1 ;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans = s2.peek() ;
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return ans ;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() ;
    }
}

class dupl{
    public int get(int[] nums){
        int[] ans = new int[2] ;
        int[] array = new int[nums.length] ;
        int num = 0 ;
        for(int i = 0 ; i< nums.length ; i++){
            num  = num ^ nums[i] ;
        }
        return num ;
    }
}