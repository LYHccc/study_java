
public class Process {
    String name;//进程名
    int arriveTime;//到达时间
    int serveTime;//服务时间
    int beginTime;//开始时间
    int finshTime;//结束时间
    int roundTime;//周转时间
    double aveRoundTime;//带权周转时间
    double clock=0;//在时间轮转调度算法中，记录该进程真实服务时间已经用时的时长

    public Process() {

    }
    public Process(String name, int arriveTime, int serveTime) {
        super();
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
    }

    public String toString() {
        String info=new String("进程名：P"+this.name);
        return info;
    }

}
