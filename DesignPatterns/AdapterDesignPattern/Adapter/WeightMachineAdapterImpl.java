package DesignPatterns.AdapterDesignPattern.Adapter;

import DesignPatterns.AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter  {
	WeightMachine weightMachine; 
	public WeightMachineAdapterImpl(WeightMachine weightMachine) {
		this.weightMachine=weightMachine; 
	}
	@Override
	public double getWeightInKg() {
		double weightInPound = weightMachine.getWeightInPound(); 
		//Convert it to Kgs
		double weightInKg = weightInPound*.45; 
		return weightInKg; 
	}
}
