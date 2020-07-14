/*数组中只出现一次的数字
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class NumberAppearOnlyOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        int num = 0;
        for(int i = 0; i < len; i++){
            num ^= array[i];
        }
        //找到最终两个数异或结果的第一个不同位即第一个为1的地方
        int index = findOne(num);
        //按照所有数字index位为1还是0将数组分为两组，这样两个数就分到不同的两组去了
        for(int i = 0; i < len; i++){
            if(bitNum(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private static int findOne(int num){
        int i = 0;
        while(i < 32 && ((num & 1) == 0)){
            num >>= 1;
            i++;
        }
        return i;
    }

    private static boolean bitNum(int num, int index){
        int n = (num >> index) & 1;
        return n == 0;
    }
}
