//如果出现下述两种情况，交易 可能无效：
//交易金额超过 ¥1000
//或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
//每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
//给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。

import java.util.LinkedList;
import java.util.List;

public class InvalidTransactions {
    public static List<String> invalidTransactions(String[] transactions) {
        List<String> list = new LinkedList<>();
        boolean[] flag = new boolean[transactions.length];
        for(int i = 0; i < transactions.length; i++){
            String[] s1 = transactions[i].split(",");
            int num1 = Integer.valueOf(s1[2]);
            if(num1 > 1000 && flag[i] == false){
                list.add(transactions[i]);
                flag[i] = true;
            }
            for(int j = i + 1; j < transactions.length; j++){
                String[] s2 = transactions[j].split(",");
                int num2 = Integer.valueOf(s1[1]);
                int num3 = Integer.valueOf(s2[1]);
                if(s1[0].equals(s2[0]) && Math.abs(num2 - num3) <= 60 && !s1[3].equals(s2[3]                  )){
                    if(flag[i] == false){
                        list.add(transactions[i]);
                        flag[i] = true;
                    }
                    if(flag[j] == false){
                        list.add(transactions[j]);
                        flag[j] = true;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] s = {"bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona","alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"};
        System.out.println(invalidTransactions(s));
    }
}
