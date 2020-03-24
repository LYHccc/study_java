/*
我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 */
public class NumSmallerByFrequency {
    /*
    //方法一：
    public int f(String s){
        int[] num = new int[26];
        for(char c : s.toCharArray()){
            num[c - 'a']++;
        }
        for(int i = 0; i < num.length; i++){
            if(num[i] != 0){
                return num[i];
            }
        }
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arr = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            for(int j = 0; j < words.length; j++){
                if(f(queries[i]) < f(words[j])){
                    arr[i]++;
                }
            }
        }
        return arr;
    }
    */
    //方法二：
    public int f(String s){
        int[] num = new int[26];
        for(char c : s.toCharArray()){
            num[c - 'a']++;
        }
        for(int i = 0; i < num.length; i++){
            if(num[i] != 0){
                return num[i];
            }
        }
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];
        for(int i = 0; i < words.length; i++){
            count[f(words[i])]++;
        }
        for(int i = 10; i > 0; i--){
            count[i] += count[i + 1];
        }
        int[] arr = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            arr[i] = count[f(queries[i]) + 1];
        }
        return arr;
    }
}
