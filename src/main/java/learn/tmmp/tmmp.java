package learn.tmmp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

interface monkey{
    public void eat(String message) ;
}
interface animal{
    public void eat(String message) ;
}
public class tmmp {
    public static int i = 0 ;
    public static HashMap<String , String> hashMap = new HashMap<>() ;
    public static HashMap<String , String> ansMap = new HashMap<>() ;
    public static void main(String[] args){
//        hashMap.put("111","22222") ;
//        hashMap.put("33333","4444444") ;
//        String str = mapToString(hashMap) ;
//        System.out.println(str);
//        stringToMap(str);
//        for(Map.Entry entry : ansMap.entrySet()){
//            System.out.print(entry.getKey()+ " ");
//            System.out.println(entry.getValue());
//        }
//        String str = "www.abcde.fghi.com" ;
 //       System.out.println(reverseString(str));
        ExecutorService poolService = Executors.newFixedThreadPool(3);
        poolService.execute(new testInc());
        poolService.execute(new testInc());
        poolService.execute(new testInc());
    }


    public static String mapToString(Map<String ,String> map){
        if(map == null || map.size() < 1){
            return null ;
        }
        StringBuilder ans = new StringBuilder()  ;
        String key ,value ;
        for(Map.Entry entry : map.entrySet()){
            if(entry.getKey() == null || entry.getValue() == null){
                continue;
            }
            key = (String)entry.getKey() ;
            value = (String) entry.getValue() ;
            ans.append(key.length()).append(":").append(value.length()).append(":").append(key).append(value) ;
        }
        return ans.toString() ;
    }
    public static void stringToMap(String str){
        if(str == null || str.length() < 1){
            return ;
        }
        String[] strs = str.split(":") ;
        int keyLength = Integer.valueOf(strs[0]);
        int valueLength = Integer.valueOf(strs[1]) ;
        int keyIndex = str.indexOf(":");
        int valueIndex = str.indexOf(":" , keyIndex+1) ;
        str = str.substring(keyIndex + valueIndex , str.length());
        String key = str.substring(0 ,keyLength) ;
        String value = str.substring(keyLength ,keyLength + valueLength) ;
        ansMap.put(key ,value) ;
        stringToMap(str.substring(keyLength+valueLength , str.length()));
    }
    public static String reverseString(String str){
        String[] strs = str.split("\\.") ;
        for(int i = 0 ; i < strs.length / 2 ; i++){
            String tmpStr = strs[i] ;
            strs[i] = strs[strs.length - i-1] ;
            strs[strs.length - i- 1 ] = tmpStr ;
        }
        StringBuilder ans = new StringBuilder() ;
        for(int i = 0 ; i < strs.length ; i++){
            ans.append(strs[i]) ;
            if(i  != strs.length -1 ){
                ans.append(".") ;
            }
        }
        return ans.toString() ;
    }
}
class testInc implements Runnable{
    public static int i = 0 ;
    @Override
    public void run() {
        for(int j = 0 ; j < 9 ; j++){
            inc();
        }
    }
    public static synchronized void inc(){
        i++ ;
        System.out.println(Thread.currentThread().getName() + " "+ i);
    }
}