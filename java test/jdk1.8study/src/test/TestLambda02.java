package test;

import interf.MyFun;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName TestLambda02
 * @Deacription Lambda 基本语法：java 8 引入新操作符 “->” 称：箭头表达式 也称 Lambda 操作符
 *              左侧：Lambda 表达式的参数列表
 *              右侧：Lambda 表达式中所需执行的功能，即Lambda 体
 * @Author WinKinWong
 * @Date 2020/1/14 14:45
 * @Version 1.0
 **/

public class TestLambda02 {

    //语法格式一：无参数，无返回值
    @Test
    public void test01(){
        int num = 0;//jdk 1.7前，必须是 final
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello world!"+num);
                }
            };
        r.run();
        System.out.println("------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    //语法格式二：有一个参数，并且无返回值
    @Test
    public void test02(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("test");
    }
    //语法格式三：若只有一个参数，小括号可以省略不写
    //语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
    @Test
    public void test03(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    //语法格式五：若Lambda体中，若返回值只有一个，则大括号和return可以省略
    //语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器推断出数据类型即“类型推断”


    //练习
    @Test
    public void test04(){
        Integer num = operation(100,(x) -> x*x+10);
        System.out.println(num);
    }
    public Integer operation(Integer num, MyFun my){
        return my.getValue(num);
    }
}
