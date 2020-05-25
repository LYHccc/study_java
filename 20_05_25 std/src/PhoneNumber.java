/*电话号码
1       2(ABC) 3(DEF)
4(GHI)  5(JKL) 6(MNO)
7(PQRS) 8(TUV) 9(WXYZ)
0
上图是一个电话的九宫格，如你所见一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。
例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。
同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分。

输入描述:
输入包含多组数据。
每组数据第一行包含一个正整数n（1≤n≤1024）。
紧接着n行，每行包含一个电话号码，电话号码仅由连字符“-”、数字和大写字母组成。
没有连续出现的连字符，并且排除连字符后长度始终为7（美国电话号码只有7位）。

输出描述:
对应每一组输入，按照字典顺序输出不重复的标准数字形式电话号码，即“xxx-xxxx”形式。
每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
 */
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneNumber{
    private static final String[] arr = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    private static String transition(String number){
        String s = number.replaceAll("-","");
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                str.append(c);
            }else{
                for(int i = 0; i < arr.length; i++){
                    if(arr[i].contains(Character.toString(c))){
                        str.append(i);
                        break;
                    }
                }
            }

            if(str.length() == 3){
                str.append("-");
            }
        }

        return str.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            Set<String> set = new TreeSet<>();
            for(int i = 0; i < n; i++){
                String s = scanner.next();
                String temp = transition(s);
                set.add(temp);
            }
            for(String s : set){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}