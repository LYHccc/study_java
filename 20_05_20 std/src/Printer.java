/*二维数组打印
题目描述
有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
给定一个二位数组arr及题目中的参数n，请返回结果数组。

测试样例：
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] array = new int[n * n];
        int index = 0;
        //打印包含对角线的右上方部分
        for(int i = 1; i <= n; i++){
            int row = 0;
            int col = n - i;
            for(int j = i; j >= 1; j--){
                array[index++] = arr[row++][col++];
            }
        }
        //打印左下方的部分
        for(int i = 1; i < n; i++){//从[i,0]开始打印
            int row = i;
            int col = 0;
            for(int j = n - i; j >= 1; j--){//打印多少个
                array[index++] = arr[row++][col++];
            }
        }

        return array;
    }
}
