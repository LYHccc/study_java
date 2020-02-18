//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
//（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）

public class CountPrimeSetBits {
    public static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static int countPrimeSetBits(int L, int R) {
        /*
        //二进制整数最多有32个1，可以创建一个数组存储0-32是不是质数
        boolean[] flag = new boolean[33];
        for(int i = 2; i < 32; i++){
            flag[i] = isPrime(i);
        }
        */
        int count = 0;
        for(int i = L; i <= R; i++){
            int temp = 0;
            int num = i;
            while(num > 0){
                temp += num % 2 == 1 ? 1 : 0;
                num /= 2;
            }
            /*
            if(flag[temp])
                count++;
                */
            if(isPrime(temp))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }
}
