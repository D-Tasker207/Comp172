package Lab02;
import java.lang.Math;

public class Runner {
	
	public static void main (String[] args) {
		System.out.println("newBatteryHours = 10, batteryHealth = 100(1.0), wheelchairSpeed = 10: wheelchairRange = expected 100 miles");
		Wheelchair chair1 = new Wheelchair(10, 1.0, 10);
		chair1.calculateRange();
		System.out.println("Actual " + Math.round(chair1.getRange()*100)/100.0);
		
		System.out.println("newBatteryHours = 6, batteryHealth = 100 (1.0), wheelchairSpeed = 10: wheelchairRange = expected 60 miles");
		Wheelchair chair2 = new Wheelchair(6, 1.0, 10);
		chair2.calculateRange();
		System.out.println("Actual " + Math.round(chair2.getRange()*100)/100.0);
		
		System.out.println("newBatteryHours = 6, batteryHealth = 45 (0.45), wheelchairSpeed = 10: wheelchairRange = expected 27 miles");
		Wheelchair chair3 = new Wheelchair(6, 0.45, 10);
		chair3.calculateRange();
		System.out.println("Actual " + Math.round(chair3.getRange()*100)/100.0);
		
		System.out.println("newBatteryHours = 6, batteryHealth = 45 (0.45), wheelchairSpeed = 4: wheelchairRange = expected 10.8 miles");
		Wheelchair chair4 = new Wheelchair(6, 0.45, 4);
		chair4.calculateRange();
		System.out.println("Actual " + Math.round(chair4.getRange()*100)/100.0);
	}
}
