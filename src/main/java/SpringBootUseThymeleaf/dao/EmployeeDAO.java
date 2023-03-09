package SpringBootUseThymeleaf.dao;

import SpringBootUseThymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
   // public List<Employee> findAllByOrderByLastNameAsc();
    @Query(value = "SELECT * FROM employee e WHERE e.first_name like :searchName% or e.last_name like :searchName%",nativeQuery = true)
    public List<Employee> findByFirstName(@Param("searchName") String searchName );
}
