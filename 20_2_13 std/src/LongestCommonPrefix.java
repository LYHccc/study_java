//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String s = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(s) != 0){
                s = s.substring(0, s.length() - 1);
                if(s.isEmpty())
                    return "";
            }
        }
        return s;
    }
}
