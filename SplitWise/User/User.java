package SplitWise.User;

import SplitWise.UserExpenseBalanceSheet;

public class User {
	String userId;
	String userName; 
	UserExpenseBalanceSheet userExpenseBalanceSheet;
	
	public User(String id,String name) {
		this.userId = id;
		this.userName = name; 
		userExpenseBalanceSheet = new UserExpenseBalanceSheet(); 
	}
	
	public String getUserId() {
		return userId; 
	}
	
	public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
		return userExpenseBalanceSheet;
	}
	
}
