/*无缓存交换
请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。

测试样例：
[1,2]
返回：[2,1]
 */
public class CacheFreeSwitching {
    //方法一：加减法
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }

    /*
    //方法二：运用异或 a ^ 0 = a , a ^ a = 0 这个规律,
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];  // AB[1] = AB[0] ^ AB[1] ^ AB[1] = AB[0] ^ 0 = AB[0]
        AB[0] = AB[0] ^ AB[1];  //AB[0] = AB[0] ^ AB[1] ^ AB[0] = AB[1] ^ 0 = AB[1]
        return AB;
    }
    */
}
