/*回文串
题目描述：
给定一个字符串，问是否能通过添加一个字母将其变为回文串。

输入描述:
一行一个由小写字母构成的字符串，字符串长度小于等于10。

输出描述:
输出答案(YES\NO).
 */
import java.util.Scanner;

public class PalindRomicSubString {
    private static boolean flag = false;
    private static boolean isPalindRomic(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] aegs){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (isPalindRomic(s)) {
                flag = true;
            }

            int left = 0, right = s.length() - 1;
            while (left < right) {
                char cLeft = s.charAt(left);
                char cRight = s.charAt(right);
                if (cLeft != cRight) {
                    StringBuilder str = new StringBuilder();
                    str.append(s);
                    str.insert(left, cRight);
                    if (isPalindRomic(str.toString())) {
                        flag = true;
                        break;
                    } else {
                        str.deleteCharAt(left);
                        str.insert(right + 1, cLeft);
                        if (isPalindRomic(str.toString())) {
                            flag = true;
                        }
                    }
                    break;
                }

                left++;
                right--;
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
