import java.util.Scanner;

public class Main {
    private static User logic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.老师 2.学生");
        System.out.println("请选择您的身份：");
        int select = scanner.nextInt();
        User u;
        if(select == 1){                                //选择1创建老师对象
            u = new TeatherUser();
        }else if(select == 2){                          //选择2创建学生对象
            u = new StudentUser();
        }else{
            throw new RuntimeException("身份选择不正确");
        }
        return u;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            User user = logic();                             //logic()用来进行身份的选择
            user.menu();                                     //显示选择的身份的操作界面
            System.out.println("请选择要进行的操作：");
            int select = scanner.nextInt();
            user.operation(select);
        }
    }
}
