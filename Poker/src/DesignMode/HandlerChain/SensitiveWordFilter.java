package DesignMode.HandlerChain;


/**
 * 职责链模式：多个处理器依次处理同一个请求。一个请求先经过 A处理器处理，然后再把请求传递给 B处理器，
 *           B处理器处理完后再传递给 C处理器，以此类推，形成一个链条。
 *           链条上的每个处理器各自承担各自的处理职责，所以叫作职责链模式。
 *
 * 职责链模式的应用一：敏感词过滤
 */

//所有处理器类的抽象父类（这里用的接口，也可用用抽象类）
public interface SensitiveWordFilter {
    //判断是输入内容是否有敏感词
    boolean doFilter(String content);
}
