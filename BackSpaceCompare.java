//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
// 判断二者是否相等，并返回结果。 # 代表退格字符。
import java.util.ArrayList;
import java.util.List;

public class BackSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();
        for(char c : S.toCharArray()){
            if(c != '#'){
                sList.add(c);
            }else{
                if(!(sList.isEmpty())){
                    sList.remove(sList.size() - 1);
                }
            }
        }
        for(char c : T.toCharArray()){
            if(c != '#'){
                tList.add(c);
            }else{
                if(!(tList.isEmpty())){
                    tList.remove(tList.size() - 1);
                }
            }
        }
        if(sList.equals(tList)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        BackSpaceCompare s = new BackSpaceCompare();
        System.out.println(s.backspaceCompare("ab##","c#d#"));
    }
}
