package VendingMachineDesign.VendingStates.impl;

import java.util.List;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.VendingMachine;
import VendingMachineDesign.VendingStates.State;

public class SelectionState implements State {
	public SelectionState() {
		System.out.println("Currently vending machine is in selection state");
	}
	
	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		throw new Exception("You can't click insert coin button in Selection State"); 
	}
	
	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		return ; 
	}
	
	@Override
	public void insertCoin(VendingMachine machine,Coin coin) throws Exception {
		throw new Exception("You can't insert coin in selection state");
	}
	
	@Override
	public void chooseProduct(VendingMachine machine,int codeNumber) throws Exception {
		//1. get Item of this codeNumber 
		Item item = machine.getInventory().getItem(codeNumber); 
		
		//2. Total amount paid by User 
		int paidByUser=0;
		for(Coin coin: machine.getCoinList()) {
			paidByUser = paidByUser+coin.value; 
		}
		
		//3. Compare product price and amount paid by the user
		if(paidByUser < item.getPrice()) {
			System.out.println("Insufficient amount,product you selected is for price: "+item.getPrice()+" and you paid: "+paidByUser);
			refundFullMoney(machine);
			throw new Exception("Insufficient amount"); 
		}
		else if(paidByUser>=item.getPrice()) {
			if(paidByUser>item.getPrice()) {
				getChange(paidByUser-item.getPrice());
			}
			machine.setVendingMachineState(new DispenseState(machine,codeNumber)); 
		}
	}
	
	@Override
	public int getChange(int returnExtraMoney) throws Exception {
		//actual logic should be to return COINs in the dispense tray
		System.out.println("Returned the change in the coin dispense tray");
		return returnExtraMoney; 
	}
	
	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		System.out.println("Returned the full amount back in the coin dispense tray");
		machine.setVendingMachineState(new IdleState(machine)); 
		return machine.getCoinList(); 
	}
	
	@Override
	public Item dispenseProduct(VendingMachine machine,int codeNumber) throws Exception {
		throw new Exception("Products can't be dispensed in Selection State");
	}
	
	@Override
	public void updateInventory(VendingMachine machine,Item item,int codeNumber) throws Exception {
		throw new Exception("Inventory can't be updated in selection state"); 
	}
}
