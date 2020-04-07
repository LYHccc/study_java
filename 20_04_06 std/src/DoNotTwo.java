/*不要二
题目描述：
二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
小易想知道最多可以放多少块蛋糕在网格盒子里。

输入描述；
每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)

输出描述；
输出一个最多可以放的蛋糕数
 */
import java.util.Scanner;

public class DoNotTwo {
    /*
    //方法一：判断每一个位置是否可以放(这个位置的上下左右 + 2 都没有放)，放了后将这个位置置为true
    //没想到整体的样子，写的很烂，不建议参考
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = scanner.nextInt();
        boolean[][] flag = new boolean[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                boolean flag1 = false;
                boolean flag2 = false;
                if(j - 2 >= 0 && j + 2 < col){
                    if(!flag[i][j - 2] && !flag[i][j + 2]){
                        flag1 = true;
                    }
                }else if(j - 2 < 0 && j + 2 < col){
                    if(!flag[i][j + 2]){
                        flag1 = true;
                    }
                }else if(j - 2 >= 0 && j + 2 >= col){
                    if(!flag[i][j - 2]){
                        flag1 = true;
                    }
                }else{
                    flag1 = true;
                }

                if(i - 2 >= 0 && i + 2 < row){
                    if(!flag[i - 2][j] && !flag[i + 2][j]){
                        flag2 = true;
                    }
                }else if(i - 2 < 0 && i + 2 < row){
                    if(!flag[i + 2][j]){
                        flag2 = true;
                    }
                }else if(i - 2 >= 0 && i + 2 >= row){
                    if(!flag[i - 2][j]){
                        flag2 = true;
                    }
                }else{
                    flag2 = true;
                }

                if(flag1 && flag2){
                    flag[i][j] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    */

    //方法二：
    //* * × × * *
    //* * × × * *
    //×× * * ××
    //×× * * ××
    //* * × × * *
    //* * × × * *
    //可以找出规律是以4为周期重复出现的
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = scanner.nextInt();
        int[][] arr = new int[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            if(i % 4 == 0 || i % 4 == 1){
                for(int j = 0; j < col; j++){
                    if(j % 4 == 0 || j % 4 == 1){
                        count++;
                    }
                }
            }else{
                for(int j = 0; j < col; j++){
                    if(j % 4 == 2 || j % 4 == 3){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
