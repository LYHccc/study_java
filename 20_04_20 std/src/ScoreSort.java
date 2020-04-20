/*成绩排序
题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

示例：          从高到低  成绩       从低到高
jack      70    peter     96        smith     67
peter     96    jack      70        jack      70
Tom       70    Tom       70        Tom      70
smith     67    smith     67        peter     96

输入描述:
输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，
以一个空格隔开

输出描述:
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person{
    String name;
    int score;

    public Person(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class ScoreSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            int mode = scanner.nextInt();
            Person[] arr = new Person[num];
            for (int i = 0; i < num; i++) {
                arr[i] = new Person(scanner.next(), scanner.nextInt());
            }

            if (mode == 0) {
                Arrays.sort(arr, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o2.score - o1.score;
                    }
                });
            }

            if (mode == 1) {
                Arrays.sort(arr, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.score - o2.score;
                    }
                });
            }

            for (int i = 0; i < num; i++) {
                System.out.println(arr[i].name + " " + arr[i].score);
            }
        }
    }
}
