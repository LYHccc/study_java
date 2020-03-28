package 线程状态;

public class 线程状态展示 {
    public static void main(String[] args) {
        Thread.State[] stateArr = Thread.State.values();
        for(Thread.State state : stateArr){
            System.out.println(state);
        }
    }
}
