package SplitWise.Expense;

import java.util.ArrayList;
import java.util.List;

import SplitWise.Expense.Split.Split;
import SplitWise.User.User;

public class Expense {
	String expenseId; 
	String description; 
	double expenseAmount; 
	User paidByUser;
	ExpenseSplitType splitType; 
	List<Split> splitDetails = new ArrayList<> ();
	
	public Expense(String expenseId,String description,double expenseAmount,
			User paidByUser,ExpenseSplitType splitType,List<Split> splitDetails) {
		this.expenseId = expenseId; 
		this.expenseAmount = expenseAmount; 
		this.description = description; 
		this.paidByUser = paidByUser;
		this.splitType = splitType;
		this.splitDetails.addAll(splitDetails); 
	}
}
