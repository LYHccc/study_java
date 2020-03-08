//N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
//每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
//一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
//此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
//车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
//即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
//会有多少车队到达目的地?

import java.util.Arrays;
import java.util.Comparator;

class Car{
    int position;
    double time;
    Car(int position, double time){
        this.position = position;
        this.time = time;
    }
}
class posComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2){
        return o2.position - o1.position;
    }
}
public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) return 0;
        Car[] car = new Car[position.length];
        for(int i = 0; i < position.length; i++){
            car[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }
        Arrays.sort(car, new posComparator());
        int count = 1;
        for(int i = 0; i < car.length - 1; i++){
            if(car[i].time < car[i + 1].time){
                count++;
            }else{
                car[i + 1] = car[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] p = {0, 4, 2};
        int[] s = {2, 1, 3};
        System.out.println(carFleet(10, p, s));
    }
}
