package ATMDesign.ATMStates;


import ATMDesign.ATM;
import ATMDesign.Card;

public class IdleState extends ATMState {
	@Override
	public void insertCard(ATM atm,Card card) {
		System.out.println("Card is inserted");
		atm.setCurrentATMState(new HasCardState()); 
	}
}
