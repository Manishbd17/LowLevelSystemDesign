package SplitWise;

import java.util.ArrayList;
import java.util.List;

import SplitWise.Expense.ExpenseSplitType;
import SplitWise.Expense.Split.Split;
import SplitWise.Group.Group;
import SplitWise.Group.GroupController;
import SplitWise.User.User;
import SplitWise.User.UserController;

public class Splitwise {
	UserController userController;
	GroupController groupController;
	
	BalanceSheetController balanceSheetController; 
	
	Splitwise() {
		userController = new UserController();
		groupController = new GroupController(); 
		balanceSheetController = new BalanceSheetController(); 
	}
	
	public void demo() {
		setupUserAndGroup();
		
		//Add members to the group 
		Group group = groupController.getGroup("G1001"); 
		group.addMember(userController.getUser("U2001"));
		group.addMember(userController.getUser("U3001")); 
		
		//Create an expense inside a group
		List<Split> splits = new ArrayList<> (); 
		Split split1 = new Split(userController.getUser("U1001"),300);
		Split split2 = new Split(userController.getUser("U2001"),300);
		Split split3 = new Split(userController.getUser("U3001"),300);
		splits.add(split1); 
		splits.add(split2);
		splits.add(split3);
		group.createExpense("Exp1001","Breakfast",900,splits,ExpenseSplitType.EQUAL,userController.getUser("U1001"));
		
		List<Split> splits2 = new ArrayList<> (); 
		Split split2_1 = new Split(userController.getUser("U1001"),300);
		Split split2_2 = new Split(userController.getUser("U2001"),300);
		splits2.add(split2_1); 
		splits2.add(split2_2);
		group.createExpense("Exp1002","Lunch",500,splits2,ExpenseSplitType.UNEQUAL,userController.getUser("U2001"));
		
		for(User user: userController.getAllUsers()) {
			balanceSheetController.showBalanceSheetOfUser(user); 
		}
	}
	
	public void setupUserAndGroup() {
		//onboard user to splitwise app
		addUsersToSplitwiseApp();
		
		//create a group by user1
		User user1 = userController.getUser("U1001"); 
		groupController.createNewGroup("G1001","Outing with Friends",user1); 
	}
	
	
	private void addUsersToSplitwiseApp() {
		User user1 = new User("U1001", "User1");
		User user2 = new User("U2001", "User2"); 
		User user3 = new User("U3001", "User3"); 
		
		userController.addUser(user1); 
		userController.addUser(user2); 
		userController.addUser(user3); 
	}
	
	
}
