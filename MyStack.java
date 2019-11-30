//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

import java.util.Stack;

public class MyStack {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        //用一个数组来记录要进行判断的符号
        char[][] arr = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
        //遍历输入的字符串
        for(int i = 0; i < s.length(); i++){
            char stackCur = s.charAt(i);
            //flag用来表示当前这个是符号是左括号还是右括号 0代表右  1代表左
            int flag = 0;
            //确定是哪一个左括号
            for(int j = 0; j < arr.length; j++){
                //如果此时的符号是左括号，将这个符号压入栈中
                if(stackCur == arr[j][0]){
                    stack.push(stackCur);
                    flag = 1;
                    break;
                }
            }
            //如果是右括号
            if(flag == 0){
                //如果此时栈中没有元素，说明不匹配
                if(stack.isEmpty()){
                    return false;
                }else{
                    //取出此时的栈顶元素
                    char stackTop = stack.pop();
                    //确定是哪一个左括号
                    for(int k = 0; k < arr.length;k++){
                        //找相应的左括号后，
                        //判断这个左括号能不能与遍历到的右括号匹配
                        if(stackTop == arr[k][0]){
                            if(stackCur == arr[k][1]){
                                break;
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        //判断栈中是否为空，如果是空说明遍历所有括号，相互匹配成功
        return stack.isEmpty();
    }
}
