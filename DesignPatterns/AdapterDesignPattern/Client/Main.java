package DesignPatterns.AdapterDesignPattern.Client;

import DesignPatterns.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {
	public static void main(String args[]) {
		WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
		System.out.println(weightMachineAdapter.getWeightInKg());
	}
}
