/**
 * 不同字串
 * 一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成 的串。
 * 例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
 * 注意在计算时，只算本质不同的串的个数。
 * 请问，字符串0100110001010001 有多少个不同的非空子串？
 */
package Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    private static void dfs(Set<String> set, String s, String cur, int index){
        if(cur.length() != 0){
            set.add(cur);
        }
        for(int i = index; i < s.length(); i++){
            dfs(set, s, cur + s.charAt(i), i + 1);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Set<String> set = new HashSet<>();
        dfs(set, s, "", 0);
        System.out.println(set.size());
    }
}
