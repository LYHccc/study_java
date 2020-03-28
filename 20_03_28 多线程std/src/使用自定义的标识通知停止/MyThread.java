package 使用自定义的标识通知停止;
public class MyThread extends Thread {
    private Condition condition;
    public MyThread(Condition condition){
        this.condition = condition;
    }

    @Override
    public void run() {
        Thread thread = currentThread();
        while (condition.running) {
            System.out.println(thread.getId() + ": 工作");
        }
    }
}
