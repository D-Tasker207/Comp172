package Lab02;

public class Wheelchair{
	private double newBatteryHours, batteryHealth, wheelchairSpeed, wheelchairRange;
	
	public Wheelchair(double newBatteryHoursIn, double batteryHealthIn, double wheelchairSpeedIn){
		newBatteryHours = newBatteryHoursIn;
		batteryHealth = batteryHealthIn;
		wheelchairSpeed = wheelchairSpeedIn;
		wheelchairRange = 0.0;
	}
	public void calculateRange(){
		wheelchairRange = (newBatteryHours * batteryHealth) * wheelchairSpeed;
	}
	
	public double getRange(){
		return wheelchairRange;
	}
}
