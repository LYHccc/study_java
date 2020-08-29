/**
 * 分解质因数
 * 给定一个数字返回分解素数
 * 实例输入：50
 * 输出：2*5*5
 */

import java.util.Scanner;

public class Main4 {
    private static StringBuilder res;
    private static boolean isNumber(int n){
        if(n == 1 || n == 2) return true;
        for(int i = 2; i < n / 2; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    private static void deliver(int n){
        if(isNumber(n)){
            res.append(n).append("*");
            return;
        }
        for(int i = 2; i < n; i++){
            if(!isNumber(i))
                continue;
            if(n % i == 0){
                res.append(i).append("*");
                deliver(n / i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        res = new StringBuilder();
        deliver(num);
        if(res.length() != 0){
            res.deleteCharAt(res.length() - 1);
        }
        System.out.println(res.toString());
    }
}
