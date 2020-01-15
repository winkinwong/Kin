package test;

import model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName TestSteamAPI01
 * @Deacription Stream 的三个步骤：1.创建Stream 2.中间操作 3. 终止操作（终端操作）
 * @Author WinKinWong
 * @Date 2020/1/15 10:35
 * @Version 1.0
 **/
public class TestStreamAPI01 {
    List<Employee> employees = Arrays.asList(
            new Employee("001",18,4000),
            new Employee("002",16,5000),
            new Employee("003",22,6000),
            new Employee("004",25,7000),
            new Employee("005",30,8000),
            new Employee("006",35,9000),
            new Employee("007",40,2000)
    );

    @Test
    public void test01(){
        //1.可以通过Collection 系列集合提供的stream()或则parallelStream();
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] e1 = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(e1);

        //3.通过Stream 类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->(int)(Math.random()*100)).limit(20).forEach(System.out::println);
    }

    //映射 flatMap
    @Test
    public void test02(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list.stream()
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("______________________________________");

        employees.stream()
                    .map(Employee::getName)
                    .forEach(System.out::println);

        System.out.println("______________________________________");

        Stream<Stream<Character>> stream2 = list.stream()
                                                    .map(TestStreamAPI01::filterCharacter);
        stream2.forEach((sm)->sm.forEach(System.out::println));
        System.out.println("______________________________________");

        Stream<Character> sm = list.stream()
                                    .flatMap(TestStreamAPI01::filterCharacter);
        sm.forEach(System.out::println);
    }

    public static Stream<Character>filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for(Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }
}
