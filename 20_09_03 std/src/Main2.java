/**
 * 顺时针打印矩阵
 */
import java.util.Arrays;

public class Main2 {
    public static int[] SpiralMatrix (int[][] matrix) {
        int startX = 0, startY = 0;
        int endX = matrix.length - 1, endY = matrix[0].length - 1;
        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;
        while(startX <= endX && startY <= endY){
            //存储第一行
            for(int i = startY; i <= endY; i++){
                arr[index++] = matrix[startX][i];
            }
            //存储最后一列
            for(int i = startX + 1; i <= endX; i++){
                arr[index++] = matrix[i][endY];
            }
            //存储最后一行
            if(startX < endX) {
                for (int i = endY - 1; i >= startY; i--) {
                    arr[index++] = matrix[endX][i];
                }
            }
            //存储第一列
            if(startY < endY) {
                for (int i = endX - 1; i >= startX + 1; i--) {
                    arr[index++] = matrix[i][startY];
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(SpiralMatrix(arr)));
    }
}
