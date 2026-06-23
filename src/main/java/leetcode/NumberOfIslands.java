package leetcode;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = numIslands(grid);
        System.out.println(result);
    }

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    callBFS(grid, i , j);
                }

            }
        }
        return count;
    }

    public static void callBFS(char[][] grid, int i, int j){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        callBFS(grid, i-1, j);  //up
        callBFS(grid, i+1, j);  //dowm
        callBFS(grid, i, j-1);  //left
        callBFS(grid, i, j+1);  //right

    }
}
