/*地下迷宫
题目描述：
小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,
小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,
地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,
向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。

输入描述:
输入包括n+1行:
 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 接下来的n行:
 每行m个0或者1,以空格分隔

输出描述:
如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;
如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 */
import java.util.LinkedList;
import java.util.Scanner;

public class UnderGroundMaze {
    private static int n = 0,m = 0, p = 0, max = 0;
    private static boolean flag = false;
    private static int[][] arr;
    private static String path = "";
    private static LinkedList<String> list = new LinkedList<>();

    private static void dfs(int x, int y, int step){
        if(x < 0 || y < 0 || step < 0 || x >= n || y >= m || arr[x][y] == 0){
            return;
        }else{
            list.add("[" + x + "," + y + "]");
            arr[x][y] = 0;
            if(x == 0 && y == m - 1){
                flag = true;
                if(step >= max){
                    updataPath();
                    max = step;
                }
                arr[x][y] = 1;
                list.removeLast();
                return;
            }
            dfs(x - 1, y, step - 3);
            dfs(x + 1, y, step);
            dfs(x, y - 1, step - 1);
            dfs(x, y + 1, step - 1);
            arr[x][y] = 1;
            list.removeLast();
        }
    }

    private static void updataPath() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            str.append(list.get(i) + ",");
        }
        if(str.length() > 0){
            str.deleteCharAt(str.length() - 1);
        }
        path = str.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            p = scanner.nextInt();
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            dfs(0, 0, p);
            if(flag){
                System.out.println(path);
            }else{
                System.out.println("Can not escape!");
            }
        }
    }
}
