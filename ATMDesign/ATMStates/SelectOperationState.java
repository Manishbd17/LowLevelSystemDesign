package ATMDesign.ATMStates;

import ATMDesign.ATM;
import ATMDesign.Card;
import ATMDesign.TransactionType;

public class SelectOperationState extends ATMState{
	
	public SelectOperationState() {
		showOperations();
	}


	@Override
	public void selectOperation(ATM atmObject,Card card,TransactionType txnType) {
		switch(txnType) {
			case CASH_WITHDRAWAL : 
				atmObject.setCurrentATMState(new CashWithdrawalState());
				break;
			case BALANCE_CHECK : 
				atmObject.setCurrentATMState(new CheckBalanceState()); 
				break;
			default: {
				System.out.println("Invalid option");
				exit(atmObject);
			}
		}
	}


private void showOperations() {
	System.out.println("Please select the operation");
	TransactionType.showAllTransactionTypes();
}
}
