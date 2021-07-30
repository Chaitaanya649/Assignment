package com.company;

import java.util.Scanner;

//class Assign{
//    public void task(int[][] grid){
//                ///marking die cell -> live, -1
//                ///marking live -> die, 2
//                ///update() -1 => 1,2 =>0
////         int[][] dir = {{0,-1},{0,1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
////        arr = new int[m][n];
////        int p = board.length
//
//        if(grid == null || grid.length == 0)
//            return;
//        int row = grid.length, col = grid[0].length;
//
//        for(int i = 0; i<row; i++){
//            for(int j=0; j<col; j++){
//                if(grid[i][j]==0){
//                    int lives = count(grid,i,j);
//                    if(lives == 3){
//                        grid[i][j] = -1;
//                    }
//                }
//                if(grid[i][j] == 1){
//                    int lives = count(grid, i, j);
//                    if(lives<2 || lives > 3){
//                        grid[i][j] = 2;
//                    }
//                }
//            }
//        }
//        update(grid);
//    }
//    public void update(int[][] grid){
//        for(int i = 0;i< grid.length; i++){
//            for(int j = 0;j<grid[0].length;j++){
//                if(grid[i][j] == -1){
//                    grid[i][j] = 1;
//                }
//                if(grid[i][j]== 2){
//                    grid[i][j] = 0;
//                }
//            }
//        }
//    }
//    public int count(int [][] grid, int row, int col){
//        int result = 0;
//        int[][] dir;
//        for(int[]a:dir){
//            int newR = row + a[0];
//            int newC = col + a[1];
//            if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length &&
//                    (grid[newR][newC] == 1 || grid[newR][newC] == 2)){
//                result++;
//            }
//        }
//        return result;
//    }
//}
//
//
//
//public class Main {
//
//    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int m = sc.nextInt();
////        int n = sc.nextInt();
//
////        int[][] arr = new int[m][n];
////        System.out.println("Enter Your Values:");
////        for(int i = 0; i<m; i++){
////            for(int j = 0; j<n;j++){
////                arr[m][n]= sc.nextInt();
////            }
//        int[][] b = {{0, 0, 1}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
//        Assign a = new Assign();
//        a.task(b);
//    }
//}
//

// m * n grid
/* 010     000
   001     101
   111 =>  011
   000     010
* */

//LIVE CELL - 1
//DEAD CELL - 0

class Assign1{
    int [][]arr = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,-1},{1,0},{1,1}}; /*DEFINING DIRECTION ARRAY AS WE NEED
    TO GO IN 4 DIRECTION UP, DOWN, RIGHT, LEFT, DIAGONALS*/

    public void task(int[][] grid){
        int m = grid.length, n = grid[0].length;      //DEFINING M AND N VARIABLES
        int[][] rs = new int[m][n];                   //ARRAY OF SIZE M*N  //this can also be avoided to not use memory

        /* LOGIC => */

        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                int count=0;
                for(int []a:arr){    //FOR EACH LOOP
                    int p=i+a[0];    //NEW ROW
                    int q=j+a[1];    //NEW COLUMN


                    /* WE NEED TO CHECK IF THEY ARE INSIDE THE BOUNDARY AND ALSO MAINTAIN THE COUNT*/
                    if(p>=0 && p<m && q>=0 && q<n && grid[p][q]==1){
                        count++;
                    }
                }

                // IF IT IS LIVE CELL(1) WE NEED TO PROVIDE THREE CONDITION
                // AS INITIALLY ALL VALUES IN RES- ARRAY WILL BE 0 , -->FEWER THAN TWO LIVE NEIGHBOUR CONDITION NOT NEEDED<--
                //REST TWO CONDITION ARE -->TWO OR THREE LIVE NEIGHBOURS AND --> MORE THAN THREE NEIGHOURS
                if(grid[i][j]==1){
                    if(count == 2 || count ==3){
                        rs[i][j]=1;                     //we can also avoid
                    }
                }
                else{
                    if(count == 3){
                        rs[i][j]=1;
                    }
                }
            }
        }
        //WE NEED TO UPDATE VALUES FROM RESULT ARRAY TO THE ORIGINAL PROVIDED ARRAY
        for(int i=0;i<m;i++) {
            for(int j=0; j < n; j++) {
                grid[i][j] = rs[i][j];
            }
        }
    }
}

///