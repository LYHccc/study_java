package SingLeton;
/*
懒汉模式：
需要时才进行初始化，（如果不是一开始就需要，就没有必要一开始就分配资源）
缺点：会使情况变得非常复杂（出现 BUG 的几率变大）
 */
public class Lazying {
    private volatile static Lazying instance = null;

    // 把构造方法声明为 private，保证别人无法调用构造方法
    private Lazying(){
    }

    /*
    //版本1：线程不安全
    public static Lazying getInstance(){
        if(instance == null){
            instance = new Lazying();
        }

        return instance;
    }
    */

    /*
    //版本2：加一个大锁,线程安全，但是效率不高
    //getInstance()分为两种情况
    //1.instance == null，需要new一个对象
    //2.instance != null, 直接返回(不需要加锁)
    public static synchronized Lazying getInstance(){
        if(instance == null){
            instance = new Lazying();
        }

        return instance;
    }
    */

    /*
    //版本3中间过程：加小锁
    public static  Lazying getInstance(){
        if(instance == null){
            synchronized (Lazying.class) {          //线程不安全
                instance = new Lazying();
            }
        }

        return instance;
    }
    */


    //版本3：
    //instance = new Lazying() 可能会被重排序，引起问题，所以要加volatile
    public static  Lazying getInstance(){
        if(instance == null){
            synchronized (Lazying.class) {
                if(instance == null) {          //二次判断，解决线程安全问题
                    instance = new Lazying();
                }
            }
        }

        return instance;
    }
}
