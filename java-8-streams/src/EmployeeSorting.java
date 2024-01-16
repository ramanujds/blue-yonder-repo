import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSorting {

    public static void main(String[] args) {

        Employee e1 = new Employee(104,"Javed", 65000);
        Employee e2 = new Employee(103,"Rahul", 55000);
        Employee e3 = new Employee(102,"Suresh", 75000);
        Employee e4 = new Employee(101,"Ramesh", 45000);
        Employee e5 = new Employee(105,"Rajesh", 85000);

        List<Employee> employees = new ArrayList<>(List.of(e1,e2,e3,e4,e5));

//        Comparator <Employee> sortById = (emp1,emp2) -> emp1.getId()-emp2.getId();
//        Comparator <Employee> sortByName = (emp1,emp2) -> emp1.getName().compareTo(emp2.getName());

        List<Employee> sortedEmployee = employees.stream().sorted(
                Comparator.comparing(Employee::getName)
        ).collect(Collectors.toList());

        sortedEmployee.forEach(System.out::println);




    }

}
