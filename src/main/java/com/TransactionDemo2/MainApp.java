package main.java.com.TransactionDemo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansTransaction2.xml");
        StudentDAO studentJDBCTemplate = (StudentDAO) context.getBean("studentJDBCTemplate");
        System.out.println("-----------Records Creation---------");
        studentJDBCTemplate.create("myq",11,1,2010);
        studentJDBCTemplate.create("lhc",2,3,1990);
        studentJDBCTemplate.create("yyy",23,12,1111);
        System.out.println("-------Listing all Records---------");
        List<StudentMarks> studentMarks= studentJDBCTemplate.listStudents();
        for(StudentMarks marks : studentMarks) {
            System.out.print("ID: " + marks.getId());
            System.out.print(",Name: " + marks.getName());
            System.out.print(",Age: " + marks.getAge());
            System.out.print(",Marks: "+ marks.getMarks());
            System.out.print(",Year: " + marks.getYear());
            System.out.print(",Sid: " + marks.getSid());
        }
    }
}
