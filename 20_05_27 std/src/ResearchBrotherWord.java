//查找兄弟单词
import java.util.Arrays;
import java.util.Scanner;

public class ResearchBrotherWord {
    private static boolean isBrother(String s1, String s2){
        if(s1.equals(s2)){
            return false;
        }

        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        for(char c : s1.toCharArray()){
            arr1[c - 'a']++;
        }
        for(char c : s2.toCharArray()){
            arr2[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] dic = new String[n];
            for (int i = 0; i < n; i++) {
                dic[i] = scanner.next();
            }
            Arrays.sort(dic);
            String word = scanner.next();
            int num = scanner.nextInt();

            String[] arr = new String[n];
            int index = 0;
            for (String str : dic) {
                if (isBrother(word, str)) {
                    arr[index++] = str;
                }
            }

            if(index == 0){
                System.out.println(0);
            }else if(num > index){
                System.out.println(index);
            }else {
                System.out.println(index);
                System.out.println(arr[num - 1]);
            }
        }
    }
}
