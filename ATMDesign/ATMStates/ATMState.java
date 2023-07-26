package ATMDesign.ATMStates;

import ATMDesign.ATM;
import ATMDesign.Card;
import ATMDesign.TransactionType;

public abstract class ATMState {
	public void insertCard(ATM atm,Card card) {
		System.out.println("Oops! Something went wrong");
	}
	
	public void authenticatePin(ATM atm,Card card,int pin) {
		System.out.println("Oops! Something went wrong");
	}
	
	public void selectOperation(ATM atm,Card card,TransactionType txnType) {
		System.out.println("Oops! Something went wrong");
	}
	
	public void cashWithdrawal(ATM atm,Card card,int withdrawAmount) {
		System.out.println("Oops! Something went wrong");
	}
	
	public void displayBalance(ATM atm,Card card) {
		System.out.println("Oops! Something went wrong");
	}
	
	public void returnCard() {
		System.out.println("Oops! Something went wrong");
	}
	
	public void exit(ATM atm) {
		System.out.println("Oops! Something went wrong");
	}
}
