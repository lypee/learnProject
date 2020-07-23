package collections.s64;

public class s64 {
}
class Solution2 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0 ;
        }
        int n = grid.length ;
        int m = grid[0].length ;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] = Math.min(grid[i-1][j] , grid[i][j-1]) +grid[i][j];
                }
            }
        }
        return grid[n-1][m-1];
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1 ;
        }
        int n = grid.length ;
        int m = grid[0].length ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if (i == 0 && j == 0) {
                    continue;
                }else if(i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }else if(i != 0 && j == 0){
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else{
                    grid[i][j] += Math.min(grid[i-1][j] , grid[i][j-1])
                }
            }
        }
        return grid[n-1][m-1] ;
    }
}