package csa_2;

public class Test {
    public static void main(String[] args){
        printTriangle(4);
    }
    public static void printTriangle(int n) {
//n为杨辉三⻆形⾏数
        int i = 1;
        int array[] = new int[n];
        for (i = 0; i < n; i++) {
            array[i] = 1; //末尾元素⼀直为1
            for (int j = i - 1; j > 0; j--) {
                array[j] = array[j - 1] + array[j]; //关键值计算
            }
            for (int k = n - i - 1; k > 0; k--) { //打印空格
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) { //输出该⾏的⼀维数组
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }
}
