import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealizeArithmetic {
    List<Integer> Available = new ArrayList<>();        //存放可用资源数目
    List<List<Integer>> Allocation = new ArrayList<>(); //存放已分配资源数目
    List<List<Integer>> Need = new ArrayList<>();       //存放尚需资源数目
    int size = 0;                                       //表示资源种类的多少
    int processSize = 0;                                //表示进程种类数
    Scanner scanner = new Scanner(System.in);

    //初始化可用资源矩阵
    public void AvailableInit(int resourceNum){
        for(int i = 0; i < resourceNum; i++){
            System.out.println("R" + i + "可用资源数目：");
            int num = scanner.nextInt();
            Available.add(num);
            size++;
        }
        System.out.println("可用资源矩阵初始化成功！");
    }

    //初始化已分配资源矩阵
    public void AllocationInit(int processNum, int resourceNum){
        for(int i = 0; i < processNum; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < resourceNum; j++){
                System.out.println("P" + i +"进程已分配R" + j + "资源数目：");
                int rnum = scanner.nextInt();
                list.add(rnum);
            }
            processSize++;
            Allocation.add(list);
        }
        System.out.println("已分配资源矩阵初始化成功");
    }

    //初始化尚需资源矩阵
    public void NeedInit(int processNum, int resourceNum){
        for(int i = 0; i < processNum; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < resourceNum; j++){
                System.out.println("P" + i +"进程尚需R" + j + "资源数目：");
                int num = scanner.nextInt();
                list.add(num);
            }
            Need.add(list);
        }
        System.out.println("尚需资源矩阵初始化成功");
    }

    //输入需求分配需要的各类资源数目
    public List<Integer> requestScan(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            System.out.println("请求分配的R" + i + "类资源数目：");
            int num = scanner.nextInt();
            list.add(num);
        }
        return list;
    }

    //打印安全序列
    public void Safe(){
        boolean b = isSafety(Available, Need, Allocation);
    }

    //请求资源试分配(request为请求分配的矩阵，numProcess是对哪一个进程进行操作)
    public void requestAlloc(List<Integer> request, int numProcess){
        //判断需求矩阵是否满足小于等于尚需资源矩阵的情况
        for(int i = 0; i < request.size(); i++){
            if(request.get(i) > Need.get(numProcess).get(i)){
                System.out.println("请求分配的资源数量大于进程所需的资源数量！无法进行分配");
                return;
            }
        }
        //判断需求矩阵是否满足小于等于可用资源矩阵的情况
        for(int i = 0; i < request.size(); i++){
            if(request.get(i) > Available.get(i)){
                System.out.println("请求分配的资源数量大于当前可用的资源数量！让P" + i + "等待");
                return;
            }
        }
        //拷贝三个矩阵
        //拷贝可用资源矩阵
        List<Integer> tAvailable = new ArrayList<>();
        for(int i = 0; i < size; i++){
            tAvailable.add(Available.get(i));
        }
        //拷贝已分配资源矩阵
        List<List<Integer>> tAllocation = new ArrayList<>();
        for(int i = 0; i < processSize; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < size; j++){
                list.add(Allocation.get(i).get(j));
            }
            tAllocation.add(list);
        }
        //拷贝尚需资源矩阵
        List<List<Integer>> tNeed = new ArrayList<>();
        for(int i = 0; i < processSize; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < size; j++){
                list.add(Need.get(i).get(j));
            }
            tNeed.add(list);
        }
        //对拷贝的三个矩阵进行资源试分配
        //对拷贝可用资源矩阵根据请求分配矩阵进行更改
        for(int i = 0; i < size; i++){
            tAvailable.set(i, tAvailable.get(i) - request.get(i));
        }

        //对拷贝尚需资源矩阵根据请求分配矩阵进行更改
        List<Integer> tempNeed = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int temp = tNeed.get(numProcess).get(i) - request.get(i);
            tempNeed.add(temp);
        }
        tNeed.set(numProcess, tempNeed);

        //对拷贝已分配资源矩阵根据请求分配矩阵进行更改
        List<Integer> tempAllocation = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int temp = tAllocation.get(numProcess).get(i) + request.get(i);
            tempAllocation.add(temp);
        }
        tAllocation.set(numProcess, tempAllocation);

        //对拷贝的矩阵试分配后调用安全性算法看是不是安全状态
        if(isSafety(tAvailable, tNeed, tAllocation)){
            boolean isnot = true;
            for(int i = 0; i < size; i++){
                if(request.get(i) != Need.get(numProcess).get(i)){
                    isnot = false;
                    break;
                }
            }
            if(isnot){
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    Available.set(i, Available.get(i) + Allocation.get(numProcess).get(i));
                    list.add(0);
                }
                Need.set(numProcess, list);
                Allocation.set(numProcess, list);
            }
            if(!isnot) {
                //对可用资源矩阵根据请求分配矩阵进行更改
                for (int i = 0; i < size; i++) {
                    Available.set(i, Available.get(i) - request.get(i));
                }

                //对尚需资源矩阵根据请求分配矩阵进行更改
                List<Integer> tempNeed2 = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    int temp = Need.get(numProcess).get(i) - request.get(i);
                    tempNeed2.add(temp);
                }
                Need.set(numProcess, tempNeed2);

                //对已分配资源矩阵根据请求分配矩阵进行更改
                List<Integer> tempAllocation2 = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    int temp = Allocation.get(numProcess).get(i) + request.get(i);
                    tempAllocation2.add(temp);
                }
                Allocation.set(numProcess, tempAllocation2);
            }
        }
    }

    //判断是不是安全
    public boolean isSafety(List<Integer> available, List<List<Integer>> need, List<List<Integer>> allocation){
        List<Integer> work = new ArrayList<>();
        for(int i = 0; i < size; i++){
            work.add(available.get(i));
        }
        boolean[] finish = new boolean[processSize];     //f[]来表示这个进程是否被找过了的状态
        for(int i = 0; i < processSize; i++){
            finish[i] = false;
        }
        int[] sequence = new int[processSize];
        int count = 0;              //完成进程数
        int num = 0;                //在work与need的比较过程中，记录比较了几个资源
        while(count < processSize) {
            int lap = 0;        //lap用来记录此时这一轮的work与多少个进程进行了比较,并且满足了条件
            for (int i = 0; i < processSize; i++) {
                num = 0;
                for (int j = 0; j < size; j++) {
                    if (finish[i] == false && work.get(j) >= need.get(i).get(j)) {
                        num++;      //此进程每次有一个资源满足条件num+1
                        if (num == size) {        //如果所有的资源都满足条件
                            //将work的值加上allocation
                            for (int m = 0; m < size; m++) {
                                work.set(m, work.get(m) + allocation.get(i).get(m));
                            }

                            lap++;      //如果可以找到满足条件进程lap+1
                            finish[i] = true;       //状态位置为找过了true
                            sequence[count] = i;        //将此时的进程编号存入安全序列中
                            count++;        //完成进程数+1
                        }
                    }
                }
            }
            //如果一轮找过去lap没有变化，说明这一轮都没有找到可以满足work条件的进程结束循环
            if(lap == 0){
                break;
            }
        }
        if(count == processSize){
            System.out.println("可以找到一个安全序列！此时系统是安全的");
            System.out.print("安全序列为：");
            for(int i = 0; i < processSize; i++){
                System.out.print("p" + sequence[i] + " ");
            }
            System.out.println();
            return true;
        }
        for(int i = 0; i < processSize; i++){
            if(finish[i] == false){
                System.out.println("没有找到安全序列！此时系统不处于安全状态，试分配失败");
                break;
            }
        }
        return false;
    }

    //打印三个矩阵
    public void print(){
        System.out.println("Available");
        System.out.println(Available);

        System.out.println("Allocation");
        for(int i = 0; i < Allocation.size(); i++){
            System.out.println("p" + i + " " + Allocation.get(i));
        }

        System.out.println("Need");
        for(int i = 0; i < Need.size(); i++){
            System.out.println("p" + i + " " + Need.get(i));
        }
    }
}
