package main.java.com.tutorialspoint2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans2.xml");
        Student student = (Student)context.getBean("student");
        student.getName();
        student.getAge();
        student.pringThrowException();
    }


}
