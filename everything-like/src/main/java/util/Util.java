package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一些日期格式配置，以及文件大小、日期格式解析的工具类
 */
public class Util {
    public static final String date_pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 解析文件的大小
     * @param size 数据库中保存的字节大小
     * @return 解析出的格式大小
     */
    public static String parseSize(Long size) {
        String[] unit = {"B", "KB", "MB", "GB"};
        int index = 0;
        while(size > 1024 && index < unit.length - 1){
            index++;
            size /= 1024;
        }

        return size + unit[index];
    }

    /**
     * 解析日期格式
     * @param lastModified 传入的日期格式
     * @return 解析出的日期格式
     */
    public static String parseDate(Date lastModified) {
        return new SimpleDateFormat(date_pattern).format(lastModified);
    }
}
