package interf;

import module.Employee;

import java.util.List;

public interface MyPredicate<T> {
    boolean test(Employee employee);
}
