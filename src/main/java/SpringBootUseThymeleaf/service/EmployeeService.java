package SpringBootUseThymeleaf.service;

import SpringBootUseThymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee theEmployee);

    public void deleteById(int id);

}
