package DesignPatterns.ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public void create(String client, EmployeeDo obj) throws Exception {
		
		//creates a new Row 
		System.out.println("Created new row in Employee table");
	}
	
	@Override
	public void delete(String client, int employeeId) throws Exception {
		
		//delete a row 
		System.out.println("Deleted row with employeeId " + employeeId);
	}
	
	@Override
	public EmployeeDo get(String client,int employeeId) throws Exception {
		
		//fetch row 
		System.out.println("Fetching data from the DB");
		return new EmployeeDo(); 
	}
}
