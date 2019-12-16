//你现在是棒球比赛记录员。
//给定一个字符串列表，每个字符串可以是以下四种类型之一：
//1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
//2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
//3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
//4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除
//你需要返回你在所有回合中得分的总和。
import java.util.Stack;

public class CalPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i < ops.length; i++){
            if(ops[i].equals("C")){
                if(!stack.empty()){
                    stack.pop();
                }
            }else if(ops[i].equals("D")){
                if(!stack.empty()){
                    stack.push(stack.peek() * 2);
                }
            }else if(ops[i].equals("+")){
                int temp1 = 0;
                int temp2 = 0;
                if(!stack.empty()){
                    temp1 = stack.pop();
                }
                if(!stack.empty()){
                    temp2 = stack.peek();
                    stack.push(temp1);
                }
                stack.push(temp1 + temp2);
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        while(!stack.empty()){
            sum += stack.pop();
        }
        return sum;
    }
}
