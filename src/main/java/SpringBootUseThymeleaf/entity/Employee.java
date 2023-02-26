package SpringBootUseThymeleaf.entity;



import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	public Employee() {
		
	}

	public Employee(String theFirstName,String theLastName, String theEmail ) {
		this.firstName=theFirstName;
		this.lastName=theLastName;
		this.email=theEmail;
	}
	public Employee(int theId, String theFirstName,String theLastName, String theEmail ) {
		
		this.id=theId;
		this.firstName=theFirstName;
		this.lastName=theLastName;
		this.email=theEmail;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int theId) {
		this.id=theId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String theFirstName) {
		this.firstName=theFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String theLastName) {
		this.lastName=theLastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String theEmail) {
		this.email=theEmail;
	}
	
	@Override
	public String toString() {
		return "Employee [id= "+id+", firstName= "+firstName+", lastName= "+lastName+", email= "+email+"]";
	}
	
}
