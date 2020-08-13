package task;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {
    //创建一个线程池
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());

    //private ExecutorService pool = Executors.newFixedThreadPool(5);
    //计数器，用来检测所有的递归扫描是否已经结束即所有的线程都执行完毕
    private static volatile AtomicInteger count = new AtomicInteger();

    //阻塞等待方式一：锁对象(synchronized)
    private Object lock = new Object();

    //阻塞等待方式二：CountDownLatch计数
    private CountDownLatch lunch = new CountDownLatch(1);

    //阻塞等待方式三：
    private Semaphore semaphore = new Semaphore(0);

    private ScannerCallBack callBack;

    public FileScanner(ScannerCallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 扫描文件任务
     * @param path 要扫描的目录
     */
    public void scanner(String path) {
        //启动根目录扫描，计数器+1
        count.incrementAndGet();
        doScanner(new File(path));
    }

    /**
     * 获取当前目录的子文件
     * 如果子文件是文件夹就要递归处理
     * @param dir 根目录文件夹
     */
    private void doScanner(File dir){
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //保存文件
                    callBack.callBack(dir);
                    //子文件和子文件夹
                    File[] child = dir.listFiles();
                    if (child != null) {
                        for (File file : child) {
                            //如果是文件夹
                            if (file.isDirectory()) {
                                //启动子文件夹扫描任务，计数器+1
                                count.incrementAndGet();
                                //System.out.println("当前任务数" + count.get());
                                doScanner(file);
                            }
                        }
                    }
                }finally {//保证上边代码无论是否出现异常，计数器都可以减1
                    //一个文件夹扫描完毕，计数器-1
                    int res = count.decrementAndGet();
                    //说明此时所有文件都扫描完毕，唤醒等待的线程
                    if(res == 0){
                        /*
                        //方式一
                        synchronized (lock){
                            lock.notify();
                        }
                        //方式二
                        lunch.countDown();
                        */

                        //方式三
                        semaphore.release();
                    }
                }
            }
        });
    }

    /**
     * 等待扫描任务结束
     */
    public void waitFinish() throws InterruptedException {
        //阻塞等待
        /*
        //方式一
        synchronized (lock){
            lock.wait();
        }
        //方式二：
        lunch.await();
        */

        //方式三
        try {
            semaphore.acquire();
        } finally {
            System.out.println("关闭线程池");
            //pool.shutdown();
            pool.shutdownNow();
        }
    }
}
