/*N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    //当前位置放置皇后是否会有冲突
    private boolean isConflict(List<int[]> list2, int row, int col){
        for(int[] arr : list2){
            if(arr[1] == col || arr[0] + arr[1] == row + col
                    || arr[1] - arr[0] == col - row){
                return false;
            }
        }
        return true;
    }
    //遍历，先找出所有可以不冲突放置皇后的位置坐标
    private void dfs(List<List<int[]>> list, List<int[]> list2, int curRow, int n){
        if(curRow == n){
            List<int[]> temp = new LinkedList<>();
            for(int[] arr : list2){
                temp.add(arr);
            }
            list.add(temp);
        }

        for(int i = 0; i < n; i++){
            if(isConflict(list2, curRow, i)){
                list2.add(new int[]{curRow, i});
                dfs(list, list2, curRow + 1, n);
                list2.remove(list2.size() - 1);
            }
        }
    }
    //将坐标转化为需要输出的对应格式
    private List<List<String>> transString(List<List<int[]>> list, int n){
        List<List<String>> res = new LinkedList<>();
        for(List temp : list){
            List<String> resTemp = new LinkedList<>();
            for(int i = 0; i < temp.size(); i++){
                int[] arr = (int[]) temp.get(i);
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < n; j++){
                    char c = '.';
                    if(i == arr[0] && j == arr[j]){
                        c = 'Q';
                    }
                    str.append(c);
                }
                resTemp.add(str.toString());
            }
            res.add(resTemp);
        }

        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<int[]>> list = new LinkedList<>();
        List<int[]> list2 = new LinkedList<>();
        dfs(list, list2, 0, n);
        return transString(list, n);
    }
}
