package Lab12;

public class Lawn {
	
	private double sodSize;
	private double lawnLength;
	private double lawnWidth;
	private double lawnArea;
	private double numSodBlocks;
	
	//Constructor
	public Lawn(double sodSizeIn, double lawnLengthIn, double lawnWidthIn){
		sodSize = sodSizeIn;
		lawnLength = lawnLengthIn;
		lawnWidth = lawnWidthIn;
		lawnArea = 0.0;
		numSodBlocks =0.0;
	}
	
	public void calculateLawnArea(){
		lawnArea = lawnLength * lawnWidth;
	}
	
	public void calculateSodBlocks(){
		numSodBlocks = lawnArea/sodSize;
	}
	
	public double getLawnArea(){
		return lawnArea;
	}
	
	public int getNumSodBlocks() {
		return (int) Math.ceil(numSodBlocks);
	}
	
}//Lawn class
		
		
		
	
