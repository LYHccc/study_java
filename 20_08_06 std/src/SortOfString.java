/*字符串的排列
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SortOfString {
    private static HashSet<String> set;
    private static void dfs(String str, String curStr, boolean[] flag){
        if(curStr.length() == str.length()){
            set.add(curStr);
        }
        for(int i = 0; i < str.length(); i++){
            if(flag[i]) continue;
            flag[i] = true;
            dfs(str, curStr + str.charAt(i), flag);
            flag[i] = false;
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0) return list;
        boolean[] flag = new boolean[str.length()];
        set = new HashSet<>();
        dfs(str, "", flag);

        for(String s : set){
            list.add(s);
        }
        Collections.sort(list);
        return list;
    }
}
