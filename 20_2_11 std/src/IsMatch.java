//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//'?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
//两个字符串完全匹配才算匹配成功。

public class IsMatch {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] flag = new boolean[sLength + 1][pLength + 1];
        flag[0][0] = true;
        for(int i = 1; i <= pLength; i++){
            flag[0][i] = flag[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for(int i = 1; i <= sLength; i++){
            for(int j = 1; j <= pLength; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    flag[i][j] = flag[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    flag[i][j] = flag[i - 1][j] || flag[i][j - 1];
                }
            }
        }
        return flag[sLength][pLength];
    }
}
