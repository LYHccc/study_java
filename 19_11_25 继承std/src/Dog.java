public class Dog extends Animal{
    String host;
    Dog(){
        super(2,4);
    }
    Dog(String host){
        super(2,4);
        this.host = host;
    }
    //重载
    public void scream(String s2){
        System.out.println( s2 + "汪汪");
    }
    //覆写
    @Override
    public void print(){
        System.out.println("我是Dog的");
    }
}
