package main.java.com.JDBCDemo2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall jdbcCall;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcCall = new SimpleJdbcCall(ds).withProcedureName("getrecord");
    }

    @Override
    public void create(String name, Integer age) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String SQL = "insert into Student(name, age) values(?, ?)";
        jdbcTemplate.update(SQL, name, age);
        System.out.println("create record name ="+name+"age="+age);
    }

    @Override
    public Student getStudent(Integer id) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String ,Object> out = jdbcCall.execute(in);
        Student student = new Student();
        student.setId(id);
        student.setAge((Integer)out.get("out_age"));
        student.setName((String)out.get("out_name"));
        return student;
    }

    @Override
    public List<Student> listStudents() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplate.query(SQL,new StudentMapper());
        return students;
    }

}
