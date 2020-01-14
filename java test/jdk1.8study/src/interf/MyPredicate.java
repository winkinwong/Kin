package interf;

import model.Employee;

public interface MyPredicate<T> {
    boolean test(Employee employee);
}
