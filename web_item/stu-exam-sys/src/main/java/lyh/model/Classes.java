package lyh.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 班级表
 */
@Getter
@Setter
@ToString
public class Classes {
    
    private Integer id;

    /**
     * 班级名称
     */
    private String classesName;

    /**
     * 毕业年份，数据字典000001
     */
    private String classesGraduateYear;

    /**
     * 专业，数据字典000002
     */
    private String classesMajor;

    /**
     * 备注
     */
    private String classesDesc;

    /**
     * 创建时间
     */
    private Date createTime;
}