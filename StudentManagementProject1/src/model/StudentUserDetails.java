package model;

public class StudentUserDetails {
	 int studentId;
	 String studentname;
	 String studentPhone;
	 String studentCity;
	 String firstname;
	 String lastname;
	 String location;
	 String username;
	 String password;
	 String mobileno;
	 public StudentUserDetails(String firstname, String lastname, String location, String username, String password,
			String mobileno) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public StudentUserDetails()
	 {
		 super();
	 }
	public StudentUserDetails(int studentId, String studentname, String studentPhone, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.studentPhone = studentPhone;
		this.studentCity = studentCity;
	}
	public StudentUserDetails( String studentname, String studentPhone, String studentCity) {
		super();

		this.studentname = studentname;
		this.studentPhone = studentPhone;
		this.studentCity = studentCity;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	@Override
	public String toString() {
		return "StudentUserDetails [studentId=" + studentId + ", studentname=" + studentname + ", studentPhone="
				+ studentPhone + ", studentCity=" + studentCity + "]";
	}


}
