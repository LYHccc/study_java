package app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import task.*;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FileMeta> fileTable;

    @FXML
    private Label srcDirectory;

    private Thread directoryChooseTask;

    private Thread task;

    public void initialize(URL location, ResourceBundle resources) {
        //界面初始化时，需要初始化数据库及表
        DBInit.init();
        //DBService.init();
        // 添加搜索框监听器，内容改变时执行监听事件
        searchField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                freshTable();
            }
        });
    }

    /**
     * @param event 点击选择目录事件
     */
    public void choose(Event event){
        // 选择文件目录
        DirectoryChooser directoryChooser=new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);
        if(file == null)
            return;
        // 获取选择的目录路径，并显示
        String path = file.getPath();
        srcDirectory.setText(path);
        if(directoryChooseTask != null){
            directoryChooseTask.interrupt();
        }
        //选择了任务就需要执行任务的扫描:将该目录下的子文件和子文件夹都扫描出来
        directoryChooseTask = new Thread(new Runnable() {
            @Override
            public void run() {
                //文件扫描回调接口，用来保存下一级子文件夹和子文件到数据库
                ScannerCallBack callBack = new FileSave();
                //传入扫描任务类中
                FileScanner scanner =  new FileScanner(callBack);
                try {
                    System.out.println("执行扫描文件任务");
                    //为了提高效率，多线程去执行扫描根目录
                    scanner.scanner(path);
                    //等待扫描任务结束，需要阻塞等待
                    System.out.println("等待扫描任务结束" + path);
                    scanner.waitFinish();
                    System.out.println("扫描结束，刷新表格");
                    //刷新表格，将扫描出来的子文件以及子文件夹都显示出来
                    freshTable();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        directoryChooseTask.start();
    }

    /**
     * 刷新表格数据
     */
    private void freshTable(){
        ObservableList<FileMeta> metas = fileTable.getItems();
        metas.clear();
        //选择了某个目录，需要再根据搜索框的内容，来进行数据库文件的查询
        String dir = srcDirectory.getText();
        if(dir != null && dir.trim().length() != 0){
            String content  = searchField.getText();
            //提供数据库查询方法
            List<FileMeta> fileMetas = FileSearch.search(dir, content);
            metas.addAll(fileMetas);
        }

        //javafx表单通过反射获取fileMeta类型中的属性(app.fxml文件中定义的属性)
    }
}
