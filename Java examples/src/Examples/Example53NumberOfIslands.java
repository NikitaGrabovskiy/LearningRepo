package Examples;/*

200. Number of Islands
        Medium
        Topics
        premium lock icon
        Companies
        Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



        Example 1:

        Input: grid = [
        [1,1,1,1,0],
        [1,1,0,1,0],
        [1,1,0,0,0],
        [0,0,0,0,0]
        ]
        Output: 1
        Example 2:

        Input: grid = [
        [1,1,0,0,0],
        [1,1,0,0,0],
        [0,0,1,0,0],
        [0,0,0,1,1]
        ]
        Output: 3


        Constraints:

        m == grid.length
        n == grid[i].length
        1 <= m, n <= 300
        grid[i][j] is '0' or '1'.



*/


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example53NumberOfIslands {

    public static void main(String[] args) {


        char [][] input = new char[4][];
        input[0] = new char[]{'1','1','1','1','0'};
        input[1] = new char[]{'1','1','0','1','0'};
        input[2] = new char[]{'1','1','0','0','0'};
        input[3] = new char[]{'0','0','0','0','0'};

        char [][] input1 = new char[4][];
        input1[0] = new char[]{'1','1','0','0','0'};
        input1[1] = new char[]{'1','1','0','0','0'};
        input1[2] = new char[]{'0','0','1','0','0'};
        input1[3] = new char[]{'0','0','0','1','1'};

        System.out.println(getNumberOfIslands(input));
    }







    private static int getNumberOfIslands(char[][] grid){

        int count = 0;

        for(int row =0; row<grid.length; row++){
            for(int column =0; column<grid[row].length; column++){
                if(grid[row][column] == '1'){
                   count++;
                   markRestOfTheIsland(row,column,grid);
                }
            }
        }
        return count;
    }

    private static void markRestOfTheIsland(int row, int column, char[][] grid){
        if (row<0 || row>=grid.length || column<0 || column>=grid[row].length || grid[row][column] != '1') return;

        grid[row][column] = '0';

        markRestOfTheIsland(row-1,column,grid);
        markRestOfTheIsland(row+1,column,grid);
        markRestOfTheIsland(row,column-1,grid);
        markRestOfTheIsland(row,column+1,grid);

    };
}
