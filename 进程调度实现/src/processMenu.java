import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class processMenu {

    ArrayList<Process> jcb;// 存放所有进程
    LinkedList<Process> link;// 存放已经进入队列的进程
    ArrayList<Process> new_jcb;// 存放已经按指定调度算法实现完成后的进程
    Process nowProess;// 当前应执行进程

    public void init(Process[] p, int n) {//初始化
        jcb = new ArrayList<Process>();
        link = new LinkedList<Process>();
        new_jcb = new ArrayList<Process>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入进程的信息（进程名、到达时间、服务时间）:");
        for(int i = 0; i < n; i++){
            System.out.println("请输入第" + (i + 1) + "个进程信息");
            p[i] = new Process();
            System.out.print("进程名：");
            p[i].name = scanner.next();
            System.out.print("到达时间：");
            p[i].arriveTime = scanner.nextInt();
            System.out.print("服务时间：");
            p[i].serveTime = scanner.nextInt();
            jcb.add(p[i]);
        }
        //先将jcb按照到达时间排序
        Collections.sort(jcb, new compareTime());
    }

    public void FCFS(){//先来先服务算法
        ProcessQueue pq=new ProcessQueue();//创建内部类对象
        pq.Enqueue1();//调用Enqueue方法让最先到达的进程先入队
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.Dequeue();//出队，一次一个
            pq.Enqueue1();//已到达的进程入队
        }
    }

    public void SJF() {// 短作业优先算法
        ProcessQueue pq=new ProcessQueue();
        pq.Enqueue1();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.Dequeue();//出队，一次一个
            Collections.sort(link, new compareServeTime());//队列中的进程还需按服务时间长度进行排序
            pq.Enqueue1();//已到达的进程入队
        }
    }
    public void RR1(int q){

    }
    public void RR(int q) {//时间片轮转调度算法
        ProcessQueue pq=new ProcessQueue();
        pq.Enqueue2();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.Dequeue(q);//出队，一次一个，因为上一轮出的得让刚到达的进程先进队列，所以没办法，进队操作只能也放在这个函数里了
        }
    }

    class ProcessQueue{
        int k = 0;// jcb中的进程遍历时的下标
        int nowTime = 0;// 当前时间
        double sliceTime;//轮转调度时间片
        int i=0;//记录当前出入队列的次数
        public void Enqueue1() {//进程首次入队，可一次进多个
            while (k < jcb.size()) {//当遍历完jcb中的所有进程时结束
                link.add(jcb.get(k));               //将所有的进程全部插入link中
                k++;
            }
        }

        public void Enqueue2() {//进程首次入队，可一次进多个
            while (k < jcb.size()) {//当遍历完jcb中的所有进程时结束
                if (jcb.get(k).arriveTime <= nowTime) {//已经到达的进程按到达时间先后进入队列
                    link.add(jcb.get(k));
                    k++;
                } else {
                    break;//如果该进程还未入队，即先结束遍历，保留当前下标k；
                }
            }
        }

        public void Dequeue() {//进程出队，一次只出一个
            nowProess = link.removeFirst();//移除队列的队首元素并且返回该对象元素
            if(nowTime >= nowProess.arriveTime) {
                nowProess.beginTime = nowTime;//计算开始时间，即为上一个进程的结束时间
            }else{
                nowProess.beginTime = nowProess.arriveTime;
            }
            nowProess.finshTime = nowProess.beginTime + nowProess.serveTime;//计算结束时间，该进程开始时间+服务时间
            nowProess.roundTime = nowProess.finshTime - nowProess.arriveTime;//计算周转时间
            nowProess.aveRoundTime = (double) nowProess.roundTime / nowProess.serveTime;//计算平均周转时间
            nowTime = nowProess.finshTime;//获得结束时间，即当前时间，方便判断剩下的进程是否已到达
            new_jcb.add(nowProess);//经处理过数据后加入new_jcb容器
        }

        public void Dequeue(double sliceTime) {//重载Dequeue方法，实现轮转调度算法的出队
            nowProess = link.removeFirst();//移除队列的队首元素并且返回该对象元素
            //原本是加一个时间片的时间进行，当前时间的更新
            //由于在一个时间片内可能进程服务已经完成就需要提前结束，、
            // 因此我们用循环来处理，让它每次时间加1，直到加完一个时间片
            for(int i = 1; i <= sliceTime; i++){
                nowTime++;//更新当前时间，循环一共加一个时间片的时间（可能提前结束）
                nowProess.clock++;//更新当前进程已服务时间，循环一共加一个时间片的时间（可能提前结束）
                if(nowProess.clock == nowProess.serveTime){//如果此时服务已经完成就结束循环
                    break;
                }
            }
            if(nowProess.clock >= nowProess.serveTime) {
                nowProess.finshTime = nowTime;//计算该进程完成时间
                nowProess.roundTime = nowProess.finshTime - nowProess.arriveTime;//计算周转时间
                nowProess.aveRoundTime = (double) nowProess.roundTime / nowProess.serveTime;//计算平均周转时间
                new_jcb.add(nowProess);//经处理过数据后加入new_jcb容器
            }
            else {
                Enqueue2();
                link.addLast(nowProess);//上一轮出的再紧接着进入队尾
            }
        }
    }
    public void printProcess() {
        System.out.println("进程名,到达时间,服务时间,开始时间,完成时间,周转时间,带权周转时间");
        for (int i = 0; i < new_jcb.size(); ++i) {
            System.out.println("P"+new_jcb.get(i).name + "     " + new_jcb.get(i).arriveTime + "        " +
                    new_jcb.get(i).serveTime+ "       " + new_jcb.get(i).beginTime + "        " + new_jcb.get(i).finshTime +
                    "        "+ new_jcb.get(i).roundTime + "         " + new_jcb.get(i).aveRoundTime);
        }
        new_jcb.clear();//清空new_jcb容器内的内容，方便存储各种算法的结果并展示
    }
}

class compareServeTime implements Comparator<Process> {// 按服务时间升序
    public int compare(Process arg0, Process arg1) {
        return arg0.serveTime - arg1.serveTime;
    }
}

class compareTime implements Comparator<Process> {// 按到达时间升序，若到达时间相同，按服务时间升序
    public int compare(Process o1, Process o2) {
        int a = o1.arriveTime - o2.arriveTime;
        if (a > 0)
            return 1;
        else if (a == 0) {
            return o1.serveTime > o2.serveTime ? 1 : -1;
        } else
            return -1;
    }
}