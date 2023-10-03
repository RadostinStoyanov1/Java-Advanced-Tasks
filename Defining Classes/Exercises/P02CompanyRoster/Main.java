package P14DefiningClasses_Exercise.P02CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> employees = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            employees.putIfAbsent(department, new ArrayList<>());

            int tokensLength = tokens.length;
            Employee employee;

            switch (tokensLength) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    } else {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    }
                    break;
                default:
                    employee = new Employee(name, salary, position, department, tokens[4], Integer.parseInt(tokens[5]));
                    break;
            }
            employees.get(department).add(employee);
        }
        Map.Entry<String, List<Employee>> highestSalaryDepartment = employees.entrySet()
                .stream()
                .sorted(Comparator.comparing((department) -> department.getValue().stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble(), Comparator.reverseOrder()))
                .findFirst() //takes only the first (highest average salary) element of the map
                .orElse(null); //if there is element in the map - returns the result, otherwise returns what is in brackets after orElse


        System.out.printf("Highest Average Salary: %s\n", highestSalaryDepartment.getKey());
        highestSalaryDepartment.getValue()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
