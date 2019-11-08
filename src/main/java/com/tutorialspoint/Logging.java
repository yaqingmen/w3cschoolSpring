package main.java.com.tutorialspoint;

public class Logging {
    public Logging(){

    }
    /**
     * 前置处理器
     */
    public void beforeAdvice() {
        System.out.println("going to setup student profile");
    }

    /**
     * 后置处理器
     */
    public void afterAdvice() {
        System.out.println("Student profile has been setup");
    }

    /**
     * 返回后处理器
     * @param retVal
     */
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning :" + retVal.toString());
    }

    /**
     * 抛异常后处理器
     * @param ex
     */
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception :" + ex.toString());
    }
}
