package learn.homework;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class homework {
    public static void main(String[] args){
     three();
    }
    public static String getUpString(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine() ;
        StringBuffer stringBuffer = new StringBuffer() ;
        for(int i = 0 ; i < string.length() ; i++){
            if(Character.isUpperCase(string.charAt(i))){
                stringBuffer.append(string.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
    public static int[] two(){
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt() ;

        HashSet<Integer> hashSet = new HashSet<>() ;
        for(int i = 0 ; i < s ; i++){
           hashSet.add(scanner.nextInt());
        }
        int[] nums =  hashSet.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nums);
        return nums ;
    }
    public static void three(){
        HashMap<Character  ,Integer> hashMap = new HashMap<>() ;
        Scanner scanner = new Scanner(System.in) ;
        String tree = scanner.nextLine() ;
        String input = scanner.nextLine() ;
        StringBuffer stringBuffer = new StringBuffer() ;
        int height = 0 ;
        char name = '\0' ;
        String value = "" ;
        for(int i = 0 ; i < tree.length() ; i++){
            char c = tree.charAt(i) ;
            if(c >= 'a' && c <= 'z' || (c >= 'A' && c <= 'Z')){
                if(name != '\0'){
                    int x = Integer.parseInt(value) ;
                    if(x > height){
                        height = x ;
                    }
                    hashMap.put(name , x) ;
                    name = '\0' ;
                    value = "" ;
                }
                name =  c ;
            }
            if (c >= '0' && c <= '9'){
                value += c ;
            }
        }
        if (name != '\0'){
            int x = Integer.parseInt(value) ;
            if(x > height){
                height += x ;
            }
            hashMap.put(name , x) ;
            name = '\0' ;
            value = "" ;
        }
        for(int i = 0 ; i < input.length()  ; i++){
            if(hashMap.get(input.charAt(i)) != null){
                stringBuffer.append(String.valueOf(height - hashMap.get(input.charAt(i))+1)+" ");
            }else{
                stringBuffer.append("0 ");
            }

        }
        System.out.println(stringBuffer.toString().trim());
    }
}

