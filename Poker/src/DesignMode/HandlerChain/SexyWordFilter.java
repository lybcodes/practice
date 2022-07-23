package DesignMode.HandlerChain;


//具体的处理器类
public class SexyWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(String content) {
        boolean legal = false;
        //...
        return legal;
    }
}
