/**
 * 字符串碎片
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成
 * 例如："aaabbaaac",是由下边的碎片组成的："aaa""bb""c"
 * 现给定一个字符串，请你帮助计算这个字符串的所有碎片的平均长度，结果直接取整，无需保留小数
 * 示例输入：aaabbaaac
 * 输出：2
 * (3+2+3+1) / 4 = 2
 */
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static int GetFragment (String str) {
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
        String temp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(left) == str.charAt(right)){
                temp += str.charAt(left);
            }else{
                list.add(temp);
                left = right;
                temp = String.valueOf(str.charAt(left));
            }
            right++;
        }
        list.add(temp);
        int sum = 0;
        for(String s : list){
            sum += s.length();
        }
        int res = sum / list.size();
        return res;
    }

    public static void main(String[] args) {
        String s = "aaabbaaac";
        System.out.println(GetFragment(s));
    }
}
