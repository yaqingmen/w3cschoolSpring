package main.java.com.TransactionDemo2;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMarksMapper implements RowMapper<StudentMarks> {
    @Override
    public StudentMarks mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setAge(resultSet.getInt("age"));
        studentMarks.setId(resultSet.getInt("id"));
        studentMarks.setName(resultSet.getString("name"));
        studentMarks.setMarks(resultSet.getInt("marks"));
        studentMarks.setYear(resultSet.getInt("year"));
        studentMarks.setSid(resultSet.getInt("sid"));
        return studentMarks;
    }
}
