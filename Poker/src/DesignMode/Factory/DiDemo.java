package DesignMode.Factory;

public class DiDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimter");
        Boolean isValid = rateLimiter.isValid();
        System.out.println("RateLimter call isValid method, result: " + isValid);
    }
}
