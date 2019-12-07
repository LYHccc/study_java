import java.util.*;

public class Memory {
    private int size;           //内存大小
    private int lastFind;       //上次寻址结束的内存下标(当前要访问的内存地址下标)
    private LinkedList<MemoryBlock> memory;    //记录内存分区的链表
    private static final int MIN_SIZE = 5;

    public Memory(){
    }

    public Memory(int size, int site){
        this.size = size;
        this.memory = new LinkedList<>();
        memory.add(new MemoryBlock(size, site));
    }

    //内存区初始化
    public void InIt(int size, int site){
            memory.add(new MemoryBlock(size, site));
    }

    //首次适应算法
    public void fristFit(Process p){
        //遍历分区链表
        for (lastFind = 0; lastFind < memory.size(); lastFind++){
            MemoryBlock tmp = memory.get(lastFind);
            //找到可用分区（空闲且大小足够）
            if (tmp.size >= p.size){
                doAllocation(p.size, lastFind, tmp);
                return;
            }
        }
        //遍历结束后未找到可用分区, 则内存分配失败
        System.out.println("无可用内存空间!");
    }

    //循环首次适应算法
    public void nextFit(Process p){
        //从上次分配空闲区位置开始遍历分区链表
        //因为上次分配空间有可能是在最后一个分区，并且分配完成删除了这个分区，那么先要判断此时的指向如果指向删除的那个分区就从头开始遍历
        if(lastFind >= memory.size() - 1){
            lastFind = 0;
        }
        MemoryBlock tmp = memory.get(lastFind);
        //如果当前指向的内存区可以满足进程的分配需求，那么直接在这个内存区分配
        if (tmp.size >= p.size){
            doAllocation(p.size, lastFind, tmp);
            return;
        }
        int i = lastFind;
        for(lastFind = lastFind + 1; lastFind != i; lastFind++){
            if(lastFind >= memory.size() - 1){
                lastFind = 0;
            }
            tmp = memory.get(lastFind);
            if (tmp.size >= p.size){
                doAllocation(p.size,lastFind, tmp);
                return;
            }
        }
        //遍历结束后未找到可用分区, 则内存分配失败
        System.out.println("无可用内存空间!");
    }

    //最佳适应算法
    public void bestFit(Process p){
        //将内存区按照从小到大的顺序排列
        Collections.sort(memory, new fromSmallToLarge());
        //对排序后的内存区运用首次适应算法分配空间
        fristFit(p);
    }

    //最坏适应算法
    public void worstFit(Process p){
        //将内存区按照从大到小的顺序排列
        Collections.sort(memory, new fromLargeToSmall());
        //对排序后的内存区运用首次适应算法分配空间
        fristFit(p);
    }

    //分配空间
    public void doAllocation(int size, int location, MemoryBlock tmp) {//size申请的大小，location当前可用空间位置，tmp可用空闲区
        //如果分割后分区剩余大小过小（MIN_SIZE）则将分区全部分配，否则分割为两个分区
        if (tmp.size - size <= MIN_SIZE){
            memory.remove(location);         //将这个分区全部分配，删除这个分区
        } else {
            //split代表分配给进程内存后内存分区中的大小和起始地址
            //大小就是之前的大小减去要分配给进程的大小，起始地址就是之前的地址加上分配给进程的内存大小
            MemoryBlock split = new MemoryBlock(tmp.size - size, tmp.site + size);
            //将当前位置中内容改变为分配给内存之后的内存分区
            memory.set(location, split);
            tmp.size = size;
        }
        System.out.println("成功分配 " + size + "KB 内存!");
    }

    //打印内存的分区情况
    public void printMemory(){
        System.out.println("分区号，分区大小，分区始址");
        for(int i = 0; i < memory.size(); i++){
            System.out.println((i + 1) + "      " + memory.get(i).size + "      " +
                    memory.get(i).site );
        }
    }

    // 按空闲分区容量从小到大
    class fromSmallToLarge implements Comparator<MemoryBlock> {
        public int compare(MemoryBlock arg0, MemoryBlock arg1) {
            return arg0.size - arg1.size;
        }
    }
    // 按空闲分区容量从大到小
    class fromLargeToSmall implements Comparator<MemoryBlock> {
        public int compare(MemoryBlock arg0, MemoryBlock arg1) {
            return arg1.size - arg0.size;
        }
    }
}
