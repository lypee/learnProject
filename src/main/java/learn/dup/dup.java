package learn.dup;

public class dup {
    public static void main(String[] args){
        int[] nums = {1,2,2,3,4,5,6,7 , 9} ;
        System.out.println(get(nums));
    }
    public static int get(int[] nums){
        int ans = 0 ;
        int[] array = new int[nums.length +1 ] ;

        for(int i = 0 ; i < nums.length ; i++){
            ans = ans ^ nums[i] ;
            array[nums[i] -1 ] ++ ;
        }
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] == 0 ){
                return i + 1 ;
            }
        }
        return ans ;
    }
}
