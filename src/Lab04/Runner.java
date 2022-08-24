package Lab04;

public class Runner {
	
	public static void main (String[] args) {
		
		//test suite
		ExoticPetFine fine1 = new ExoticPetFine("bird", 0, false, false, false); //fine is for bird, two previous fines, is endangered, source was disclosed, no prosecution
		fine1.calculateFine();
		System.out.println("fine1 should be 1000, is: " + fine1.getTotalFine());
		
		ExoticPetFine fine2 = new ExoticPetFine("cat", 0, false, false, false); //fine is for cat, no previous fines, is endangered, no source disclosed, no prosecution
		fine2.calculateFine();
		System.out.println("fine2 should be 2000, is: " + fine2.getTotalFine());
		
		ExoticPetFine fine3 = new ExoticPetFine("primate", 0, false, false, false); //fine is for primate, 4 previous fines, is not endangered, source disclosed, no prosecution
		fine3.calculateFine();
		System.out.println("fine3 should be 3000, is: " + fine3.getTotalFine());
		
		ExoticPetFine fine4 = new ExoticPetFine("bird", 2, false, false, false); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine4.calculateFine();
		System.out.println("fine4 should be 1400, is: " + fine4.getTotalFine());
		
		ExoticPetFine fine5 = new ExoticPetFine("bird", 5, false, false, false); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine5.calculateFine();
		System.out.println("fine5 should be 2000, is: " + fine5.getTotalFine());
		
		ExoticPetFine fine6 = new ExoticPetFine("bird", 0, true, false, false); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine6.calculateFine();
		System.out.println("fine6 should be 1400, is: " + fine6.getTotalFine());
		
		ExoticPetFine fine7 = new ExoticPetFine("bird", 2, false, false, false); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine7.calculateFine();
		System.out.println("fine7 should be 1400, is: " + fine7.getTotalFine());
		
		ExoticPetFine fine8 = new ExoticPetFine("bird", 0, false, false, true); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine8.calculateFine();
		System.out.println("fine8 should be 1000, is: " + fine8.getTotalFine());
		
		ExoticPetFine fine9 = new ExoticPetFine("bird", 0, false, true, true); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine9.calculateFine();
		System.out.println("fine9 should be 1400, is: " + fine9.getTotalFine());
		
		ExoticPetFine fine10 = new ExoticPetFine("cat", 1, true, true, true); //fine is for bird, 3 previous fines, is endangered, source disclosed, lead to prosecution
		fine10.calculateFine();
		System.out.println("fine10 should be 1400, is: " + fine10.getTotalFine());
	}
}

