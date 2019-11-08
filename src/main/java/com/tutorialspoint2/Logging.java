package main.java.com.tutorialspoint2;

import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {


    /**
     * pointcut定义来选择所有的可用方法
     *
     * @pointcut注解能够在一个@AspectJ切面内定义可重用的切点
     */
    @Pointcut("execution(* main.java.com.tutorialspoint2.*.*(..))")
    private void selectAll(){}
    /**
     * 前置处理器
     */
    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("going to setup student profile");
    }

    /**
     * 后置处理器
     */

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("Student profile has been setup");
    }

    /**
     * 返回后处理器
     * @param retVal
     */
    @AfterReturning(pointcut = "selectAll()",returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning :" + retVal.toString());
    }

    /**
     * 抛异常后处理器
     * @param ex
     */
    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception :" + ex.toString());
    }
}
