//给定一组字符，使用原地算法将其压缩。
//压缩后的长度必须始终小于或等于原数组长度。
//数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//在完成原地修改输入数组后，返回数组的新长度。

public class Compress {
    public int compress(char[] chars) {
        int i = 0;//遍历字符串当前遍历到的位置下标
        int flag = 0;//更新数组更新到的下标
        while(i < chars.length && flag < chars.length){
            chars[flag++] = chars[i];//新的字符存下
            int temp = i;//相同的新字符序列的首元素下标
            //将i的位置向后移，直到下个新字符出现，此时i的位置是在上边字符序列末尾的下一个位置
            while(i < chars.length && chars[i] == chars[flag - 1])
                i++;
            //因为此时i的位置是在上边字符序列末尾的下一个位置，所以i - temp的值就是相同字符的长度
            if(i - temp > 1){//只有相同字符长度大于1
                //将长度从int先转化成字符串再转化成字符数组存入更新数组中
                for(char c : String.valueOf(i - temp).toCharArray())
                    chars[flag++] = c;
            }
        }
        return flag;
    }
}
