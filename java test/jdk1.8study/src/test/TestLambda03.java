package test;

import interf.MyFun2;
import interf.MyStringFun;
import model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName TestLambda03
 * @Deacription TODO
 * @Author WinKinWong
 * @Date 2020/1/14 15:31
 * @Version 1.0
 **/
public class TestLambda03 {

    List<Employee> employees = Arrays.asList(
            new Employee("001",18,4000),
            new Employee("002",16,5000),
            new Employee("003",22,6000),
            new Employee("004",25,7000),
            new Employee("005",30,8000),
            new Employee("006",35,9000),
            new Employee("007",40,2000)
    );

    //定制排序
    @Test
    public void test01(){
        Collections.sort(employees,(e1,e2) -> {
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        employees.forEach(System.out::println);
    }

    @Test
    public void test02(){
        String target = handleStr("传递师装你妈比呢，you can you up,no can no bb",(str) -> str = str.toUpperCase().substring(9,str.length()));
        System.out.println(target);
    }

    @Test
    public void test03(){
        op(200L,300L,(x,y) -> x*y+10);
    }
    public String handleStr(String str, MyStringFun myfun){
        return myfun.getValue(str);
    }
    public void op(Long l1, Long l2, MyFun2<Long,Long> my){
        System.out.println(my.getValue(l1,l2));
    }
}
