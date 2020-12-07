package learn.reflect;

import java.lang.reflect.Method;

public class reflect {
    public static void main(String[] args) throws Exception{
        Student student = new Student("lpy" , 22);
        Method m = student.getClass().getMethod("Say",String.class) ;
        m.setAccessible(true);
        System.out.println(m.invoke(student ,"message"));
    }
}
class Student{
    public String name ;
    public int age ;
    public static int count = 0;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void Say(String message){
        ++count ;
        System.out.println(name + " isSaying " + message + " count: " + count);
    }
}