package learn.josephuse;

public class josephuse {
    public static void main(String[] args){

    }
    //nums个人 ，数到m的人退出
    public static int LastRemain(int nums ,int m){
       if(nums <= 0 || m <= 0){
           return -1 ;
       }
       int last = 0 ;
       for(int i = 2 ; i <= nums ; i++){
           last = (last + m) % last;
       }
       return last ;
    }
}
