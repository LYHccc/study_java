//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        //name和typed字符串的遍历下标
        int nameIndex = 0;
        int typedIndex = 0;
        //如果有一个遍历完了循环结束
        while (nameIndex < name.length() && typedIndex < typed.length()) {
            //如果此时的name字符串下标位置的字符与typed字符串的下标位置字符相等，两个下标同时++
            if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex++;
            }
            //否则只让typed的下标++
            typedIndex++;
        }
        //循环结束后判断name是否被遍历完
        return nameIndex == name.length();
    }
}
