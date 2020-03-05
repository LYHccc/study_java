//给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
//求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。

public class NumSubarrayBoundedMax {

    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        //最大元素满足大于等于L 小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
        return count(A, R) - count(A, L - 1);
    }
    private static int count(int[] A, int max){//最大元素小于等于max的子数组个数
        int count = 0;//记录当前已有的子数组个数
        int num = 0;//在一连续区间中，当前小于等于max的元素个数
        for(int a: A){
            if(a <= max){//找到小于等于max的元素
                num++;//num数量加1
                count += num;//子数组个数更新，加上新找到的元素产生的新子数组(数组的元素个数num加1，子数组个数会增加num个)
            }else{
                num = 0;//如果某处小于max那么连续区间会在这断开，在下一个连续区间进行查找num置为0
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3};
        System.out.println(numSubarrayBoundedMax(A, 2, 3));
    }
}
