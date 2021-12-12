import java.net.*;
import java.io.*;


public class ReadFromFile {
    public static void main(String[] args) throws Exception {
	int numberOfLarger = 0;
	int numToCompare = 0;
	int currentLineValue = 0;
	int lineNum = 1;

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		
		while((line = bufferedReader.readLine()) != null){
			currentLineValue = Integer.parseInt(line);
		  //System.out.println(line);
			if(lineNum == 1){
				numToCompare = currentLineValue;
			}else{
				if(numToCompare < currentLineValue){
					numberOfLarger++;
				}
			}
			numToCompare = currentLineValue;
			lineNum++;
			
		}
		System.out.println(numberOfLarger);
		System.out.println("out of " + lineNum + " lines");
	      reader.close();
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}