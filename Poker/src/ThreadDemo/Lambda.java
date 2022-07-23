package ThreadDemo;

import java.util.Properties;

/**
 * 一步步推导lambda表达式
 * 理解函数式接口是学习lambda表达式的关键
 * 1、任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接口
 * 2、对于函数式接口，我们可以通过lambda表达式来创建该接口的对象
 */
public class Lambda {

    //3、静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda(){
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4、局部内部类
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like = new Like3();
        like.lambda();


        //5、匿名内部类，没有类名，必须借助接口或父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();


        //6、lambda表达式
        like = ()->{
            System.out.println("i like lambda5");
        };
        like.lambda();

    }
}

//1、定义一个函数式接口
interface ILike{
    void lambda();
}
//2、实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
