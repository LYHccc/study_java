//请你来实现一个函数，使其能将字符串转换成整数。
//首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
// 作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//在任何情况下，若函数不能进行有效的转换时，请返回 0。

public class MyAtoi {
    public static int myAtoi(String str) {
        if(str == null) return 0;
        int i = 0;
        //去除空格
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        //如果空格去除完毕发现已经遍历完整个字符串说明没有有效整数，返回0
        if(i == str.length()) return 0;
        //确定符号位
        int flag = 1;
        if(str.charAt(i) == '-'){
            flag = -1;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }
        //从有效数字开始的位置开始找出这个整数
        int num = 0;
        for(; i < str.length(); i++){
            char c = str.charAt(i);//当前位置的字符
            if(c < '0' || c > '9') break;//如果这个字符不是数字遍历结束
            //溢出判断
            //如果此时的数字大于Integer.MAX_VALUE/10(去掉最后一位)的大小，那么在下边更新数字的时候肯定就会溢出出错。返回边界值
            //如果等于Integer.MAX_VALUE/10，那么你需要判断下边更新数字要加的c如果大于Integer.MAX_VALUE % 10(即溢出界限的最后一位)，更新数字就会溢出出错。返回边界值
            //小于flag * num < Integer.MIN_VALUE / 10是一样的道理
            if(flag * num > Integer.MAX_VALUE / 10){
                return Integer.MAX_VALUE;
            }
            if(flag * num == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10){
                return Integer.MAX_VALUE;
            }
            if(flag * num < Integer.MIN_VALUE / 10){
                return Integer.MIN_VALUE;
            }
            if(flag * num == Integer.MIN_VALUE / 10 && -(c - '0') < Integer.MIN_VALUE % 10){
                return Integer.MIN_VALUE;
            }
            //更新数字
            num = num * 10 + (c - '0');
        }
        return num * flag;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoi(s));
    }
}
