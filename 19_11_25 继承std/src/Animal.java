public class Animal {
    int color;;
    int numberOfLegs;
    Animal(int color, int numberOfLegs){
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }
    Animal(){
        color = 0;
        numberOfLegs = 0;
    }

    public void scream(){
        System.out.println("嘎嘎");
    }

    public void print(){
        System.out.println("我是Animal的");
    }
}
