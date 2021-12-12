import java.net.*;
import java.io.*;
import java.util.Arrays;


public class ReadFromFile2 {
    public static void main(String[] args) throws Exception {

	try{
	FileReader reader = new FileReader("Code Input.txt");
//	FileReader reader = new FileReader("Test Input.txt");
	BufferedReader bufferedReader = new BufferedReader(reader);
	
	String line;
	long[] listOfFish = new long[9];
	int numOfDays = 256;
	long totalFish = 0;
	long firstIn = 0;
	
	while((line = bufferedReader.readLine()) != null){
		String[] newLine = line.split(",");
		for(int i=0; i<newLine.length; i++){
			listOfFish[Integer.parseInt(newLine[i])] += 1L;
//			listOfFish.add(Integer.parseInt(newLine[i]));
		}
	}

//	for(Integer i : listOfFish){
//		System.out.println(i);
//	}

//	System.out.println("At the start, there are " + listOfFish.size() + " lanternfish.");

	for(int i=0; i<numOfDays; i++){
		firstIn = listOfFish[0];
		listOfFish[0] = 0L;
		for(int j=0; j<listOfFish.length; j++){
			if(j!=listOfFish.length-1){
				listOfFish[j] = listOfFish[j+1];
			}else{
				listOfFish[j] = firstIn;
			}
		}
		listOfFish[6] = Long.sum(listOfFish[6],firstIn);
//		listOfFish[5] += firstIn;
//		listOfFish[7] = Long.sum(listOfFish[7], firstIn);
//		listOfFish[7] += firstIn;

		System.out.println("Day " + i);
		for(int j=0; j<listOfFish.length; j++){
			System.out.print(listOfFish[j] + " ");
		}
		System.out.println();
	}

	for(int i=0; i<listOfFish.length; i++){
		totalFish = Long.sum(totalFish,listOfFish[i]);
//		totalFish += listOfFish[i];
	}

	
	System.out.println("After " + numOfDays + " days, there are " + totalFish + " lanternfish.");

	reader.close();
	}
	catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}