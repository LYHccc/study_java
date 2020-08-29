import java.util.Scanner;

public class Main2 {
    private static int[] quickSort(int[] arr){
        int len  =  arr.length;
        for(int i = 0; i < len - 1; i++){
            int min = i;
            for(int j = i + 1; j < len; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();
        String[] sArr = s.split(",");
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.valueOf(sArr[i]);
        }
        quickSort(arr);
        for(int i = 0; i < num; i++){
            if(i != num - 1){
                System.out.print(arr[i] + ",");
            }else{
                System.out.print(arr[i]);
            }
        }
    }
}
