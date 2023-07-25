package VendingMachineDesign.VendingStates.impl;

import java.util.List;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.VendingMachine;
import VendingMachineDesign.VendingStates.State;

public class DispenseState implements State {
	DispenseState(VendingMachine machine,int codeNumber) throws Exception {
		System.out.println("Currently vending machine is in dispense state");
		dispenseProduct(machine,codeNumber);
	}
	
	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		throw new Exception("Insert coin button can't be clicked on Dispenser State"); 
	}
	
	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		throw new Exception("Product selection button can't be clicked on Dispenser State"); 
	}
	
	@Override
	public void chooseProduct(VendingMachine machine,int codeNumber) throws Exception {
		throw new Exception("Product can't be choosen on Dispenser State"); 
	}
	
	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("Change can't be returned in Dispenser state"); 
	}
	
	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		throw new Exception("Refund can't happen in Dispenser State"); 
	}
	
	@Override
	public Item dispenseProduct(VendingMachine machine,int codeNumber) throws Exception {
		System.out.println("Product has been dispensed");
		Item item = machine.getInventory().getItem(codeNumber); 
		machine.getInventory().updateSoldOutItem(codeNumber); 
		machine.setVendingMachineState(new IdleState(machine)); 
		return item; 
	}
	
	@Override
	public void updateInventory(VendingMachine machine,Item item,int codeNumber) throws Exception {
		throw new Exception("Inventory can't be updated in Dispense State"); 
	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		throw new Exception("Coin can't be inserted in Dispenser State"); 
	}
	
	
	
}
