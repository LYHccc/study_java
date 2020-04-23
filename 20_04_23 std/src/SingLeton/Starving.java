package SingLeton;
/*
饿汉模式:
只允许生成一个对象
 */
public class Starving {
    //静态属性初始化，发生在类加载时期
    //在一开始就初始化好了，大家使用的都是这个对象
    private static Starving instance = new Starving();

    // 把构造方法声明为 private，保证别人无法调用构造方法
    private Starving() {
    }

    //其他类需要Starving类的对象
    // 统统调用 getInstance() 这个静态方法获取
    // 保证不会有新的对象产生
    public static Starving getInstance(){
        return instance;
    }
}
