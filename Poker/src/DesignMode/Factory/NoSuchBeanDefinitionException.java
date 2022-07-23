package DesignMode.Factory;

public class NoSuchBeanDefinitionException extends RuntimeException{
    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}
