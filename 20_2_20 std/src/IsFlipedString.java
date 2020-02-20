//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

public class IsFlipedString {
    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        String s3 = s1 + s1;
        return s3.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "bab";
        System.out.println(isFlipedString(s1, s2));
    }
}
