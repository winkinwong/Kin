package test;

import model.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @ClassName TestLambda05
 * @Deacription 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用是Lambda表达式的另外一种表现形式）
 * @Author WinKinWong
 * @Date 2020/1/15 9:51
 * @Version 1.0
 **/
public class TestLambda05 {

    //类::实例方法名
    @Test
    public void test01(){
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);
        System.out.println(bp.test("abc","abc"));
        //注意，此方式只能够是 x,y为实参，且x为实例方法调用者，y为方法参数才能够使用。
        //若Lambda参数列表中的第一个参数是实例方法的调用者，第二参数是实例方法的参数，则可以使用 ClassName::method
        BiPredicate<String,String> bp2 = String::equals;
        System.out.println(bp2.test("abc","abc"));
    }
    //类::静态方法名
    @Test
    public void test02(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        System.out.println(com.compare(3,2));
        Comparator<Integer> com1 = Integer::compareTo;
        System.out.println(com1.compare(2,2));
    }
    //对象::实例方法名
    @Test
    public void test03(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)-> ps.println(x);
        con.accept("nice");

        Consumer<String> con2 = System.out::println;
        con2.accept("fuck");
    }

    @Test
    public void test04(){
        Employee e1 = new Employee();
        e1.setName("fuck");
        Supplier<String> s1 =e1::getName;
        System.out.println(s1.get());

    }

    //构造器引用方式
    @Test
    public void test05(){
        Supplier<Employee> s1 = ()->new Employee();
        Employee e1 = s1.get();
        System.out.println(e1);
        Supplier<Employee> s2 = Employee::new;
        Employee e2 = s2.get();
        e2.setName("nice");
        System.out.println(e2);
    }

    @Test
    public void test06(){
        Function<Integer,Employee> f1 = (x)->new Employee(x);
        Employee e1 =f1.apply(10);
        System.out.println(e1);
        BiFunction<String,Integer,Employee> f2 = Employee::new;
        Employee e2 = f2.apply("fuck",20);
        System.out.println(e2);
    }

    //数组引用方式
    @Test
    public void test07(){
        Function<Integer,String[]> f1 = (x)->new String[x];
        String[] s1 = f1.apply(10);
        System.out.println(s1.length);

        Function<Integer,String[]> f2 = String[]::new;
        String[] s2 = f2.apply(20);
        System.out.println(s2.length);
    }
}
