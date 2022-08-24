package Lab08;

import java.io.*;
import java.util.*;

public class Kennel {

    public ArrayList<Dog> kennelArr;
    public int kennelSize;

    public Kennel(String fileName, int kennelCapacity){
        kennelSize = kennelCapacity;
        kennelArr = new ArrayList<>();
        readInKennel(fileName);
    }

    private void readInKennel(String fileName){
        try{
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);
            while(reader.hasNextLine()){
                if (kennelArr.size() <= kennelSize){
                	
                    String ownerName = reader.nextLine();
                    
                    String creditCard = reader.nextLine();
                    
                    String dogName = reader.nextLine();
                    
                    int stayLength = Integer.parseInt(reader.nextLine());
                    
                    double costperNight = Double.parseDouble(reader.nextLine());
                    
                    kennelArr.add(new Dog(ownerName, creditCard, dogName, stayLength, costperNight));
                }
            }
            reader.close();
        }
        catch(Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public int headcount(){
        return kennelArr.size();
    }

    public String getDogInfo(){
        String allInfo = "";
        for (int i = 0; i < kennelArr.size(); i++){
                allInfo += i + " " + kennelArr.get(i).toString() + "\n";
        }
        return allInfo;
    }
    
    public String getDogInfo(int dogNum) {
    	return dogNum + " " + kennelArr.get(dogNum).toString() + "\n";
    }

    public boolean checkInDog(String ownerName, String creditCard, String dogName, int stayLength, double costPerNight){
        if (kennelArr.size() >= this.kennelSize){
            return false;
        }

        kennelArr.add(new Dog(ownerName, creditCard, dogName, stayLength, costPerNight));
        return true;
    }

    public double checkOutDog(String ownerName, String dogName){
    	int dogNum = searchKennel(ownerName, dogName);
        if (dogNum == -1) return -1;

        kennelArr.get(dogNum).calculateTotalCost();
        double totalCost = kennelArr.get(dogNum).getTotalCost();
        kennelArr.remove(dogNum);
        return totalCost;
    }

    public int searchKennel(String ownerName, String dogName){
        for (int i = 0; i < kennelArr.size(); i++) {
        	if ((kennelArr.get(i).getOwnerName().equalsIgnoreCase(ownerName)) && (kennelArr.get(i).getDogName().equalsIgnoreCase(dogName))){
        		return i;
        	}
        }
        return -1;
    }
}
