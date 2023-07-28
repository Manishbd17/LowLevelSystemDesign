package SplitWise;

import java.util.List;
import java.util.Map;

import SplitWise.Expense.Split.Split;
import SplitWise.User.User;

public class BalanceSheetController {
	
	public void updateUserExpenseBalanceSheet(User expensePaidBy,List<Split> splits, double totalExpenseAmount) {
		//update the total amount paid of the expense paid by user
		UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet(); 
		paidByUserExpenseSheet.setTotalYourPayment(paidByUserExpenseSheet.getTotalYourPayment() + totalExpenseAmount);
		
		for(Split split: splits) {
			User userOwe = split.getUser(); 
			UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
			double oweAmount = split.getAmountOwe();
			
			if(expensePaidBy.getUserId().equals(userOwe.getUserId())) {
				paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount); 
			}
			else {
				//update the balance of paid user
				paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack()+oweAmount);
				
				Balance userOweBalance; 
				if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
					userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
				} else {
					userOweBalance = new Balance(); 
					paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance); 
				}
				userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);
				
				//update the balance sheet of owe user
				oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
				oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);
				
				Balance userPaidBalance; 
				if(oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())) {
					userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId()); 
				} else {
					userPaidBalance = new Balance();
					oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(),userPaidBalance);
				}
				userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount); 
			}
		}
	}
	
	public void showBalanceSheetOfUser(User user) {
		System.out.println("----------------------------");
		System.out.println("Balance sheet of user: "+ user.getUserId());
		
		UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet(); 
		System.out.println("Total your expense: " + userExpenseBalanceSheet.getTotalYourExpense());
		System.out.println("Total Get Back: " + userExpenseBalanceSheet.getTotalYouGetBack());
		System.out.println("Total you owe: " + userExpenseBalanceSheet.getTotalYouOwe());
		System.out.println("Total payment made: " + userExpenseBalanceSheet.getTotalYourPayment());
		
		for(Map.Entry<String,Balance> entry: userExpenseBalanceSheet.getUserVsBalance().entrySet()) {
			String userId = entry.getKey();
			Balance balance = entry.getValue(); 
			
			System.out.println("UserId: " + userId + "YouGetBack: " + balance.getAmountGetBack() + "You Owe: "+ balance.getAmountOwe());
		}
		System.out.println("------------------------------");
	}
}
