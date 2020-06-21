/*电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
1(&^%)  2(abc) 3(def)
4(ghi)  5(jkl) 6(mno)
7(pqrs) 8(tuv) 9(wxyz)
 */
import java.util.LinkedList;
import java.util.List;

public class CombinationsOfTelephoneNumber {
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
    private void dfs(String digits, List<String> list, String curStr, int index){
        if(index == digits.length()){
            list.add(curStr);
            return;
        }
        int mapIndex = digits.charAt(index) - '0';
        String curMap = map[mapIndex];
        for(int i = 0; i < curMap.length(); i++){
            dfs(digits, list, curStr + curMap.charAt(i), index + 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits.length() == 0){
            return list;
        }
        dfs(digits, list, "", 0);
        return list;
    }
}
