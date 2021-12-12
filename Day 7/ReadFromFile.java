import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;


public class ReadFromFile {
	public static void main(String[] args) throws Exception {
		try{
//			FileReader reader = new FileReader("Code Input.txt");
			FileReader reader = new FileReader("Test Input.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
		
			String line;
			List<Integer> listOfPositions = new ArrayList<Integer>();
			List<Integer> originalPositions = new ArrayList<Integer>();
			int listSize = 0;
			int sum = 0;
			double mean = 0;
			int median = 0;
			int totalFuelUsed = 0;
		
			while((line = bufferedReader.readLine()) != null){
				String[] newLine = line.split(",");
				for(int i=0; i<newLine.length; i++){
					listOfPositions.add(Integer.parseInt(newLine[i]));
					originalPositions.add(Integer.parseInt(newLine[i]));
				}
			}
		        reader.close();
			
			listSize = listOfPositions.size();
			
			for(Integer i : listOfPositions){
				//System.out.println(i);
				sum += i;
			}
			mean = sum/listSize;

			Collections.sort(listOfPositions);
			
			if(listSize % 2 == 0){
				median = (listOfPositions.get(listSize/2)+listOfPositions.get((listSize/2)-1))/2;
			}else{
				median = listOfPositions.get(listSize/2);
			}


			for(int i=0; i<originalPositions.size(); i++){
				int numInQuestion = originalPositions.get(i);
				int fuelStep = 1;
				int thisFuel = 0;
				while(numInQuestion != mean){
					if(numInQuestion<mean){
						numInQuestion++;
					}else{
						numInQuestion--;
					}
					thisFuel+=fuelStep;
					fuelStep++;
				}
				totalFuelUsed += thisFuel;
			}


			System.out.println("Median is: " + median);
			System.out.println("Mean is: " + mean);
			System.out.println("Total fuel used: " + totalFuelUsed);
			
		}
		catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
		}
	}
}