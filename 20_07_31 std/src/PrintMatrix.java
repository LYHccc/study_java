/*顺时针打印矩阵
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int firstx = 0, firsty = 0, lastx = row - 1, lasty = col - 1;
        while(firstx <= lastx && firsty <= lasty){
            //打印当前第一行
            for(int i = firsty; i <= lasty; i++){
                list.add(matrix[firstx][i]);
            }
            //最后一列
            for(int i = firstx + 1; i <= lastx; i++){
                list.add(matrix[i][lasty]);
            }

            //if判断避免只有一行的情况
            //最后一行
            if(firstx < lastx && firsty < lasty){
                for(int i = lasty - 1; i >= firsty; i--){
                    list.add(matrix[lastx][i]);
                }
            }
            //if判断避免只有一列的情况
            //第一列
            if(firstx < lastx && firsty < lasty){
                for(int i = lastx - 1; i >= firstx + 1; i--){
                    list.add(matrix[i][firsty]);
                }
            }

            firstx++;
            firsty++;
            lastx--;
            lasty--;
        }

        return list;
    }
}
