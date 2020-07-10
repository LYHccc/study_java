/*正则表达式匹配
题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionMatch {
    public boolean match(char[] str, char[] pattern){
        int sLength = str.length;
        int pLength = pattern.length;
        //F(i, j)表示str的前i个字符和pattern的前j个字符是否匹配
        boolean[][] flag = new boolean[sLength + 1][pLength + 1];
        flag[0][0] = true;
        for(int i = 1; i <= pLength; i++){
            if(pattern[i - 1] == '*'){
                flag[0][i] = flag[0][i - 2];
            }
        }

        for(int i = 1; i <= sLength; i++){
            for(int j = 1; j <= pLength; j++){
                if(str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.'){
                    flag[i][j] = flag[i - 1][j - 1];
                }else if(pattern[j - 1] == '*'){
                    if(str[i - 1] != pattern[j - 2] && pattern[j - 2] != '.'){
                        flag[i][j] = flag[i][j - 2];
                    }else{
                        flag[i][j] = flag[i][j - 1] || flag[i - 1][j];
                    }
                }
            }
        }

        return flag[sLength][pLength];
    }
}
