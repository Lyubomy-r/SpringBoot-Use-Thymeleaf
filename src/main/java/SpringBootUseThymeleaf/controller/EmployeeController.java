package SpringBootUseThymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import SpringBootUseThymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import SpringBootUseThymeleaf.entity.Employee;

import javax.validation.Valid;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//private List<Employee> theEmployee;

//	@PostConstruct
//	private void loadData() {
//		Employee emp1 = new Employee(1,"Leslie","Andrews","leslie@code.com");
//		Employee emp2 = new Employee(2,"Emma","Baumger","emma@code.com");
//		Employee emp3 = new Employee(3,"Avani","Gupra","avai@code.com");
//
//		theEmployee=new ArrayList<>();
//
//		theEmployee.add(emp1);
//		theEmployee.add(emp2);
//		theEmployee.add(emp3);
//	}
	private EmployeeService employeeService;

	public EmployeeController (EmployeeService employeeService){
		this.employeeService=employeeService;

	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployee = employeeService.findAll();

		theModel.addAttribute("employees", theEmployee);
		
		return "list-employees";
	}

	@GetMapping("/showAddPage")
	public String showAddPage(Model theModel){

		Employee employee=new Employee();
		theModel.addAttribute("addEmployee",employee );

		return "employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("addEmployee")Employee theEmployee, BindingResult theBindingResult){

		if(theBindingResult.hasErrors()){
			return "employee-form";
		}else{
			employeeService.save(theEmployee);
		}



		return "redirect:/employees/list";

	}

	@PostMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int id,Model theModel){

		Employee employee=employeeService.findById(id);
		theModel.addAttribute("addEmployee", employee);

		return "employee-form";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int id){

		employeeService.deleteById(id);

		return  "redirect:/employees/list";

	}


	
	
}
