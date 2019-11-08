package main.java.com.TransactionDemo1;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;


    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    public void setTransactionManager(PlatformTransactionManager platformTransactionManager){
        this.transactionManager = platformTransactionManager;
    }

    @Override
    public void create(String name, Integer age, Integer marks, Integer year) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);//开启事务
        try{
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            jdbcTemplate.update( SQL1, name, age);
            // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            int sid = jdbcTemplate.queryForObject( SQL2,Integer.class );
            String SQL3 = "insert into Marks(sid, marks, year) " +
                    "values (?, ?, ?)";
            jdbcTemplate.update( SQL3, sid, marks, year);
            System.out.println("Created Name = " + name + ", Age = " + age);
            transactionManager.commit(status);
        }catch(DataAccessException e){
            System.out.println("error in createing record,rolling back");
            transactionManager.rollback(status);
            throw e;
        }

    }

    @Override
    public List<StudentMarks> listStudents() {
        String SQL = "select * from Student, Marks where Student.id = Marks.sid";
        List<StudentMarks> studentMarks =
                jdbcTemplate.query(SQL, new StudentMarksMapper());
        return studentMarks;
    }
}
