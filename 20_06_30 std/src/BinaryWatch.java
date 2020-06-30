/*二进制手表
二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。
给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

示例：
输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {
    private static final int[] arr = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

    private static void dfs(List<String> list, int num, int hour, int minute, int index){
        if(num == 0){
            StringBuilder str = new StringBuilder();
            str.append(hour);
            str.append(":");
            if(minute < 10){
                str.append("0").append(minute);
            }else{
                str.append(minute);
            }
            list.add(str.toString());
            return;
        }
        for(int i = index; i < 10; i++){
            if(i < 4){
                int temp = hour + arr[i];
                if(temp > 11) continue;
                dfs(list, num - 1, temp, minute, i + 1);
            }else{
                int temp = minute + arr[i];
                if(temp > 59) continue;
                dfs(list, num - 1, hour, temp, i + 1);
            }
        }
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new LinkedList<>();
        dfs(list, num, 0, 0, 0);
        return list;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(readBinaryWatch(n));
    }
}
