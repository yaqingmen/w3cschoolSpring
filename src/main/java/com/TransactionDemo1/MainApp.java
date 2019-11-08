package main.java.com.TransactionDemo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansTransaction.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("-----------Records Creation---------");
        studentJDBCTemplate.create("myq",11,1,2010);
        studentJDBCTemplate.create("lhc",2,3,1990);
        studentJDBCTemplate.create("yyy",23,12,1111);
        System.out.println("-------Listing all Records---------");
        List<StudentMarks> studentMarks= studentJDBCTemplate.listStudents();
        for(StudentMarks marks : studentMarks) {
            System.out.println("ID: " + marks.getId());
            System.out.println("Name: " + marks.getName());
            System.out.println("Age: " + marks.getAge());
            System.out.println("Marks: "+ marks.getMarks());
            System.out.println("Year: " + marks.getYear());
            System.out.println("Sid: " + marks.getSid());
        }
    }
}
