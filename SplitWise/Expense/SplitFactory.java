package SplitWise.Expense;

import SplitWise.Expense.Split.EqualExpenseSplit;
import SplitWise.Expense.Split.ExpenseSplit;
import SplitWise.Expense.Split.PercentageExpenseSplit;
import SplitWise.Expense.Split.UnEqualExpenseSplit;

public class SplitFactory {
	public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
		switch(splitType) {
			case EQUAL: 
				return new EqualExpenseSplit(); 
			case UNEQUAL: 
				return new UnEqualExpenseSplit(); 
			case PERCENTAGE: 
				return new PercentageExpenseSplit();
			default: 
				return null; 
		}
	}
}
