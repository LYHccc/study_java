/*简单错误记录
题目描述
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理：
1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），
对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
3、 输入的文件可能带路径，记录文件名称不能带路径。

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

输出描述:
将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：

示例1
输入
E:\V1R2\product\fpgadrive.c   1325
输出
fpgadrive.c 1325 1
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleMistakeRecord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while(scanner.hasNext()){
            String s = scanner.next();
            int n = scanner.nextInt();

            String[] sArr = s.split("\\\\");
            String temp = sArr[sArr.length - 1];
            if(temp.length() > 16){
                temp = temp.substring(temp.length() - 16);
            }
            StringBuilder str = new StringBuilder();
            str.append(temp).append(" ").append(n);

            map.put(str.toString(), map.getOrDefault(str.toString(), 0) + 1);
        }

        int count = 0;
        int index = map.size() - 8;
        for(String str : map.keySet()){
            if(count >= index){
                System.out.println(str + " " + map.get(str));
            }
            count++;
        }
    }
}
