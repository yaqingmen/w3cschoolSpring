package main.java.com.JDBCDemo2;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {


    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setAge(resultSet.getInt("age"));
        student.setName(resultSet.getString("name"));
        return student;
    }
}
