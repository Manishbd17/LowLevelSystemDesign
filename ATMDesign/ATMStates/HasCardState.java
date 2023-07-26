package ATMDesign.ATMStates;

import ATMDesign.ATM;
import ATMDesign.Card;

public class HasCardState extends ATMState {
	public HasCardState() {
		System.out.println("Enter your card pin number");
	}
	
	@Override
	public void authenticatePin(ATM atm,Card card,int pin) {
		boolean isCorrectPinEntered = card.isCorrectPINEntered(pin); 
		if(isCorrectPinEntered) {
			atm.setCurrentATMState(new SelectOperationState()); 
		} else {
			System.out.println("Invalid PIN Number");
			exit(atm);
		}
	}
	
	@Override
	public void exit(ATM atmObject) {
		returnCard();
		atmObject.setCurrentATMState(new IdleState());
		System.out.println("Exit happens");
	}
	
	@Override
	public void returnCard() {
		System.out.println("Please collect your card");
	}
	
}
