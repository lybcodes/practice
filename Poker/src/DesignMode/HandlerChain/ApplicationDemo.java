package DesignMode.HandlerChain;



public class ApplicationDemo {
    public static void main(String[] args) {
        SensitiveWordFilterChain filterChain = new SensitiveWordFilterChain();
        //这里只定义了一个处理器
        filterChain.addFilter(new SexyWordFilter());

        boolean legal = filterChain.filter(new String());
        if(!legal){
            //...
        }else{
            //...
        }
    }
}
