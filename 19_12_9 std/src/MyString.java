import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyString {
    //字符串比较s1大于s2返回值大于零，等于返回0，小于返回小于零
    public int compareTo(String s1, String s2){
        int shortLen = 0;
        //找出较短的字符串，长度记为shortLen
        if(s1.length() >= s2.length()){
            shortLen = s2.length();
        }else{
            shortLen = s1.length();
        }
        //遍历完短的字符串看在shortLen的长度内的字符是否相同
        //不相同的话返回对应的值
        for(int i = 0; i < shortLen; i++){
            if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }
            if(s1.charAt(i) < s2.charAt(i)){
                return -1;
            }
        }
        //如果相同判断两个字符串长度是否相同
        //如果相同说明在上边循环执行完没有返回的条件两个字符串在shortLen长度内相等，两个字符串相等
        //如果不等看哪个长，返回对应的值
        if(s1.length() == s2.length()){
            return 0;
        }
        return (s1.length() - s2.length() > 0) ? 1 : -1;
    }

    //判断s2是不是s1的子字符串
    public boolean contains(String s1, String s2){
        //count用来记录在发现s1和s2首字母相同后，进行比较s1从相同点开始是否与s2相同的过程中，记录比较结束进行了几次判断，
        // 如果count与s2的长度相等说明比较完了没有提前结束，s2就是s1的子字符串
        //如果不相等说明提前结束了，继续s1向下遍历找下一个首字母相同的字符
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            //找到首字母相同的地方
            if(s1.charAt(i) == s2.charAt(0)){
                //更新count的值，防止上次内循环count的变化影响
                count = 0;
                for(int j = 0; j < s2.length(); j++){
                    //保证遍历到的地方s1还有字符才进行判断
                    if(i + j < s1.length()) {
                        //如果有不相同的字符，结束内循环
                        if (s1.charAt(i + j) != s2.charAt(j)) {
                            break;
                        }
                        count++;
                    }
                }
                if(count == s2.length()){
                    return true;
                }
            }
        }
        return false;
    }

    //从头开始查找s1，看s2是不是s1的子字符串，找到返回位置的开始下标，找不到返回-1
    public int indexOf(String s1, String s2){
        //只是在判断是不是子字符串的前提下，加上了返回位置开始的下标，同样的道理
        int count = 0;
        int i = 0;
        int j = 0;
        for(i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(0)){
                count = 0;
                for(j = 0; j < s2.length(); j++){
                    if(i + j < s1.length()) {
                        if (s1.charAt(i + j) != s2.charAt(j)) {
                            break;
                        }
                        count++;
                    }
                }
                if(count == s2.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    // 能够指定分割符s2将字符串s1拆分成字符串数组(不必支持正则表达式)
    public String[] split(String s1, String s2){
        //创建一个线性表list，用来保存分割后的字符串
        List<String> list = new ArrayList<>();
        //如果字符串中有分隔符进行循环中的操作
        while(contains(s1, s2)){
            //找到开始分割的位置
            int index = indexOf(s1, s2);
            //将分割符前边的字符串保存下来
            String temp = s1.substring(0, index);
            //添加到list中
            list.add(temp);
            //将分割后分隔符前边的字符串去掉，更新要分割的字符串
            s1 = s1.substring((temp + s2).length());
        }
        //因为循环结束的条件是字符串中没有了分割符，所以最后一次循环结束最后一次分割剩下的字符串还没有放到list中
        //将其尾插到list中
        list.add(s1);
        //将list中的字符串提取到str[]数组中
        String[] str = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            str[i] = list.get(i);
        }
        return str;
    }

    public static void main(String[] args) {
        MyString s = new MyString();
        String s1 = "aa aa ba abc";
        String s2 = "abc";
        System.out.println(s.compareTo(s1, s2));
        System.out.println(s.contains(s1, s2));
        System.out.println(s.indexOf(s1, s2));
        System.out.println(Arrays.toString(s.split(s1, " ")));
    }
}
