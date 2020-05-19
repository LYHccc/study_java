/*最近公共祖先
有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。

给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。
注意这里结点本身也可认为是其祖先。
 */
import java.util.HashSet;
import java.util.Set;

public class LeastCommonAncestors {
    public int getLCA(int a, int b) {
        if(a == 1 || b == 1) return 1;
        if(a == b) return a;

        Set<Integer> Set = new HashSet<>();
        int low = Math.max(a, b);
        int fast = Math.min(a, b);
        Set.add(fast);

        while(fast > 1){
            if(Set.contains(low)){
                return low;
            }else{
                low /= 2;
                fast /= 2;
                Set.add(fast);
            }
        }

        while(low > 1){
            if(Set.contains(low)){
                return low;
            }else{
                low /= 2;
            }
        }

        return 1;
    }
}
