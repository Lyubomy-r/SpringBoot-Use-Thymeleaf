package SpringBootUseThymeleaf.dao;

import SpringBootUseThymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
   // public List<Employee> findAllByOrderByLastNameAsc();

}
