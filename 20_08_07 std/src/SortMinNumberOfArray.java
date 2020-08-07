/*把数组排成最小的数
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
import java.util.Arrays;
import java.util.Comparator;

public class SortMinNumberOfArray {
    public String PrintMinNumber(int [] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String s : arr){
            res.append(s);
        }
        return res.toString();
    }
}
