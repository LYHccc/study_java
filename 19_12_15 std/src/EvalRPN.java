//根据逆波兰表示法，求表达式的值。
//有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 - temp1);
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
