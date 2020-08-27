/**
 * 矩形相交
 * 给定两个矩阵，判断两个矩形是否相交
 */
class MyArray{
    int x1;
    int y1;
    int x2;
    int y2;
    public MyArray(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class RectanglesOverlap {
    private static boolean get(int a1, int b1, int a2, int b2){
        int min1 = Math.min(a1, b1);
        int max1 = Math.max(a1, b1);
        int min2 = Math.min(a2, b2);
        int max2 = Math.max(a2, b2);
        if(min1 <= min2 && max1 >= max2 || min2 <= min1 && max2 >= max1){
            return true;
        }
        return false;
    }

    private static boolean is(MyArray array1, MyArray array2){
        return get(array1.x1, array1.x2, array2.x1, array2.x2) &&
                get(array1.y1, array1.y2, array2.y1, array2.y2);
        /*
        int minX1 = Math.min(array1.x1, array1.x2);
        int maxX1 = Math.max(array1.x1, array1.x2);
        int minX2 = Math.min(array2.x1, array2.x2);
        int maxX2 = Math.max(array2.x1, array2.x2);
        boolean flag1 = false;
        if(minX1 <= minX2 && maxX1 >= maxX2 || minX2 <= minX1 && maxX2 >= maxX1){
            flag1 = true;
        }
        int minY1 = Math.min(array1.y1, array1.y2);
        int maxY1 = Math.min(array1.y1, array1.y2);
        int minY2 = Math.max(array2.y1, array2.y2);
        int maxY2 = Math.max(array2.y1, array2.y2);
        boolean flag2 = false;
        if(minY1 <= minY2 && maxY1 >= maxY2 || minY2 <= minY1 && maxY2 >= maxY1){
            flag2 = true;
        }
        return  flag1 && flag2;
        */
    }
}
