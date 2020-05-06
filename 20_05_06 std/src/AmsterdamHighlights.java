/*景点游览
问题描述：
　　小明来到一个景区游玩，但是他的时间有限，没办法逛遍所有的景点，所以他从网上下载了每个景点的评分，
    他希望能够使游览的景点的评分总和最高，于是他希望你帮他对于N个景点排下序。
输入格式：
　　输入的第一行包含一个正整数N，表示N个景点。
　　第二行有N个正整数，表示每个景点的评分值。
输出格式：
　　输出一行，包含N个正整数，表示N个景点的评分从大到小的排列
 */
import java.util.Arrays;
import java.util.Scanner;

public class AmsterdamHighlights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for(int i = n - 1; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }
}
