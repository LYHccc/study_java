/*把字符串转换成整数
题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
数值为0或者字符串不是一个合法的数值则返回0

输入描述:
输入一个字符串,包括数字字母符号,可以为空

输出描述:
如果是合法的数值表达则返回该数字，否则返回0
 */
public class StringToInt {
    public int StrToInt(String str){
        if(str.length() == 0)
            return 0;
        boolean flag = true;//true是正数，flag是负数
        int index = 0;//第一位是否为符号，是的话index置1，从1开始
        if(str.charAt(0) == '-'){
            index = 1;
            flag = false;
        }else if(str.charAt(0) == '+'){
            index = 1;
        }

        long res = 0;
        for(int i = index; i < str.length(); i++){
            int c = str.charAt(i) - '0';
            if(c > 9 || c < 0)
                return 0;
            res = res * 10 + c;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }

        if(!flag){
            return (int)(-1 * res);
        }else{
            return (int)res;
        }
    }
}
