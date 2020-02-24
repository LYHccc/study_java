//给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
//我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
//山羊拉丁文的规则如下：
//如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
//例如，单词"apple"变为"applema"。
//如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
//例如，单词"goat"变为"oatgma"。
//根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
//例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
//返回将 S 转换为山羊拉丁文后的句子。

public class ToGoatLatin {
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'             || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }

    public String toGoatLatin(String S) {
        String[] str = S.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            char c = str[i].charAt(0);
            if(isVowel(c)){
                builder.append(str[i]).append("ma");
                for(int j = 0; j <= i; j++){
                    builder.append("a");
                }
                builder.append(" ");
            }else{
                builder.append(str[i].substring(1, str[i].length())).append(c + "")                                         .append("ma");
                for(int j = 0; j <= i; j++){
                    builder.append("a");
                }
                builder.append(" ");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
