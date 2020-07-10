/*表示数值的字符串
题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class StringRepresentValue {
    public boolean isNumeric(char[] str) {
        //分别代表e，小数点是否已经出现
        boolean flagE = false, point = false;
        for(int i = 0; i < str.length; i++){
            char c = str[i];
            if(c == 'e' || c == 'E'){
                //e不能出现两次并且不能出现在最后一位
                if(flagE || i == str.length - 1)
                    return false;
                //后边不能是小数点
                if(str[i + 1] == '.')
                    return false;
                flagE = true;
            }else if(c == '+' || c == '-'){
                //+-号出现只能在开头或者e的后边
                if(i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                //后边必须要有数字
                if(i == str.length - 1)
                    return false;
            }else if(c == '.'){
                //小数点不能出现两次，不能出现在开头,不能出现在e的后边
                if(i == 0 || point || flagE)
                    return false;
                point = true;
            }else if(c < '0' || c >'9'){
                return false;
            }
        }

        return true;
    }
}
