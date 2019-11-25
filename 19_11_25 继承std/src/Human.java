public class Human extends Animal {
    String name;
    Human(){
        super(3,6);
    }
    Human(String name){
        super(3,6);
        this.name = name;
    }
    //重载
    public void scream(String s1){
        System.out.println(s1 +  "哈哈");
    }
    //覆写
    @Override
    public void print(){
        System.out.println("我是Human的");
    }
}
