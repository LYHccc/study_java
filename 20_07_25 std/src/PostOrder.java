/*二叉树的后序遍历序列
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class PostOrder {
    private static boolean isRes(int[] arr, int start, int root){
        if(start >= root) return true;
        int index = start;
        while(index < root){
            if(arr[index] > arr[root])
                break;
            index++;
        }
        for(int i = root; i > index; i--){
            if(arr[i] < arr[root]) return false;
        }
        return  isRes(arr, start, index - 1) && isRes(arr, index, root - 1);
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return isRes(sequence, 0, sequence.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 9, 10, 11, 6};
        System.out.println(VerifySquenceOfBST(arr));
    }
}
