//比较两个版本号 version1 和 version2。
//如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//你可以假设版本字符串非空，并且只包含数字和 . 字符。
// . 字符不代表小数点，而是用于分隔数字序列。
//例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
//你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。

public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        int v1 = 0;
        int v2 = 0;
        while(index1 < ver1.length || index2 < ver2.length){
            if(index1 < ver1.length){
                v1 = Integer.parseInt(ver1[index1]);
            }else{
                v1 = 0;
            }
            if(index2 < ver2.length){
                v2 = Integer.parseInt(ver2[index2]);
            }else{
                v2 = 0;
            }
            if(v1 > v2) return 1;
            if(v2 > v1) return -1;
            index1++;
            index2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "1.1";
        String s2 = "0.1";
        System.out.println(compareVersion(s1, s2));
    }
}
