//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
//示例：
//输入: S = "loveleetcode", C = 'e'
//输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
import java.util.Arrays;

public class ShortestToChar {
    public static int[] shortestToChar(String S, char C) {
        int[] a = new int[S.length()];
        int index = -10000;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == C)
                index = i;
            a[i] = i - index;
        }
        index = 10000;
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) == C)
                index = i;
            a[i] = Math.min(a[i], index - i);
        }
        return a;
    }

    public static void main(String[] args) {
        String s = "baab";
        char c = 'b';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }
}
