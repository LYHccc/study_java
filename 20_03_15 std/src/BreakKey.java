//旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
//肯定坏掉的那些键。
//输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
//以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
//按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
import java.util.HashSet;
import java.util.Scanner;

public class BreakKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = scanner.nextLine();
        HashSet<Character> worrySet = new HashSet<>();
        for(char c : output.toCharArray()){
            worrySet.add(Character.toUpperCase(c));
        }
        for(char c : input.toCharArray()){
            c = Character.toUpperCase(c);
            if(!worrySet.contains(c)){
                System.out.print(c);
                worrySet.add(c);
            }
        }
        System.out.println();
    }
}
