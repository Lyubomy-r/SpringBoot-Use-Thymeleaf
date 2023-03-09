package SpringBootUseThymeleaf.service;

import SpringBootUseThymeleaf.dao.EmployeeDAO;
import SpringBootUseThymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Override
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id){

        Employee employee =employeeDAO.findById(id).get();

        return employee;
    }

    @Override
    public void save(Employee theEmployee){
        employeeDAO.save(theEmployee);

    }

    @Override
    public void deleteById(int id){

        employeeDAO.deleteById(id);
    }

    @Override
    public List<Employee> findByFirstName (String firstName){
        return employeeDAO.findByFirstName(firstName);
    }
}
