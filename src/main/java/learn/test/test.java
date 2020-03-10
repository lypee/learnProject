package learn.test;

import com.fasterxml.jackson.core.util.BufferRecycler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args)throws IOException {

        ExecutorService poolExecutor = Executors.newFixedThreadPool(1) ;
        //mask :8191
        System.out.println(1 << 13);
    }
    public static String reverseString(String str)  {
        if(str == null || str.length() < 1){
            return null ;
        }
        String[] strs = str.split("\\s+") ;
        StringBuilder ans = new StringBuilder() ;
        for(int i = strs.length - 1 ;i >= 0 ; i--){
            ans.append(strs[i]);
            if(i != 0){
                ans.append(" ");
            }
        }
        return ans.toString() ;
    }
}
class E{
    public static void testDate(){
        final HashMap<Integer , Integer> hashMap = new HashMap<>() ;
        hashMap.put(99 ,99) ;
        System.out.println(hashMap.size());
        for(int i = 0 ; i < 20 ; i++){
            hashMap.put(i ,i);
        }
        hashMap.forEach((k,v)->{
            System.out.println(k + " " + v);
        });
        System.out.println(hashMap.size());
    }
    public static String reverseString(String str){
        if(str == null || str.length() < 1){
            return null ;
        }
        String[] strs = str.split("\\s+") ;
        StringBuilder ans = new StringBuilder() ;
        for(int i = strs.length - 1 ;i >= 0 ; i--){
            ans.append(strs[i]);
            if(i != 0){
                ans.append(" ");
            }
        }
        return ans.toString() ;
    }
}
class D{
    public static void testLambda(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("i" ,"lova" , "you" ,"yrq"));
        list.forEach(new Consumer<String>(){

            @Override
            public void accept(String s) {
                if(s.length() >= 3 ){
                    System.out.println(s);
                }
            }
        });
    }
    public static void testLambda_2(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach((k,v)->{

        });
    }

}
class A {
     static {
        System.out.println("A static");
    }
    A(){
         System.out.println("A");
    }
}
class B extends A{
    static{
        System.out.println("B static");
    }
    B(){
        System.out.println("B");
    }
}
class C{
    private static int NUMBERS = 1000000;
    public void random(){
        HashSet<Double> hashSet = new HashSet<>() ;
        for(int i = 0 ; i < NUMBERS  ;i++){
            hashSet.add(Math.random()) ;
        }
        for(Double item : hashSet){
            System.out.println(item);
        }
    }
}