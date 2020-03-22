//给定两个字符串 s 和 t，它们只包含小写字母。
//字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//请找出在 t 中被添加的字母。

public class FindTheDifference {
    //方法一：
    public char findTheDifference(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < arrT.length; i++){
            sum1 += arrT[i];
        }
        for(int i = 0; i < arrS.length; i++){
            sum2 += arrS[i];
        }
        return (char)(sum1 - sum2);
    }

    //方法二：
    /*
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for(int i = 0; i < s.length(); i++){
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
    */
}
