package csa_2;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        printTriangle(6);
        zeroToRear(new int[]{1,2,0,3,4});
        generateMatrix(5);
    }
    /*
    编程题1：
    打印杨辉三角方法
     */
    private static void printTriangle(int row){
        //创建二维数组list
        int[][] list = new int[row][row];
        //行 = i
        for (int i = 0; i < row; i++){
            //列 = j
            for(int j = 0;j<= i;j++){
                //先设置每行第一个、最后一个数为1
                if ( j==0 || j==i ){
                    list[i][j] = 1;
                }else{      //再设置中间的数
                    list[i][j] = list[i-1][j-1] + list[i-1][j];
                }
            }
        }
        //等腰输出
        for (int i = 0; i < row; i++){
            //输出重复空格
            System.out.print(blank(row - i));
            //输出数字
            for(int k =0;k <=i;k++){
                System.out.print(list[i][k]+" ");
            }
            //一行输出完后换行
            System.out.println();
        }
    }
    /*
    编程题2：
    给定⼀个数组 nums，编写⼀个函数将所有 0 移动到数组的末尾，同时保持⾮零元素的相对顺序。
    */
    private static void zeroToRear(int[] nums) {
        //打印初始数组
        System.out.println("初始数组");
        for (int num : nums) {
            System.out.print(num+" ");
        }
        //创建一个新数组
        int[] newnums = new int[nums.length];
        int m = 0;
        //遍历数组
        for (int n :nums){
            //如果元素非0，添加到新数组中
            if(n != 0){
                newnums[m] = n;
                m++;
            }
        }
        //打印新数组
        System.out.println("\n新数组");
        for (int num : newnums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    /*
    编程题3：
    给你⼀个正整数 n ，⽣成⼀个包含 1 到 n^2 所有元素
    且元素按顺时针顺序螺旋排列的 n x n 正⽅形矩阵 matrix
    */
    private static void generateMatrix(int n){
        //创建matrix矩阵
        int[][] matrix = new int[n][n];
        int num = 0;
        //顺时针旋转一圈为一个循环，循环次数不大于 (n/2)+1
        for (int i = 0;i <= (n/2);i++){
            //左上至右上，第 i 行，添加 n-i 个数
            for (int j = i;j < n-i;j++){
                num += 1;
                if (num>n*n)break;
                matrix[i][j] = num;
            }
            //右上至右下，第 n-i 列，添加 n-i-1 个数
            for (int j = i+1;j < n-i;j++){
                num += 1;
                if (num>n*n)break;
                matrix[j][n-i-1] = num;
            }
            //右下至左下，第 n-i 行，添加 n-i-1 个数
            for (int j = n-i-2;j >= i;j--){
                num += 1;
                if (num>n*n)break;
                matrix[n-i-1][j] = num;
            }
            //左下至左上，第 i 行，添加 n-i-2 个数
            for (int j = n-i-2;j >= i+1;j--){
                num += 1;
                if (num>n*n)break;
                matrix[j][i] = num;
            }
        }
        //输出矩阵
        System.out.println(n+"阶顺时针螺旋矩阵");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //如输出数 <10 ，在数字前添加空格，使10阶以内矩阵格式工整
                if (matrix[i][j]<10)System.out.print(" ");
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    //重复空格
    private static String blank(int n) {
        return String.join("", Collections.nCopies(n," "));
    }
}
