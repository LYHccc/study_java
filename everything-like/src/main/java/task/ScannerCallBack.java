package task;

import java.io.File;

public interface ScannerCallBack {
    //文件扫描回调，用来保存下一级子文件夹和子文件到数据库
    void callBack(File dir);
}
