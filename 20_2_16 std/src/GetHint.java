//你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。//请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
//请注意秘密数字和朋友的猜测数都可能含有重复数字。

public class GetHint {
    public String getHint(String secret, String guess) {
        StringBuilder str = new StringBuilder();
        int[] A = new int[10];
        int[] B = new int[10];
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i))
                countA++;
            char cA = secret.charAt(i);
            char cB = guess.charAt(i);
            A[cA - '0']++;
            B[cB - '0']++;
        }
        for(int i = 0; i < A.length; i++){
            countB += Math.min(A[i], B[i]);
        }
        str.append(countA).append("A").append(countB - countA).append("B");
        return str.toString();
    }
}
