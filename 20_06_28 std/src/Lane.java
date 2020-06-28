/*航线
题目描述
“呼！！终于到了，可是接下来要怎么走才能到达楚楚街港港呢？”亮亮在醋溜港直发愁。
突然“啾”的一下，一只银色小船出现在亮亮的面前，上面坐着小精灵丹丹“又见面了，有什么可以帮助你的么？”
小精灵向亮亮眨了眨眼睛，微笑着说。 “我想去楚楚街港，但我不知道要怎么走，请问你可以告诉我么？”
亮亮按捺着激动的心情轻声问道。 “楚楚街港呀......那是个特别美好的地方”小精灵歪着头想了想，
说“我只能告诉你大海上所有的航线，剩下的就只能靠你自己啦~” “只有所有的航线呀”，
亮亮的内心再三挣扎，却又没有其他的办法。 “不管有多困难，我一定要达到楚楚街港，请你告诉我吧”亮亮坚定地对小精灵说。
小精灵欣赏地点了点头，递给亮亮一张航线图，并叮嘱道“时限是1000天，一定要到哦~”，
然后如来时一般“啾”的一声，消失了。
亮亮现在迫切地想要抵达楚楚街港，请问亮亮最快能在第几天抵达楚楚街港呢？

输入描述:
一行包含两个整数N(2<=N<=500),M(1<=M<=2000)，用单个空格隔开。表示公有N个港，M条航线。起点为1，终点为N。
接下来M行，每行包含五个整数P,Q(1<=P,Q<=n), K(1<=K<=1000), X,Y(0<=X,Y<=10000),
代表P,Q两个港有航线并需要K天，并且该航线在第X天到第Y天天气恶劣不可通行。

输出描述:
一个整数，即亮亮最快能在第几天抵达楚楚街港
 */
import java.util.Scanner;

public class Lane {
    private static int getDay(int[][] map, int[][] start, int[][] end, int n){
        int[] dp = new int[n + 1];//dp[i]表示当前到达i港口需要的最短天数
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        boolean[] visit = new boolean[n + 1];//该港口遍历过了没

        for(int i = 1; i <= n; i++){//使所有的港口都能被遍历到
            int min = Integer.MAX_VALUE;
            int cur = 1;//这一轮作为起始点的港口cur
            for(int j = 1; j <= n; j++){
                if(!visit[j] && dp[j] < min){//找出上次港口可以到达的,距离起始点最近的港口作为本轮的起始点港口cur
                    min = dp[j];
                    cur = j;
                }
            }
            visit[cur] = true;

            //遍历cur港口的所有可能航线，更新可以到达的港口所需要的最短天数
            for(int k = 1; k <= n; k++){
                if(!visit[k] && map[cur][k] != 0){//如果k港口没有遍历过，并且从cur港口可以到达
                    int arrive = dp[cur] + map[cur][k];//到达时的天数 = 当前的天数 + 此航程时间
                    if(arrive < start[cur][k]){//如果在恶劣天气之前到达
                        dp[k] = Math.min(dp[k], arrive);
                    }else{//恶劣天气之后到达
                        if(dp[cur] > end[cur][k]){//出发时，恶劣天气已经过了
                            dp[k] = Math.min(dp[k], arrive);
                        }else{//无论是到达时恶劣天气还是行驶途中会碰到恶劣天气
                            dp[k] = Math.min(dp[k], end[cur][k] + map[cur][k]);
                        }
                    }
                }
            }
        }
        //dp[n]表示最短几天到达，答案问第几天需要+1
        return dp[n] + 1;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n + 1][m + 1];//map[x][y]表示x，y港口之间航程
        int[][] start = new int[n + 1][m + 1];//start[x][y]表示x，y港口的航线恶劣天气的起始时间
        int[][] end = new int[n + 1][m + 1];//end[x][y]表示x，y港口的航线恶劣天气的结束时间
        for(int i = 1; i <= m; i++){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            map[p][q] = k;
            map[q][p] = k;
            start[p][q] = x;
            start[q][p] = x;
            end[p][q] = y;
            end[q][p] = y;
        }
        System.out.println(getDay(map, start, end, n));
    }
}
