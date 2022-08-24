package Lab04;

public class ExoticPetFine{
	
	private String animalType;
	private double totalFine;
	private int numPrevViolations;
	private boolean isEndangered, isDisclosed, isProsecuted;
	
	public ExoticPetFine(String animalTypeIn, int numPrevViolationsIn, boolean isEndangeredIn, boolean isDisclosedIn, boolean isProsecutedIn){
		//initialise instance variables
		animalType = animalTypeIn;
		totalFine = 0.0;
		numPrevViolations = numPrevViolationsIn;
		isEndangered = isEndangeredIn;
		isDisclosed = isDisclosedIn;
		isProsecuted = isProsecutedIn;
	}
	
	private void initialFine(){
		//sets the initial price of the fine based on animal type input
		if(animalType.equals("bird")){
			totalFine = 1000.0;
		}
		else if(animalType.equals("cat")){
			totalFine = 2000.0;
		}
		else{
			totalFine = 3000.0;
		}

	}
	
	private void previousViolations(){ //adds 200 to total price for each previous violation
		totalFine += 200*numPrevViolations;
	}
	
	private void endangeredPenalty(){ //if animal is endangered multiply price by two
		if(isEndangered == true){
			totalFine *= 2;
		}
	}
	
	private void sourceDisclosed(){ //if source is disclosed apply 5% discound, if source if then prosecuted apply further 10% discount
		if(isDisclosed == true){
			totalFine *= 0.95;
			if(isProsecuted == true){
				totalFine *= 0.90;
			}
		}
	}

	public void calculateFine(){//public method to calculate fine to simplify interface
		this.initialFine();
		this.previousViolations();
		this.endangeredPenalty();
		this.sourceDisclosed();
	}

	//getters
	public double getTotalFine(){
		return totalFine;
	}
	
	public String getAnimaltype(){
		return animalType;
	}
	
	public int getNumPrevViolations(){
		return numPrevViolations;
	}
	
	public boolean getIsSourceDisclosed(){
		return isDisclosed;
	}
	
	public boolean getIsSourceProsecuted(){
		return isProsecuted;
	}
}
