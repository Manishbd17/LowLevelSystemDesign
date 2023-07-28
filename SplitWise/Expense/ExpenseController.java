package SplitWise.Expense;

import java.util.List;

import SplitWise.BalanceSheetController;
import SplitWise.Expense.Split.ExpenseSplit;
import SplitWise.Expense.Split.Split;
import SplitWise.User.User;

public class ExpenseController {
	
	BalanceSheetController balanceSheetController; 
	
	public ExpenseController() {
		balanceSheetController = new BalanceSheetController(); 
	}
	
	public Expense createExpense(String expenseId, String description,double expenseAmount,
								List<Split> splitDetails,ExpenseSplitType splitType,User paidByUser) {
		
		ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
		expenseSplit.validateSplitRequest(splitDetails, expenseAmount); 
		
		Expense expense  = new Expense(expenseId, description,expenseAmount, paidByUser, splitType, splitDetails);
		
		balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitDetails,expenseAmount); 
		
		return expense; 
	}
 	
}
