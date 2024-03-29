package main.java.com.JDBCDemo1;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(String name, Integer age) {
        String SQL = "insert into Student(name, age) values(?, ?)";
        jdbcTemplate.update(SQL, name, age);
        System.out.println("create record name ="+name+"age="+age);
    }

    @Override
    public Student getStudent(Integer id) {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplate.query(SQL,new StudentMapper());
        return students;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("delete record with id =" + id);

    }

    @Override
    public void update(Integer id, Integer age) {
        String SQL = "update Student set age = ? where id =?";
        jdbcTemplate.update(SQL, age,id);
        System.out.println("update record with id = " + id);

    }
}
