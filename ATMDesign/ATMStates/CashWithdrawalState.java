package ATMDesign.ATMStates;

import ATMDesign.ATM;
import ATMDesign.Card;
import ATMDesign.WithdrawalProcessor.CashWithdrawProcessor;
import ATMDesign.WithdrawalProcessor.FiveHundredWithdrawProcessor;
import ATMDesign.WithdrawalProcessor.OneHundredWithdrawProcessor;
import ATMDesign.WithdrawalProcessor.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {
	public CashWithdrawalState() {
		System.out.println("Please enter the withdrawal amount");
	}
	
	public void cashWithdrawal(ATM atmObject,Card card,int withdrawalAmountRequest) {
		if(atmObject.getAtmBalance()<withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the ATM Machine");
			exit(atmObject);
		} else if(card.getBankBalance()<withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the Bank Account");
			exit(atmObject);
		} else {
			card.deductBankBalance(withdrawalAmountRequest);
			atmObject.deductATMBalance(withdrawalAmountRequest); 
			
			CashWithdrawProcessor withdrawProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
			withdrawProcessor.withdraw(atmObject,withdrawalAmountRequest); 
			exit(atmObject); 
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
