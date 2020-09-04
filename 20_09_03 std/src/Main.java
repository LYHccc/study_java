/**
 * 最长连续子数组
 * 给定一个由若干个0和1组成的数组，我们最多可以将k个0变为1，返回仅包含1的最长连续子数组的长度
 */
public class Main {
    public static int GetMaxConsecutiveOnes (int[] arr, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < arr.length){
            if(arr[right] == 1){
                right++;
                max = Math.max(max, right - left);
                continue;
            }
            if(arr[right] == 0){
                if(k > 0){
                    right++;
                    k--;
                }else{
                    if(arr[left] == 0){
                        k++;
                    }
                    left++;
                }
                max = Math.max(max, right - left);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(GetMaxConsecutiveOnes(arr, 2));
    }
}
