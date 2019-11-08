package main.java.com.TransactionDemo1;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    /**
     * 初始化数据库连接
     */
    public void setDataSource(DataSource ds);

    /**
     * 在表Marks,Student创建记录
     */
    public void create(String name,Integer age,Integer marks, Integer year);

    /**
     * 罗列Marks,Student表中所有记录
     */
    public List<StudentMarks> listStudents();
}
