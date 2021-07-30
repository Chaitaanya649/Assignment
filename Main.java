package com.company;

// m * n grid
/* 000     010
   011     011
   001 =>  101
   010     000
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