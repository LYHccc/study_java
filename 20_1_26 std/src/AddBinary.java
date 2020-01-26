//给定两个二进制字符串，返回他们的和（用二进制表示）。
//输入为非空字符串且只包含数字 1 和 0。

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();//定义一个新的字符串s
        int aIndex = a.length() - 1;//字符串a的下标位置
        int bIndex = b.length() - 1;//字符串b的下标位置
        int sum = 0;//某一位相加的和
        int carry = 0;//进位是多少（1 或者 0）
        //如果两个字符串都遍历完了循环结束
        while(aIndex >= 0 || bIndex >= 0){
            sum = carry;//加上上一位的进位
            sum += aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;//a的下标如果大于等于0，说明a没有遍历完加上a此时下标位置的值；如果小于0，说明a已经遍历完了加0
            sum += bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;//加上b下标位置的值
            s.append(sum % 2);//将这一位的结果拼接到s上（如果是2则会产生进位，此位置0；0或1则正常记录）
            carry = sum / 2;//进位的值（2则进1；0或1则不进）
            aIndex--;
            bIndex--;
        }
        //如果循环结束之后最后一位产生进位，那么给字符串s拼接一个"1"，作为进位
        if(carry == 1){
            s.append("1");
        }
        //将字符串反转返回，因为我们是从前往后拼接，遍历是从后往前，所以需要一个反转字符串
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
