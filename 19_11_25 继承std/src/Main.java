public class Main {
    public static void main(String[] args) {
        Animal p = new Animal();            //类型为Animal的引用指向的对象是Animal类型;
        Animal p1 = new Human();            //类型为Animal的引用指向的对象是Human类型;
        Animal p2 = new Dog();              //类型为Animal的引用指向的对象是Dog类型;
        Human p3 = new Human();             //类型为Human的引用指向的对象是Human类型;
        Dog p4 = new Dog();                 //类型为Dog的引用指向的对象是Dog类型;
        //子类调用父类的方法
        p.scream();
        p3.scream();
        p4.scream();
        System.out.println("======");
        //调用本身类的重载方法
        p.scream();
        p3.scream("人");
        p4.scream("狗");
        System.out.println("======");
        //调用本身类的覆写方法
        p.print();
        p3.print();
        p4.print();
        System.out.println("======");
        //向上转型                       父类类型的引用指向子类类型的对象
        p1.print();
        p2.print();
        System.out.println("======");
        //向下转型                        父类类型的引用指向的对象中含有父类不具备的方法
        ((Human) p1).scream("人");
        ((Dog)p2).scream("狗");;
    }
}
