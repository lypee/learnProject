package learn.search;

public class search {
    public static void main(){

    }
}
class binarySearch{
   public int search(int[] nums , int x){
       int low = 0 ;
       int high = nums.length - 1 ;
       int mid ;
       while(low <= high){
           mid = (low + high) / 2 ;
           if(nums[mid] < x){
               low = mid+ 1 ;
           }else if (nums[mid] > x){
               high = mid -1 ;
           }else {
               return mid ;
           }
       }
       return -1 ;
   }
   public int search2(int[] nums , int x){
       int low = 0 ;
       int high = nums.length  - 1 ;
       int mid ;
       while(low < high){
           mid = (low + high) / 2 ;
           if(nums[mid]  < x){
               low = mid +  1;
           }else if(nums[mid] > x){
               high = mid - 1 ;
           }else {
               return mid ;
           }
       }
       return -1 ;
   }
}
class mergeSort{
    public  void mergeSort(int[] array){
        int[] helper = new int[array.length]  ;
        mergeSort(array , 0 , array.length -1 );
    }
    public void mergeSort(int[] array , int low  , int high){
        if(low < high){
            int middle = (low + high) /2 ;
            mergeSort(array , low , middle);
            mergeSort(array, middle + 1 , high);
            merge(array , low , middle , high);
        }
    }
    public void merge(int[] array , int low , int middle , int high){
        int[] helper = new int[array.length];

        for(int i = low ; i <= high ; i++){
            helper[i] = array[i] ;
        }
        int helperLeft = low ;
        int helperRight = middle + 1 ;
        int current = low ;
        while(helperLeft <= middle && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++ ;
            }else {
                array[current] = helper[helperRight] ;
                helperRight++ ;
            }
            current++ ;
        }
        int remaining = middle - helperLeft ;
        for(int i = 0 ; i <= remaining ; i++){
            array[current + i] =  helper[helperLeft + 1 ];
        }

    }
}