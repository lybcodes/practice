package DesignMode.HandlerChain;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;

//处理器链：用数组来保存所有的处理器，然后在filter函数中依次调用每个处理器的doFilter函数
public class SensitiveWordFilterChain {
    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter){
        this.filters.add(filter);
    }

    // return true if content doesn't contain sensitive words.
    public boolean filter(String content){
        for(SensitiveWordFilter filter : filters){
            if(!filter.doFilter(content)){
                return false;
            }
        }
        return true;
    }
}
