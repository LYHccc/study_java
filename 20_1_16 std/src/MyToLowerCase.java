//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

public class MyToLowerCase {
    public String toLowerCase(String str) {
        char[] s = new char[str.length()];
        char c = ' ';
        for(int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                s[i] = (char)(c + 32);
            }else{
                s[i] = c;
            }
        }
        return new String(s);
    }
}
