package VendingMachineDesign.VendingStates.impl;

import java.util.ArrayList;
import java.util.List;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.VendingMachine;
import VendingMachineDesign.VendingStates.State;

public class IdleState implements State {
	public IdleState() {
		System.out.println("Currently vending machine is in idle state");
	}
	
	public IdleState(VendingMachine machine) {
		System.out.println("Currently vending machine is in IdleState");
		machine.setCoinList(new ArrayList<>());
	}
	
	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		machine.setVendingMachineState(new HasMoneyState()); 
	}
	
	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		throw new Exception("First click on insert coin button"); 
	}
	
	@Override
	public void chooseProduct(VendingMachine machine,int codeNumber) throws Exception {
		throw new Exception("Product can't be choosen on Idle State"); 
	}
	
	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("Change can't be returned in Idle state"); 
	}
	
	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		throw new Exception("Refund can't happen in Idle State"); 
	}
	
	@Override
	public Item dispenseProduct(VendingMachine machine,int codeNumber) throws Exception {
		throw new Exception("Products can't be dispensed in Idle State");
	}
	
	@Override
	public void updateInventory(VendingMachine machine,Item item,int codeNumber) throws Exception {
		machine.getInventory().addItem(item,codeNumber); 
	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		throw new Exception("You can't choose product in idle state"); 
	}
	
}	
