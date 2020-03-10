package learn.sort.quickSort;

public class quickSort {
    public static void main(String[] args){
        int[] nums =new int[]{1,433,324,4,124,123,1,412,31,24,123,12,41} ;
        QSort(nums , 0 , nums.length - 1 );
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void QSort(int[] nums , int left , int right){
       if(left >= right){
           return ;
       }
       int key = nums[left] ;
       int i = left ;
       int j = right ;
       while(i < j){
           while(nums[j] >= key && i < j){
               j-- ;
           }
           while(nums[i] <= key && i < j){
               i++ ;
           }
           if(i < j){
               swap(nums , i , j);
           }
       }
       nums[left] = nums[i] ;
       nums[i] = key ;
       QSort(nums ,left ,i-1);
       QSort(nums ,i+1 ,right);

    }
    public static void QuickSort(int[] nums , int left , int right){
        if(left >= right){
            return ;
        }
        int key = nums[left] ;
        int i = left ;
        int j = right ;
        while(i < j){
            while(nums[j] >= key && i < j){
                j-- ;
            }
            while(nums[i] <= key && i < j){
                i++ ;
            }

            if(i < j){
                int tmp = nums[i] ;
                nums[i] = nums[j] ;
                nums[j] = tmp ;
            }
        }
        nums[left] = nums[i] ;
        nums[i] = key ;
        QuickSort(nums ,left , i - 1 );
        QuickSort(nums ,i + 1 ,right) ;
    }
    public static void swap(int[] nums , int i , int j){
        int tmp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = tmp ;
    }
    public static void QS(int[] nums , int left , int right){
        if(left >= right){
            return ;
        }
        int key = nums[left] ;
        int i = left ;
        int j = right ;
        while(i < j){
            while(nums[j] >= key && i < j){
                j-- ;
            }
            while(nums[i] <= key && i < j){
                i++ ;
            }
            if(i < j){
                swap(nums , i , j);
            }
        }
        nums[left] = nums[i] ;
        nums[i] = key ;
        QS(nums , left ,i - 1);
        QS(nums , i+ i , right) ;
    }

}
