package impl;

import model.Employee;
import interf.MyPredicate;

/**
 * @ClassName EmployeeByAgeImpl
 * @Deacription TODO
 * @Author WinKinWong
 * @Date 2020/1/14 14:18
 * @Version 1.0
 **/
public class EmployeeByAgeImpl implements MyPredicate {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>=20;
    }
}
