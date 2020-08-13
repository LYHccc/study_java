package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.HashSet;
import java.util.Set;

public class PinyinUtil {
    //中文字符格式
    private static final String CHINESE_PATTERN = "[\\u4E00-\\u9FA5]";

    /**
     * 汉语拼音格式化类
     */
    private static final HanyuPinyinOutputFormat format= new HanyuPinyinOutputFormat();

    static {
        //小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //不带音调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //带V，即类似绿(lv)
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    /**
     * 字符串是否包含中文
     * @param name 文件名
     * @return true包含，false不包含
     */
    public static boolean containsChinese(String name){
        return name.matches(".*" + CHINESE_PATTERN + ".*");
    }

    /**
     * 通过文件名获取全拼+拼音名
     * @param name 文件名
     * @return 拼音全拼字符串+拼音首字母字符串
     */
    public static String[] get(String name){
        String[] res = new String[2];
        //全拼
        StringBuilder pinyin = new StringBuilder();
        //拼音首字母
        StringBuilder pinyinFirst = new StringBuilder();
        for(char c : name.toCharArray()){
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if(pinyins == null || pinyins.length == 0){
                    pinyin.append(c);
                    pinyinFirst.append(c);
                }else{
                    pinyin.append(pinyins[0]);
                    pinyinFirst.append(pinyins[0].charAt(0));
                }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                pinyin.append(c);
                pinyinFirst.append(c);
            }
        }
        res[0] = pinyin.toString();
        res[1] = pinyinFirst.toString();

        return res;
    }



    /**
     * 可能出现多音字，通过文件名获取全拼+拼音名
     * @param name 文件名
     * @param fullSpell true表示全拼，false首字母
     * @return 所有字的拼音产生的二维数组，row代表每一个字，col代表每个字的可能读音
     */
    public static String[][] get(String name, boolean fullSpell) {
        char[] chars = name.toCharArray();
        String[][] res = new String[chars.length][];
        for (int i = 0; i < chars.length; i++) {
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                if (pinyins == null || pinyins.length == 0) {
                    res[i] = new String[]{String.valueOf(chars[i])};
                } else {
                    res[i] = distinct(pinyins, fullSpell);
                }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                res[i] = new String[]{String.valueOf(chars[i])};
            }
        }

        return res;
    }
    /**
     * 多音字可能出现同拼写不同音调的情况，因此要对相同拼写不同音调的进行去重
     * @param arr 一个字可能出现的所有拼写情况的数组
     * @param fullSpell true表示全拼，false首字母
     * @return 去重之后的数组
     */
    public static String[] distinct(String[] arr, boolean fullSpell){
        Set<String> set = new HashSet<>();
        for(String s : arr){
            if(fullSpell){
                set.add(s);
            }else{
                set.add(String.valueOf(s.charAt(0)));
            }
        }
        return set.toArray(new String[set.size() - 1]);
    }
    /**
     * 对拼音数组进行组合
     * 先合并两个拼音数组为一个，接着再用这一个去合并，依此类推
     * @param arr 所有字的拼音产生的二维数组
     * @return 合并结果，即所有可能的结果
     */
    public static String[] merge(String[][] arr){
        if(arr == null || arr.length == 0) return null;
        if(arr.length == 1) return arr[0];
        String[] res = arr[0];
        for(int i = 1; i < arr.length; i++){
            res = merge(res, arr[i]);
        }
        return res;
    }
    /**
     * 合并两个拼音数组
     * @param arr1 第一个拼音数组
     * @param arr2 第二个拼音数组
     * @return 合并结果
     */
    public static String[] merge(String[] arr1, String[] arr2){
        String[] res = new String[arr1.length * arr2.length];
        int index = 0;
        for(String s1 : arr1){
            for(String s2 : arr2){
                res[index++] = s1 + s2;
            }
        }
        return res;
    }
}
