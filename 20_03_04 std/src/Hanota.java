//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
//(1) 每次只能移动一个盘子;
//(2) 盘子只能从柱子顶端滑出移到下一根柱子;
//(3) 盘子只能叠在比它大的盘子上。
//请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
//你需要原地修改栈。

import java.util.LinkedList;
import java.util.List;

public class Hanota {
    public static void hanota1(int n, List<Integer> from, List<Integer> to, List<Integer> other){
        if(n == 1){
            to.add(from.remove(from.size() - 1));
        }else{
            hanota1(n - 1, from, other, to);
            hanota1(1, from, to, other);
            hanota1(n - 1, other, to, from);
        }
    }
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota1(A.size(), A, C, B);
    }

    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        A.add(1);
        A.add(0);
        List<Integer> B = new LinkedList<>();
        List<Integer> C = new LinkedList<>();
        System.out.print(A);
        System.out.print(B);
        System.out.println(C);
        System.out.println("移动后：");
        hanota(A, B, C);
        System.out.print(A);
        System.out.print(B);
        System.out.println(C);
    }
}
