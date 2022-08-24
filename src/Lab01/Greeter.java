package Lab01;

public class Greeter {
	
	private String userName, userGreeting;
	
	public Greeter(String nameIn){
		userName = nameIn;
	}
	
	public void generateGreeting(){
		userGreeting = "Hello " + userName + "!";
	}
	
	public String getGreeting(){
		return userGreeting;
	}
}

