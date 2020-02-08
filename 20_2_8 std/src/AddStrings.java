//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        while(index1 >= 0 || index2 >= 0 || carry != 0){
            if(index1 >= 0){
                carry += num1.charAt(index1--) - '0';
            }
            if(index2 >= 0){
                carry += num2.charAt(index2--) - '0';
            }
            s.append(carry % 10);
            carry /= 10;
        }
        return s.reverse().toString();
    }
}
