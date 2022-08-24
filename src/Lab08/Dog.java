package Lab08;

public class Dog {

    private String creditCard = "", dogName = "", ownerName = "";
    private double costPerNight, totalCost, stayLength;

    public Dog(String ownerName, String creditCard, String dogName, double stayLength, double costPerNight){
        this.dogName = dogName;
        this.ownerName = ownerName;
        this.creditCard = creditCard;
        this.stayLength = stayLength;
        this.costPerNight = costPerNight;
    }

    public void calculateTotalCost(){
        totalCost = Math.ceil(stayLength) * costPerNight;
    }

    public String getCreditCard(){
        return creditCard;
    }

    public String getOwnerName(){
        return ownerName;
    }
    
    public String getDogName(){
        return dogName;
    }

    public double getStayLength(){
        return stayLength;
    }
    
    public double getCostPerNight(){
        return costPerNight;
    }
    
    public double getTotalCost(){
        return totalCost;
    }

    public String toString(){
        return "Owner Name: " + ownerName + ", Credit Card: " + creditCard + ", Dog Name: " + dogName + ", Stay Length: " + stayLength + ", Cost Per Night: " + costPerNight;
    }
}