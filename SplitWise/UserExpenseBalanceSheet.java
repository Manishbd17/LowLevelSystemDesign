package SplitWise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
	Map<String,Balance> userVsBalance; 
	double totalYourExpense; 
	double totalYourPayment;
	double totalYouOwe;
	double totalYouGetBack; 
	
	public UserExpenseBalanceSheet() {
		userVsBalance = new HashMap<> (); 
		totalYourExpense=0;
		totalYouOwe=0;
		totalYouGetBack=0; 
	}

	public Map<String, Balance> getUserVsBalance() {
		return userVsBalance;
	}

	public double getTotalYourExpense() {
		return totalYourExpense;
	}

	public void setTotalYourExpense(double totalYourExpense) {
		this.totalYourExpense = totalYourExpense;
	}

	public double getTotalYourPayment() {
		return totalYourPayment;
	}

	public void setTotalYourPayment(double totalYourPayment) {
		this.totalYourPayment = totalYourPayment;
	}

	public double getTotalYouOwe() {
		return totalYouOwe;
	}

	public void setTotalYouOwe(double totalYouOwe) {
		this.totalYouOwe = totalYouOwe;
	}

	public double getTotalYouGetBack() {
		return totalYouGetBack;
	}

	public void setTotalYouGetBack(double totalYouGetBack) {
		this.totalYouGetBack = totalYouGetBack;
	}
	
	
}
