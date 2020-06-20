/*活字印刷
你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
注意：本题中，每个活字字模只能使用一次。 

输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 */
import java.util.HashSet;

public class Main {
    private static void dfs(String tiles, HashSet<String> set, String curStr, boolean[] flag){
        if(curStr != ""){
            set.add(curStr);
        }
        for(int i = 0; i < tiles.length(); i++){
            if(flag[i]) continue;
            flag[i] = true;
            dfs(tiles, set, curStr + tiles.charAt(i), flag);
            flag[i] = false;
        }
    }

    public static int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        boolean[] flag = new boolean[tiles.length()];
        dfs(tiles, set, "", flag);
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("ABC"));
    }
}
