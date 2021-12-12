import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadFromFile {
    public static void main(String[] args) throws Exception {

	try{
	FileReader reader = new FileReader("Code Input.txt");
	BufferedReader bufferedReader = new BufferedReader(reader);
	
	String line;
	List<Integer> listOfFish = new ArrayList<Integer>();
	int numOfDays = 80;
	
	while((line = bufferedReader.readLine()) != null){
		String[] newLine = line.split(",");
		for(int i=0; i<newLine.length; i++){
			listOfFish.add(Integer.parseInt(newLine[i]));
		}
	}

//	for(Integer i : listOfFish){
//		System.out.println(i);
//	}

	System.out.println("At the start, there are " + listOfFish.size() + " lanternfish.");

	for(int j=0; j<numOfDays; j++){
		for(int i=listOfFish.size() - 1; i>=0; i--){
			int numToCompare = listOfFish.get(i);
			if(numToCompare == 0){
				//listOfFish.get(i) = 6;
				listOfFish.set(i,6);
				listOfFish.add(8);
			}else{
				//listOfFish.get(i) = listOfFish.get(i) -1);
				listOfFish.set(i,numToCompare-1);
			}
		}
	}
	
	System.out.println("After " + numOfDays + " days, there are " + listOfFish.size() + " lanternfish.");

	reader.close();
	}
	catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}