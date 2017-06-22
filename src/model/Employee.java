package model;

public class Employee {

	int empId			=	0 ;
	String empName		=	null;
	String empStatus	=	null;
	String empAddress	=	null;
	String CNIC			=	null;
	String empCellNumber=	null;
	int empSalary		=	0;
	

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getCNIC() {
		return CNIC;
	}
	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}
	public String getEmpCellNumber() {
		return empCellNumber;
	}
	public void setEmpCellNumber(String empCellNumber) {
		this.empCellNumber = empCellNumber;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
}
