/*丑数
题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    /*
    //方法一：判断每一个数是不是丑数，找到第N个丑数
    private static boolean isUgly(int num){
        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
            }else if(num % 3 == 0){
                num /= 3;
            }else if(num % 5 == 0){
                num /= 5;
            }else{
                return false;
            }
        }
        return true;
    }

    public static int GetUglyNumber_Solution(int index) {
        int count = 0;
        int i = 1;
        while(true){
            if(isUgly(i)){
                count++;
            }
            if(count == index)
                return i;
            i++;
        }
    }
    */

    /**
     * 方法二：1是第一个丑数，后边的丑数一定是前边的某个丑数 *2 或 *3 或 *5的得到的
     * 用数组保存从小到大的每一个丑数，那么后边数组中新增的丑数一定是当前数组中的某个丑数*2或*3或*5得到
     * 当前数组中每一个元素*2 *3 *5都会得到一个新的丑数，那么该用哪个丑数乘，又该将哪个丑数加入数组
     * 用三个指针c2、c3、c5分别表示要得到新丑数时，数组中哪个下标的元素该去*2、*3、*5
     * 三个指针所指位置*2、*3、*5得到的三个丑数找到最小的加入数组
     * 之后将得到这个丑数的指针向后移指向下一个位置
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;
        int[] arr = new int[index];
        arr[0] = 1;
        int c2 = 0, c3 = 0, c5 = 0;
        for(int i = 1; i < index; i++){
            int min = Math.min(arr[c2] * 2, Math.min(arr[c3] * 3, arr[c5] * 5));
            if(arr[c2] * 2 == min) c2++;
            if(arr[c3] * 3 == min) c3++;
            if(arr[c5] * 5 == min) c5++;
            arr[i] = min;
        }
        return arr[index - 1];
    }
}
