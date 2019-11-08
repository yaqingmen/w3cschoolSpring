package main.java.com.JDBCDemo2;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    /**
     * 初始化database resources连接
     */
    public void setDataSource(DataSource ds);

    /**
     * 在学生表中创建一条记录
     */
    public void create(String name, Integer age);

    /**
     * 根据id得到一条学生记录
     */
    public Student getStudent(Integer id);

    /**
     * 罗列出学生表中所有的记录
     */
    public List<Student> listStudents();

}
