import java.util.ArrayList;
import java.util.List;

public class Stringstd {
    //返回比 s 小的字符串
    private List<String> smallList (List<String> origin, String s){
        List<String> list = new ArrayList<>();
        for(String cur : origin){
            if(cur.compareTo(s) < 0){
                list.add(cur);
            }
        }
        return list;
    }

    //返回等于 s 的字符串
    private List<String> equalS(List<String> origin, String s) {
        List<String> list = new ArrayList<>();
        for (String cur : origin) {
            if (cur.equals(s)) {
                list.add(cur);
            }
        }
        return list;
    }

    //返回等于 s 的字符串（不区分大小写）
    private List<String> equalToDiffer(List<String> origin, String s){
        List<String> list = new ArrayList<>();
        for(String cur : origin){
            if(cur.equalsIgnoreCase(s)){
                list.add(cur);
            }
        }
        return list;
    }

    //返回 s 结尾的字符串
    private List<String> returnLate(List<String> origin, String s){
        List<String> list = new ArrayList<>();
        for(String cur : origin){
            if(cur.endsWith(s)){
                list.add(cur);
            }
        }
        return list;
    }

    //返回包含 s 的字符串
    private List<String> includeS(List<String> origin, String s){
        List<String> list = new ArrayList<>();
        for(String cur : origin){
            if(cur.contains(s)){
                list.add(cur);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("abc");
        list.add("我是abc");
        list.add("我爱java");
        list.add("ABC");
        System.out.println(list);
        Stringstd s = new Stringstd();
        list = s.smallList(list, "abc");         //[ABC]
        System.out.println(list);
        /*
        list = s.equalToDiffer(list, "abc");        //[abc, ABC]
        System.out.println(list);
        list = s.equalS(list, "abc");               //[abc]
        System.out.println(list);
        list = s.includeS(list, "我");              //[我是abc, 我爱java]
        System.out.println(list);
        list = s.returnLate(list, "abc");              //[abc, 我是abc]
        System.out.println(list);
        */
    }
}
