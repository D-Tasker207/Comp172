package Lab05;

/**
 * Purpose:  objects of this class will represent different print orders for cost calculation.
 * Note that this class does not check for input errors.  This should be done by any class that uses this
 * that uses this class.
 * @author Stansfield
 */
public class PrintOrder {
    //properties:
    private String color; //should be "gs" "p1" "p2" "p3"
    private String paperType; //"glossy" "matte"
    private String sided; //"single" "double"
    private int numPages;
    private double colorCost;
    private double paperTypeCost;
    private double costPerPage;
    private double totalCost;

    /**
     * Parameterized constructor for the PrintOrder class
     * @param colorIn should be "gs" "p1" "p2" "p3"
     * @param paperTypeIn "glossy" "matte"
     * @param sidedIn "single" "double"
     * @param numPagesIn total number of pages in order
     */
    public PrintOrder(String colorIn, String paperTypeIn, String sidedIn, int numPagesIn) {
        color = colorIn;
        paperType = paperTypeIn;
        sided = sidedIn;
        numPages = numPagesIn;
        paperTypeCost= 0.0;
        costPerPage = 0.0;
        totalCost = 0.0;
    }//constructor


    /*
     * determines the color cost taking sided-ness into account
     */
    private void determineColorCost() {
        if (color.equalsIgnoreCase("GS")) {
            colorCost = 0.10;
        } else if (color.equalsIgnoreCase("P1")) {
            colorCost = 0.30;
        } else if (color.equalsIgnoreCase("P2")) {
            colorCost = 0.45;
        } else { //P3  default assuming input error checking done in code using this class
            colorCost = 0.65;
        }
        
    }

	/* 
	 * determines the cost for paper type 
	 */
	private void determinePaperTypeCost() {
        if (paperType.equalsIgnoreCase("matte")) {
            paperTypeCost = 0.05;
        } else {
            paperTypeCost = 0.10;  //Glossy default assuming error checking done in code using this class
        }
        
    }
     
    /*
     * determines total cost taking color cost and sheet cost into account. Must be called after both are calculated
     */
    private void determineCostPerPage(){
		if (sided.equalsIgnoreCase("double") && numPages != 1){
			colorCost = colorCost * 2.0;
			paperTypeCost = paperTypeCost / 2.0;
		}
		
		costPerPage = colorCost + paperTypeCost;
	}
    
    /**
     * determine the total cost using number of pages. DetermineCostPerSheet must be executed first
     */
    public void determineTotalCost() {
		determineColorCost();
		determinePaperTypeCost();
		determineCostPerPage();
        totalCost = costPerPage * numPages;
    }

	/*
	 * getters
	 */
	public double getColorCost(){
		return colorCost;
	}
	
	public double getPaperTypeCost(){
		return paperTypeCost;
	}
	
    public double getCostPerPage() {
        return costPerPage;
    }

    public double getTotalCost() {
        return totalCost;
    }
    
    /***************************************************************
     * This main method with tester code should be removed or commented out before the 
     * class is used within other programs
     * ************************************************************
     
     public static void main(String[] args) {

     //First, unit test each method for each option.
     //since main is within the class, it can call the private methods.
		
		//Test color calculation
		//since we don't care about other parameters yet, we'll just use a valid set
		System.out.println("Testing color ----------------------------------");
		PrintOrder gs = new PrintOrder("gs","matte","single",2);
		gs.determineColorCost();
		System.out.printf("Expected .10 got %5.2f\n", gs.getColorCost());
		
		PrintOrder p1 = new PrintOrder("p1","matte","single",2);
		p1.determineColorCost();
		System.out.printf("Expected .30 got %5.2f\n", p1.getColorCost());
		
		PrintOrder p2 = new PrintOrder("p2","matte","single",2);
		p2.determineColorCost();
		System.out.printf("Expected .45 got %5.2f\n", p2.getColorCost());
		
		PrintOrder p3 = new PrintOrder("p3","matte","single",2);
		p3.determineColorCost();
		System.out.printf("Expected .65 got %5.2f\n", p3.getColorCost());
	
		PrintOrder p4 = new PrintOrder("gs","matte","double",2);
		p4.determineColorCost();
		System.out.printf("Expected .10 got %5.2f\n", p4.getColorCost());
		
		/*------------------------------------------------------
		//test paper type in the same way
		System.out.println("Testing paper type ----------------------------------");
		PrintOrder pm = new PrintOrder("gs","matte","single",2);
		pm.determinePaperTypeCost();
		System.out.printf("Expected .05 got %5.2f\n", pm.getPaperTypeCost());
		PrintOrder pg = new PrintOrder("gs","glossy","single",2);
		pg.determinePaperTypeCost();
		System.out.printf("Expected .10 got %5.2f\n", pg.getPaperTypeCost());
		PrintOrder pmd = new PrintOrder("gs","matte","double",2);
		pmd.determinePaperTypeCost();
		System.out.printf("Expected .05 got %5.2f\n", pmd.getPaperTypeCost());
		
		/*-------------------------------------------------------
		//test cost per sheet with adjustment using both methods above
		System.out.println("Testing cost per sheet ----------------------------------");
		PrintOrder ps1 = new PrintOrder("gs","matte","single",2);
		ps1.determineColorCost();
		ps1.determinePaperTypeCost();
		ps1.determineCostPerPage();
		System.out.printf("Expected .15 got %5.2f\n", ps1.getCostPerPage());
		
		PrintOrder pd1 = new PrintOrder("gs","matte","double",2);
		pd1.determineColorCost();
		pd1.determinePaperTypeCost();
		pd1.determineCostPerPage();
		System.out.printf("Expected .23 got %5.2f\n", pd1.getCostPerPage());
		
		PrintOrder ps2 = new PrintOrder("gs","matte","single",1);
		ps2.determineColorCost();
		ps2.determinePaperTypeCost();
		ps2.determineCostPerPage();
		System.out.printf("Expected .15 got %5.2f\n", ps1.getCostPerPage());
		
		PrintOrder pd2 = new PrintOrder("gs","matte","double",1);
		pd2.determineColorCost();
		pd2.determinePaperTypeCost();
		pd2.determineCostPerPage();
		System.out.printf("Expected .15 got %5.2f\n", ps2.getCostPerPage());
		
		/*------------------------------------------------
		//test different numbers of sheets to test total cost calculation
		System.out.println("Testing total cost (by changing sheets) ---------------");
		PrintOrder np = new PrintOrder("gs","matte","single",10);
		np.determineTotalCost();
		System.out.printf("Expected 1.5 got %5.2f\n", np.getTotalCost());
		
		PrintOrder np2 = new PrintOrder("gs","matte","single",333);
		np2.determineTotalCost();
		System.out.printf("Expected 49.95 got %5.2f\n", np2.getTotalCost());
		
		System.out.println("Testing total cost (by changing sheets) ---------------");
		PrintOrder np3 = new PrintOrder("gs","matte","double",10);
		np3.determineTotalCost();
		System.out.printf("Expected 2.25 got %5.2f\n", np3.getTotalCost());
	}//end of main 
	*/
		
}// end of class PrintOrder

