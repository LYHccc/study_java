//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
// 如果可以构成，返回 true ；否则返回 false。
//(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }

        //count中的每一个位置用来保存26个英文字母的个数
        int[] count = new int[26];
        //记录magazine中每个字符的个数，存入count中
        for(char c : magazine.toCharArray()){
            count[c - 'a']++;
        }

        //找出ransomNote中的每一个字符，将其在数组中的对应位置数量减1，减1后判断是否小于0即超过了         某个字符的个数，如果超过了则返回false
        for(char c : ransomNote.toCharArray()){
            if(--count[c - 'a'] < 0){//注意这里需要先减在判断
                return false;
            }
        }
        return true;
    }
}
