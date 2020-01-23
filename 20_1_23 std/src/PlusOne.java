//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//你可以假设除了整数 0 之外，这个整数不会以零开头。

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                if(i != 0){
                    digits[i] = 0;
                }
            }else{
                digits[i]++;
                return digits;
            }
        }
        int[] temp = new int[digits.length +1];
        temp[0] = 1;
        return temp;
    }
}
