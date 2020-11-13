/*
 * 全排列
 * 对于某个串，比如：“1234”，求它的所有全排列。
 * 并且要求这些全排列一定要按照字母的升序排列。
 */
import java.util.*;

public class WholeArrangement {
	public static void dfs(List<String> list, String s, boolean[] flag, String cur){
		if(cur.length() == s.length()){
			list.add(cur);
			return;
		}
		for(int i = 0; i < s.length(); i++){
			if(flag[i]){
				continue;
			}
			flag[i] = true;
			dfs(list, s, flag, cur + s.charAt(i));
			flag[i] = false;
		}
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		List<String> list = new ArrayList<>();
		boolean[] flag = new boolean[s.length()];
		dfs(list, s, flag, "");
		System.out.println(list);
		scanner.close();
	}
}
