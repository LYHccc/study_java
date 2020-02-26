//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
// 在执行上述操作后，找到包含重复字母的最长子串的长度。

public class CharacterReplacement {
    //滑动窗口思路解决
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];//num数组记录窗子中对应元素的个数
        int left = 0;//窗子的左边界
        int right = 0;//窗子的右边界
        int max = 0;//窗子中数量最多的元素个数
        for(right = 0; right < s.length(); right++){
            int index = s.charAt(right) - 'A';//新进入窗子的元素在num中的对应位置
            num[index]++;//对应位置数量加1
            max = Math.max(max, num[index]);//更新此时窗子中数量最多的元素个数
            if(right - left + 1 > max + k){//如果窗子中的元素个数大于此时窗子中数量最多的元素个数加上可以改变的个数k，那么说明此时不满足条件，窗子不能继续扩张了，需要开始滑动
                num[s.charAt(left) - 'A']--;//左边界第一个的元素会被滑出去，num中该元素的个数-1
                left++;
            }
        }
        return s.length() - left;
    }
}
