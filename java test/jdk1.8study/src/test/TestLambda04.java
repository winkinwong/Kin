package test;

import model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName TestLambda04
 * @Deacription TODO
 * @Author WinKinWong
 * @Date 2020/1/14 16:13
 * @Version 1.0
 **/
public class TestLambda04 {

    List<Employee> employees = Arrays.asList(
            new Employee("001",18,4000),
            new Employee("002",16,5000),
            new Employee("003",22,6000),
            new Employee("004",25,7000),
            new Employee("005",30,8000),
            new Employee("006",35,9000),
            new Employee("007",40,2000)
    );

    //四大核心函数式接口一：断言式：Predicate<T> boolean test(T);
    @Test
    public void test01(){
        List<Employee> list = filterEmployee(employees,(x) -> x.getAge()==16);
        list.forEach(System.out::println);
    }

    //四大核心函数式接口二： 函数型接口： Function<T,R> R apply(T t);
    @Test
    public void test02(){
        String target = operationStr("good good study day day up",(str)-> str=str.substring(9,15).toUpperCase());
        System.out.println(target);
    }
    //四大核心函数式接口三： 供给型接口： Supplier<T> T get();
    @Test
    public void test03(){
        List<Integer> list = getRandomNum(10,()->(int)(Math.random()*100));
        list.forEach(System.out::println);
    }
    //四大核心函数式接口四： 消费型接口： Consumer<T> void accept(T t);
    @Test
    public void test04(){
        happy(100,(x)-> System.out.println("消费了"+x+"元"));
    }


    //**************************************************method area *******************************************************
    public void happy(Integer i, Consumer<Integer> con){
        con.accept(i);
    }

    public List<Integer> getRandomNum(Integer size, Supplier<Integer> supplier){
        List<Integer> nums = new ArrayList<>();
        for (int i=0;i<size;i++){
            Integer num = supplier.get();
            nums.add(num);
        }
        return nums;
    }

    public String operationStr(String str,Function<String,String> function){
        return function.apply(str);
    }

    public List<Employee> filterEmployee(List<Employee> employees, Predicate<Employee> employeePredicate){
        List<Employee> list = new ArrayList<>();
        for(Employee employee : employees){
            if(employeePredicate.test(employee)){
                list.add(employee);
            }
        }
        return list;
    }
}
