package interview.s9;

import java.util.LinkedList;
import java.util.Queue;

public class s9 {
    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new Solution().numIslands(grid));
    }
}
class Solution {
    int ans = 0;
    char[][] grid ;
    int xlen , ylen ;
    int[] dx = {1 , 0 , -1 , 0 , 1} ;
    int[] dy = {0 , 1 , 0 , -1 , 1} ;
    public int numIslands(char[][] grid) {
        this.grid = grid ;
        this.xlen = this.grid.length ;
        this.ylen = this.grid[0].length ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' ){
                    bfs(i , j);
                    ans++ ;
                }
            }
        }
        return ans ;
    }
    public void bfs(int i , int j){
        Queue<Point> queue = new LinkedList<>() ;
        Point p = new Point(i , j) ;
        queue.offer(p) ;
        while(!queue.isEmpty()){
            Point curPoint = queue.poll() ;
            int cx = curPoint.getX() ;
            int cy = curPoint.getY() ;
            for(int index = 0 ; index < 5 ; index++){
                int x = cx + dx[index] ;
                int y = cy + dy[index] ;
                if(x < 0 || x >= xlen || y < 0 || y >= ylen || grid[x][y] != '1' ) {
                    continue;
                }else{
                    queue.offer(new Point(x , y)) ;
                    grid[cx][cy] = '0'  ;
                    grid[x][y] = '0' ;
                }
            }
            grid[cx][cy] = '0'  ;
        }
    }
}
class Point{
    public Point(int x , int y , int val){
        this.x = x ;
        this.y = y ;
        this.val = val ;
    }
    public Point(int x , int y){
        this.x = x ;
        this.y = y ;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public  int x , y , val ;

}