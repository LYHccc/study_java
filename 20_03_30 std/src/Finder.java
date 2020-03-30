/*寻找第K大
有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class Finder {
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int quickSort(int[] a, int left, int right){
        int index = left;
        int key = a[left];
        while(left < right){
            while(left < right && a[right] > key){
                right--;
            }
            while(left < right && a[left] <= key){
                left++;
            }
            swap(a, left, right);
        }
        swap(a, index, left);
        return left;
    }

    public static int findKth(int[] a, int n, int K) {
        int max = n - K;
        int left = 0, right = n - 1;
        int mid = quickSort(a, left, right);
        while(mid != max){
            if(mid > max){
                right = mid - 1;
                mid = quickSort(a, left, right);
            }else{
                left = mid + 1;
                mid = quickSort(a, left, right);
            }
        }
        return a[mid];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7};
        System.out.println(findKth(a, 5, 3));
    }
}
