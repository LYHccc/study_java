/*简单错误记录
题目描述
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

    文件路径为windows格式

    如：E:\V1R2\product\fpgadrive.c 1325

输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
    如果超过8条记录，则只输出前8条记录.
    如果文件名的长度超过16个字符，则只输出后16个字符
 */
import java.util.*;

public class SimpleErrorRecord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new LinkedHashMap<>();
        while(scanner.hasNext()){
            String s = scanner.next();
            int n = scanner.nextInt();
            StringBuilder str = new StringBuilder();
            str.append(s).append(" ").append(n);
            String[] sArr = str.toString().split("\\\\");
            String temp = sArr[sArr.length - 1];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

       int count = 0;
        for(Map.Entry<String, Integer> m : list){
            if(count == 8){
                break;
            }
            String s = m.getKey();
            String[] arr = s.split(" ");
            if(arr[0].length() > 16){
                System.out.println(arr[0].substring(arr[0].length() - 16) + " " + arr[1] + " " + m.getValue());
            }else{
                System.out.println(s + " " + m.getValue());
            }
            count++;
        }
    }
}
