package test;

import impl.EmployeeByAgeImpl;
import interf.MyPredicate;
import model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Test01
 * @Deacription TODO
 * @Author WinKinWong
 * @Date 2020/1/14 14:09
 * @Version 1.0
 **/
public class TestLambda01 {
     List<Employee> employees = Arrays.asList(
            new Employee("001",18,4000),
            new Employee("002",16,5000),
            new Employee("003",22,6000),
            new Employee("004",25,7000),
            new Employee("005",30,8000),
            new Employee("006",35,9000),
            new Employee("007",40,2000)
    );

    //优化方式：策略设计模式
    @Test
    public void test01(){
        List<Employee> list = filterEmployee(employees,new EmployeeByAgeImpl());
        for (Employee employee:list){
            System.out.println(employee);
        }
    }
    // 优化方式：lambda表达式
    @Test
    public void test02(){
        List<Employee> list = filterEmployee(employees,(e) -> e.getAge() >= 20);
        list.forEach(System.out::println);
    }

    //优化方式：Steam Api   以转换为流方式
    @Test
    public void test03(){
       List<Employee> list =  employees.stream()
                .filter((e)->e.getAge()>=20)
                .collect(Collectors.toList());
       list.forEach(System.out::println);
       //***************************************************
        employees.stream()
                .filter((e)->e.getAge()>=20)
                .forEach(System.out::println);
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> employees = new ArrayList<>();
        for(Employee employee : list){
            if (mp.test(employee)){
                employees.add(employee);
            }
        }
        return employees;
    }
}
