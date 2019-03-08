package sfnw.ds.pool;

import java.util.function.BinaryOperator;

public class LambdaTest {

    public static void main(String[] args) {
        //无参方法lambda调用
        Runnable noArguments = () -> System.out.println("hello lambda");
        noArguments.run();

        //一个参数的方法lambda调用
        OneArgument oneArgument = aa -> System.out.println(aa);
        oneArgument.sayHi("测试带参数的lambda");

        //lambda主体可以是一行，也可以是代码块
        OneArgument oneArgument1 = aa -> {
            System.out.println("测试：" + aa);
            System.out.println("第二行");
        };
        oneArgument1.sayHi("代码块lambda");

        //多个参数的lambda
        BinaryOperator<Long> add = (x, y) -> x + y;
        System.out.println(add.apply(1l, 2l));

        //显示的声明lambda表达式的参数类型
        BinaryOperator<Long> addOperate = (Long x, Long y) -> x + y;
        System.out.println(addOperate.apply(1l, 2l));

        //lambda中只能引用final变量，或者只赋值一次的变量。
        String name = "final string name";
        Runnable finalVar = () -> System.out.println("hello lambda" + name);
    }
}
