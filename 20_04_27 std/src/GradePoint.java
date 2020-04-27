/*学分绩点
题目描述:
北京大学对本科生的成绩施行平均学分绩点制（GPA）。
既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
公式如下： 实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0 75——77 2.7
72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0
1．一门课程的学分绩点=该课绩点*该课学分
2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）。

输入描述:
第一行 总的课程数n（n<10）；
第二行 相应课程的学分（两个学分间用空格隔开）；
第三行 对应课程的实际得分；
此处输入的所有数字均为整数。

输出描述:
输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
 */
import java.util.Scanner;

public class GradePoint {
    private static double showCredit(int score){
        if(score >= 90 && score <= 100){
            return 4.0;
        }
        if(score >= 85 && score <= 89){
            return 3.7;
        }
        if(score >= 82 && score <= 84){
            return 3.3;
        }
        if(score >= 78 && score <= 81){
            return 3.0;
        }
        if(score >= 75 && score <= 77){
            return 2.7;
        }
        if(score >= 72 && score <= 74){
            return 2.3;
        }
        if(score >= 68 && score <= 71){
            return 2.0;
        }
        if(score >= 64 && score <= 67){
            return 1.5;
        }
        if(score >= 60 && score <= 63){
            return 1.0;
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] credit = new double[n];
        int[] score = new int[n];
        for(int i = 0; i < n; i++){
            credit[i] = scanner.nextDouble();
        }
        for(int i = 0; i < n; i++){
            score[i] = scanner.nextInt();
        }

        double gradePoint = 0;
        int creditSum = 0;
        for(int i = 0; i < n; i++){
            gradePoint += credit[i] * showCredit(score[i]);
            creditSum += credit[i];
        }

        double res = gradePoint / creditSum;
        System.out.printf("%.2f", res);
    }
}
