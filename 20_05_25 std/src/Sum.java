/*求和
题目描述：
输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来

输入描述:
每个测试输入包含2个整数,n和m

输出描述:
按每个组合的字典序排列输出,每行输出一种组合
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sum {
    private static List<List<Integer>> lists = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();
    private static void dfs(int index, int m, int n){
        if(m == 0){
            lists.add(new ArrayList<>(list));
        }else{
            for(int i = index; i <= m && i <= n; i++){
                list.add(i);
                dfs(i + 1, m - i, n);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        dfs(1, m, n);
        for(List<Integer> l : lists){
            int i = 0;
            while(i != l.size() - 1){
                System.out.print(l.get(i) + " ");
                i++;
            }
            System.out.println(l.get(i));
        }
    }
}
