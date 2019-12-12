//给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
        }
        int count = 0;
        int sum1 = 0;
        for(; count < A.length; count++){
            sum1 += A[count];
            if(sum1 == sum / 3){
                count++;
                break;
            }
        }
        int sum2 = 0;
        for(; count < A.length; count++){
            sum2 += A[count];
            if(sum2 == sum / 3){
                count++;
                break;
            }
        }
        int sum3 = 0;
        for(; count < A.length; count++){
            sum3 += A[count];
        }
        if(sum3 == sum / 3){
            return true;
        }
        return false;
    }
}
