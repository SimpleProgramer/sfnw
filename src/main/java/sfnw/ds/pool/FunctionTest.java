package sfnw.ds.pool;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

//函数接口
public class FunctionTest {

    static CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<>();
    static Map<String, String> mapT = new HashMap<>();
    static {
        cow.add("222");
        cow.add("111");
        mapT.put("1key", "1value");
        mapT.put("2key", "2value");
        mapT.put("3key", "3value");
        mapT.put("4key", "4value");
    }


    public static void main(String[] args) {



        //java中重要的函数接口


        BiConsumer<String,String> biConsumer = (a,b) ->{
            System.out.println(a + "-" + b);
        };
        System.out.println("-----------------------------------------------------");
        System.out.println("调用BiConsumer函数");
        biConsumer.accept("1","2");
        System.out.println("-----------------------------------------------------");
        System.out.println("在Map系forEach中使用BiConsumer");
        mapT.forEach(biConsumer);
        System.out.println("-----------------------------------------------------");
        //在stream中使用BiConsumer
        System.out.println("在stream中使用BiConsumer");
        //supplier：一个能创造目标类型实例的方法。
        //accumulator：一个将当元素添加到目标中的方法。
        //combiner：一个将中间状态的多个结果整合到一起的方法（parallelStream的时候会用到）
        cow.parallelStream().collect(() -> {
            List<String> s = new ArrayList<>();
            s.add("else");
            return s;
            }, (a,b) ->{
            a.add(b);
            System.out.println("第二个参数");
            System.out.println(a +" :" + b);
        },(one,two) -> {
            one.addAll(two);
            System.out.println("第三个参数");
            System.out.println(one + "====" + two);
        });
        System.out.println("-----------------------------------------------------");

        //1.Predicate -> test(T t) 对t进行断言，返回boolean，应用场景:stream().filter(Predicate< ? super T> predicate);
        Predicate<Long> predicate = (a) -> {
            return a > 0;
        };
        List<String> s = new ArrayList<>();
        System.out.println(predicate.test(2l));

        Consumer<String> consumer = (a) -> {
            System.out.println(a + " [Consumer]");
        };
        consumer.accept("ttt");



        cow.forEach(consumer);

        Function<Integer,Integer> funcs = (a) -> {
            System.out.println("in [Function]" + a);
            if (a < 2) {
                return 3+a;
            }
            return 2+ a;
        };
        //在Comparator中调用Function函数
        Comparator<Integer> comparing = Comparator.comparing(funcs);
        System.out.println(comparing.compare(1,2));

        //在map中调用function函数 在forEach中调用Consumer函数
        cow.stream().map(a -> a + "[function]").forEach(consumer);

        //顺带试一下flatmap的操作
        Function<String, Stream<String>> flatmapFuncs = a -> {
            List<String> newArr = new ArrayList<>();
            newArr.add(a+" flatMap in [Function]");
            return newArr.stream();
        };
        cow.stream().flatMap(flatmapFuncs).forEach(consumer);



    }
}
