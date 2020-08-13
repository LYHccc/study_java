package app;

import util.PinyinUtil;
import util.Util;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * 本地文件类型为File，数据库不为File
 * 为了保持一致，封装出一个FileMeta类，保存文件的信息
 */
public class FileMeta {
    private Integer id;
    //文件名称
    private String name;
    //文件所在根目录
    private String path;
    //大小
    private Long size;
    //是否是文件夹
    private boolean isDirectory;
    //最近一次修改时间
    private Date lastModified;
    //与app.fxml中的客户端控件sizeText显示名称一致
    private String sizeText;
    //与app.fxml中的客户端控件lastModifiedText显示名称一致
    private String lastModifiedText;
    //文件名全拼
    private String pinyin;
    //文件名拼音首字母
    private String pinyinFirst;

    //通过文件设置属性
    public FileMeta(File file){
        this(file.getName(), file.getParent(), file.length(), file.isDirectory(), new Date(file.lastModified()));
    }

    //通过数据库获取的数据设置FileMeta
    public FileMeta(String name, String path, Long size, Boolean isDirectory, Date lastModified) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.isDirectory = isDirectory;
        this.lastModified = lastModified;
        if(PinyinUtil.containsChinese(name)){
            String[] pinyins = PinyinUtil.get(name);
            this.pinyin = pinyins[0];
            this.pinyinFirst = pinyins[1];
        }
        //客户端表格控件文件大小，最近一次更新时间
        sizeText = Util.parseSize(size);
        lastModifiedText = Util.parseDate(lastModified);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileMeta meta = (FileMeta) o;
        return isDirectory == meta.isDirectory &&
                Objects.equals(name, meta.name) &&
                Objects.equals(path, meta.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, isDirectory);
    }

    @Override
    public String toString() {
        return "FileMeta{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", isDirectory=" + isDirectory +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public String getLastModifiedText() {
        return lastModifiedText;
    }

    public void setLastModifiedText(String lastModifiedText) {
        this.lastModifiedText = lastModifiedText;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinFirst() {
        return pinyinFirst;
    }

    public void setPinyinFirst(String pinyinFirst) {
        this.pinyinFirst = pinyinFirst;
    }
}
