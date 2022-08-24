package Lab03;
import java.lang.Math;

public class PhonePlan{
	private double totalCost, discountAmount, originalCost, taxAmount;
	private boolean contractState;
	
	public PhonePlan(double originalCostIn, boolean contractStateIn){
		//constructor for everything
		originalCost = originalCostIn;
		contractState = contractStateIn;
		discountAmount = 0.0;
		taxAmount = 0.0;
		totalCost = 0.0;
	}
	
	public void calculateCost(double taxRate){
		//applies discount to totalCost if contratState is true
		if(contractState){
			totalCost = 0.9 * originalCost;
		}
		else {
			totalCost = originalCost;
		}
		//sets discount and tax amounts
		discountAmount = originalCost - totalCost;
		taxAmount = totalCost * taxRate;
		totalCost += taxAmount;
	}
	
	//getters for various properties
	public double getOriginalCost(){
		return Math.round(originalCost*100)/100.0;
	}
	public double getTax(){
		return Math.round(taxAmount*100)/100.0;
	}
	
	public double getDiscount(){
		return Math.round(discountAmount*100)/100.0;
	}
	
	public double getFinalCost(){
		return Math.round(totalCost*100)/100.0;
	}
}
