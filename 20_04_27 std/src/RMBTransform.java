/*人民币转换
1、中文大写金额数字前应标明“人民币”字样。
中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。
在”角“和”分“后面不写”整字。（30分）
3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，
中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（

输入描述:
输入一个double数

输出描述:
输出人民币格式
 */
import java.util.Scanner;

public class RMBTransform {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();

            String[] arr = input.split("\\.");//分割出整数位和小数位
            StringBuilder str = new StringBuilder();
            String[] data = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
            String[] util = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万"};

            String s1 = arr[0];
            str.append("人民币");
            int len = s1.length();
            boolean flag = false; //标志位，看前面是不是全0
            for (int i = 0; i < len; i++) {
                int num = s1.charAt(i) - '0'; //这一位的数值
                int index = len - i - 1;     //这一位应处于的位置
                if (num == 0) {
                    if (i + 1 < len && s1.charAt(i + 1) != '0') {  //处理连续的0只读最后一个0
                        str.append(data[num]);
                    }
                } else if (i == 0 && (index == 1 || index == 5 || index == 9) && num == 1) {//处理开头是1的情况
                    flag = true;
                    str.append(util[index]);
                } else {
                    flag = true;
                    str.append(data[num]).append(util[index]);
                }
            }
            if (flag) {//如果不全是0，加上元
                str.append("元");
            }

            String s2 = arr[1];
            if (s2.equals("00")) {
                str.append("整");
            } else {
                if (s2.charAt(0) != '0') {
                    str.append(data[s2.charAt(0) - '0']).append("角");
                }
                if (s2.charAt(1) != '0') {
                    str.append(data[s2.charAt(1) - '0']).append("分");
                }
            }

            System.out.println(str.toString());
        }
    }
}
