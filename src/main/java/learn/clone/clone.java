package learn.clone;

public class clone {
}
class Student implements Cloneable{
    String Name ;
    int age ;

    public Student(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone() ;
    }
}