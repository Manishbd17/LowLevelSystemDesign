package VendingMachineDesign.VendingStates.impl;

import java.util.List;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.VendingMachine;
import VendingMachineDesign.VendingStates.State;

public class HasMoneyState implements State {
	public HasMoneyState() {
		System.out.println("Currently vending machine is in hasMoneyState");
	}
	
	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		return ; 
	}
	
	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		machine.setVendingMachineState(new SelectionState()); 
	}
	
	@Override
	public void insertCoin(VendingMachine machine,Coin coin) throws Exception {
		System.out.println("Accept the coin");
		machine.getCoinList().add(coin); 
	}
	
	@Override
	public void chooseProduct(VendingMachine machine,int codeNumber) throws Exception {
		throw new Exception("You need to click on start product selection"); 
	}
	
	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("You can't get change in hasMoney state"); 
	}
	
	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		 System.out.println("Returned the full amount back in the Coin dispense tray");
		 machine.setVendingMachineState(new IdleState(machine)); 
		 return machine.getCoinList(); 
	}
	
	@Override
	public Item dispenseProduct(VendingMachine machine,int codeNumber) throws Exception {
		throw new Exception("Product can't be dispensed in hasMoney state"); 
	}
	
	@Override
	public void updateInventory(VendingMachine machine,Item item,int codeNumber) throws Exception {
		throw new Exception("Inventory can't be updated in hasMonehy State"); 
	}
	
}
