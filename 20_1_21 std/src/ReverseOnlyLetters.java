//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//示例：
//输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
public class ReverseOnlyLetters {
    public boolean isletter(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
            return true;
        }
        return false;
    }
    public String reverseOnlyLetters(String S) {
        char[] str = S.toCharArray();
        int left = 0;
        int right = S.length() - 1;
        while(left < right){
            while(left < right && !isletter(str[left])){
                left++;
            }
            while(left < right && !isletter(str[right])){
                right--;
            }
            char tc = str[left];
            str[left] = str[right];
            str[right] = tc;
            left++;
            right--;
        }
        return new String(str);
    }
}
