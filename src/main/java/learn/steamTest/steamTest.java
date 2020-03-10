package learn.steamTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class steamTest {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        ArrayList<String> strList = new ArrayList<>() ;
        strList.add("shaochen");
        strList.add("shaoChen");
        strList.add("cool");
        strList.add("bean");
        strList.add("java");
        strList.add("java");
        Stream<String> stream = strList.stream() ;
        List<String> list = stream.filter(s -> s.contains("a")).distinct().collect(Collectors.toList());
        for(String item : list){
            System.out.println(item);
        }
        char c = '中';
        System.out.println(c);
    }
}
