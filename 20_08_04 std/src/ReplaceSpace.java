/*替换空格
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    /*
    //方法一：直接调用API
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }
    */
    //方法二：手动添加
    public String replaceSpace(StringBuffer str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                res.append("%20");
            else
                res.append(str.charAt(i));
        }
        return res.toString();
    }
}
