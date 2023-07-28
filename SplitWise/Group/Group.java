package SplitWise.Group;

import java.util.ArrayList;
import java.util.List;

import SplitWise.Expense.Expense;
import SplitWise.Expense.ExpenseController;
import SplitWise.Expense.ExpenseSplitType;
import SplitWise.Expense.Split.Split;
import SplitWise.User.User;

public class Group {
	String groupId;
	String groupName; 
	List<User> groupMembers; 
	List<Expense> expenseList; 
	ExpenseController expenseController;
	
	Group() {
		groupMembers = new ArrayList<> (); 
		expenseList = new ArrayList<> (); 
		expenseController = new ExpenseController();
	}
	
	public void addMember(User member) {
		groupMembers.add(member); 
	}
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Expense createExpense(String expenseId, String description,double expenseAmount,
			List<Split> splitDetails,ExpenseSplitType splitType,User paidByUser) {
		Expense expense = expenseController.createExpense(expenseId, description,expenseAmount, splitDetails, splitType, paidByUser);
		expenseList.add(expense); 
		return expense; 
	}
}
