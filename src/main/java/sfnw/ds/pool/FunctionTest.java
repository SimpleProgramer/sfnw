package sfnw.ds.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//函数接口
public class FunctionTest {

    public static void main(String[] args) {
        //java中重要的函数接口
        //1.Predicate -> test(T t) 对t进行断言，返回boolean，应用场景:stream().filter(Predicate< ? super T> predicate);
        Predicate<Long> predicate = (a) -> {
            return a > 0;
        };
        List<String> s = new ArrayList<>();
        System.out.println(predicate.test(2l));
    }
}
