/*顺时针打印矩阵
题目描述
对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 */
public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] arr = new int[n * m];
        int index = 0;
        int firstx = 0, firsty = 0, lastx = n - 1, lasty = m - 1;
        while(firstx <= lastx && firsty <= lasty){
            for(int i = firsty; i <= lasty; i++){
                arr[index++] = mat[firstx][i];
            }

            if(firstx < lastx){
                for(int i = firstx + 1; i <= lastx; i++){
                    arr[index++] = mat[i][lasty];
                }
            }

            if(firstx < lastx && firsty < lasty){
                for(int i = lasty - 1; i >= firsty; i--){
                    arr[index++] = mat[lastx][i];
                }
            }

            if(firstx < lastx && firsty < lasty){
                for(int i = lastx - 1; i > firstx; i--){
                    arr[index++] = mat[i][firsty];
                }
            }

            firstx++;
            firsty++;
            lastx--;
            lasty--;
        }

        return arr;
    }
}
